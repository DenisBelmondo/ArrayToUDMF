import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

import java.io.File;
import java.io.PrintWriter;

import java.io.IOException;

public class UDMFMap
{
	private List<Sector> sectors;
	
	public UDMFMap()
	{
		sectors = new ArrayList<Sector>();
	}
	
	public UDMFMap(int map[][], final int TILE_SIZE)
	{
		this();
		
		for (int i = 0; i < map.length; ++i)
		{
			for (int j = 0; j < map[i].length; ++j)
			{
				System.out.printf("%d", map[i][j]);
				System.out.print(j == map[i].length - 1 ? "\n" : "");
				
				switch(map[i][j])
				{
				case 0:
					// they have to appear in this order, bottom left first
					Linedef[] quad =
					{
						// bottom left to bottom right
						new Linedef
						(
							new Sidedef(),
							new Vertex(j * TILE_SIZE, i * TILE_SIZE + TILE_SIZE),
							new Vertex(j * TILE_SIZE + TILE_SIZE, i * TILE_SIZE + TILE_SIZE)
						),
						// bottom right to top right
						new Linedef
						(
							new Sidedef(),
							new Vertex(j * TILE_SIZE + TILE_SIZE, i * TILE_SIZE + TILE_SIZE),
							new Vertex(j * TILE_SIZE + TILE_SIZE, i * TILE_SIZE)
						),
						// top right to top left
						new Linedef
						(
							new Sidedef(),
							new Vertex(j * TILE_SIZE + TILE_SIZE, i * TILE_SIZE),
							new Vertex(j * TILE_SIZE, i * TILE_SIZE)
						),
						// top left to bottom left
						new Linedef
						(
							new Sidedef(),
							new Vertex(j * TILE_SIZE, i * TILE_SIZE),
							new Vertex(j * TILE_SIZE, i * TILE_SIZE + TILE_SIZE)
						)
					};
					
					Sector newSector = new Sector(sectors.size(), quad, 0, TILE_SIZE);
					for (int k = 0; k < newSector.lines.length; ++k)
					{
						newSector.lines[k].sideFront.textureMiddle = "STARTAN2";
					}
					
					sectors.add(newSector);
					
				break;
				}
			}
		}
		
		Merger.removeOverlappingVertices(sectors);
		Merger.removeOverlappingLines(sectors);
	}
	
	public void writeTextmapToFile(String fileName)
	{
		try
		{
			PrintWriter pw = new PrintWriter(new File(fileName));
			pw.println("namespace = \"zdoom\";"
				+ System.lineSeparator());
			
			// make and sort lists for printing
			
			List<Vertex> vertices = new ArrayList<Vertex>();
			
			for (int i = 0; i < sectors.size(); ++i)
			for (int j = 0; j < sectors.get(i).lines.length; ++j)
			{
				if (!vertices.contains(sectors.get(i).lines[j].v1)) {
					sectors.get(i).lines[j].v1.index = vertices.size();
					vertices.add(sectors.get(i).lines[j].v1);
				}
				
				if (!vertices.contains(sectors.get(i).lines[j].v2)) {
					sectors.get(i).lines[j].v2.index = vertices.size();
					vertices.add(sectors.get(i).lines[j].v2);
				}
			}
			
			List<Linedef> lines = new ArrayList<Linedef>();
			List <Sidedef> sidedefs = new ArrayList<Sidedef>();
			
			for (int i = 0; i < sectors.size(); ++i)
			for (int j = 0; j < sectors.get(i).lines.length; ++j)
			{
				if (!lines.contains(sectors.get(i).lines[j]))
				{
					sectors.get(i).lines[j].index = lines.size();
					lines.add(sectors.get(i).lines[j]);
					
					sectors.get(i).lines[j].sideFront.index = sidedefs.size();
					sectors.get(i).lines[j].sideFront.sector = sectors.get(i);
					sidedefs.add(sectors.get(i).lines[j].sideFront);
					
					if (sectors.get(i).lines[j].sideBack != null)
					{
						sectors.get(i).lines[j].sideBack.index = sidedefs.size();
						sectors.get(i).lines[j].sideBack.sector = sectors.get(i);
						sidedefs.add(sectors.get(i).lines[j].sideBack);
					}
				}
			}
			
			// printing
			
			for (int i = 0; i < vertices.size(); ++i) {
				pw.println(vertices.get(i).toString());
			}
			
			for (int i = 0; i < lines.size(); ++i) {
				pw.println(lines.get(i).toString());
			}
			
			for (int i = 0; i < lines.size(); ++i) {
				pw.println(lines.get(i).sideFront.toString());
				if (lines.get(i).sideBack != null) {
					pw.println(lines.get(i).sideBack.toString());
				}
			}
			
			for (int i = 0; i < sectors.size(); ++i) {
				pw.println(sectors.get(i).toString());
			}
			
			pw.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
		return;
	}
}
