public class Vertex
{
	public int index;
	
	public final Vector2 pos;
	
	public Vertex()
	{
		this.index = -1;
		this.pos = new Vector2(0.0, 0.0);
	}
	
	public Vertex(Vector2 pos)
	{
		this.index = -1;
		this.pos = pos;
	}
	
	public Vertex(double x, double y)
	{
		this.index = -1;
		this.pos = new Vector2(x, y);
	}
	
	public Vertex(int index, double x, double y)
	{
		this.index = index;
		this.pos = new Vector2(x, y);
	}
	
	public Vertex(int index, Vector2 pos)
	{
		this.index = index;
		this.pos = pos;
	}
	
	public boolean equals(Vertex other)
	{
		return this.pos.equals(other.pos) ? true : false;
	}
	
	@Override
	public String toString()
	{
		String str = "vertex";
		
		str += "// " + index;
		
		str += String.format("%n{%n");
		
		str += String.format("\tx = %f;%n", pos.x);
		str += String.format("\ty = %f;%n", pos.y);
		
		str += String.format("}%n");
		
		return str;
	}
}
