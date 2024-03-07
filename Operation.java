/**
 * Represents a mathematical operation between two double values.
 */
interface Operation {
    /**
     * Executes the mathematical operation on the given operands.
     * 
     * @param a the first operand.
     * @param b the second operand.
     * @return the result of the operation.
     */
    double execute(double a, double b);
}