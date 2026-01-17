package oops.encapsulation;

import java.util.Scanner;

interface Borrowable {
    void borrowBook();
}

abstract class LibraryItem {
    private String title;

    public LibraryItem(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    abstract void displayItem();
}

class Book extends LibraryItem implements Borrowable {

    public Book(String title) {
        super(title);
    }

    public void borrowBook() {
        System.out.println(getTitle() + " borrowed successfully");
    }

    void displayItem() {
        System.out.println("Book Title: " + getTitle());
    }
}

public class LibraryModel {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter book title: ");
        String title = sc.nextLine();

        LibraryItem item = new Book(title);
        item.displayItem();
        ((Borrowable) item).borrowBook();
    }
}
