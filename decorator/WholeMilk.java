package decorator;
import sale.Drink;

/**
 * Represents a Whole Milk Topping.
 */
public class WholeMilk extends Toppings {
    /**
     * Creates a Whole Milk topping that wraps around a drink base
     * @param base a Drink which will hold this topping
     */
    public WholeMilk(Drink base) {
        super(base);
        double newCost = base.getCost() + 0.5;
        base.setCost(newCost);
    }

    /**
     * Gets a String with the Drink's and the WholeMilk's attributes
     * @return A String containing the drink's and the WholeMilk's attributes
     */
    public String printDescription() {
        return getBase().printDescription() + "\nAdded: Whole Milk +$0.50";
    }
}

