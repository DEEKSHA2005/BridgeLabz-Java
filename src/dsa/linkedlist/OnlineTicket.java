package dsa.linkedlist;

import java.util.Scanner;


class TicketNode {
    int ticketId;
    String customerName;
    String movieName;
    String seatNumber;
    String bookingTime;
    TicketNode next;

    TicketNode(int ticketId, String customerName, String movieName,
               String seatNumber, String bookingTime) {
        this.ticketId = ticketId;
        this.customerName = customerName;
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.bookingTime = bookingTime;
        this.next = null;
    }
}


class TicketReservation {
    private TicketNode head;
    private TicketNode tail;


    public void addTicket(int id, String customer, String movie,
                          String seat, String time) {
        TicketNode newNode = new TicketNode(id, customer, movie, seat, time);

        if (head == null) {
            head = tail = newNode;
            newNode.next = newNode;
        } else {
            tail.next = newNode;
            newNode.next = head;
            tail = newNode;
        }
        System.out.println("Ticket booked successfully.");
    }


    public void removeTicket(int id) {
        if (head == null) {
            System.out.println("No tickets booked.");
            return;
        }

        TicketNode temp = head;
        TicketNode prev = tail;

        do {
            if (temp.ticketId == id) {


                if (temp == head && temp == tail) {
                    head = tail = null;
                } else {
                    if (temp == head)
                        head = head.next;

                    if (temp == tail)
                        tail = prev;

                    prev.next = temp.next;
                }

                System.out.println("Ticket cancelled.");
                return;
            }
            prev = temp;
            temp = temp.next;
        } while (temp != head);

        System.out.println("Ticket not found.");
    }


    public void displayTickets() {
        if (head == null) {
            System.out.println("No tickets to display.");
            return;
        }

        TicketNode temp = head;
        do {
            displayTicket(temp);
            temp = temp.next;
        } while (temp != head);
    }


    public void search(String customer, String movie) {
        if (head == null) {
            System.out.println("No tickets booked.");
            return;
        }

        TicketNode temp = head;
        boolean found = false;

        do {
            if (temp.customerName.equalsIgnoreCase(customer) ||
                    temp.movieName.equalsIgnoreCase(movie)) {
                displayTicket(temp);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);

        if (!found)
            System.out.println("No matching ticket found.");
    }


    public void countTickets() {
        if (head == null) {
            System.out.println("Total Tickets: 0");
            return;
        }

        int count = 0;
        TicketNode temp = head;

        do {
            count++;
            temp = temp.next;
        } while (temp != head);

        System.out.println("Total Tickets Booked: " + count);
    }


    private void displayTicket(TicketNode t) {
        System.out.println("--------------------------");
        System.out.println("Ticket ID    : " + t.ticketId);
        System.out.println("Customer     : " + t.customerName);
        System.out.println("Movie        : " + t.movieName);
        System.out.println("Seat Number  : " + t.seatNumber);
        System.out.println("Booking Time : " + t.bookingTime);
    }
}


public class OnlineTicket {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TicketReservation tr = new TicketReservation();

        while (true) {
            System.out.println("\n--- Online Ticket Reservation ---");
            System.out.println("1. Book Ticket");
            System.out.println("2. Cancel Ticket");
            System.out.println("3. Display Tickets");
            System.out.println("4. Search Ticket");
            System.out.println("5. Count Tickets");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.print("Ticket ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Customer Name: ");
                    String customer = sc.nextLine();
                    System.out.print("Movie Name: ");
                    String movie = sc.nextLine();
                    System.out.print("Seat Number: ");
                    String seat = sc.nextLine();
                    System.out.print("Booking Time: ");
                    String time = sc.nextLine();
                    tr.addTicket(id, customer, movie, seat, time);
                }

                case 2 -> {
                    System.out.print("Ticket ID: ");
                    tr.removeTicket(sc.nextInt());
                }

                case 3 -> tr.displayTickets();

                case 4 -> {
                    System.out.print("Customer Name (or NA): ");
                    String customer = sc.nextLine();
                    System.out.print("Movie Name (or NA): ");
                    String movie = sc.nextLine();
                    tr.search(
                            customer.equalsIgnoreCase("NA") ? "" : customer,
                            movie.equalsIgnoreCase("NA") ? "" : movie
                    );
                }

                case 5 -> tr.countTickets();

                case 6 -> {
                    System.out.println("Exiting...");
                    return;
                }

                default -> System.out.println("Invalid choice.");
            }
        }
    }
}
