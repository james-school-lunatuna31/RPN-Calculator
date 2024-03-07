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
                return new Operation() {
                    @Override
                    public double execute(double a, double b) {
                        return a + b;
                    }
                };
            case "-":
                return new Operation() {
                    @Override
                    public double execute(double a, double b) {
                        return a - b;
                    }
                };
            case "*":
                return new Operation() {
                    @Override
                    public double execute(double a, double b) {
                        return a * b;
                    }
                };
            case "/":
                return new Operation() {
                    @Override
                    public double execute(double a, double b) {
                        return a / b;
                    }
                };
            case "^":
                return new Operation() {
                    @Override
                    public double execute(double a, double b) {
                        return Math.pow(a, b);
                    }
                };
            default:
                throw new IllegalArgumentException("Invalid operation token: " + token);
        }
    }

}
