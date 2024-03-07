import java.util.Arrays;

/**
 * The {@code RPNCalc} class represents a Reverse Polish Notation (RPN)
 * Calculator.
 * It evaluates mathematical expressions written in RPN, also known as postfix
 * notation.
 */
public class RPNCalc {
    /**
     * The equation to be evaluated, represented as an array of strings.
     */
    private String[] equation;

    /**
     * The result of the evaluation if it has been run
     */
    private double result;

    /**
     * Constructs a new RPNCalc with the specified equation.
     */
    public RPNCalc() {
    }

    /**
     * Evaluates the RPN equation.
     * 
     * @return the result of the evaluation as a double.
     */
    public double evaluate() {
        return evaluate(0, new String[0]);
    }

    /**
     * Recursively evaluates the RPN equation from a given index with the current
     * arguments.
     * 
     * @param index             the current index in the equation array.
     * @param current_arguments the current arguments (operands) as an array of
     *                          strings.
     * @return the result of the evaluation as a double.
     * @throws Error if the expression is invalid or contains unsupported
     *               operations.
     */
    /**
     * Recursively evaluates the RPN equation from a given index with the current
     * arguments.
     * 
     * @param index             the current index in the equation array.
     * @param current_arguments the current arguments (operands) as an array of
     *                          strings.
     * @return the result of the evaluation as a double.
     * @throws Error if the expression is invalid or contains unsupported
     *               operations.
     */
    private double evaluate(int index, String[] current_arguments) {
        if (index >= equation.length) {
            if (current_arguments.length == 1) {
                return Double.parseDouble(current_arguments[0]);
            } else {
                throw new Error("Invalid Expression");
            }
        } else {
            String token = equation[index];
            return parseOperatorOrNumber(index, current_arguments, token);
        }
    }

    /**
     * Parses the current token as either an operator or a number and proceeds with
     * the evaluation accordingly.
     * 
     * @param index             the current index in the equation array.
     * @param current_arguments the current arguments (operands) as an array of
     *                          strings.
     * @param token             the current token to be parsed.
     * @return the result of the evaluation up to the current index as a double.
     * @throws IllegalArgumentException if the token is an unsupported operation.
     * @throws Error                    if the token is neither a valid number nor a
     *                                  supported
     *                                  operation.
     */
    private double parseOperatorOrNumber(int index, String[] current_arguments, String token)
            throws IllegalArgumentException {
        Operation operation;
        try {
            operation = OperationFactory.getOperation(token);
        } catch (IllegalArgumentException e) {
            try {
                Double.parseDouble(token); // attempt to parse the token as a number
                return evaluate(index + 1, appendToArray(current_arguments, token));
            } catch (NumberFormatException ex) {
                throw new Error("Unsupported character: " + token);
            }
        }
        if (current_arguments.length < 2) {
            throw new Error("Invalid RPN expression: not enough operands for operation " + token);
        }
        double b = Double.parseDouble(current_arguments[current_arguments.length - 1]);
        double a = Double.parseDouble(current_arguments[current_arguments.length - 2]);
        double result = operation.execute(a, b);
        String[] newArgs = Arrays.copyOf(current_arguments, current_arguments.length - 2);
        newArgs = appendToArray(newArgs, String.valueOf(result)); // add new value in as a string
        return evaluate(index + 1, newArgs);
    }

    /**
     * Appends a value to the end of an array.
     * 
     * @param array the original array.
     * @param value the value to append.
     * @return a new array with the value appended.
     */
    private String[] appendToArray(String[] array, String value) {
        String[] newArray = Arrays.copyOf(array, array.length + 1);
        newArray[newArray.length - 1] = value;
        return newArray;
    }

    /**
     * Sets the equation for the RPN calculator.
     * 
     * @param input the RPN equation as a string, with elements separated by spaces.
     */
    public void setEquation(String input) {
        this.equation = input.split(" ");
    }

    /**
     * Returns the result of the last calculation or evaluates the current equation
     * if not already done.
     * 
     * @return the result of the last calculation or the evaluation of the current
     *         equation.
     * @throws Error if the equation is invalid or contains unsupported operations.
     */
    public double lastCalculation() {
        if (this.equation == null || this.equation.length == 0) {
            throw new Error("No equation set");
        }
        if (Double.isNaN(this.result)) {
            this.result = this.evaluate();
        }
        return this.result;
    }
}
