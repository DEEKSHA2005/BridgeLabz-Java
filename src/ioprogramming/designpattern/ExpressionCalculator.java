package ioprogramming.designpattern;
import java.util.Scanner;

/*
 Interpreter Pattern
 Evaluates expressions
*/

interface MathExpression {
    int interpret();
}

class AdditionOperation implements MathExpression {

    int a, b;

    AdditionOperation(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public int interpret() {
        return a + b;
    }
}

class SubtractionOperation implements MathExpression {

    int a, b;

    SubtractionOperation(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public int interpret() {
        return a - b;
    }
}

public class ExpressionCalculator {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter first number:");
        int a = sc.nextInt();

        System.out.println("Enter operator (+ or -):");
        char op = sc.next().charAt(0);

        System.out.println("Enter second number:");
        int b = sc.nextInt();

        MathExpression exp;

        if (op == '+')
            exp = new AdditionOperation(a, b);
        else
            exp = new SubtractionOperation(a, b);

        System.out.println("Result: " + exp.interpret());
    }
}
