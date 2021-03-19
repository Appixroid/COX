package cox.model.attribute;

public interface XMLAttribute
{
	public abstract String getName();

	public abstract String getValue();

	public default boolean equals(XMLAttribute attribute)
	{
		return this.getName().equals(attribute.getName()) && this.getValue().equals(attribute.getValue());
	}
}
