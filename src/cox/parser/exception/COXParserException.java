package cox.parser.exception;

public class COXParserException extends Exception
{
	private static final long serialVersionUID = -1849978440662646295L;

	public COXParserException(String error, char c, int line, int character)
	{
		super("Parsing Error : " + error + " near " + c + " at line " + line + ":" + character);
	}
}
