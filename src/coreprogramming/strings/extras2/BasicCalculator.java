package coreprogramming.strings.extras2;

import java.util.Scanner;

public class BasicCalculator {

    public static int add(int a, int b) { return a + b; }
    public static int subtract(int a, int b) { return a - b; }
    public static int multiply(int a, int b) { return a * b; }
    public static int divide(int a, int b) { return a / b; }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter two numbers: ");
        int a = sc.nextInt();
        int b = sc.nextInt();

        System.out.print("Choose operation (+ - * /): ");
        char op = sc.next().charAt(0);

        switch (op) {
            case '+': System.out.println("Result = " + add(a, b)); break;
            case '-': System.out.println("Result = " + subtract(a, b)); break;
            case '*': System.out.println("Result = " + multiply(a, b)); break;
            case '/': System.out.println("Result = " + divide(a, b)); break;
            default: System.out.println("Invalid Operation");
        }
    }
}
