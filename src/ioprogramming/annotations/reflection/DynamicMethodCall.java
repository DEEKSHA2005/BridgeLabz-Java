package ioprogramming.annotations.reflection;
import java.lang.reflect.*;
import java.util.Scanner;

class MathOperations{

    public int add(int a,int b){
        return a+b;
    }

    public int subtract(int a,int b){
        return a-b;
    }

    public int multiply(int a,int b){
        return a*b;
    }
}

public class DynamicMethodCall{

    public static void main(String[] args) throws Exception{

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter method name (add/subtract/multiply):");
        String methodName = sc.nextLine();

        System.out.println("Enter first number:");
        int a = sc.nextInt();

        System.out.println("Enter second number:");
        int b = sc.nextInt();

        MathOperations obj = new MathOperations();

        /*
         Get class and method dynamically
        */
        Class<?> cls = obj.getClass();

        Method method = cls.getMethod(methodName,int.class,int.class);

        Object result = method.invoke(obj,a,b);

        System.out.println("Result: "+result);
    }
}
