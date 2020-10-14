package decorator;
import sale.Drink;

/**
 * Represents a Honey Boba Topping.
 */
public class HoneyBoba extends Toppings {
	/**
	 * Creates a Honey Boba topping that wraps around a drink base
	 * @param base a Drink which will hold this topping
	 */
	public HoneyBoba(Drink base) {
		super(base);
		double newCost = base.getCost() + 0.5;
		base.setCost(newCost);
	}

	/**
	 * Gets a String with the Drink's and the HoneyBoba's attributes
	 * @return A String containing the drink's and the HoneyBoba's attributes
	 */
	public String printDescription() {
		return getBase().printDescription() + "\nAdded: Honey Boba +$0.50";
	}
}
