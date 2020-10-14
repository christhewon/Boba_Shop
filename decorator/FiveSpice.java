package decorator;
import sale.Snack;

/**
 * Represents a Five Spice Chicken Flavor.
 */
public class FiveSpice extends ChickenFlavors {

    /**
     * Creates a Five Spice chicken flavor that wraps around a snack base
     * @param base a Snack which will hold this chicken flavor
     */
    public FiveSpice(Snack base) {
        super(base);
    }

    /**
     * Gets a String with the Snack's and the FiveSpice's attributes
     * @return A String containing the Snack's and the FiveSpice's attributes
     */
    public String printDescription() {
        return getBase().printDescription() + "\nFlavor: Five Spice";
    }
}
