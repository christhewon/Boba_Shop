package factory;
import java.util.ArrayList;

import decorator.*;
import sale.*;

/**
 * A Factory class that will be used to create Drinks
 */
public abstract class DrinkFactory {
	/**
	 * Creates a Tea or Coffee Drink object, using the following parameters
	 * @param type An enum type of the drink
	 * @param cost A double representing the cost of the drink
	 * @param name A string representing the name of the customer the drink is for
	 * @param sizeType An enum sizeType that represents the size of the drink
	 * @param toppings An array list of toppings the drink has
	 * @param sweetness An integer respresenting how sweet the drink will be
	 * @return A drink object initialized with its necessary attributes
	 */
	public static Drink makeSale(DrinkTypes type, double cost, String name, SizeTypes sizeType, ArrayList<ToppingsTypes> toppings, int sweetness) {
		Drink drink = null;
		
		switch(type) {
		case Coffee:
			drink = new Coffee(cost, name, sizeType);
			break;
		case Tea:
			drink = new Tea(cost, name, sizeType, sweetness);
		}

		switch(sizeType) {
			case Small:
				drink = new Small(drink);
				break;
			case Medium:
				drink = new Medium(drink);
				break;
			case Large:
				drink = new Large(drink);
				break;

		}

		for(ToppingsTypes t: toppings) {
			switch(t)
			{
			case Boba:
				drink = new Boba(drink);
				break;
			case ChocolateDrizzle:
				drink = new ChocolateDrizzle(drink);
				break;
			case CaramelDrizzle:
				drink = new CaramelDrizzle(drink);
				break;
			case LycheeJelly:
				drink = new LycheeJelly(drink);
				break;
			case PassFruitJelly:
				drink = new PassFruitJelly(drink);
				break;
			case HoneyBoba:
				drink = new HoneyBoba(drink);
				break;
			case FreshStrawberries:
				drink = new FreshStrawberries(drink);
				break;
			case HalfMilk:
				drink = new HalfMilk(drink);
				break;
			case SoyMilk:
				drink = new SoyMilk(drink);
				break;
			case WholeMilk:
				drink = new WholeMilk(drink);
				break;
			}
		}
		return drink;
	}
}
