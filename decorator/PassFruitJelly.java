package decorator;
import sale.Drink;

/**
 * Represents a Passion Fruit Jelly Topping.
 */
public class PassFruitJelly extends Toppings {
	/**
	 * Creates a Passion Fruit Jelly topping that wraps around a drink base
	 * @param base a Drink which will hold this topping
	 */
	public PassFruitJelly(Drink base) {
		super(base);
		double newCost = base.getCost() + 0.5;
		base.setCost(newCost);
	}

	/**
	 * Gets a String with the Drink's and the PassFruitJelly's attributes
	 * @return A String containing the drink's and the PassFruitJelly's attributes
	 */
	public String printDescription() {
		return getBase().printDescription() + "\nAdded: Passion Fruit Jelly +$0.50";
	}
}
