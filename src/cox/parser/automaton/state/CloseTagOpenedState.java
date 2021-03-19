package cox.parser.automaton.state;

import cox.model.XMLCharaters;
import cox.parser.automaton.XMLAutomaton;
import cox.parser.exception.parsing.MalformedCloseTagException;

public class CloseTagOpenedState implements XMLAutomatonState
{
	@Override
	public void read(XMLAutomaton automaton, char c) throws MalformedCloseTagException
	{
		if(XMLCharaters.isIdentifier(c))
		{
			automaton.changeState(new CloseTagNameState(c));
		}
		else
		{
			throw new MalformedCloseTagException();
		}
	}
}
