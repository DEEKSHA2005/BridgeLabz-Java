package dsa.linkedlist;

import java.util.Scanner;


class BookNode {
    int bookId;
    String title;
    String author;
    String genre;
    boolean isAvailable;
    BookNode next;
    BookNode prev;

    BookNode(int bookId, String title, String author, String genre, boolean isAvailable) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.isAvailable = isAvailable;
        this.next = null;
        this.prev = null;
    }
}


class LibraryList {
    private BookNode head;
    private BookNode tail;


    public void addAtBeginning(int id, String title, String author, String genre, boolean available) {
        BookNode newNode = new BookNode(id, title, author, genre, available);

        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        System.out.println("Book added at beginning.");
    }


    public void addAtEnd(int id, String title, String author, String genre, boolean available) {
        BookNode newNode = new BookNode(id, title, author, genre, available);

        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        System.out.println("Book added at end.");
    }


    public void addAtPosition(int pos, int id, String title, String author, String genre, boolean available) {
        if (pos == 1) {
            addAtBeginning(id, title, author, genre, available);
            return;
        }

        BookNode temp = head;
        for (int i = 1; i < pos - 1 && temp != null; i++) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Invalid position.");
            return;
        }

        BookNode newNode = new BookNode(id, title, author, genre, available);
        newNode.next = temp.next;
        newNode.prev = temp;

        if (temp.next != null)
            temp.next.prev = newNode;
        else
            tail = newNode;

        temp.next = newNode;
        System.out.println("Book added at position " + pos);
    }


    public void removeById(int id) {
        if (head == null) {
            System.out.println("Library is empty.");
            return;
        }

        BookNode temp = head;

        while (temp != null) {
            if (temp.bookId == id) {

                if (temp == head)
                    head = head.next;

                if (temp == tail)
                    tail = tail.prev;

                if (temp.prev != null)
                    temp.prev.next = temp.next;

                if (temp.next != null)
                    temp.next.prev = temp.prev;

                System.out.println("Book removed.");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Book not found.");
    }


    public void search(String title, String author) {
        BookNode temp = head;
        boolean found = false;

        while (temp != null) {
            if (temp.title.equalsIgnoreCase(title) ||
                    temp.author.equalsIgnoreCase(author)) {
                displayBook(temp);
                found = true;
            }
            temp = temp.next;
        }

        if (!found)
            System.out.println("No matching book found.");
    }


    public void updateAvailability(int id, boolean available) {
        BookNode temp = head;

        while (temp != null) {
            if (temp.bookId == id) {
                temp.isAvailable = available;
                System.out.println("Availability updated.");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Book not found.");
    }


    public void displayForward() {
        if (head == null) {
            System.out.println("No books available.");
            return;
        }

        BookNode temp = head;
        while (temp != null) {
            displayBook(temp);
            temp = temp.next;
        }
    }


    public void displayReverse() {
        if (tail == null) {
            System.out.println("No books available.");
            return;
        }

        BookNode temp = tail;
        while (temp != null) {
            displayBook(temp);
            temp = temp.prev;
        }
    }


    public void countBooks() {
        int count = 0;
        BookNode temp = head;

        while (temp != null) {
            count++;
            temp = temp.next;
        }
        System.out.println("Total books in library: " + count);
    }


    private void displayBook(BookNode b) {
        System.out.println("--------------------------");
        System.out.println("Book ID     : " + b.bookId);
        System.out.println("Title       : " + b.title);
        System.out.println("Author      : " + b.author);
        System.out.println("Genre       : " + b.genre);
        System.out.println("Available   : " + (b.isAvailable ? "Yes" : "No"));
    }
}


public class LibraryManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LibraryList library = new LibraryList();

        while (true) {
            System.out.println("\n--- Library Management System ---");
            System.out.println("1. Add Book at Beginning");
            System.out.println("2. Add Book at End");
            System.out.println("3. Add Book at Position");
            System.out.println("4. Remove Book by ID");
            System.out.println("5. Search Book");
            System.out.println("6. Update Availability");
            System.out.println("7. Display Books Forward");
            System.out.println("8. Display Books Reverse");
            System.out.println("9. Count Books");
            System.out.println("10. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.print("Book ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Title: ");
                    String title = sc.nextLine();
                    System.out.print("Author: ");
                    String author = sc.nextLine();
                    System.out.print("Genre: ");
                    String genre = sc.nextLine();
                    System.out.print("Available (true/false): ");
                    boolean available = sc.nextBoolean();
                    library.addAtBeginning(id, title, author, genre, available);
                }

                case 2 -> {
                    System.out.print("Book ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Title: ");
                    String title = sc.nextLine();
                    System.out.print("Author: ");
                    String author = sc.nextLine();
                    System.out.print("Genre: ");
                    String genre = sc.nextLine();
                    System.out.print("Available (true/false): ");
                    boolean available = sc.nextBoolean();
                    library.addAtEnd(id, title, author, genre, available);
                }

                case 3 -> {
                    System.out.print("Position: ");
                    int pos = sc.nextInt();
                    System.out.print("Book ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Title: ");
                    String title = sc.nextLine();
                    System.out.print("Author: ");
                    String author = sc.nextLine();
                    System.out.print("Genre: ");
                    String genre = sc.nextLine();
                    System.out.print("Available (true/false): ");
                    boolean available = sc.nextBoolean();
                    library.addAtPosition(pos, id, title, author, genre, available);
                }

                case 4 -> {
                    System.out.print("Book ID: ");
                    library.removeById(sc.nextInt());
                }

                case 5 -> {
                    System.out.print("Title (or NA): ");
                    String title = sc.nextLine();
                    System.out.print("Author (or NA): ");
                    String author = sc.nextLine();
                    library.search(
                            title.equalsIgnoreCase("NA") ? "" : title,
                            author.equalsIgnoreCase("NA") ? "" : author
                    );
                }

                case 6 -> {
                    System.out.print("Book ID: ");
                    int id = sc.nextInt();
                    System.out.print("Available (true/false): ");
                    boolean available = sc.nextBoolean();
                    library.updateAvailability(id, available);
                }

                case 7 -> library.displayForward();
                case 8 -> library.displayReverse();
                case 9 -> library.countBooks();

                case 10 -> {
                    System.out.println("Exiting...");
                    return;
                }

                default -> System.out.println("Invalid choice.");
            }
        }
    }
}

