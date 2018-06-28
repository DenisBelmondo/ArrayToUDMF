import java.util.List;
import java.util.Arrays;

public class Merger
{
	public Merger() {}
	
	public static void removeOverlappingVertices(List<Sector> sectors)
	{
		for (int i = 0; i < sectors.size(); ++i)
		for (int j = 0; j < sectors.size(); ++j)
		{
			for (int k = 0; k < sectors.get(i).lines.length; ++k)
			for (int l = 0; l < sectors.get(j).lines.length; ++l)
			{
				if (sectors.get(i).lines[k].v1.equals(sectors.get(j).lines[l].v1))
				{
					sectors.get(j).lines[l].v1 = sectors.get(i).lines[k].v1;
				}
				
				if (sectors.get(i).lines[k].v1.equals(sectors.get(j).lines[l].v2))
				{
					sectors.get(j).lines[l].v2 = sectors.get(i).lines[k].v1;
				}
				
				if (sectors.get(i).lines[k].v2.equals(sectors.get(j).lines[l].v2))
				{
					sectors.get(j).lines[l].v2 = sectors.get(i).lines[k].v2;
				}
			}
		}
		
		return;
	}
	
	public static void removeOverlappingLines(List<Sector> sectors)
	{
		for (int i = 0; i < sectors.size(); ++i)
		for (int j = 0; j < sectors.size(); ++j)
		{
			for (int k = 0; k < sectors.get(i).lines.length; ++k)
			for (int l = 0; l < sectors.get(j).lines.length; ++l)
			{
				if (sectors.get(i).lines[k].equals(sectors.get(j).lines[l]))
				{
					if (sectors.get(j).lines[l].hashCode()
						!= sectors.get(i).lines[k].hashCode())
					{
						sectors.get(i).lines[k].sideFront = new Sidedef();
						sectors.get(i).lines[k].sideBack = new Sidedef();
						sectors.get(i).lines[k].blocking = false;
						sectors.get(i).lines[k].twoSided = true;
						
						sectors.get(j).lines[l] = sectors.get(i).lines[k];
					}
				}
			}
		}
		
		return;
	}
}
