package sale;

/**
 * Represents a snack
 */
public abstract class Snack extends Sale{

	private int amount;

	/**
	 * Gets the cost of the snack while keeping the amount in mind
	 * @return A double representing the cost of the Snack times the amount
	 */
	public double getCost() {
		return getAmount() * super.getCost();
	}

	/**
	 * Gets the amount of this Snack
	 * @return An integer representing the amount of this Snack
	 */
	public int getAmount() {
		return amount;
	}

	/**
	 * Sets the amount of this snack
	 * @param amount An integer representing the amount that this snack will be set to
	 */
	public void setAmount(int amount) {
		this.amount = amount;
	}

	/**
	 * Gets the description of the Snack
	 * @return A String representing the components of the Snack
	 */
	public abstract String printDescription();
}
