package cox.parser.exception.parsing;

import cox.model.XMLCharaters;
import cox.parser.exception.COXAutomatonException;

public class MissingOrphanTagEndException extends COXAutomatonException
{
	private static final long serialVersionUID = 3593570878321209013L;

	public MissingOrphanTagEndException()
	{
		super("Tags must end with " + XMLCharaters.CLOSING_TAG);
	}
}
