package decorator;
import sale.Drink;

/**
 * Represents a Boba Topping
 */
public class Boba extends Toppings {

	/**
	 * Creates a Boba topping that wraps around a drink base
	 * @param base a Drink which will hold this topping
	 */
	public Boba(Drink base) {
		super(base);
		double newCost = base.getCost() + 0.5;
		base.setCost(newCost);
	}

	/**
	 * Gets a String with the Drink's and the Boba's attributes
	 * @return A String containing the drink's and the Boba's attributes
	 */
	public String printDescription() {
		return getBase().printDescription() + "\nAdded: Boba +$0.50";
	}

}
