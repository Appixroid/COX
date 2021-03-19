package cox.model.attribute;

public class SimpleXMLAttribute implements XMLAttribute
{
	private String name;
	private String value;

	public SimpleXMLAttribute(String name)
	{
		this(name, "");
	}

	public SimpleXMLAttribute(String name, String value)
	{
		this.name = name;
		this.value = value;
	}

	@Override
	public String getName()
	{
		return this.name;
	}

	@Override
	public String getValue()
	{
		return this.value;
	}

	@Override
	public boolean equals(Object obj)
	{
		if(obj instanceof XMLAttribute)
		{
			return super.equals((XMLAttribute) obj);
		}
		else
		{
			return false;
		}
	}

	@Override
	public String toString()
	{
		return this.getName() + "=" + this.getValue();
	}
}
