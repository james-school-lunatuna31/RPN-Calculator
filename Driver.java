import java.util.Scanner;

/**
 * The {@code Driver} class serves as the entry point for the RPN calculator
 * application.
 * It prompts the user for an RPN expression, validates it, and then calculates
 * and displays the result.
 */
public class Driver {
    /**
     * The main method that initiates the RPN calculator application.
     * It reads an RPN expression from the user, validates the input, and if valid,
     * calculates and displays the result.
     * 
     * @param arg Command line arguments (not used).
     */
    public static void main(String[] arg) {
        // The calculator validates the input, but we will validate it here too for good
        // practice.
        RPNCalc calculator = new RPNCalc();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter an expression (all characters must be separated with a space): ");
        String input = scanner.nextLine();
        String[] tokens = input.split(" ");
        boolean isValid = true;
        for (String token : tokens) {
            try {
                Double.parseDouble(token); // Check if it's a number
            } catch (NumberFormatException e) {
                try {
                    OperationFactory.getOperation(token); // Check if it can be converted to an operator
                } catch (IllegalArgumentException ex) {
                    System.out.println("Invalid input: " + token);
                    isValid = false;
                    break;
                }
            }
        }
        if (isValid) {
            try {
                calculator.setEquation(input);
                double result = calculator.evaluate();
                System.out.println("Output: " + result);
            } catch (Error e) {
                System.out.println("Error evaluating expression: " + e.getMessage());
            }
        }
        scanner.close();
    }
}
