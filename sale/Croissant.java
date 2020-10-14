package sale;

/**
 * Represents a croissant snack
 */
public class Croissant extends Snack {

	private boolean heat;
	/**

	 */

	/**
	 * Constructor for the Croissant class
	 * @param cost An integer representing the cost of the Croissant
	 * @param name A string representing who the Croissant is for
	 * @param amount An integer representing the number of Croissants
	 * @param heat A boolean representing whether the Croissant is heated or not
	 */
	public Croissant(double cost, String name, int amount, boolean heat) {
		setName(name);
		setAmount(amount);
		setBaseCost(cost);
		setCost(cost);
		setHeat(heat);
	}

	/**
	 * Gets a description of the Croissant
	 * @return A String representing all the components of the Croissant
	 */
	public String printDescription() {
		String heated = "";
		if(this.heat == true) {
			heated = "Yes";
		}
		else {
			heated = "No";
		}
		return "Croissant: " + getName() + "\nCost: $" + getBaseCost() + "\nHeated: " + heated +"\nQuantity: " + getAmount();
	}

	/**
	 * Gets the boolean for whether or not the croissant is heated or not
	 * @return A boolean representing whether or not the croissant is heated or not
	 */
	public boolean getHeat() {
		return heat;
	}

	/**
	 * Sets the heat of the croissant
	 * @param heat A boolean representing whether or not the croissant is heated or not
	 */
	public void setHeat(boolean heat) {
		this.heat = heat;
	}


}
