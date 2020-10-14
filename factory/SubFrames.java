package factory;
import decorator.SizeTypes;
import sale.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * A frame class that holds methods for its inheritors
 */
public abstract class SubFrames extends JFrame{

    /**
     * Takes a Sale object and prints to the screen all necessary information on the customers order
     * @param sale
     */
    public void printSummary(Sale sale) {
        OrderFrame.displayString += (sale.printDescription()+ "\n\n");
        OrderFrame.screen.setText("");
        OrderFrame.screen.append(OrderFrame.displayString);
        OrderFrame.frameTotalCost += sale.getCost();
        double subTotal = OrderFrame.frameTotalCost;
        double tax = subTotal * .10;
        double total = subTotal + tax;
        subTotal = Math.floor(subTotal * 100) / 100;
        tax = Math.floor(tax * 100) / 100;
        total = Math.floor(total * 100) / 100;

        OrderFrame.screen.append("Subtotal: " + subTotal + "\n");
        OrderFrame.screen.append("Tax: " + tax + "\n");
        OrderFrame.screen.append("Total: " + total + "\n");

    }

    /**
     * Determines the SizeType by what was selected from the JComboBox
     * @param sizes The JComboBox used to determine the SizeType
     * @return A SizeType that was chosen from the JComboBox
     */
    public SizeTypes determineSize(JComboBox<String> sizes) {
        SizeTypes drinkSizeType = SizeTypes.Small;

        // Just in case
        if(sizes.getSelectedItem().equals("S")) {
            drinkSizeType = SizeTypes.Small;
        }
        else if(sizes.getSelectedItem().equals("M")) {
            drinkSizeType = SizeTypes.Medium;
        }
        else if(sizes.getSelectedItem().equals("L")) {
            drinkSizeType = SizeTypes.Large;
        }
        return drinkSizeType;
    }

    /**
     * Closes the frame that triggered the ActionEvent
     * @param click The ActionEvent used to determine which panel the event came from
     */
    public void closeFrame(ActionEvent click) {
        // Gets the button that was clicked
        Component button = (Component) click.getSource(); //e.getSource() returns Object

        // Gets the frame that the clicked button was on
        JFrame frame = (JFrame) SwingUtilities.getRoot(button);

        // Sets the frame's visibility with button to false
        frame.setVisible(false);
    }

}
