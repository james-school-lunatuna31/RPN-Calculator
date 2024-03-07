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
        if (validate(input)) {
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

    /**
     * Validates the input expression to ensure it only contains numbers and valid
     * operators.
     * 
     * @param input The input expression as a String.
     * @return true if the input is valid, false otherwise.
     */
    private static boolean validate(String input) {
        String[] tokens = input.split(" ");
        for (String token : tokens) {
            if (!isValidToken(token)) {
                System.out.println("Invalid input: " + token);
                return false;
            }
        }
        return true;
    }

    /**
     * Checks if the given token is a valid number or operator.
     * 
     * @param token The token to be checked.
     * @return true if the token is a valid number or operator, false otherwise.
     */
    private static boolean isValidToken(String token) {
        return isNumber(token) || isOperator(token);
    }

    /**
     * Determines if the specified token represents a number.
     * 
     * @param token The token to be evaluated.
     * @return true if the token can be parsed as a Double, false if it throws a
     *         NumberFormatException.
     */
    private static boolean isNumber(String token) {
        try {
            Double.parseDouble(token);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * Determines if the specified token represents a valid operator.
     * 
     * @param token The token to be evaluated.
     * @return true if the token corresponds to a valid operation, false if it
     *         throws an IllegalArgumentException.
     */
    private static boolean isOperator(String token) {
        try {
            OperationFactory.getOperation(token);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }
}