package cox.parser.exception.parsing;

import cox.model.XMLCharaters;
import cox.parser.exception.COXAutomatonException;

public class InvalidAttributeNameException extends COXAutomatonException
{
	private static final long serialVersionUID = 3497117207872319658L;

	public InvalidAttributeNameException()
	{
		super("Attribute name must be compose of valid identifier chars and " + XMLCharaters.ATTRIBUTE_KEY_VALUE_SEPARATOR + " before the value");
	}
}
