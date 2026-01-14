package objectorientedprogramming.fundamental.level2;

import java.util.Scanner;

public class MovieTicket {

    String movieName;
    int seatNumber;
    double price;

    void bookTicket(int seat, double cost) {
        seatNumber = seat;
        price = cost;
    }

    void display() {
        System.out.println("Movie Name : " + movieName);
        System.out.println("Seat No    : " + seatNumber);
        System.out.println("Price      : " + price);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MovieTicket t = new MovieTicket();

        System.out.print("Enter movie name: ");
        t.movieName = sc.nextLine();

        System.out.print("Enter seat number: ");
        int seat = sc.nextInt();

        System.out.print("Enter price: ");
        double cost = sc.nextDouble();

        t.bookTicket(seat, cost);
        t.display();
    }
}

