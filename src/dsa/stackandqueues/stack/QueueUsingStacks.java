package dsa.stackandqueues.stack;

import java.util.Scanner;
import java.util.Stack;

class QueueUsingStacks {

    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();

    // Enqueue operation
    public void enqueue(int x) {
        stack1.push(x);
        System.out.println(x + " enqueued");
    }

    // Dequeue operation (no try-catch)
    public int dequeue() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

        if (stack2.isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }

        return stack2.pop();
    }

    // Main method with user input (no try-catch)
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        QueueUsingStacks q = new QueueUsingStacks();

        System.out.print("Enter number of elements to enqueue: ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter element " + (i + 1) + ": ");
            q.enqueue(sc.nextInt());
        }

        System.out.print("Enter number of dequeue operations: ");
        int d = sc.nextInt();

        for (int i = 0; i < d; i++) {
            int removed = q.dequeue();
            if (removed != -1) {
                System.out.println("Dequeued: " + removed);
            }
        }

        sc.close();
    }
}
