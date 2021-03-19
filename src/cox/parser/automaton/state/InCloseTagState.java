package cox.parser.automaton.state;

import cox.model.XMLCharaters;
import cox.parser.automaton.XMLAutomaton;
import cox.parser.exception.COXAutomatonException;

public class InCloseTagState implements XMLAutomatonState
{
	private String name;

	public InCloseTagState(String name)
	{
		this.name = name;
	}

	@Override
	public void read(XMLAutomaton automaton, char c) throws COXAutomatonException
	{
		if(c == XMLCharaters.CLOSING_TAG.getChar())
		{
			automaton.closeElement(this.name);
			automaton.changeState(new ContentState());
		}
		else if(!XMLCharaters.isWhitespace(c))
		{
		}
	}

}
