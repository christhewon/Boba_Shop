package decorator;
import sale.Snack;

/**
 * Represents a Garlic Parmesan Chicken Flavor.
 */
public class GarlicParmesan extends ChickenFlavors {
    /**
     * Creates a Garlic Parmesan chicken flavor that wraps around a snack base
     * @param base a Snack which will hold this chicken flavor
     */
    public GarlicParmesan(Snack base) {
        super(base);
        double newCost = base.getBaseCost() + 0.75;
        base.setCost(newCost);
    }

    /**
     * Gets a String with the Snack's and the GarlicParmesan's attributes
     * @return A String containing the Snack's and the GarlicParmesan's attributes
     */
    public String printDescription() {
        return getBase().printDescription() + "\nFlavor: Garlic Parmesan +$0.75";
    }


}

