package cox.parser.exception.parsing;

import cox.parser.exception.COXAutomatonException;

public class MissingClosingTagException extends COXAutomatonException
{
	private static final long serialVersionUID = -2041916638658340873L;

	public MissingClosingTagException(String foundTagName, String missingTagName)
	{
		super("Closing tag found for " + foundTagName + " whithout closing tag for " + missingTagName);
	}
}
