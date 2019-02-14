package ausnahmen;

public class MyOwnException extends UnsupportedOperationException
{

	public MyOwnException(String message)
	{
		super(message);
	}
	
	
	
	//eigene methoden...
	public String getFehlerLog()
	{
		return null;
	}
	
	
	
	
	
	
	
}
