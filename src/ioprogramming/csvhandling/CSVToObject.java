package ioprogramming.csvhandling;

import java.io.*;
import java.util.*;

class Student {
    private int id;
    private String name;
    private int age;
    private int marks;

    public Student(int id, String name, int age, int marks) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "ID=" + id +
                ", Name=" + name +
                ", Age=" + age +
                ", Marks=" + marks;
    }
}

public class CSVToObject {

    public static void main(String[] args) {

        String fileName = "students.csv";
        List<Student> studentList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {

            br.readLine();
            String line;

            while ((line = br.readLine()) != null) {

                String[] data = line.split(",");

                Student student = new Student(
                        Integer.parseInt(data[0]),
                        data[1],
                        Integer.parseInt(data[2]),
                        Integer.parseInt(data[3])
                );

                studentList.add(student);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


        for (Student s : studentList) {
            System.out.println(s);
        }
    }
}

