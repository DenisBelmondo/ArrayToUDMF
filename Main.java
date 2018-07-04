import java.lang.Math;

public class Main
{
	static int TILE_SIZE;
	static String FILE_NAME;
	
	public static void main(String args[])
	{
		TILE_SIZE = 64;
		FILE_NAME = "textmap.txt";
		
		// ugh
		
		boolean valid = false;
		
		// mod 2 because every argument expects a following value
		// e.g. --tilesize <int>
		
		if (args.length % 2 == 0)
		{
			if (args.length > 0)
			{
				try
				{
					for (int i = 0; i < args.length; ++i)
					{
						if (args[i].equals("--tilesize"))
						{
							TILE_SIZE = Math.abs(
								Integer.parseInt(args[++i]));
							valid = true;
						}
						else if (args[i].equals("--output"))
						{
							FILE_NAME = args[++i];
							if (!FILE_NAME.contains(".")) {
								FILE_NAME += ".txt";
							}
							valid = true;
						}
						else
						{
							System.err.println("Invalid argument "
												+ "\"" + args[i] + "\"."
							);
							
							valid = false;
							printUsage();
							
							break;
						}
					}
				}
				catch (NumberFormatException e)
				{
					System.err.println("Invalid tile size.");
				}
			}
			else
			{
				valid = true;
			}
		}
		else
		{
			System.err.println("Malformed arguments.");
			printUsage();
		}

		if (valid)
			doThing();

		return;
	}
	
	private static void printUsage()
	{
		System.out.println
		(
			"Usage: [OPTION]... [DESTINATION]\n"
			+ "This is a placeholder message. The above usage is not "
			+ "functional yet."
		);
		
		return;
	}
	
	private static void doThing()
	{
		final int[][] tileMap =
		{
			{0,0,0,0,0,0,0},
			{0,0,1,0,1,0,0},
			{0,0,0,1,0,0,0},
			{0,0,1,0,1,0,0},
			{0,0,0,0,0,0,0}
		};
		
		UDMFMap map = new UDMFMap(tileMap, TILE_SIZE);
		map.writeTextmapToFile(FILE_NAME);
		
		return;
	}
}
