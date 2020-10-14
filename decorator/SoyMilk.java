package decorator;
import sale.Drink;

/**
 * Represents a Soy Milk Topping.
 */
public class SoyMilk extends Toppings {
	/**
	 * Creates a Soy Milk topping that wraps around a drink base
	 * @param base a Drink which will hold this topping
	 */
	public SoyMilk(Drink base) {
		super(base);
		double newCost = base.getCost() + 0.5;
		base.setCost(newCost);
	}

	/**
	 * Gets a String with the Drink's and the SoyMilk's attributes
	 * @return A String containing the drink's and the SoyMilk's attributes
	 */
	public String printDescription() {
		return getBase().printDescription() + "\nAdded: Soy Milk +$0.50";
	}
}
