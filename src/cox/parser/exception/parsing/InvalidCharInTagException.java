package cox.parser.exception.parsing;

import cox.model.XMLCharaters;
import cox.parser.exception.COXAutomatonException;

public class InvalidCharInTagException extends COXAutomatonException
{
	private static final long serialVersionUID = 1367578685767752467L;

	public InvalidCharInTagException()
	{
		super("Opening tag can only contains identifier and attributes separated by space, and optionally a " + XMLCharaters.CLOSING_TAG_MARKER + " to make it orphan");
	}
}
