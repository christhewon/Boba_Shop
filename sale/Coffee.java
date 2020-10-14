package sale;

import decorator.SizeTypes;

/**
 * Represents a coffee drink
 */
public class Coffee extends Drink{

	/**
	 * Constructor for Coffee Drink object
	 * @param cost A double representing the cost of the Coffee
	 * @param name A String representing who the Coffee is for
	 * @param sizeType A SizeType enum representing the size of a Coffee
	 */
	public Coffee(double cost, String name, SizeTypes sizeType) {
		setCost(cost);
		setBaseCost(cost);
		setName(name);
		setSizeType(sizeType);
	}


	/**
	 * Gets a description of the Coffee
	 * @return A String representing all the components of the Coffee
	 */
	public String printDescription() {
		return "Coffee for " + getName() + "\nCost: $" + getBaseCost()+ "\nSize: " + getSizeType();
	}
}
