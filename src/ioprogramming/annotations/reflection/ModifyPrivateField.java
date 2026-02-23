package ioprogramming.annotations.reflection;
import java.lang.reflect.*;
import java.util.Scanner;

class Person{

    // private field
    private int age;

}

public class ModifyPrivateField {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        /*
         Create object normally
        */
        Person p = new Person();

        System.out.println("Enter new age:");
        int newAge = sc.nextInt();

        // Get class object
        Class<?> cls = p.getClass();

        // Access private field
        Field field = cls.getDeclaredField("age");

        // Allow access to private field
        field.setAccessible(true);

        // Modify value
        field.set(p,newAge);

        // Retrieve value
        int value = (int) field.get(p);

        System.out.println("Updated Age: " + value);
    }
}