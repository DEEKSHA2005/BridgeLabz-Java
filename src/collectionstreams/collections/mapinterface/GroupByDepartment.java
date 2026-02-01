package collectionstreams.collections.mapinterface;

import java.util.*;

class Employee {
    String name;
    String department;

    Employee(String n, String d) {
        name = n;
        department = d;
    }

    public String toString() {
        return name;
    }
}

public class GroupByDepartment {
    public static void main(String[] args) {

        List<Employee> employees = Arrays.asList(
                new Employee("Alice", "HR"),
                new Employee("Bob", "IT"),
                new Employee("Carol", "HR")
        );

        Map<String, List<Employee>> map = new HashMap<>();

        for (Employee e : employees) {
            map.computeIfAbsent(e.department, k -> new ArrayList<>()).add(e);
        }

        System.out.println(map);
    }
}

