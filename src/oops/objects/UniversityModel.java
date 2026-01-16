package oops.objects;

import java.util.ArrayList;
import java.util.Scanner;

class Department {
    String name;

    Department(String name) {
        this.name = name;
    }
}

class Faculty {
    String name;

    Faculty(String name) {
        this.name = name;
    }
}

class University {
    ArrayList<Department> departments = new ArrayList<>();

    void addDepartment(Department d) {
        departments.add(d);
    }

    void deleteUniversity() {
        departments.clear();
        System.out.println("University deleted. Departments removed.");
    }
}

public class UniversityModel {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        University u = new University();

        System.out.print("Enter first department: ");
        u.addDepartment(new Department(sc.nextLine()));

        System.out.print("Enter second department: ");
        u.addDepartment(new Department(sc.nextLine()));

        System.out.print("Enter faculty name: ");
        Faculty f = new Faculty(sc.nextLine());

        u.deleteUniversity();
        System.out.println("Faculty still exists: " + f.name);
    }
}

