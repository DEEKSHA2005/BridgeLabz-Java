package oops.objects;

import java.util.Scanner;

class Patient {
    String name;

    Patient(String name) {
        this.name = name;
    }
}

class Doctor {
    String name;

    Doctor(String name) {
        this.name = name;
    }

    void consult(Patient p) {
        System.out.println("Doctor " + name + " is consulting patient " + p.name);
    }
}

public class HospitalModel {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter doctor name: ");
        Doctor d = new Doctor(sc.nextLine());

        System.out.print("Enter patient name: ");
        Patient p = new Patient(sc.nextLine());

        d.consult(p);
    }
}
