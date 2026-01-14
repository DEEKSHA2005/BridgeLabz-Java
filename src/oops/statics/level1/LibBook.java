package objectorientedprogramming.statics.level1;

import java.util.Scanner;

public class LibBook {

    private static String libraryName;

    private String title;
    private String author;
    private final String isbn;

    public LibBook(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    public static void setLibraryName(String name) {
        libraryName = name;
    }

    public void display() {
        System.out.println("Library : " + libraryName);
        System.out.println("Title   : " + title);
        System.out.println("Author  : " + author);
        System.out.println("ISBN    : " + isbn);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter library name: ");
        setLibraryName(sc.nextLine());

        System.out.print("Enter title: ");
        String t = sc.nextLine();

        System.out.print("Enter author: ");
        String a = sc.nextLine();

        System.out.print("Enter ISBN: ");
        String i = sc.nextLine();

        Object obj = new LibBook(t, a, i);

        if (obj instanceof LibBook) {
            LibBook b = (LibBook) obj;
            b.display();
        }
    }
}

