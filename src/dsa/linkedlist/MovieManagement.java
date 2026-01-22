package dsa.linkedlist;

import java.util.Scanner;


class MovieNode {
    String title;
    String director;
    int year;
    double rating;
    MovieNode next;
    MovieNode prev;

    MovieNode(String title, String director, int year, double rating) {
        this.title = title;
        this.director = director;
        this.year = year;
        this.rating = rating;
        this.next = null;
        this.prev = null;
    }
}


class MovieLinkedList {
    private MovieNode head;
    private MovieNode tail;

    // Add movie at beginning
    public void addAtBeginning(String title, String director, int year, double rating) {
        MovieNode newNode = new MovieNode(title, director, year, rating);

        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        System.out.println("Movie added at beginning.");
    }


    public void addAtEnd(String title, String director, int year, double rating) {
        MovieNode newNode = new MovieNode(title, director, year, rating);

        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        System.out.println("Movie added at end.");
    }


    public void removeByTitle(String title) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        MovieNode temp = head;

        while (temp != null) {
            if (temp.title.equalsIgnoreCase(title)) {

                if (temp == head)
                    head = head.next;

                if (temp == tail)
                    tail = tail.prev;

                if (temp.prev != null)
                    temp.prev.next = temp.next;

                if (temp.next != null)
                    temp.next.prev = temp.prev;

                System.out.println("Movie removed successfully.");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Movie not found.");
    }


    public void search(String director, double rating) {
        MovieNode temp = head;
        boolean found = false;

        while (temp != null) {
            if (temp.director.equalsIgnoreCase(director) || temp.rating == rating) {
                displayMovie(temp);
                found = true;
            }
            temp = temp.next;
        }

        if (!found)
            System.out.println("No matching movie found.");
    }


    public void updateRating(String title, double newRating) {
        MovieNode temp = head;

        while (temp != null) {
            if (temp.title.equalsIgnoreCase(title)) {
                temp.rating = newRating;
                System.out.println("Rating updated successfully.");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Movie not found.");
    }


    public void displayForward() {
        if (head == null) {
            System.out.println("No movies available.");
            return;
        }

        MovieNode temp = head;
        while (temp != null) {
            displayMovie(temp);
            temp = temp.next;
        }
    }


    public void displayReverse() {
        if (tail == null) {
            System.out.println("No movies available.");
            return;
        }

        MovieNode temp = tail;
        while (temp != null) {
            displayMovie(temp);
            temp = temp.prev;
        }
    }


    private void displayMovie(MovieNode m) {
        System.out.println("--------------------------");
        System.out.println("Title    : " + m.title);
        System.out.println("Director : " + m.director);
        System.out.println("Year     : " + m.year);
        System.out.println("Rating   : " + m.rating);
    }
}


public class MovieManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MovieLinkedList list = new MovieLinkedList();

        while (true) {
            System.out.println("\n--- Movie Management System ---");
            System.out.println("1. Add Movie at Beginning");
            System.out.println("2. Add Movie at End");
            System.out.println("3. Remove Movie by Title");
            System.out.println("4. Search Movie (Director or Rating)");
            System.out.println("5. Update Movie Rating");
            System.out.println("6. Display Movies Forward");
            System.out.println("7. Display Movies Reverse");
            System.out.println("8. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.print("Title: ");
                    String t = sc.nextLine();
                    System.out.print("Director: ");
                    String d = sc.nextLine();
                    System.out.print("Year: ");
                    int y = sc.nextInt();
                    System.out.print("Rating: ");
                    double r = sc.nextDouble();
                    list.addAtBeginning(t, d, y, r);
                }

                case 2 -> {
                    System.out.print("Title: ");
                    String t = sc.nextLine();
                    System.out.print("Director: ");
                    String d = sc.nextLine();
                    System.out.print("Year: ");
                    int y = sc.nextInt();
                    System.out.print("Rating: ");
                    double r = sc.nextDouble();
                    list.addAtEnd(t, d, y, r);
                }

                case 3 -> {
                    System.out.print("Enter movie title: ");
                    String t = sc.nextLine();
                    list.removeByTitle(t);
                }

                case 4 -> {
                    System.out.print("Director name (or type NA): ");
                    String d = sc.nextLine();
                    System.out.print("Rating (or -1): ");
                    double r = sc.nextDouble();
                    list.search(d.equalsIgnoreCase("NA") ? "" : d, r);
                }

                case 5 -> {
                    System.out.print("Movie title: ");
                    String t = sc.nextLine();
                    System.out.print("New rating: ");
                    double r = sc.nextDouble();
                    list.updateRating(t, r);
                }

                case 6 -> list.displayForward();
                case 7 -> list.displayReverse();
                case 8 -> {
                    System.out.println("Exiting...");
                    return;
                }

                default -> System.out.println("Invalid choice.");
            }
        }
    }
}
