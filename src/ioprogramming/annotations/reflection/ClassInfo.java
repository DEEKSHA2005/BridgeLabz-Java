package ioprogramming.annotations.reflection;
import java.lang.reflect.*;
import java.util.Scanner;

public class ClassInfo {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        // User input for class name
        System.out.println("Enter class name:");
        String className = sc.nextLine();

        /*
         Load class dynamically using Reflection
         */
        Class<?> cls = Class.forName(className);

        System.out.println("\nMethods:");
        Method[] methods = cls.getDeclaredMethods();
        for(Method m : methods){
            System.out.println(m);
        }

        System.out.println("\nFields:");
        Field[] fields = cls.getDeclaredFields();
        for(Field f : fields){
            System.out.println(f);
        }

        System.out.println("\nConstructors:");
        Constructor<?>[] constructors = cls.getDeclaredConstructors();
        for(Constructor<?> c : constructors){
            System.out.println(c);
        }
    }
}
