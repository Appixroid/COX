package cox.parser.exception.parsing;

import cox.model.XMLCharaters;
import cox.parser.exception.COXAutomatonException;

public class InvalidTagStartException extends COXAutomatonException
{
	private static final long serialVersionUID = -4902304561183344085L;

	public InvalidTagStartException()
	{
		super("Tag markup must begin by an identifier or " + XMLCharaters.CLOSING_TAG_MARKER + " for closing tag");
	}
}
