import java.io.OutputStream;
import java.io.ByteArrayOutputStream;

public class Lump
{
	public final OutputStream data;
	
	public Lump()
	{
		this.data = new ByteArrayOutputStream();
	}
}
