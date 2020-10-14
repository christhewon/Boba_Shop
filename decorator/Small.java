package decorator;
import sale.Drink;

/**
 * Represents a Small Size for aDrink.
 */
public class Small extends Sizes {
    /**
     * Creates a Small Size that wraps around a drink base
     * @param base a Drink which will be this size
     */
    public Small(Drink base) {
        super(base);
        double newCost = base.getCost();
        base.setCost(newCost);
    }

    /**
     * Gets a String with the Drink's and the Small's attributes
     * @return A String containing the drink's and the Small's attributes
     */
    public String printDescription() {
        return getBase().printDescription();
    }
}
