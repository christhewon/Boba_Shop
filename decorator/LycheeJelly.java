package decorator;
import sale.Drink;

/**
 * Represents a Lychee Jelly Topping.
 */
public class LycheeJelly extends Toppings {
	/**
	 * Creates a Lychee Jelly topping that wraps around a drink base
	 * @param base a Drink which will hold this topping
	 */
	public LycheeJelly(Drink base) {
		super(base);
		double newCost = base.getCost() + 0.5;
		base.setCost(newCost);
	}

	/**
	 * Gets a String with the Drink's and the LycheeJelly's attributes
	 * @return A String containing the drink's and the LycheeJelly's attributes
	 */
	public String printDescription() {
		return getBase().printDescription() + "\nAdded: Lychee Jelly +$0.50";
	}
}
