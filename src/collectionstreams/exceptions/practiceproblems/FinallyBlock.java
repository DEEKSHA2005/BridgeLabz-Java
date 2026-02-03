package collectionstreams.exceptions.practiceproblems;

import java.util.*;

public class FinallyBlock {
    public static void main(String[] args) {

        try {
            Scanner sc = new Scanner(System.in);
            int a = sc.nextInt();
            int b = sc.nextInt();
            System.out.println("Result: " + (a / b));

        } catch (ArithmeticException e) {
            System.out.println("Cannot divide by zero");

        } finally {
            System.out.println("Operation completed");
        }
    }
}

