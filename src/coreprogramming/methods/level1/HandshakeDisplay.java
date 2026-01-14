package coreprogramming.methods.level1;

import java.util.Scanner;

public class HandshakeDisplay {

    public static int findHandshakes(int numberOfStudents) {
        return (numberOfStudents * (numberOfStudents - 1)) / 2;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int numberOfStudents = sc.nextInt();

        int result = findHandshakes(numberOfStudents);

        System.out.println("The number of possible handshakes among " +
                numberOfStudents + " students is " + result);
    }
}
