package cox.parser.automaton.state;

import cox.model.XMLCharaters;
import cox.parser.automaton.XMLAutomaton;
import cox.parser.exception.parsing.InvalidXMLDocumentStartException;

public class StartState implements XMLAutomatonState
{
	@Override
	public void read(XMLAutomaton automaton, char c) throws InvalidXMLDocumentStartException
	{
		if(c == XMLCharaters.OPENING_TAG.getChar())
		{
			automaton.changeState(new EnterTagState());
		}
		else if(!Character.isWhitespace(c))
		{
			throw new InvalidXMLDocumentStartException(c);
		}
	}
}
