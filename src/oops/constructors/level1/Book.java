package oops.constructors.level1;

import java.util.Scanner;

public class Book {

    private String title;
    private String author;
    private double price;

    public Book() {
        this.title = "NA";
        this.author = "NA";
        this.price = 0.0;
    }

    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public void setTitle(String title) { this.title = title; }
    public void setAuthor(String author) { this.author = author; }
    public void setPrice(double price) { this.price = price; }

    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public double getPrice() { return price; }

    public void display() {
        System.out.println("Title  : " + getTitle());
        System.out.println("Author : " + getAuthor());
        System.out.println("Price  : " + getPrice());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter title: ");
        String t = sc.nextLine();

        System.out.print("Enter author: ");
        String a = sc.nextLine();

        System.out.print("Enter price: ");
        double p = sc.nextDouble();

        Book book = new Book(t, a, p);
        book.display();
    }
}
