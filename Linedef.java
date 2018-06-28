public class Linedef
{
	public int index;
	
	public int id;
	public Vertex v1, v2;
	
	public boolean
		blocking,
		blockMonsters,
		twoSided,
		dontPegTop,
		dontPegBottom,
		secret,
		blockSound,
		dontDraw,
		mapped;
	public boolean
	// UDMF: BOOM passuse flag not supported in Strife/Heretic/Hexen
		passUse,
		playerCross,
		playerUse,
		monsterCross,
		monsterUse,
		impact,
		playerPush,
		monsterPush,
		missileCross,
		repeatSpecial;
	public int
		special,
		arg0, arg1, arg2, arg3, arg4;
	
	public Sidedef sideFront, sideBack;
	
	public String comment;
	
	public Linedef()
	{
		this.index = -1;
		
		this.id = -1;
		
		this.v1 = null;
		this.v2 = null;
		
		this.blocking = true;
		this.blockMonsters = false;
		this.twoSided = false;
		this.dontPegTop = false;
		this.dontPegBottom = false;
		this.secret = false;
		this.blockSound = false;
		this.dontDraw = false;
		this.mapped = false;
		
		this.passUse = false;
		
		this.playerCross = false;
		this.playerUse = false;
		this.monsterCross = false;
		this.monsterUse = false;
		this.impact = false;
		this.playerPush = false;
		this.monsterPush = false;
		this.missileCross = false;
		this.repeatSpecial = false;
		
		this.special = 0;
		this.arg0 = 0;
		this.arg1 = 0;
		this.arg2 = 0;
		this.arg3 = 0;
		this.arg4 = 0;
		
		this.sideFront = new Sidedef();
		this.sideBack = null;
	}
	
	public Linedef(Vertex v1, Vertex v2)
	{
		this();
		
		this.v1 = v1;
		this.v2 = v2;
	}
	
	public Linedef(Sidedef sideFront, Vertex v1, Vertex v2)
	{
		this(v1, v2);
		this.sideFront = sideFront;
	}
	
	public Linedef(Sidedef sideFront, Sidedef sideBack, Vertex v1, Vertex v2)
	{
		this(sideFront, v1, v2);
		this.sideBack = sideBack;
	}
	
	public boolean equals(Linedef other)
	{
		if (this.v1.equals(other.v2) && this.v2.equals(other.v1)
			|| (this.v1.equals(other.v1) && this.v2.equals(other.v2)))
		{
			return true;
		}
		
		return false;
	}
	
	@Override
	public String toString()
	{
		String str = "linedef // " + index;
		
		str += String.format("%n{%n");
		
		if (id != -1) {
			str += String.format("id = %d;%n", id);
			str += System.lineSeparator();
		}
		
		str += String.format("\tv1 = %d;%n", this.v1.index);
		str += String.format("\tv2 = %d;%n", this.v2.index);
		
		if (blocking)
			{ str += String.format("\tblocking = %b;%n", blocking); }
		if (blockMonsters)
			{ str += String.format("\tblockmonsters = %b;%n", blockMonsters); }
		if (twoSided)
			{ str += String.format("\ttwoSided = %b;%n", twoSided); }
		if (dontPegTop)
			{ str += String.format("\tdontpegtop = %b;%n", dontPegTop); }
		if (dontPegBottom)
			{ str += String.format("\tdontpegbottom = %b;%n", dontPegBottom); }
		if (secret)
			{ str += String.format("\tsecret = %b;%n", secret); }
		if (blockSound)
			{ str += String.format("\tblocksound = %b;%n", blockSound); }
		if (dontDraw)
			{ str += String.format("\tdontdraw = %b;%n", dontDraw); }
		if (mapped)
			{ str += String.format("\tmapped = %b;%n", mapped); }
		
		if (passUse)
			{ str += String.format("\tpassuse = %b;%n", passUse); }
		
		if (playerCross)
			{ str += String.format("\tplayercross = %b;%n", playerCross); }
		if (playerUse)
			{ str += String.format("\tplayeruse = %b;%n", playerUse); }
		if (monsterCross)
			{ str += String.format("\tmonstercross = %b;%n", monsterCross); }
		if (monsterUse)
			{ str += String.format("\tmonsteruse = %b;%n", monsterUse); }
		if (impact)
			{ str += String.format("\timpact = %b;%n", impact); }
		if (playerPush)
			{ str += String.format("\tplayerpush = %b;%n", playerPush); }
		if (monsterPush)
			{ str += String.format("\tmonsterpush = %b;%n", monsterPush); }
		if (missileCross)
			{ str += String.format("\tmissilecross = %b;%n", missileCross); }
		if (repeatSpecial)
			{ str += String.format("\trepeatspecial = %b;%n", repeatSpecial); }
		
		if (special != 0)
			{ str += String.format("\tplayercross = %d;%n", special); }
		if (arg0 != 0)
			{ str += String.format("\targ0 = %d;%n", arg0); }
		if (arg1 != 0)
			{ str += String.format("\targ1 = %d;%n", arg1); }
		if (arg2 != 0)
			{ str += String.format("\targ2 = %d;%n", arg2); }
		if (arg3 != 0)
			{ str += String.format("\targ3 = %d;%n", arg3); }
		if (arg4 != 0)
			{ str += String.format("\targ4 = %d;%n", arg4); }
		
		if (sideFront != null)
			{ str += String.format("\tsidefront = %d;%n", sideFront.index); }
		if (sideBack != null)
			{ str += String.format("\tsideback = %d;%n", sideBack.index); }
		else
			{ str += String.format("\tsideback = -1;%n"); }
		
		str += String.format("}%n");
		
		return str;
	}
}
