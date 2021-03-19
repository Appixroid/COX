package cox.parser.automaton.state;

import cox.model.XMLCharaters;
import cox.parser.automaton.XMLAutomaton;
import cox.parser.exception.COXAutomatonException;

public class CloseTagNameState implements XMLAutomatonState
{
	private String name;

	public CloseTagNameState(char firstChar)
	{
		this.name = String.valueOf(firstChar);
	}

	@Override
	public void read(XMLAutomaton automaton, char c) throws COXAutomatonException
	{
		if(XMLCharaters.isIdentifier(c))
		{
			this.name += c;
		}
		else if(c == XMLCharaters.CLOSING_TAG.getChar())
		{
			automaton.closeElement(this.name);
			automaton.changeState(new ContentState());
		}
		else if(XMLCharaters.isWhitespace(c))
		{
			automaton.changeState(new InCloseTagState(this.name));
		}
	}
}
