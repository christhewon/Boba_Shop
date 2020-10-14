package factory;

import java.awt.event.*;
import javax.swing.*;
import sale.*;
import decorator.ChickenFlavorTypes;

/**
 * A frame containing the options to build a Snack object
 */
public class SnackFrame extends SubFrames
{
	private JPanel panel;
	private static JComboBox<String> items;
	private JButton saveButton;
	private JButton cancelButton;
	private static JComboBox<String> chickenFlavor;
	private static JCheckBox heated;
	private JLabel qtyLabel;
	private JTextField qtyField;
	private JLabel nameLabel;
	private JTextField name;

	/**
	 * Creates a new Snack frame
	 */
	public SnackFrame() {
		createComponents();
		this.setTitle("New Coffee Order");
		this.setSize(800, 400);
	}


	/**
	 * Creates and initializes all the gui components including event handlers then adds them to a panel
	 */
	private void createComponents() {
		String[] s = {"Cookie" , "Macaroon", "Croissant", "Popcorn Chicken"};
		items = new JComboBox<String>(s);
		nameLabel = new JLabel("Name:");
		name = new JTextField(15);
		panel = new JPanel();
		saveButton = new JButton("Save");
		cancelButton = new JButton("Cancel");

		ActionListener cancelListener = new CancelListener();
		ActionListener saveListener = new SaveButtonListener();
		cancelButton.addActionListener(cancelListener);
		saveButton.addActionListener(saveListener);

		panel.add(nameLabel);
		panel.add(name);

		qtyLabel = new JLabel("Quantity");
		qtyField = new JTextField(3);

		panel.add(qtyLabel);
		panel.add(qtyField);
		panel.add(items);

		heated = new JCheckBox("Heated");
		String[] c = {"Five Spice", "Garlic Parmesan", "Buffalo"};
		chickenFlavor = new JComboBox<>(c);
		
		panel.add(chickenFlavor);
		panel.add(heated);
		panel.add(saveButton);
		panel.add(cancelButton);

		chickenFlavor.setVisible(false);
		heated.setVisible(false);


		items.addActionListener (new ActionListener () {
			public void actionPerformed(ActionEvent e) {
				// Allows the heated JCheckBox to be visible only when croissant is selected.
				if(SnackFrame.items.getSelectedItem().equals("Croissant")) {
					heated.setVisible(true);
				}
				else {
					heated.setVisible(false);
					heated.setSelected(false);
				}

				// Allows the chicken flavor JComboBox to be visible only when popcorn chicken is selected.
				if(items.getSelectedItem().equals("Popcorn Chicken")) {
					chickenFlavor.setVisible(true);
				}
				else {
					chickenFlavor.setVisible(false);
				}
			}
		});

		// Adds panel with all the components to the frame
		this.add(panel);
	}

	/**
	 * An inner class event listener for the save button
	 */
	class SaveButtonListener implements ActionListener{

		SnackTypes snackType;
		ChickenFlavorTypes flavorType;

		/**
		 * When the Save button is clicked, A snack will be created with all the components chosen
		 * @param click
		 */
		public void actionPerformed(ActionEvent click) {
			Boolean snackHeated = false;
			double snackCost = 0;
			String snackQuantity = qtyField.getText();
			String customerName = name.getText();

			// heat choice for croissant
			if(SnackFrame.heated.isSelected()) {
				snackHeated = true;
			}

			// Snack Choice
			if(SnackFrame.items.getSelectedItem().equals("Croissant")) {
				snackType = SnackTypes.Croissant;
				snackCost = 4;
			}
			else if(SnackFrame.items.getSelectedItem().equals("Macaroon")) {
				snackType = SnackTypes.Macaroon;
				snackCost = 3;
			}
			else if(SnackFrame.items.getSelectedItem().equals("Popcorn Chicken")) {
				snackType = SnackTypes.PopcornChicken;
				snackCost = 6;
			}
			else {
				snackType = SnackTypes.Cookie;
				snackCost = 2;
			}

			//Flavor Choice for popcorn chicken
			if(SnackFrame.chickenFlavor.getSelectedItem().equals("Garlic Parmesan")) {
				flavorType = ChickenFlavorTypes.GarlicParmesan;
			}
			else if(SnackFrame.chickenFlavor.getSelectedItem().equals("Buffalo")) {
				flavorType = ChickenFlavorTypes.Buffalo;
			}
			else {
				flavorType = ChickenFlavorTypes.FiveSpice;
			}

			//Making sure the quantity field is not empty
			if(!(snackQuantity.isEmpty())) {
				int pastryQty = Integer.parseInt(qtyField.getText());

				// Uses Factory class to make the snack object
				Snack snack = SnackFactory.makeSale(snackType, snackCost, customerName, pastryQty, snackHeated, flavorType);

				// Prints to the screen all necessary information on the order
				printSummary(snack);
			}
			// Closes the current frame
			closeFrame(click);
		}
	}

	/**
	 * An inner class event listener for the cancel button
	 */
	class CancelListener implements ActionListener {

		/**
		 * Closes the frame when the cancel button is click
		 * @param click
		 */
		public void actionPerformed(ActionEvent click) {
			closeFrame(click);
		}
	}
}






