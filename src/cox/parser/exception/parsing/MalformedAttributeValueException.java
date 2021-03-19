package cox.parser.exception.parsing;

import cox.model.XMLCharaters;
import cox.parser.exception.COXAutomatonException;

public class MalformedAttributeValueException extends COXAutomatonException
{
	private static final long serialVersionUID = 351952900768350907L;

	public MalformedAttributeValueException()
	{
		super("Attribute identifier and " + XMLCharaters.ATTRIBUTE_KEY_VALUE_SEPARATOR + " must be followed by a value delimited by " + XMLCharaters.ATTRIBUTE_DELIMITER);
	}
}
