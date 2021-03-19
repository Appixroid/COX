package cox.parser.automaton;

import java.io.IOException;
import java.io.InputStream;

import cox.model.document.SimpleXMLDocument;
import cox.model.document.XMLDocument;
import cox.model.element.XMLElement;
import cox.model.element.XMLPCDataElement;
import cox.parser.automaton.state.ContentState;
import cox.parser.automaton.state.StartState;
import cox.parser.automaton.state.XMLAutomatonState;
import cox.parser.exception.COXAutomatonException;
import cox.parser.exception.COXParserException;
import cox.parser.exception.parsing.InvalidContentOutsideTagException;
import cox.parser.exception.parsing.MissingClosingTagException;
import cox.parser.exception.parsing.MissingOpeningTagException;

public class XMLAutomaton
{
	private XMLElement root;
	private XMLElement currentElement;

	private XMLAutomatonState state;

	public XMLAutomaton(InputStream input) throws COXParserException
	{
		this.state = new StartState();
		this.readAll(input);
	}

	public void putElement(XMLPCDataElement element) throws InvalidContentOutsideTagException
	{
		if(this.currentElement == null)
		{
			throw new InvalidContentOutsideTagException();
		}
		else
		{
			this.currentElement.appendChild(element);
		}
	}

	public void putElement(XMLElement element)
	{
		if(this.root == null)
		{
			this.root = element;
			this.currentElement = this.root;
		}
		else
		{
			this.currentElement.appendChild(element);
			this.currentElement = element;
		}
	}

	public void closeElement(String tagName) throws COXAutomatonException
	{
		if(this.currentElement == null)
		{
			throw new MissingOpeningTagException(tagName);
		}
		else if(this.currentElement.getTagName().equals(tagName))
		{
			if(this.currentElement.isRoot())
			{
				this.currentElement = null;
			}
			else
			{
				this.currentElement = this.currentElement.getParent();
			}
		}
		else
		{
			throw new MissingClosingTagException(tagName, this.currentElement.getTagName());
		}
	}

	public void changeState(XMLAutomatonState state)
	{
		this.state = state;
	}

	public XMLDocument getDocument()
	{
		return new SimpleXMLDocument(this.root);
	}

	private void readAll(InputStream input) throws COXParserException
	{
		int c = ' ';
		
		int currentChar = 1;
		int currentLine = 1;

		try
		{
			while((c = input.read()) != -1)
			{
				try
				{
					this.state.read(this, (char) c);
				}
				catch(COXAutomatonException e)
				{
					throw new COXParserException(e.getMessage(), (char) c, currentLine, currentChar);
				}

				if(c == '\n')
				{
					currentLine++;
					currentChar = 1;
				}
				else
				{
					currentChar++;
				}
			}

			if(this.currentElement != null)
			{
				throw new COXParserException("The tag " + this.currentElement.getTagName() + " is never closed", (char) c, currentLine, currentChar);
			}
			else if(this.state instanceof ContentState)
			{
				ContentState endContent = (ContentState) this.state;
				if(endContent.hasData())
				{
					throw new COXParserException("There cannot be content after the root element", (char) c, currentLine, currentChar);
				}
			}
			else if(!(this.state instanceof StartState))
			{
				throw new COXParserException("XML root can only be composed of one root element", (char) c, currentLine, currentChar);
			}
		}
		catch(IOException e)
		{
			throw new COXParserException("Parsing Error : " + e.getMessage(), (char) c, currentLine, currentChar);
		}
	}
}
