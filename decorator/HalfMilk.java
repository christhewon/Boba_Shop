package decorator;
import sale.Drink;

/**
 * Represents a Half Milk Topping.
 */
public class HalfMilk extends Toppings {
	/**
	 * Creates a Half Milk topping that wraps around a drink base
	 * @param base a Drink which will hold this topping
	 */
	public HalfMilk(Drink base) {
		super(base);
		double newCost = base.getCost() + 0.25;
		base.setCost(newCost);
	}

	/**
	 * Gets a String with the Drink's and the HalfMilk's attributes
	 * @return A String containing the drink's and the HalfMilk's attributes
	 */
	public String printDescription() {
		return getBase().printDescription() + "\nAdded: Half Milk +$0.50";
	}
}
