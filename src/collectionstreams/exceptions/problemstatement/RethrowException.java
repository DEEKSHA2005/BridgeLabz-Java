package collectionstreams.exceptions.problemstatement;

public class RethrowException {

    static int performDivision(int numerator, int denominator) {
        return numerator / denominator;
    }

    static int calculate(int numerator, int denominator) {
        try {
            return performDivision(numerator, denominator);
        } catch (ArithmeticException e) {
            throw new ArithmeticException("Error during division: Denominator is zero");
        }
    }

    public static void main(String[] args) {

        try {
            System.out.println(calculate(10, 0));
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }
    }
}
