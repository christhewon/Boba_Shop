package decorator;
import sale.Drink;

/**
 * Represents a Chocolate Drizzle Topping.
 */
public class ChocolateDrizzle extends Toppings {
	/**
	 * Creates a Chocolate Drizzle topping that wraps around a drink base
	 * @param base a Drink which will hold this topping
	 */
	public ChocolateDrizzle(Drink base) {
		super(base);
		double newCost = base.getCost() + 0.5;
		base.setCost(newCost);
	}

	/**
	 * Gets a String with the Drink's and the ChocolateDrizzle's attributes
	 * @return A String containing the drink's and the ChocolateDrizzle's attributes
	 */
	public String printDescription() {
		return getBase().printDescription() + "\nAdded: Chocolate Drizzle +$0.50";
	}
}
