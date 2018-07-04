import java.io.File;
import java.io.RandomAccessFile;
import java.io.IOException;

import java.util.List;
import java.util.LinkedList;

public class WadWriter
{
	private String filename;
	private File file;
	
	private int numFiles;
	private int offFAT;
	
	private List<Lump> lumps;
	
	private WadWriter()
	{
		this.numFiles = 0;
		this.offFAT = 0;
		this.lumps = new LinkedList<Lump>();
	}
	
	public WadWriter(String filename)
	{
		this();
		
		this.filename = filename;
		this.file = new File(filename);
	}
	
	public WadWriter(File file)
	{
		this();
		
		this.file = file;
		this.filename = file.getAbsolutePath();
	}
	
	public void addLump(Lump newLump)
	{
		lumps.add(newLump);
		numFiles = lumps.size();
		
		return;
	}
	
	public void writeToFile() throws IOException
	{
		RandomAccessFile raf = new RandomAccessFile(
									new File(filename), "rw");
		
		raf.writeChars("PWAD");
		
		for (int i = 0; i < lumps.size(); ++i) {
			raf.writeBytes(lumps.get(i).data);
		}
		
		raf.close();
		
		return;
	}
}
