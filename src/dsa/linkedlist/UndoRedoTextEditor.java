package dsa.linkedlist;

import java.util.Scanner;


class TextNode {
    String content;
    TextNode prev;
    TextNode next;

    TextNode(String content) {
        this.content = content;
        this.prev = null;
        this.next = null;
    }
}


class TextEditor {
    private TextNode head;
    private TextNode tail;
    private TextNode current;
    private int size;
    private final int LIMIT = 10;


    public void addState(String text) {
        TextNode newNode = new TextNode(text);


        if (current != null && current.next != null) {
            current.next.prev = null;
            current.next = null;
            tail = current;
            size = countNodes();
        }

        if (head == null) {
            head = tail = current = newNode;
            size = 1;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
            current = newNode;
            size++;
        }


        if (size > LIMIT) {
            head = head.next;
            head.prev = null;
            size--;
        }

        System.out.println("Text updated.");
    }


    public void undo() {
        if (current != null && current.prev != null) {
            current = current.prev;
            System.out.println("Undo successful.");
        } else {
            System.out.println("No more undo operations.");
        }
    }


    public void redo() {
        if (current != null && current.next != null) {
            current = current.next;
            System.out.println("Redo successful.");
        } else {
            System.out.println("No more redo operations.");
        }
    }


    public void displayCurrent() {
        if (current == null) {
            System.out.println("Editor is empty.");
        } else {
            System.out.println("Current Text: " + current.content);
        }
    }


    private int countNodes() {
        int count = 0;
        TextNode temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }
}


public class UndoRedoTextEditor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TextEditor editor = new TextEditor();

        while (true) {
            System.out.println("\n--- Text Editor ---");
            System.out.println("1. Type / Update Text");
            System.out.println("2. Undo");
            System.out.println("3. Redo");
            System.out.println("4. Display Current Text");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter text: ");
                    String text = sc.nextLine();
                    editor.addState(text);
                }
                case 2 -> editor.undo();
                case 3 -> editor.redo();
                case 4 -> editor.displayCurrent();
                case 5 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }
}

