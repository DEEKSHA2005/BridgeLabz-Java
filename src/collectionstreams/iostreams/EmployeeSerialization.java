package collectionstreams.iostreams;

import java.io.*;
import java.util.*;

class Employee implements Serializable {
    int id;
    String name, dept;
    double salary;

    Employee(int i, String n, String d, double s) {
        id = i; name = n; dept = d; salary = s;
    }
}

public class EmployeeSerialization {
    public static void main(String[] args) throws Exception {

        List<Employee> list = new ArrayList<>();
        list.add(new Employee(1,"Alice","IT",50000));
        list.add(new Employee(2,"Bob","HR",40000));

        ObjectOutputStream oos =
                new ObjectOutputStream(new FileOutputStream("emp.dat"));
        oos.writeObject(list);
        oos.close();

        ObjectInputStream ois =
                new ObjectInputStream(new FileInputStream("emp.dat"));
        List<Employee> empList = (List<Employee>) ois.readObject();

        for (Employee e : empList) {
            System.out.println(e.id + " " + e.name + " " + e.dept + " " + e.salary);
        }
    }
}

