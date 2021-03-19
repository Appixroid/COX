package cox.model.document;

import cox.model.element.XMLElement;

public class SimpleXMLDocument implements XMLDocument
{
	private XMLElement root;

	public SimpleXMLDocument(XMLElement root)
	{
		this.root = root;
	}

	@Override
	public XMLElement getRoot()
	{
		return this.root;
	}

	@Override
	public boolean equals(Object obj)
	{
		if(obj instanceof XMLDocument)
		{
			return this.equals((XMLDocument) obj);
		}
		else
		{
			return false;
		}
	}

	@Override
	public String toString()
	{
		if(this.isEmpty())
		{
			return "Empty Document";
		}
		else
		{
			return this.getRoot().toString();
		}
	}
}
