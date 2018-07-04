public class Thing
{
	public int id;
	
	public double x, y, height; // Z height relative to floor.
								// Default = 0.
	public int angle, type; // DoomedNum. No valid default.
	public boolean
		skill1,skill2, skill3, skill4, skill5,
		ambush,
		single, dm, coop;
	// MBF friend flag not supported in Strife/Heretic/Hexen
	public boolean friend;
	// Hexen flags; not supported in Doom/Strife/Heretic
	public boolean dormant, class1, class2, class3;
	// Strife specific flags
	public boolean standing, strifeAlly, translucent, invisible;
	// note: suggested editor defaults for all skill, gamemode, and
	// player class flags is true rather than the udmf default of false.
	
	// thing special semantics are only defined for the hexen namespace
	// or ports which implement this feature in their own namespace.
	public int special, arg0, arg1, arg2, arg3, arg4;
	public String comment;
	
	public Thing()
	{
		this.id = 0;
		
		this.x = 0.0;
		this.y = 0.0;
		this.height = 0.0;
		
		this.angle = 0;
		this.type = 0;
		
		this.skill1 = false;
		this.skill2 = false;
		this.skill3 = false;
		this.skill4 = false;
		this.skill5 = false;
		this.ambush = false;
		this.single = true;
		this.dm = true;
		this.coop = true;
		
		this.friend = false;
		
		this.dormant = false;
		this.class1 = true;
		this.class2 = true;
		this.class3 = true;
		
		this.standing = false;
		this.strifeAlly = false;
		this.translucent = false;
		this.invisible = false;
		
		this.special = 0;
		this.arg0 = 0;
		this.arg1 = 0;
		this.arg2 = 0;
		this.arg3 = 0;
		this.arg4 = 0;
		
		this.comment = null;
	}
}
