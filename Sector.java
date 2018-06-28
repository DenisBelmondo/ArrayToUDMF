public class Sector
{
	public int index;
	
	public int id;
	public Linedef lines[];
	
	public int heightFloor, heightCeiling;
	public String textureFloor, textureCeiling;
	public int lightLevel, special;
	public String comment;
	
	public Sector(Linedef lines[], int heightFloor, int heightCeiling)
	{
		this.index = -1;
		
		this.id = 0;
		this.lines = lines;
		
		this.heightFloor = heightFloor;
		this.heightCeiling = heightCeiling;
		
		this.textureFloor = "FLAT1";
		this.textureCeiling = "FLAT1";
		
		this.lightLevel = 160;
		this.special = 0;
		
		this.comment = null;
	}
	
	public Sector(int index, Linedef lines[], int heightFloor, int heightCeiling)
	{
		this(lines, heightFloor, heightCeiling);
		this.index = index;
	}
	
	@Override
	public String toString()
	{
		String str = "sector // " + index;
		str += String.format("%n{%n");
		
		if (heightFloor != 0)
			{ str += String.format("\theightfloor = %d;%n", heightFloor); }
		if (heightCeiling != 0) {
			str += String.format("\theightceiling = %d;%n", heightCeiling);
			str += System.lineSeparator();
		}
		
		str += String.format("\ttexturefloor = \"%s\";%n", textureFloor);
		str += String.format("\ttextureceiling = \"%s\";%n", textureCeiling);
		
		if (lightLevel != 160) {
			str += System.lineSeparator();
			str += String.format("\tlightlevel = %d;%n", lightLevel);
			str += System.lineSeparator();
		}
		
		if (special != 0)
			{ str += String.format("\tspecial = %d;%n", special); }
		if (id != 0) {
			str += String.format("\tid = %d;%n", id);
			str += System.lineSeparator();
		}
		
		if (comment != null)
			{ str += String.format("\tcomment = %s;%n", comment); }
		
		str += String.format("}%n");
		
		return str;
	}
}
