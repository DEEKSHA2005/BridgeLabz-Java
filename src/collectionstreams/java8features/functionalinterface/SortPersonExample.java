package javacollectionsstream.java8features.day7FunctionalInterface;

import java.util.*;

class Person {
    String name;
    int age;
    double salary;

    Person(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return name + " " + age + " " + salary;
    }
}

public class SortPersonExample {

    public static void main(String[] args) {

        List<Person> people = new ArrayList<>();
        people.add(new Person("Ravi", 30, 40000));
        people.add(new Person("Anu", 25, 50000));
        people.add(new Person("Kumar", 35, 45000));

        people.sort((p1, p2) -> p1.age - p2.age);

        people.forEach(System.out::println);
    }
}
