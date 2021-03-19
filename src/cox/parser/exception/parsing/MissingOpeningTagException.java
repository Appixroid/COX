package cox.parser.exception.parsing;

import cox.parser.exception.COXAutomatonException;

public class MissingOpeningTagException extends COXAutomatonException
{
	private static final long serialVersionUID = -2041916638658340873L;

	public MissingOpeningTagException(String foundTagName)
	{
		super("Closing tag found for " + foundTagName + " whithout opening tag for " + foundTagName);
	}
}
