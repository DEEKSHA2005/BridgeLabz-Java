package objectorientedprogramming.constructors.level1;

import java.util.Scanner;

public class LibBook {

    private String title;
    private String author;
    private double price;
    private boolean available;

    public LibBook(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.available = true;
    }

    public String getTitle() {
        return title;
    }

    public boolean isAvailable() {
        return available;
    }

    public void borrowBook() {
        if (available) {
            available = false;
            System.out.println("Book borrowed successfully.");
        } else {
            System.out.println("Book is not available.");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter title: ");
        String t = sc.nextLine();

        System.out.print("Enter author: ");
        String a = sc.nextLine();

        System.out.print("Enter price: ");
        double p = sc.nextDouble();

        LibBook b = new LibBook(t, a, p);
        b.borrowBook();
        b.borrowBook();
    }
}
