package decorator;
import sale.Drink;
import sale.Sale;

/**
 * Represents a Size for a Drink.
 */
public abstract class Sizes extends Drink {

    private Sale base;

    /**
     * Creates a size that wraps around a drink base
     * @param base a Drink which will be this size
     */
    public Sizes(Sale base) {
        this.base = base;

    }

    /**
     * Gets the cost of the Size's base
     * @return A double that contains the price of the topping's base
     */
    public double getCost() {
        return base.getCost();
    }

    /**
     * Gets the base of the Sizes
     * @return The Sale base for the Sizes
     */
    public Sale getBase() {
        return this.base;
    }

    /**
     * Sets the cost of the Size's base
     * @param cost the cost that the Size's base is getting set to
     */
    public void setCost(double cost) {
        base.setCost(cost);
    }

}
