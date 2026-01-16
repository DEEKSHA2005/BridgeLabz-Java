package oops.objects;

import java.util.Scanner;

class UniCourse {
    String courseName;
    UniProfessor professor;

    UniCourse(String courseName) {
        this.courseName = courseName;
    }

    void assignProfessor(UniProfessor p) {
        professor = p;
    }
}

class UniStudent {
    String studentName;

    UniStudent(String studentName) {
        this.studentName = studentName;
    }

    void enrollCourse(UniCourse c) {
        System.out.println(studentName + " enrolled in " + c.courseName);
    }
}

class UniProfessor {
    String professorName;

    UniProfessor(String professorName) {
        this.professorName = professorName;
    }

    void teachCourse(UniCourse c) {
        c.assignProfessor(this);
        System.out.println(professorName + " teaches " + c.courseName);
    }
}

public class UniManageModel {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter student name: ");
        UniStudent student = new UniStudent(sc.nextLine());

        System.out.print("Enter professor name: ");
        UniProfessor professor = new UniProfessor(sc.nextLine());

        System.out.print("Enter course name: ");
        UniCourse course = new UniCourse(sc.nextLine());

        student.enrollCourse(course);
        professor.teachCourse(course);
    }
}

