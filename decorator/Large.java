package decorator;
import sale.Drink;

/**
 * Represents a Large Size Drink.
 */
public class Large extends Sizes {
    /**
     * Creates a Large Size that wraps around a drink base
     * @param base a Drink which will be this size
     */
    public Large(Drink base) {
        super(base);
        double newCost = base.getCost() + 2;
        base.setCost(newCost);
    }

    /**
     * Gets a String with the Drink's and the Large's attributes
     * @return A String containing the drink's and the Large's attributes
     */
    public String printDescription() {
        return getBase().printDescription() + "\nSize upgrade to Large +$2.00";
    }
}
