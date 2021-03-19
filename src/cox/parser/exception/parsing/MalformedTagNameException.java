package cox.parser.exception.parsing;

import cox.model.XMLCharaters;
import cox.parser.exception.COXAutomatonException;

public class MalformedTagNameException extends COXAutomatonException
{
	private static final long serialVersionUID = -2755050196249327599L;

	public MalformedTagNameException()
	{
		super("Open tag markup can only contains identifier and attributes separated with space, or " + XMLCharaters.CLOSING_TAG_MARKER + " for orphan tag");
	}
}
