package cox.parser.automaton.state;

import cox.model.XMLCharaters;
import cox.model.element.XMLNodeElement;
import cox.parser.automaton.XMLAutomaton;
import cox.parser.exception.COXAutomatonException;
import cox.parser.exception.parsing.MissingOrphanTagEndException;

public class OrphanTagState implements XMLAutomatonState
{
	private XMLNodeElement element;

	public OrphanTagState(String name)
	{
		this.element = new XMLNodeElement(name);
	}

	public OrphanTagState(XMLNodeElement element)
	{
		this.element = element;
	}

	@Override
	public void read(XMLAutomaton automaton, char c) throws COXAutomatonException
	{
		if(c == XMLCharaters.CLOSING_TAG.getChar())
		{
			automaton.putElement(this.element);
			automaton.closeElement(this.element.getTagName());
			automaton.changeState(new ContentState());
		}
		else
		{
			throw new MissingOrphanTagEndException();
		}
	}

}
