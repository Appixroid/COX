package cox.parser;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import cox.model.document.XMLDocument;
import cox.parser.automaton.XMLAutomaton;
import cox.parser.exception.COXParserException;

public class COXParser
{
	public static XMLDocument parse(File file) throws COXParserException
	{
		try
		{
			return COXParser.parse(new FileInputStream(file));
		}
		catch(FileNotFoundException e)
		{
			throw new COXParserException("Cannot open source file : " + e.getMessage(), ' ', 0, 0);
		}
	}

	public static XMLDocument parse(String xml) throws COXParserException
	{
		return COXParser.parse(new ByteArrayInputStream(xml.getBytes()));
	}

	public static XMLDocument parse(InputStream input) throws COXParserException
	{
		return new XMLAutomaton(input).getDocument();
	}
}
