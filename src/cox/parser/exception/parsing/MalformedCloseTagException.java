package cox.parser.exception.parsing;

import cox.model.XMLCharaters;
import cox.parser.exception.COXAutomatonException;

public class MalformedCloseTagException extends COXAutomatonException
{
	private static final long serialVersionUID = 4506309445405123816L;

	public MalformedCloseTagException()
	{
		super("Closing tag must begin with " + XMLCharaters.CLOSING_TAG + XMLCharaters.CLOSING_TAG_MARKER + " followed by an identifier");
	}
}
