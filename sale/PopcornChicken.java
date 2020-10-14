package sale;

/**
 * Represents a popcorn chicken snack
 */
public class PopcornChicken extends Snack {

    private String description;

    /**
     * Constructor for the PopcornChicken class
     * @param cost An integer representing the cost of the PopcornChicken
     * @param name A string representing who the PopcornChicken is for
     * @param amount An integer representing the number of PopcornChickens
     */
    public PopcornChicken(double cost, String name, int amount) {
        setName(name);
        setAmount(amount);
        setBaseCost(cost);
        setCost(cost);
    }

    /**
     * Gets a description of the PopcornChicken
     * @return A String representing all the components of the PopcornChicken
     */
    public String printDescription() {
        return "Popcorn Chicken for " + getName() + "\nCost: $" + getBaseCost() + "\nQuantity: " + getAmount();
    }

}

