package sale;

/**
 * Represents an item that could be sold
 */
public abstract class Sale
{
	private String name;
	private double cost;
	private double baseCost;




	/**
	 * passes getCost to subclasses
	 */


	// Getters

	/**
	 * Gets the name of the person who the Sale is for
	 * @return A string representing a name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Gets the cost of the sale
	 * @return A double representing the cost of the Sale
	 */
	public double getCost() {
		return this.cost;
	}

	/**
	 * Gets the cost of the sale before any customizations are added
	 * @return A double representing the cost of the Sale before any customizations are added
	 */
	public double getBaseCost() {
		return this.baseCost;
	}



	// Setters

	/**
	 * Sets the name of the Sale to the whom it is for
	 * @param name A string representing the name of the person who will be receiving th sale
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Sets the cost of the Sale
	 * @param c A double representing the cost that the Sale will be set to
	 */
	public void setCost(double c) {
		System.out.println("Cost set to " + c);
		this.cost = c;
	}

	/**
	 * Sets the baseCost of the Sale
	 * @param c A double representing the cost that the Sale will be set to
	 */
	public void setBaseCost(double c) {
		this.baseCost = c;
	}

	/**
	 * Gets the description of the Sale
	 * @return A String representing the components of the Sale
	 */
	public abstract String printDescription();

}
