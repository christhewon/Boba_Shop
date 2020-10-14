package decorator;
import sale.Snack;

/**
 * Represents a Buffalo Chicken Flavor.
 */
public class Buffalo extends ChickenFlavors {
    /**
     * Creates a Buffalo chicken flavor that wraps around a snack base
     * @param base a Snack which will hold this chicken flavor
     */
    public Buffalo(Snack base) {
        super(base);
        double newCost = base.getBaseCost() + 0.75;
        base.setCost(newCost);
    }

    /**
     * Gets a String with the Snack's and the Buffalo's attributes
     * @return A String containing the Snack's and the Buffalo's attributes
     */
    public String printDescription() {
        return getBase().printDescription() + "\nFlavor: Buffalo +$0.75";
    }
}


