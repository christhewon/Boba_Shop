package decorator;
import sale.Drink;

/**
 * Represents a Fresh Strawberries Topping.
 */
public class FreshStrawberries extends Toppings {
	/**
	 * Creates a Fresh Strawberry topping that wraps around a drink base
	 * @param base a Drink which will hold this topping
	 */
	public FreshStrawberries(Drink base) {
		super(base);
		double newCost = base.getCost() + 0.5;
		base.setCost(newCost);
	}

	/**
	 * Gets a String with the Drink's and the FreshStrawberries' attributes
	 * @return A String containing the drink's and the FreshStrawberries' attributes
	 */
	public String printDescription() {
		return getBase().printDescription() + "\nAdded: Fresh Strawberries +$0.50";
	}
}
