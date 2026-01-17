package oops.encapsulation;

import java.util.Scanner;

interface Treatable {
    void treat();
}

abstract class Patient {
    protected String name;

    public Patient(String name) {
        this.name = name;
    }

    abstract void displayPatient();
}

class InPatient extends Patient implements Treatable {

    public InPatient(String name) {
        super(name);
    }

    public void treat() {
        System.out.println("Treating patient " + name);
    }

    void displayPatient() {
        System.out.println("Patient Name: " + name);
    }
}

public class HospitalModel {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter patient name: ");
        String name = sc.nextLine();

        Patient p = new InPatient(name);
        p.displayPatient();
        ((Treatable) p).treat();
    }
}

