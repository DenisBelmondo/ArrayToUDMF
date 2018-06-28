public class Sidedef
{
	public int index;
	public Sector sector;
	
	public int offsetX, offsetY;
	public String textureTop, textureBottom, textureMiddle;
	// public int sectorID;
	public String comment;
	
	public Sidedef()
	{
		this.index = -1;
		this.sector = null;
		
		this.offsetX = 0;
		this.offsetY = 0;
		
		this.textureTop = "-";
		this.textureBottom = "-";
		this.textureMiddle = "-";
		
		this.comment = null;
	}
	
	public Sidedef(int index)
	{
		this();
		this.index = index;
	}
	
	@Override
	public String toString()
	{
		String str = "sidedef // " + index;
		str += String.format("%n{%n");
		
		if (offsetX != 0)
			{ str += String.format("\toffsetx = %d;%n", offsetX); }
		if (offsetY != 0) {
			str += String.format("\toffsety = %d;%n", offsetY);
			str += System.lineSeparator();
		}
		
		if (!textureTop.equals("-"))
			{ str += String.format("\ttexturetop = \"%s\";%n", textureTop); }
		if (!textureBottom.equals("-"))
			{ str += String.format("\ttexturebottom = \"%s\";%n", textureBottom); }
		if (!textureMiddle.equals("-")) {
			str += String.format("\ttexturemiddle = \"%s\";%n", textureMiddle);
			str += System.lineSeparator();
		}
		
		if (sector != null) {
			str += String.format("\tsector = %d;%n", sector.index);
			str += System.lineSeparator();
		}
		
		if (comment != null)
			{ str += String.format("\tcomment = %s;%n", comment); }
		
		str += String.format("}%n");
		
		return str;
	}
}
