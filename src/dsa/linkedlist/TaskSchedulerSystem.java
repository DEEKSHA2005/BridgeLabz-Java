package dsa.linkedlist;

import java.util.Scanner;


class TaskNode {
    int taskId;
    String taskName;
    int priority;
    String dueDate;
    TaskNode next;

    TaskNode(int taskId, String taskName, int priority, String dueDate) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.priority = priority;
        this.dueDate = dueDate;
        this.next = null;
    }
}


class TaskScheduler {
    private TaskNode head;
    private TaskNode tail;
    private TaskNode current;


    public void addAtBeginning(int id, String name, int priority, String date) {
        TaskNode newNode = new TaskNode(id, name, priority, date);

        if (head == null) {
            head = tail = current = newNode;
            newNode.next = newNode;
        } else {
            newNode.next = head;
            tail.next = newNode;
            head = newNode;
        }
        System.out.println("Task added at beginning.");
    }


    public void addAtEnd(int id, String name, int priority, String date) {
        TaskNode newNode = new TaskNode(id, name, priority, date);

        if (head == null) {
            head = tail = current = newNode;
            newNode.next = newNode;
        } else {
            tail.next = newNode;
            newNode.next = head;
            tail = newNode;
        }
        System.out.println("Task added at end.");
    }


    public void addAtPosition(int pos, int id, String name, int priority, String date) {
        if (pos == 1) {
            addAtBeginning(id, name, priority, date);
            return;
        }

        TaskNode temp = head;
        for (int i = 1; i < pos - 1 && temp.next != head; i++) {
            temp = temp.next;
        }

        TaskNode newNode = new TaskNode(id, name, priority, date);
        newNode.next = temp.next;
        temp.next = newNode;

        if (temp == tail)
            tail = newNode;

        System.out.println("Task added at position " + pos);
    }


    public void removeById(int id) {
        if (head == null) {
            System.out.println("No tasks available.");
            return;
        }

        TaskNode temp = head;
        TaskNode prev = tail;

        do {
            if (temp.taskId == id) {

                if (temp == head && temp == tail) {
                    head = tail = current = null;
                } else {
                    if (temp == head)
                        head = head.next;

                    if (temp == tail)
                        tail = prev;

                    prev.next = temp.next;
                    if (current == temp)
                        current = temp.next;
                }

                System.out.println("Task removed.");
                return;
            }
            prev = temp;
            temp = temp.next;
        } while (temp != head);

        System.out.println("Task not found.");
    }


    public void viewNextTask() {
        if (current == null) {
            System.out.println("No tasks scheduled.");
            return;
        }

        displayTask(current);
        current = current.next;
    }


    public void displayAll() {
        if (head == null) {
            System.out.println("No tasks to display.");
            return;
        }

        TaskNode temp = head;
        do {
            displayTask(temp);
            temp = temp.next;
        } while (temp != head);
    }


    public void searchByPriority(int priority) {
        if (head == null) {
            System.out.println("No tasks available.");
            return;
        }

        TaskNode temp = head;
        boolean found = false;

        do {
            if (temp.priority == priority) {
                displayTask(temp);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);

        if (!found)
            System.out.println("No task with given priority.");
    }


    private void displayTask(TaskNode t) {
        System.out.println("-------------------------");
        System.out.println("Task ID   : " + t.taskId);
        System.out.println("Task Name : " + t.taskName);
        System.out.println("Priority  : " + t.priority);
        System.out.println("Due Date  : " + t.dueDate);
    }
}


public class TaskSchedulerSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TaskScheduler scheduler = new TaskScheduler();

        while (true) {
            System.out.println("\n--- Task Scheduler ---");
            System.out.println("1. Add Task at Beginning");
            System.out.println("2. Add Task at End");
            System.out.println("3. Add Task at Position");
            System.out.println("4. Remove Task by ID");
            System.out.println("5. View Current Task & Move Next");
            System.out.println("6. Display All Tasks");
            System.out.println("7. Search Task by Priority");
            System.out.println("8. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.print("Task ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Task Name: ");
                    String name = sc.nextLine();
                    System.out.print("Priority: ");
                    int p = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Due Date: ");
                    String d = sc.nextLine();
                    scheduler.addAtBeginning(id, name, p, d);
                }

                case 2 -> {
                    System.out.print("Task ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Task Name: ");
                    String name = sc.nextLine();
                    System.out.print("Priority: ");
                    int p = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Due Date: ");
                    String d = sc.nextLine();
                    scheduler.addAtEnd(id, name, p, d);
                }

                case 3 -> {
                    System.out.print("Position: ");
                    int pos = sc.nextInt();
                    System.out.print("Task ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Task Name: ");
                    String name = sc.nextLine();
                    System.out.print("Priority: ");
                    int p = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Due Date: ");
                    String d = sc.nextLine();
                    scheduler.addAtPosition(pos, id, name, p, d);
                }

                case 4 -> {
                    System.out.print("Task ID: ");
                    scheduler.removeById(sc.nextInt());
                }

                case 5 -> scheduler.viewNextTask();
                case 6 -> scheduler.displayAll();

                case 7 -> {
                    System.out.print("Priority: ");
                    scheduler.searchByPriority(sc.nextInt());
                }

                case 8 -> {
                    System.out.println("Exiting...");
                    return;
                }

                default -> System.out.println("Invalid choice.");
            }
        }
    }
}
