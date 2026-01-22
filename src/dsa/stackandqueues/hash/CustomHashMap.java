package dsa.stackandqueues.hash;

import java.util.Scanner;

class CustomHashMap {


    static class Node {
        int key;
        int value;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    private int SIZE = 10;
    private Node[] table;


    CustomHashMap() {
        table = new Node[SIZE];
    }


    private int hash(int key) {
        return key % SIZE;
    }


    public void put(int key, int value) {
        int index = hash(key);
        Node head = table[index];


        while (head != null) {
            if (head.key == key) {
                head.value = value;
                System.out.println("Key updated");
                return;
            }
            head = head.next;
        }


        Node newNode = new Node(key, value);
        newNode.next = table[index];
        table[index] = newNode;
        System.out.println("Key inserted");
    }


    public int get(int key) {
        int index = hash(key);
        Node head = table[index];

        while (head != null) {
            if (head.key == key) {
                return head.value;
            }
            head = head.next;
        }
        return -1;
    }


    public void remove(int key) {
        int index = hash(key);
        Node head = table[index];
        Node prev = null;

        while (head != null) {
            if (head.key == key) {
                if (prev == null) {
                    table[index] = head.next;
                } else {
                    prev.next = head.next;
                }
                System.out.println("Key removed");
                return;
            }
            prev = head;
            head = head.next;
        }
        System.out.println("Key not found");
    }


    public void display() {
        for (int i = 0; i < SIZE; i++) {
            System.out.print("Index " + i + ": ");
            Node head = table[i];
            while (head != null) {
                System.out.print("[" + head.key + "," + head.value + "] -> ");
                head = head.next;
            }
            System.out.println("null");
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CustomHashMap map = new CustomHashMap();

        while (true) {
            System.out.println("\n--- Custom HashMap ---");
            System.out.println("1. Insert");
            System.out.println("2. Get");
            System.out.println("3. Remove");
            System.out.println("4. Display");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter key: ");
                    int key = sc.nextInt();
                    System.out.print("Enter value: ");
                    int value = sc.nextInt();
                    map.put(key, value);
                    break;

                case 2:
                    System.out.print("Enter key: ");
                    int searchKey = sc.nextInt();
                    int result = map.get(searchKey);
                    if (result == -1)
                        System.out.println("Key not found");
                    else
                        System.out.println("Value: " + result);
                    break;

                case 3:
                    System.out.print("Enter key: ");
                    int removeKey = sc.nextInt();
                    map.remove(removeKey);
                    break;

                case 4:
                    map.display();
                    break;

                case 5:
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
