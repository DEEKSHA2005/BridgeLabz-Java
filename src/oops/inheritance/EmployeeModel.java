package oops.inheritance;

import java.util.Scanner;

class Employee {
    String name;
    int id;
    double salary;

    Employee(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    void displayDetails() {
        System.out.println("Name   : " + name);
        System.out.println("ID     : " + id);
        System.out.println("Salary : " + salary);
    }
}

class Manager extends Employee {
    int teamSize;

    Manager(String name, int id, double salary, int teamSize) {
        super(name, id, salary);
        this.teamSize = teamSize;
    }

    @Override
    void displayDetails() {
        super.displayDetails();
        System.out.println("Team Size : " + teamSize);
    }
}

public class EmployeeModel {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter manager name: ");
        String name = sc.nextLine();

        System.out.print("Enter id: ");
        int id = sc.nextInt();

        System.out.print("Enter salary: ");
        double salary = sc.nextDouble();

        System.out.print("Enter team size: ");
        int teamSize = sc.nextInt();

        Employee emp = new Manager(name, id, salary, teamSize);
        emp.displayDetails();
    }
}

