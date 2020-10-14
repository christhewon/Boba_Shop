package decorator;

import sale.Snack;
import sale.Sale;

/**
 * Represents a Chicken Flavor.
 */
public abstract class ChickenFlavors extends Snack {

    private Sale base;

    /**
     * Creates a chicken flavor that wraps around a snack base
     * @param base a Snack which will hold this chicken flavor
     */
    public ChickenFlavors(Sale base) {
        this.base = base;

    }

    /**
     * Gets the cost of the topping's base
     * @return A double that contains the price of the topping's base
     */
    public double getCost() {
        return base.getCost();
    }

    /**
     * Gets the base of the ChickenFlavors
     * @return The Sale base for the Chicken Flavors
     */
    public Sale getBase() {
        return this.base;
    }

    /**
     * Sets the cost of ChickenFlavors base as cost
     * @param cost The double being set to the base's cost
     */
    public void setCost(double cost) {
        base.setCost(cost);
    }
}
