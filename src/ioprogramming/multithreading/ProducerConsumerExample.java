package ioprogramming.multithreading;
import java.util.*;
import java.util.concurrent.*;

/*
 This program demonstrates the Producer-Consumer problem.

 Producer thread generates integer tasks.
 Consumer thread consumes tasks from a shared queue.

 BlockingQueue is used to automatically handle synchronization.
*/

class Producer extends Thread {

    BlockingQueue<Integer> queue;
    int limit;

    Producer(BlockingQueue<Integer> queue, int limit) {
        this.queue = queue;
        this.limit = limit;
    }

    public void run() {

        try {

            // produce tasks
            for (int i = 1; i <= limit; i++) {

                queue.put(i); // add task to queue

                System.out.println("Produced Task: " + i);

                Thread.sleep(100);

            }

        } catch (Exception e) {

            System.out.println("Producer error: " + e.getMessage());

        }
    }
}

class Consumer extends Thread {

    BlockingQueue<Integer> queue;
    int limit;

    Consumer(BlockingQueue<Integer> queue, int limit) {
        this.queue = queue;
        this.limit = limit;
    }

    public void run() {

        try {

            for (int i = 1; i <= limit; i++) {

                int task = queue.take(); // retrieve task

                System.out.println("Consumed Task: " + task);

                Thread.sleep(150);

            }

        } catch (Exception e) {

            System.out.println("Consumer error: " + e.getMessage());

        }
    }
}

public class ProducerConsumerExample {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {

            // user input
            System.out.print("Enter number of tasks: ");
            int limit = sc.nextInt();

            if (limit <= 0) {
                System.out.println("Please enter a positive number.");
                return;
            }

            // shared resource (queue)
            BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(5);

            // create producer and consumer
            Producer producer = new Producer(queue, limit);
            Consumer consumer = new Consumer(queue, limit);

            // start threads
            producer.start();
            consumer.start();

        } catch (Exception e) {

            System.out.println("Invalid input. Please enter an integer.");

        } finally {
            sc.close();
        }
    }
}
