package oops.fundamental.level1;

import java.util.Scanner;

public class Book {

    String title;
    String author;
    double price;

    void display() {
        System.out.println("Title  : " + title);
        System.out.println("Author : " + author);
        System.out.println("Price  : " + price);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Book b = new Book();

        System.out.print("Enter title: ");
        b.title = sc.nextLine();

        System.out.print("Enter author: ");
        b.author = sc.nextLine();

        System.out.print("Enter price: ");
        b.price = sc.nextDouble();

        b.display();
    }
}

