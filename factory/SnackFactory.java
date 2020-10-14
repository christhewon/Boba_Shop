package factory;

import decorator.*;
import sale.*;

/**
 * A factory class used to create Snacks
 */
public class SnackFactory
{
	/**
	 * Creates a Snack object, using the following parameters
	 * @param type An enum for the type of snack
	 * @param cost A double representing the cost of the snack
	 * @param name A string representing the name of the customer the snack is for
	 * @param amount An integer representing the quantity of the snack wanted
	 * @param heated A boolean to determine whether a croissant will be heated or not
	 * @param flavor A enum for the type of Chicken Flavor
	 * @return A Snack Object with its attributes
	 */
	public static Snack makeSale(SnackTypes type, double cost, String name, int amount, boolean heated, ChickenFlavorTypes flavor) {
		Snack snack = null;

		switch(type) {
			case Croissant:
				snack = new Croissant(cost, name, amount, heated);
				break;
			case Cookie:
				snack = new Cookie(cost, name, amount);
				break;
			case Macaroon:
				snack = new Macaroon( cost, name, amount);
				break;
			case PopcornChicken:
				snack = new PopcornChicken(cost, name, amount);
				break;
		}

		if (type == SnackTypes.PopcornChicken) {
			switch(flavor) {
				case FiveSpice:
					snack = new FiveSpice(snack);
					break;
				case GarlicParmesan:
					snack = new GarlicParmesan(snack);
					break;
				case Buffalo:
					snack = new Buffalo(snack);
					break;
			}
		}
		return snack;
	}
	
	
	
	


}
