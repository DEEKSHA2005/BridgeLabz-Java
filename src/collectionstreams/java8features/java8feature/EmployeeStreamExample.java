package javacollectionsstream.java8features.java8feature;

import java.util.*;
import java.util.stream.Collectors;

public class EmployeeStreamExample {

    public static void main(String[] args) {

        List<Employee> employees = List.of(
                new Employee(1, "Asha", "Engineering", 90000),
                new Employee(2, "Ravi", "HR", 60000),
                new Employee(3, "John", "Engineering", 85000),
                new Employee(4, "Meena", "Engineering", 78000),
                new Employee(5, "Kiran", "Finance", 95000)
        );

        Map<String, Double> avgSalaryByDept =
                employees.stream()

                        // 1️⃣ Filter
                        .filter(e -> e.getDepartment().equals("Engineering"))
                        .filter(e -> e.getSalary() > 80000)

                        // 2️⃣ Sort
                        .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())

                        // 3️⃣ Group + 4️⃣ Aggregate
                        .collect(Collectors.groupingBy(
                                Employee::getDepartment,
                                Collectors.averagingDouble(Employee::getSalary)
                        ));

        System.out.println(avgSalaryByDept);
    }
}
class Employee {
    private int id;
    private String name;
    private String department;
    private double salary;

    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return id + " " + name + " " + department + " " + salary;
    }
}

