package cox.parser.exception.parsing;

import cox.model.XMLCharaters;
import cox.parser.exception.COXAutomatonException;

public class MissingAttributeKeyValueSeparator extends COXAutomatonException
{
	private static final long serialVersionUID = -8439599769391051858L;

	public MissingAttributeKeyValueSeparator()
	{
		super("Attribute name must be followed by " + XMLCharaters.ATTRIBUTE_KEY_VALUE_SEPARATOR + " and a value between " + XMLCharaters.ATTRIBUTE_DELIMITER);
	}
}
