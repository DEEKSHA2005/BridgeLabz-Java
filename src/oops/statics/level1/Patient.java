package objectorientedprogramming.statics.level1;

import java.util.Scanner;

public class Patient {

    private static String hospitalName;
    private static int totalPatients = 0;

    private String name;
    private int age;
    private String ailment;
    private final int patientID;

    public Patient(String name, int age, String ailment, int id) {
        this.name = name;
        this.age = age;
        this.ailment = ailment;
        this.patientID = id;
        totalPatients++;
    }

    public static void setHospitalName(String name) {
        hospitalName = name;
    }

    public static void getTotalPatients() {
        System.out.println("Total Patients: " + totalPatients);
    }

    public void display() {
        System.out.println("Hospital : " + hospitalName);
        System.out.println("Name     : " + name);
        System.out.println("Age      : " + age);
        System.out.println("Ailment  : " + ailment);
        System.out.println("PatientID: " + patientID);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter hospital name: ");
        setHospitalName(sc.nextLine());

        System.out.print("Enter name: ");
        String n = sc.nextLine();

        System.out.print("Enter age: ");
        int a = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter ailment: ");
        String al = sc.nextLine();

        System.out.print("Enter patient ID: ");
        int id = sc.nextInt();

        Object obj = new Patient(n, a, al, id);

        if (obj instanceof Patient) {
            Patient p = (Patient) obj;
            p.display();
            getTotalPatients();
        }
    }
}
