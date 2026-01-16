package oops.objects;

import java.util.ArrayList;
import java.util.Scanner;

class Course {
    String courseName;
    ArrayList<Student> students = new ArrayList<>();

    Course(String courseName) {
        this.courseName = courseName;
    }

    void addStudent(Student s) {
        students.add(s);
    }

    void showStudents() {
        System.out.println("Students in " + courseName + ":");
        for (Student s : students) {
            System.out.println("- " + s.name);
        }
    }
}

class Student {
    String name;
    ArrayList<Course> courses = new ArrayList<>();

    Student(String name) {
        this.name = name;
    }

    void enrollCourse(Course c) {
        courses.add(c);
        c.addStudent(this);
    }

    void showCourses() {
        System.out.println("Courses of " + name + ":");
        for (Course c : courses) {
            System.out.println("- " + c.courseName);
        }
    }
}

class School {
    ArrayList<Student> students = new ArrayList<>();

    void addStudent(Student s) {
        students.add(s);
    }
}

public class SchoolModel {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        School school = new School();

        System.out.print("Enter student name: ");
        Student student = new Student(sc.nextLine());

        System.out.print("Enter first course: ");
        Course c1 = new Course(sc.nextLine());

        System.out.print("Enter second course: ");
        Course c2 = new Course(sc.nextLine());

        school.addStudent(student);
        student.enrollCourse(c1);
        student.enrollCourse(c2);

        student.showCourses();
        c1.showStudents();
    }
}
