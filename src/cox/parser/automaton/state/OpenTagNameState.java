package cox.parser.automaton.state;

import cox.model.XMLCharaters;
import cox.model.element.XMLNodeElement;
import cox.parser.automaton.XMLAutomaton;
import cox.parser.exception.parsing.MalformedTagNameException;

public class OpenTagNameState implements XMLAutomatonState
{
	private String name;

	public OpenTagNameState(char firstChar)
	{
		this.name = String.valueOf(firstChar);
	}

	@Override
	public void read(XMLAutomaton automaton, char c) throws MalformedTagNameException
	{
		if(XMLCharaters.isIdentifier(c))
		{
			this.name += c;
		}
		else if(c == XMLCharaters.CLOSING_TAG.getChar())
		{
			automaton.putElement(new XMLNodeElement(this.name));
			automaton.changeState(new ContentState());
		}
		else if(c == XMLCharaters.CLOSING_TAG_MARKER.getChar())
		{
			automaton.changeState(new OrphanTagState(this.name));
		}
		else if(XMLCharaters.isWhitespace(c))
		{
			automaton.changeState(new InOpenTagState(new XMLNodeElement(this.name)));
		}
		else
		{
			throw new MalformedTagNameException();
		}
	}

}
