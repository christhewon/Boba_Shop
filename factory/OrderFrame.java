package factory;
import java.awt.event.*;
import javax.swing.*;

/**
 * A frame containing the order summary screen as well as the options to go to a snack,
 * coffee, or tea frame
 */
public class OrderFrame extends JFrame {
	private JPanel panel;
	private JLabel chooseInstructions;
	private JButton coffeeButton;
	private JButton teaButton;
	private JButton snackButton;
	private JLabel amountDue;
	private JButton exitButton;
	private JButton payButton;
	private JTextField payField;
	private JButton doneButton;
	static String displayString = "";
	static double frameTotalCost = 0.00;
	double totalCost = 0.00;
	static JTextArea screen;

	/**
	 * Creates a new order frame
	 */
	public OrderFrame() {
		createComponents();
		this.setTitle("New Order");
		this.setSize(500,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

	/**
	 * Creates and initializes all the gui components including event handlers then adds them to a panel
	 */
	private void createComponents() {

		// Initializing components
		chooseInstructions = new JLabel("Choose a Sale: ");
		snackButton = new JButton("Snacks");
		teaButton = new JButton("Tea");
		coffeeButton = new JButton("Coffee");
		doneButton = new JButton("Done");
		screen = new JTextArea(25, 40);
		amountDue = new JLabel("Amount Due" + totalCost);
		payButton = new JButton("Pay");
		payField = new JTextField(30);
		exitButton = new JButton("Exit");
		panel = new JPanel();

		// Adding components to the panel
		panel.add(chooseInstructions);
		panel.add(snackButton);
		panel.add(teaButton);
		panel.add(coffeeButton);
		panel.add(amountDue);
		panel.add(screen);
		panel.add(payField);
		panel.add(payButton);
		panel.add(exitButton);
		panel.add(doneButton);

		// Sets components visibilities
		amountDue.setVisible(false);
		payButton.setVisible(false);
		payField.setVisible(false);
		screen.setVisible(true);
		exitButton.setVisible(false);
		doneButton.setVisible(false);

		// Creates event listeners
		ActionListener snackListener = new SnackListener();
		ActionListener payListener = new PayListener();
		ActionListener exitListener = new ExitListener();
		ActionListener coffeeListener = new CoffeeListener();
		ActionListener teaListener = new TeaListener();
		ActionListener doneListener = new DoneListener();

		// Adds event listeners to buttons
		payButton.addActionListener(payListener);
		exitButton.addActionListener(exitListener);
		snackButton.addActionListener(snackListener);
		teaButton.addActionListener(teaListener);
		coffeeButton.addActionListener(coffeeListener);
		doneButton.addActionListener(doneListener);

		// Adds panel with all the components onto the frame
		this.add(panel);
		
	}

	/**
	 * An inner class event listener for the coffee button
	 */
	class CoffeeListener implements ActionListener {

		/**
		 * Creates a new coffee frame
		 */
		public void actionPerformed(ActionEvent e) {
			CoffeeFrame coffeeFrame = new CoffeeFrame();
			coffeeFrame.setVisible(true);
			screen.setVisible(true);
			doneButton.setVisible(true);


			
		}
	}

	/**
	 * An inner class event listener for the tea button
	 */
	class TeaListener implements ActionListener {

		/**
		 * Creates a new tea frame
		 */
		public void actionPerformed(ActionEvent e) {
			TeaFrame teaFrame = new TeaFrame();
			teaFrame.setVisible(true);
			screen.setVisible(true);
			doneButton.setVisible(true);

			
		}
		
	}

	/**
	 * An inner class event listener for the snack button
	 */
	class SnackListener implements ActionListener {
		
		/**
		 * Creates a new snack frame
		 */
		public void actionPerformed(ActionEvent e) {
			SnackFrame snackFrame = new SnackFrame();
			snackFrame.setVisible(true);
			screen.setVisible(true);
			doneButton.setVisible(true);
		}
	}

	/**
	 * An inner class event listener for the done button
	 */
	class DoneListener implements ActionListener {

		/**
		 * Gets the screen ready for checkout
		 */
		public void actionPerformed(ActionEvent e) {
			amountDue.setVisible(true);
			payField.setVisible(true);
			payButton.setVisible(true);
			doneButton.setVisible(false);
			coffeeButton.setVisible(false);
			teaButton.setVisible(false);
			snackButton.setVisible(false);
			chooseInstructions.setVisible(false);

			totalCost += frameTotalCost + (frameTotalCost * .1);
			amountDue.setText("Amount Due: $" + totalCost);
			
		}
	}

	/**
	 * An inner class event listener for the pay button
	 */
	class PayListener implements ActionListener {

		/**
		 * Takes the amount paid and either gives change or waits for more to be input
		 */
		public void actionPerformed(ActionEvent e) {
			Double payedAmount = Double.valueOf(payField.getText());
			totalCost -= payedAmount;
			if(totalCost <= 0) {
				payField.setVisible(false);
				payButton.setVisible(false);
				amountDue.setText("Thank You");
				OrderFrame.screen.append("\nChange due: " + totalCost);
				OrderFrame.screen.append("\n-----------------------Thank You------------------------");
				exitButton.setVisible(true);
			}
			else {
				amountDue.setText("Amount Due" + totalCost);
				payField.setText("");
			}
		}
	}

	/**
	 * An inner class event listener for the exit button
	 */
	class ExitListener implements ActionListener {

		/**
		 * Exits the GUI
		 */
		public void actionPerformed(ActionEvent e) {
			setVisible(false);
			dispose();
			System.exit(0);
			
		}
	}
}
