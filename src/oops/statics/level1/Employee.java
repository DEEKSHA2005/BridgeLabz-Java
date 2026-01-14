package objectorientedprogramming.statics.level1;

import java.util.Scanner;

public class Employee {

    private static String companyName;
    private static int totalEmployees = 0;

    private String name;
    private final int id;
    private String designation;

    public Employee(String name, int id, String designation) {
        this.name = name;
        this.id = id;
        this.designation = designation;
        totalEmployees++;
    }

    public static void setCompanyName(String name) {
        companyName = name;
    }

    public static void displayTotalEmployees() {
        System.out.println("Total Employees: " + totalEmployees);
    }

    public void display() {
        System.out.println("Company     : " + companyName);
        System.out.println("Name        : " + name);
        System.out.println("ID          : " + id);
        System.out.println("Designation : " + designation);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter company name: ");
        setCompanyName(sc.nextLine());

        System.out.print("Enter name: ");
        String n = sc.nextLine();

        System.out.print("Enter ID: ");
        int i = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter designation: ");
        String d = sc.nextLine();

        Object obj = new Employee(n, i, d);

        if (obj instanceof Employee) {
            Employee e = (Employee) obj;
            e.display();
            displayTotalEmployees();
        }
    }
}

