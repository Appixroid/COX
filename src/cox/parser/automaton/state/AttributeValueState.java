package cox.parser.automaton.state;

import cox.model.XMLCharaters;
import cox.model.attribute.SimpleXMLAttribute;
import cox.model.element.XMLNodeElement;
import cox.parser.automaton.XMLAutomaton;

public class AttributeValueState implements XMLAutomatonState
{
	private XMLNodeElement element;
	private String name;
	private String value = "";

	public AttributeValueState(XMLNodeElement element, String name)
	{
		this.element = element;
		this.name = name;
	}

	@Override
	public void read(XMLAutomaton automaton, char c)
	{
		if(c == XMLCharaters.ATTRIBUTE_DELIMITER.getChar())
		{
			this.element.addAttribute(new SimpleXMLAttribute(this.name, this.value));
			automaton.changeState(new InOpenTagState(this.element));
		}
		else
		{
			this.value += c;
		}
	}
}
