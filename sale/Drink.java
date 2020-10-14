package sale;

import decorator.SizeTypes;

/**
 * Represents a drink
 */
public abstract class Drink extends Sale
{
	private SizeTypes sizeType;

	/**
	 * Gets the size of the Drink
	 * @return A SizeType enum that represents the size of the Drink
	 */
	public SizeTypes getSizeType() {
		return sizeType;
	}

	/**
	 * Sets the size of the Drink
	 * @param s A SizeType enum that represents the size of the Drink
	 */
	public void setSizeType(SizeTypes s) {
		sizeType = s;
	}

	/**
	 * Gets the description of the Drink
	 * @return A String representing the components of the Drink
	 */
	public abstract String printDescription();
}
