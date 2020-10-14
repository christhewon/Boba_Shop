package decorator;
import sale.Drink;

/**
 * Represents a Caramel Drizzle Topping
 */
public class CaramelDrizzle extends Toppings {
	/**
	 * Creates a Caramel Drizzle topping that wraps around a drink base
	 * @param base a Drink which will hold this topping
	 */
	public CaramelDrizzle(Drink base) {
		super(base);
		double newCost = base.getCost() + 0.5;
		base.setCost(newCost);
	}

	/**
	 * Gets a String with the Drink's and the CaramelDrizzle's attributes.
	 * @return A String containing the drink's and the CaramelDrizzle's attributes
	 */
	public String printDescription() {
		return getBase().printDescription() + "\nAdded: Caramel Drizzle +$0.50";
	}
}
