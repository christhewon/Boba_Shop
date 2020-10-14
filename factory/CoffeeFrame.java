package factory;


import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

import decorator.*;
import sale.*;


/**
 * A frame containing the options to build a Coffee Drink.
 */
public class CoffeeFrame extends SubFrames {
	private JLabel nameLabel;
	private JTextField name;
	private JPanel panel;
	private JComboBox<String> sizes;
	private JComboBox<String> milkBase;
	private JButton saveButton;
	private JButton closeButton;
	private JCheckBox chocolateDrizzle;
	private JCheckBox caramelDrizzle;

	/**
	 * Creates a new coffee frame
	 */
	public CoffeeFrame() {
		createComponents();
		this.setTitle("New Coffee Order");
		this.setSize(900, 300);
	}

	/**
	 * Creates and initializes all the gui components including event handlers then adds them to a panel
	 */
	private void createComponents() {
		String[] bases = {"No milk", "Whole Milk", "Half and Half", "Soy Milk"};
		String[] s = {"S", "M" ,"L"};

		// Initializes components
		nameLabel = new JLabel("name: ");
		name = new JTextField(20);
		sizes = new JComboBox<String>(s);
		milkBase = new JComboBox<String>(bases);
		chocolateDrizzle = new JCheckBox("Chocolate Drizzle");
		caramelDrizzle = new JCheckBox("Caramel Drizzle");
		saveButton = new JButton("Save Order");
		closeButton = new JButton("Cancel");

		// Creates event listeners
		ActionListener cancelListener = new CancelButtonListener();
		ActionListener saveListener = new SaveButtonListener();

		// Adds event listeners to buttons
		closeButton.addActionListener(cancelListener);
		saveButton.addActionListener(saveListener);

		panel = new JPanel();

		// Adds components to the panel
		panel.add(nameLabel);
		panel.add(name);
		panel.add(sizes);
		panel.add(milkBase);
		panel.add(chocolateDrizzle);
		panel.add(caramelDrizzle);
		panel.add(saveButton);
		panel.add(closeButton);

		// Adds the panel to the frame
		this.add(panel);
	}


	/**
	 * An inner class event listener for the save button
	 */
	class SaveButtonListener implements ActionListener {

		/**
		 * When the save button is clicked, The current choices will be saved and used to create a Coffee Drink Object
		 * @param click The action performed which in this case is a clicking the button
		 */
		public void actionPerformed(ActionEvent click) {

			ArrayList<ToppingsTypes> toppings = new ArrayList<ToppingsTypes>();

			//Size Choice
			SizeTypes drinkSizeType = determineSize(sizes);

			//Milk Choice
			if(milkBase.getSelectedItem() == "Whole Milk") {
				toppings.add(ToppingsTypes.WholeMilk);
			}
			else if(milkBase.getSelectedItem() == "Soy Milk") {
				toppings.add(ToppingsTypes.SoyMilk);
			}
			else if(milkBase.getSelectedItem() == "Half Milk") {
				toppings.add(ToppingsTypes.HalfMilk);
			}

			// Toppings Choice
			if(chocolateDrizzle.isSelected()) {
				toppings.add(ToppingsTypes.ChocolateDrizzle);
			}
			if(caramelDrizzle.isSelected()) {
				toppings.add(ToppingsTypes.CaramelDrizzle);
			}

			String drinkName = name.getText();

			// Uses Factory class to make the drink object
			Drink coffee = DrinkFactory.makeSale(DrinkTypes.Coffee, 3, drinkName, drinkSizeType, toppings, 0);

			// Prints to the screen all necessary information on the order
			printSummary(coffee);

			// Closes the current frame
			closeFrame(click);
		}
	}

	/**
	 * An inner class event listener for the cancel button
	 */
	class CancelButtonListener implements ActionListener {

		/**
		 * Closes the frame when the cancel button is click
		 * @param click
		 */
		public void actionPerformed(ActionEvent click) {
			closeFrame(click);
		}
	}
}

