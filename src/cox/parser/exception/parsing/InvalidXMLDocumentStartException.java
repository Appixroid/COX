package cox.parser.exception.parsing;

import cox.parser.exception.COXAutomatonException;

public class InvalidXMLDocumentStartException extends COXAutomatonException
{
	private static final long serialVersionUID = 6250542315696856952L;

	public InvalidXMLDocumentStartException(char c)
	{
		super("XML Document must start by an element not by '" + c + "'");
	}
}
