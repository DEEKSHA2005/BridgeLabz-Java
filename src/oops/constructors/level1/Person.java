package objectorientedprogramming.constructors.level1;

import java.util.Scanner;

public class Person {

    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person(Person p) {
        this.name = p.name;
        this.age = p.age;
    }

    public String getName() { return name; }
    public int getAge() { return age; }

    public void display() {
        System.out.println("Name : " + getName());
        System.out.println("Age  : " + getAge());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter name: ");
        String n = sc.nextLine();

        System.out.print("Enter age: ");
        int a = sc.nextInt();

        Person p1 = new Person(n, a);
        Person p2 = new Person(p1);

        p2.display();
    }
}

