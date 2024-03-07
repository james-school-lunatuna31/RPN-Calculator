/**
 * Represents a mathematical operation between two double values.
 */
/*
 * It may seem weird to define this here, but we could easily replace double
 * with Object and allow this
 * calculator to perform operations on a wide range of arguments
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