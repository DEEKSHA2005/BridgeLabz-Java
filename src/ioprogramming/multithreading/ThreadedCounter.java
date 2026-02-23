package ioprogramming.multithreading;
import java.util.Scanner;

/*
 This program demonstrates multithreading in Java.
 Multiple threads count numbers from 1 to a user-specified limit.

 Each thread handles a portion of the counting range.
 Synchronization ensures that numbers are printed in order.
*/

class Counter {
    int count = 1;   // shared counter

    // synchronized method ensures only one thread accesses it at a time
    public synchronized void printCount(int limit) {

        // loop until limit is reached
        while (count <= limit) {

            // print current thread name and count
            System.out.println(Thread.currentThread().getName() + " : " + count);

            count++;

            try {
                Thread.sleep(50); // small delay for better visualization
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted");
            }
        }
    }
}

// Thread class
class CountThread extends Thread {

    Counter counter;
    int limit;

    // constructor
    CountThread(Counter counter, int limit) {
        this.counter = counter;
        this.limit = limit;
    }

    public void run() {
        counter.printCount(limit);
    }
}

public class ThreadedCounter {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {

            // user input
            System.out.print("Enter counting limit: ");
            int limit = sc.nextInt();

            if (limit <= 0) {
                System.out.println("Please enter a positive number.");
                return;
            }

            Counter counter = new Counter();

            // creating multiple threads
            CountThread t1 = new CountThread(counter, limit);
            CountThread t2 = new CountThread(counter, limit);
            CountThread t3 = new CountThread(counter, limit);

            // naming threads
            t1.setName("Thread-1");
            t2.setName("Thread-2");
            t3.setName("Thread-3");

            // starting threads
            t1.start();
            t2.start();
            t3.start();

        } catch (Exception e) {

            // error handling
            System.out.println("Invalid input. Please enter an integer.");

        } finally {
            sc.close();
        }
    }
}
