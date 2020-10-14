package sale;

import decorator.SizeTypes;

/**
 * Represents a tea drink
 */
public class Tea extends Drink{

	private int sweetness;

	/**
	 * Constructor for Tea Drink object
	 * @param cost A double representing the cost of the Tea
	 * @param name A String representing who the Tea is for
	 * @param sizeType A SizeType enum representing the size of a Tea
	 * @param sweetness An integer representing the sweetness of the Tea
	 */
	public Tea(double cost, String name, SizeTypes sizeType, int sweetness) {
		setName(name);
		setSizeType(sizeType);
		setSweetness(sweetness);
		setCost(cost);
		setBaseCost(cost);
	}



	/**
	 * Gets a description of the Tea
	 * @return A String representing all the components of the Tea
	 */
	public String printDescription() {
		return "Tea for " + getName() + "\nCost: $" + getBaseCost()+ "\nSize: " + getSizeType() +
				"\nSweetness: " + getSweetness() + "%";
	}


	/**
	 * Gets the sweetness of the drink
	 * @return An integer representing the sweetness of the drink
	 */
	public int getSweetness() {
		return sweetness;
	}


	/**
	 * Sets the sweetness of the drink
	 * @param sweetness An integer representing the sweetness of the drink
	 */
	public void setSweetness(int sweetness) {
		this.sweetness = sweetness;
	}
}
