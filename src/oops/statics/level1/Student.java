package oops.statics.level1;

import java.util.Scanner;

public class Student {

    private static String universityName;
    private static int totalStudents = 0;

    private String name;
    private final int rollNumber;
    private String grade;

    public Student(String name, int roll, String grade) {
        this.name = name;
        this.rollNumber = roll;
        this.grade = grade;
        totalStudents++;
    }

    public static void setUniversityName(String name) {
        universityName = name;
    }

    public static void displayTotalStudents() {
        System.out.println("Total Students: " + totalStudents);
    }

    public void display() {
        System.out.println("University : " + universityName);
        System.out.println("Name       : " + name);
        System.out.println("Roll No    : " + rollNumber);
        System.out.println("Grade      : " + grade);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter university name: ");
        setUniversityName(sc.nextLine());

        System.out.print("Enter name: ");
        String n = sc.nextLine();

        System.out.print("Enter roll number: ");
        int r = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter grade: ");
        String g = sc.nextLine();

        Object obj = new Student(n, r, g);

        if (obj instanceof Student) {
            Student s = (Student) obj;
            s.display();
            displayTotalStudents();
        }
    }
}

