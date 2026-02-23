package ioprogramming.designpattern;
import java.util.Scanner;

/*
 Prototype Pattern
 Creates new objects by cloning existing ones
*/

class Employee implements Cloneable {

    String name;
    int id;

    Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }

    // override clone method
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    void display() {
        System.out.println("Employee Name: " + name);
        System.out.println("Employee ID: " + id);
    }
}

public class PrototypeDemo {

    public static void main(String[] args) throws CloneNotSupportedException {

        Scanner sc = new Scanner(System.in);

        // user input
        System.out.println("Enter employee name:");
        String name = sc.nextLine();

        System.out.println("Enter employee ID:");
        int id = sc.nextInt();

        // original object
        Employee e1 = new Employee(name, id);

        // cloned object
        Employee e2 = (Employee) e1.clone();

        System.out.println("\nOriginal Object:");
        e1.display();

        System.out.println("\nCloned Object:");
        e2.display();
    }
}