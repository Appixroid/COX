package cox.parser.exception.parsing;

import cox.parser.exception.COXAutomatonException;

public class InvalidContentOutsideTagException extends COXAutomatonException
{
	private static final long serialVersionUID = -3903715885205663255L;

	public InvalidContentOutsideTagException()
	{
		super("Cannot add text in XML document outside a tag");
	}
}
