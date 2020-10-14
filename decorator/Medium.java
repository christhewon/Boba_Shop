package decorator;
import sale.Drink;

/**
 * Represents a Medium Size for a Drink.
 */
public class Medium extends Sizes {
    /**
     * Creates a Medium Size that wraps around a drink base
     * @param base a Drink which will be this size
     */
    public Medium(Drink base) {
        super(base);
        double newCost = base.getCost() + 1.00;
        base.setCost(newCost);
    }

    /**
     * Gets a String with the Drink's and the Medium's attributes
     * @return A String containing the drink's and the Medium's attributes
     */
    public String printDescription() {
        return getBase().printDescription() + "\nSize upgrade to Medium +$1.00";
    }
}
