package objectorientedprogramming.fundamental.level1;

import java.util.Scanner;

public class Employee {

    String name;
    int id;
    double salary;

    void display() {
        System.out.println("Employee Name   : " + name);
        System.out.println("Employee ID     : " + id);
        System.out.println("Employee Salary : " + salary);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Employee emp = new Employee();

        System.out.print("Enter name: ");
        emp.name = sc.nextLine();

        System.out.print("Enter id: ");
        emp.id = sc.nextInt();

        System.out.print("Enter salary: ");
        emp.salary = sc.nextDouble();

        emp.display();
    }
}
