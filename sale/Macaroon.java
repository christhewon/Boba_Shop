package sale;

/**
 * Represents a macaroon snack
 */
public class Macaroon extends Snack {

	/**
	 * Constructor for the Macaroon class
	 * @param cost An integer representing the cost of the Macaroon
	 * @param name A string representing who the Macaroon is for
	 * @param amount An integer representing the number of Macaroons
	 */
	public Macaroon(double cost, String name, int amount) {
		setName(name);
		setAmount(amount);
		setBaseCost(cost);
		setCost(cost);
	}

	/**
	 * Gets a description of the Macaroon
	 * @return A String representing all the components of the Macaroon
	 */
	public String printDescription() {
		return "Macaroon: " + getName() + "\nCost: $" + getBaseCost() + "\nQuantity: " + getAmount();
	}


}
