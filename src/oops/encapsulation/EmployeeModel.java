package oops.encapsulation;

import java.util.Scanner;

interface BonusEligible {
    double calculateBonus();
}

abstract class Employee {
    private String name;
    private int id;
    protected double salary;

    public Employee(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    abstract void displayDetails();
}

class Manager extends Employee implements BonusEligible {

    public Manager(String name, int id, double salary) {
        super(name, id, salary);
    }

    public double calculateBonus() {
        return salary * 0.20;
    }

    void displayDetails() {
        System.out.println("Manager Name : " + getName());
        System.out.println("Salary      : " + salary);
        System.out.println("Bonus       : " + calculateBonus());
    }
}

public class EmployeeModel {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter name: ");
        String name = sc.nextLine();
        System.out.print("Enter id: ");
        int id = sc.nextInt();
        System.out.print("Enter salary: ");
        double salary = sc.nextDouble();

        Employee emp = new Manager(name, id, salary);
        emp.displayDetails();
    }
}

