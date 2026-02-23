package ioprogramming.annotations.reflection;
import java.util.Scanner;

class Student{

    String name;

    public Student(){
        name="Default";
    }

}

public class DynamicObjectCreation {

    public static void main(String[] args) throws Exception{

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter class name:");
        String className = sc.nextLine();

        /*
         Load class dynamically
        */
        Class<?> cls = Class.forName(className);

        // Create object without new keyword
        Object obj = cls.getDeclaredConstructor().newInstance();

        System.out.println("Object created: "+obj);

    }
}
