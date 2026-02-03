package collectionstreams.exceptions.practiceproblems;

public class NestedTryCatch {
    public static void main(String[] args) {

        try {
            int[] arr = {10, 20, 30};

            try {
                int result = arr[1] / 0;
                System.out.println(result);

            } catch (ArithmeticException e) {
                System.out.println("Cannot divide by zero!");
            }

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid array index!");
        }
    }
}

