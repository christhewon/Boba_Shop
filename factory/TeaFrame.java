package factory;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import decorator.*;
import sale.*;

/**
 * A frame containing the options to build a Tea object
 */
public class TeaFrame extends SubFrames {
	private JPanel panel;
	private JComboBox<String> sizes;
	private JComboBox<String> sweetness;
	private JComboBox<String> milkBase;
	private JButton cancelButton;
	private JTextField name;
	private JLabel nameLabel;
	private JButton saveButton;
	private JCheckBox boba;
	private JCheckBox honeyBoba;
	private JCheckBox lycheeJelly;
	private JCheckBox passionFruitJelly;
	private JCheckBox freshStrawberries;
	private JCheckBox chocolateDrizzle;
	private JCheckBox caramelDrizzle;


	/**
	 * Constructor for NewTeaFrame class
	 */
	public TeaFrame() {
		createComponents();
		this.setTitle("New Tea Order");
		this.setSize(800, 400);
	}

	/**
	 * Creates and initializes all the gui components including event handlers then adds them to a panel using a
	 * Grid Bag layout
	 */
	private void createComponents() {
		String[] s = {"S", "M" ,"L"};
		sizes = new JComboBox<String>(s);
		String[] sweets = {"0% Sweet", "25% Sweet", "50% Sweet", "75% Sweet", "100% Sweet"};
		sweetness = new JComboBox<String>(sweets);
		String[] bases = {"Whole Milk", "Half-and-Half", "Soy Milk", "No Milk"};
		milkBase = new JComboBox<String>(bases);
		nameLabel = new JLabel("name: ");
		name = new JTextField(20);
		saveButton = new JButton("Save Order");
		cancelButton = new JButton("Cancel");

		ActionListener saveListener = new SaveButtonListener();
		ActionListener cancelListener = new CancelButtonListener();
		saveButton.addActionListener(saveListener);
		cancelButton.addActionListener(cancelListener);

		boba = new JCheckBox("Boba");
		honeyBoba = new JCheckBox("Honey Boba");
		chocolateDrizzle = new JCheckBox("Chocolate Drizzle");
		caramelDrizzle = new JCheckBox("Caramel Drizzle");
		lycheeJelly = new JCheckBox("Lychee Jelly");
		passionFruitJelly = new JCheckBox("Passion Fruit Jelly");
		freshStrawberries = new JCheckBox("Fresh Strawberries");

		panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill=GridBagConstraints.HORIZONTAL;
		gbc.weightx = 1;
		gbc.weighty = 1;

		gbc.gridx = 0;
		gbc.gridy = 0;
		panel.add(nameLabel, gbc);

		gbc.gridx = 1;
		gbc.gridy = 0;
		panel.add(name, gbc);

		gbc.gridx = 2;
		gbc.gridy = 0;
		panel.add(sizes, gbc);

		gbc.gridx = 3;
		gbc.gridy = 0;
		panel.add(sweetness, gbc); 

		gbc.gridx = 4;
		gbc.gridy = 0;
		panel.add(milkBase, gbc);

		gbc.gridx = 0;
		gbc.gridy = 1;
		panel.add(boba, gbc);

		gbc.gridx = 1;
		gbc.gridy = 1;
		panel.add(chocolateDrizzle, gbc);

		gbc.gridx = 2;
		gbc.gridy = 1;
		panel.add(caramelDrizzle, gbc);

		gbc.gridx = 3;
		gbc.gridy = 1;
		panel.add(lycheeJelly, gbc);

		gbc.gridx = 4;
		gbc.gridy = 1;
		panel.add(honeyBoba, gbc);

		gbc.gridx = 5;
		gbc.gridy = 1;
		panel.add(freshStrawberries, gbc);

		gbc.gridx = 6;
		gbc.gridy = 1;
		panel.add(passionFruitJelly, gbc);

		gbc.gridx = 3;
		gbc.gridy = 2;
		panel.add(saveButton, gbc);

		gbc.gridx = 4;
		gbc.gridy = 2;
		panel.add(cancelButton, gbc);

		this.add(panel);
		pack();

	}

	/**
	 * An inner class event listener for the save button
	 */
	class SaveButtonListener implements ActionListener{

		/**
		 * When the save button is clicked, The current choices will be saved and used to create a Tea Drink Object
		 * @param click The action performed which in this case is clicking the button
		 */
		public void actionPerformed(ActionEvent click) {

			ArrayList<ToppingsTypes> toppings = new ArrayList<ToppingsTypes>();

			//Topping Choice
			if(boba.isSelected()) {
				toppings.add(ToppingsTypes.Boba);
			}
			if(honeyBoba.isSelected()) {
				toppings.add(ToppingsTypes.HoneyBoba);
			}
			if(chocolateDrizzle.isSelected()) {
				toppings.add(ToppingsTypes.ChocolateDrizzle);
			}
			if(caramelDrizzle.isSelected()) {
				toppings.add(ToppingsTypes.CaramelDrizzle);
			}
			if(lycheeJelly.isSelected()) {
				toppings.add(ToppingsTypes.LycheeJelly);
			}
			if(freshStrawberries.isSelected()) {
				toppings.add(ToppingsTypes.FreshStrawberries);
			}
			if(passionFruitJelly.isSelected()) {
				toppings.add(ToppingsTypes.PassFruitJelly);
			}

			// Milk Choice
			if(milkBase.getSelectedItem() == "Whole Milk") {
				toppings.add(ToppingsTypes.WholeMilk);
			}
			else if(milkBase.getSelectedItem() == "Soy Milk") {
				toppings.add(ToppingsTypes.SoyMilk);
			}
			else if(milkBase.getSelectedItem() == "Half Milk") {
				toppings.add(ToppingsTypes.HalfMilk);
			}

			// Size choice
			SizeTypes drinkSizeType = determineSize(sizes);


			// Sweetness choice
			int sweetSelection = -1;

			if(sweetness.getSelectedItem().equals("0% Sweet")) {
				sweetSelection = 0;
			}
			else if (sweetness.getSelectedItem().equals("25% Sweet")) {
				sweetSelection = 25;
			}
			else if (sweetness.getSelectedItem().equals("50% Sweet")) {
				sweetSelection = 50;
			}
			else if (sweetness.getSelectedItem().equals("75% Sweet")) {
				sweetSelection = 75;
			}
			else if (sweetness.getSelectedItem().equals("100% Sweet")) {
				sweetSelection = 100;
			}

			String drinkName = name.getText();

			// Uses Factory class to make the drink object
			Drink tea = DrinkFactory.makeSale(DrinkTypes.Tea, 3.0, drinkName, drinkSizeType, toppings, sweetSelection);

			// Prints to the screen all necessary information on the order
			printSummary(tea);

			// Closes the current frame
			closeFrame(click);
		}
	}

	/**
	 * An inner class event listener for the cancel button
	 */
	class CancelButtonListener implements ActionListener{

		/**
		 * Closes the frame when the cancel button is click
		 * @param click
		 */
		public void actionPerformed(ActionEvent click) {
			closeFrame(click);
		}
		
	}
}
