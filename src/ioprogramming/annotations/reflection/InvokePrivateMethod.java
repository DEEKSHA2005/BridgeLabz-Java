package ioprogramming.annotations.reflection;
import java.lang.reflect.*;
import java.util.Scanner;

class Calculator{

    // private method
    private int multiply(int a,int b){
        return a*b;
    }

}

public class InvokePrivateMethod {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter first number:");
        int a = sc.nextInt();

        System.out.println("Enter second number:");
        int b = sc.nextInt();

        Calculator calc = new Calculator();

        /*
         Reflection to call private method
        */
        Class<?> cls = calc.getClass();

        Method method = cls.getDeclaredMethod("multiply",int.class,int.class);

        // allow access
        method.setAccessible(true);

        Object result = method.invoke(calc,a,b);

        System.out.println("Result: "+result);

    }
}
