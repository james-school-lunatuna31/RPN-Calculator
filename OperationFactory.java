/**
 * The {@code OperationFactory} class is responsible for determining the
 * mathematical operation to perform
 * based on a given token. It supports basic arithmetic operations such as
 * addition, subtraction,
 * multiplication, and division.
 */
public class OperationFactory {

    /**
     * Returns an {@code Operation} based on the specified token.
     * 
     * @param token the operation token, which can be "+", "-", "*", "/", or "^".
     * @return the {@code Operation} that corresponds to the given token.
     * @throws IllegalArgumentException if the token does not correspond to a valid
     *                                  operation.
     */
    public static Operation getOperation(String token) {
        switch (token) {
            case "+":
                return createAdditionOperation();
            case "-":
                return createSubtractionOperation();
            case "*":
                return createMultiplicationOperation();
            case "/":
                return createDivisionOperation();
            case "^":
                return createExponentiationOperation();
            default:
                throw new IllegalArgumentException("Invalid operation token: " + token);
        }
    }

    /**
     * Creates an addition operation.
     * 
     * @return An {@code Operation} that performs addition.
     */
    private static Operation createAdditionOperation() {
        return new Operation() {
            @Override
            public double execute(double a, double b) {
                return a + b;
            }
        };
    }

    /**
     * Creates a subtraction operation.
     * 
     * @return An {@code Operation} that performs subtraction.
     */
    private static Operation createSubtractionOperation() {
        return new Operation() {
            @Override
            public double execute(double a, double b) {
                return a - b;
            }
        };
    }

    /**
     * Creates a multiplication operation.
     * 
     * @return An {@code Operation} that performs multiplication.
     */
    private static Operation createMultiplicationOperation() {
        return new Operation() {
            @Override
            public double execute(double a, double b) {
                return a * b;
            }
        };
    }

    /**
     * Creates a division operation.
     * 
     * @return An {@code Operation} that performs division.
     */
    private static Operation createDivisionOperation() {
        return new Operation() {
            @Override
            public double execute(double a, double b) {
                return a / b;
            }
        };
    }

    /**
     * Creates an exponentiation operation.
     * 
     * @return An {@code Operation} that performs exponentiation.
     */
    private static Operation createExponentiationOperation() {
        return new Operation() {
            @Override
            public double execute(double a, double b) {
                return Math.pow(a, b);
            }
        };
    }
}
