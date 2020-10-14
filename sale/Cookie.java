package sale;

/**
 * Represents a cookie snack
 */
public class Cookie extends Snack
{
	/**
	 * Constructor for the Cookie class
	 * @param cost An integer representing the cost of the Cookie
	 * @param name A string representing who the Cookie is for
	 * @param amount An integer representing the number of Cookies
	 */
	public Cookie(double cost, String name, int amount) {
		setName(name);
		setAmount(amount);
		setBaseCost(cost);
		setCost(cost);


	}

	/**
	 * Gets a description of the Cookie
	 * @return A String representing all the components of the Cookie
	 */
	public String printDescription() {
		return "Cookie: " + getName() + "\nCost: $" + getBaseCost() + "\nQuantity: " + getAmount();
	}


}
