package oops.constructors.level1;

import java.util.Scanner;

public class HotelBooking {

    private String guestName;
    private String roomType;
    private int nights;

    public HotelBooking() {
        guestName = "Guest";
        roomType = "Standard";
        nights = 1;
    }

    public HotelBooking(String guestName, String roomType, int nights) {
        this.guestName = guestName;
        this.roomType = roomType;
        this.nights = nights;
    }

    public HotelBooking(HotelBooking h) {
        this.guestName = h.guestName;
        this.roomType = h.roomType;
        this.nights = h.nights;
    }

    public String getGuestName() { return guestName; }
    public String getRoomType() { return roomType; }
    public int getNights() { return nights; }

    public void display() {
        System.out.println("Guest Name : " + getGuestName());
        System.out.println("Room Type  : " + getRoomType());
        System.out.println("Nights     : " + getNights());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter guest name: ");
        String g = sc.nextLine();

        System.out.print("Enter room type: ");
        String r = sc.nextLine();

        System.out.print("Enter nights: ");
        int n = sc.nextInt();

        HotelBooking b1 = new HotelBooking(g, r, n);
        HotelBooking b2 = new HotelBooking(b1);

        b2.display();
    }
}

