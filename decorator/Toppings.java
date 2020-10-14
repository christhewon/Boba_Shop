package decorator;
import sale.*;

/**
 * Represents a Topping for a Drink.
 */
public abstract class Toppings extends Drink {
	
	private Sale base;

	/**
	 * Creates a topping that wraps around a drink base
	 * @param base a Drink which will hold this topping
	 */
	public Toppings(Sale base) {
		this.base = base;

	}

	/**
	 * Gets the cost of the base for this topping
	 * @return A double that represents the cost of the base of this topping
	 */
	public double getCost() {
		System.out.println("Toppings: " + base.getCost());
		return base.getCost();
	}

	/**
	 * Sets the cost of the base for this topping
	 * @param cost A double that represents the cost of the base of this topping
	 */
	public void setCost(double cost) {
		base.setCost(cost);
	}



	/**
	 * Gets the base of the toppings
	 * @return The Sale base for the toppings
	 */
	public Sale getBase() {
		return this.base;
	}
	
}
