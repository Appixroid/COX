package cox.parser.automaton.state;

import cox.parser.automaton.XMLAutomaton;
import cox.parser.exception.COXAutomatonException;

public interface XMLAutomatonState
{
	public abstract void read(XMLAutomaton automaton, char c) throws COXAutomatonException;
}
