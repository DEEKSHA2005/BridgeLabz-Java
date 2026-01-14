package coreprogramming.methods.level3;

import java.util.Scanner;

public class CollinearityChecker {

    public static boolean isCollinearUsingSlope(
            double x1, double y1,
            double x2, double y2,
            double x3, double y3) {

        double slopeAB = (y2 - y1) / (x2 - x1);
        double slopeBC = (y3 - y2) / (x3 - x2);
        double slopeAC = (y3 - y1) / (x3 - x1);

        return slopeAB == slopeBC && slopeBC == slopeAC;
    }

    public static boolean isCollinearUsingArea(
            double x1, double y1,
            double x2, double y2,
            double x3, double y3) {

        double area = 0.5 * (
                x1 * (y2 - y3) +
                        x2 * (y3 - y1) +
                        x3 * (y1 - y2)
        );

        return area == 0;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter x1 y1: ");
        double x1 = sc.nextDouble();
        double y1 = sc.nextDouble();

        System.out.print("Enter x2 y2: ");
        double x2 = sc.nextDouble();
        double y2 = sc.nextDouble();

        System.out.print("Enter x3 y3: ");
        double x3 = sc.nextDouble();
        double y3 = sc.nextDouble();


        System.out.println("Using Slope Formula: " +
                (isCollinearUsingSlope(x1, y1, x2, y2, x3, y3) ? "Yes" : "No"));

        System.out.println("Using Area Formula: " +
                (isCollinearUsingArea(x1, y1, x2, y2, x3, y3) ? "Yes" : "No"));
    }
}
