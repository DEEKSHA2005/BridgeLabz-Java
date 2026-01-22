package dsa.linkedlist;

import java.util.Scanner;


class ItemNode {
    int itemId;
    String itemName;
    int quantity;
    double price;
    ItemNode next;

    ItemNode(int itemId, String itemName, int quantity, double price) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.quantity = quantity;
        this.price = price;
        this.next = null;
    }
}


class InventoryList {
    private ItemNode head;


    public void addAtBeginning(int id, String name, int qty, double price) {
        ItemNode newNode = new ItemNode(id, name, qty, price);
        newNode.next = head;
        head = newNode;
        System.out.println("Item added at beginning.");
    }


    public void addAtEnd(int id, String name, int qty, double price) {
        ItemNode newNode = new ItemNode(id, name, qty, price);

        if (head == null) {
            head = newNode;
            return;
        }

        ItemNode temp = head;
        while (temp.next != null)
            temp = temp.next;

        temp.next = newNode;
        System.out.println("Item added at end.");
    }


    public void addAtPosition(int pos, int id, String name, int qty, double price) {
        if (pos == 1) {
            addAtBeginning(id, name, qty, price);
            return;
        }

        ItemNode temp = head;
        for (int i = 1; i < pos - 1 && temp != null; i++)
            temp = temp.next;

        if (temp == null) {
            System.out.println("Invalid position.");
            return;
        }

        ItemNode newNode = new ItemNode(id, name, qty, price);
        newNode.next = temp.next;
        temp.next = newNode;
        System.out.println("Item added at position " + pos);
    }


    public void removeById(int id) {
        if (head == null) {
            System.out.println("Inventory empty.");
            return;
        }

        if (head.itemId == id) {
            head = head.next;
            System.out.println("Item removed.");
            return;
        }

        ItemNode temp = head;
        while (temp.next != null && temp.next.itemId != id)
            temp = temp.next;

        if (temp.next == null) {
            System.out.println("Item not found.");
        } else {
            temp.next = temp.next.next;
            System.out.println("Item removed.");
        }
    }


    public void updateQuantity(int id, int newQty) {
        ItemNode temp = head;

        while (temp != null) {
            if (temp.itemId == id) {
                temp.quantity = newQty;
                System.out.println("Quantity updated.");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Item not found.");
    }


    public void search(int id, String name) {
        ItemNode temp = head;
        boolean found = false;

        while (temp != null) {
            if (temp.itemId == id || temp.itemName.equalsIgnoreCase(name)) {
                displayItem(temp);
                found = true;
            }
            temp = temp.next;
        }

        if (!found)
            System.out.println("Item not found.");
    }


    public void totalValue() {
        double total = 0;
        ItemNode temp = head;

        while (temp != null) {
            total += temp.price * temp.quantity;
            temp = temp.next;
        }
        System.out.println("Total Inventory Value: " + total);
    }


    public void sortByName(boolean ascending) {
        if (head == null) return;

        for (ItemNode i = head; i.next != null; i = i.next) {
            for (ItemNode j = i.next; j != null; j = j.next) {
                if ((ascending && i.itemName.compareToIgnoreCase(j.itemName) > 0) ||
                        (!ascending && i.itemName.compareToIgnoreCase(j.itemName) < 0)) {
                    swap(i, j);
                }
            }
        }
        System.out.println("Inventory sorted by name.");
    }


    public void sortByPrice(boolean ascending) {
        if (head == null) return;

        for (ItemNode i = head; i.next != null; i = i.next) {
            for (ItemNode j = i.next; j != null; j = j.next) {
                if ((ascending && i.price > j.price) ||
                        (!ascending && i.price < j.price)) {
                    swap(i, j);
                }
            }
        }
        System.out.println("Inventory sorted by price.");
    }


    private void swap(ItemNode a, ItemNode b) {
        int id = a.itemId;
        String name = a.itemName;
        int qty = a.quantity;
        double price = a.price;

        a.itemId = b.itemId;
        a.itemName = b.itemName;
        a.quantity = b.quantity;
        a.price = b.price;

        b.itemId = id;
        b.itemName = name;
        b.quantity = qty;
        b.price = price;
    }


    public void displayAll() {
        if (head == null) {
            System.out.println("No items in inventory.");
            return;
        }

        ItemNode temp = head;
        while (temp != null) {
            displayItem(temp);
            temp = temp.next;
        }
    }

    private void displayItem(ItemNode i) {
        System.out.println("--------------------------");
        System.out.println("Item ID   : " + i.itemId);
        System.out.println("Name      : " + i.itemName);
        System.out.println("Quantity  : " + i.quantity);
        System.out.println("Price     : " + i.price);
    }
}


public class InventoryManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        InventoryList inventory = new InventoryList();

        while (true) {
            System.out.println("\n--- Inventory Management ---");
            System.out.println("1. Add Item at Beginning");
            System.out.println("2. Add Item at End");
            System.out.println("3. Add Item at Position");
            System.out.println("4. Remove Item by ID");
            System.out.println("5. Update Quantity");
            System.out.println("6. Search Item");
            System.out.println("7. Display Inventory");
            System.out.println("8. Total Inventory Value");
            System.out.println("9. Sort by Name");
            System.out.println("10. Sort by Price");
            System.out.println("11. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.print("ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Name: ");
                    String name = sc.nextLine();
                    System.out.print("Quantity: ");
                    int q = sc.nextInt();
                    System.out.print("Price: ");
                    double p = sc.nextDouble();
                    inventory.addAtBeginning(id, name, q, p);
                }

                case 2 -> {
                    System.out.print("ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Name: ");
                    String name = sc.nextLine();
                    System.out.print("Quantity: ");
                    int q = sc.nextInt();
                    System.out.print("Price: ");
                    double p = sc.nextDouble();
                    inventory.addAtEnd(id, name, q, p);
                }

                case 3 -> {
                    System.out.print("Position: ");
                    int pos = sc.nextInt();
                    System.out.print("ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Name: ");
                    String name = sc.nextLine();
                    System.out.print("Quantity: ");
                    int q = sc.nextInt();
                    System.out.print("Price: ");
                    double p = sc.nextDouble();
                    inventory.addAtPosition(pos, id, name, q, p);
                }

                case 4 -> {
                    System.out.print("Item ID: ");
                    inventory.removeById(sc.nextInt());
                }

                case 5 -> {
                    System.out.print("Item ID: ");
                    int id = sc.nextInt();
                    System.out.print("New Quantity: ");
                    int q = sc.nextInt();
                    inventory.updateQuantity(id, q);
                }

                case 6 -> {
                    System.out.print("Item ID (or -1): ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Item Name (or NA): ");
                    String name = sc.nextLine();
                    inventory.search(id, name.equalsIgnoreCase("NA") ? "" : name);
                }

                case 7 -> inventory.displayAll();
                case 8 -> inventory.totalValue();

                case 9 -> {
                    System.out.print("1-Ascending  2-Descending: ");
                    inventory.sortByName(sc.nextInt() == 1);
                }

                case 10 -> {
                    System.out.print("1-Ascending  2-Descending: ");
                    inventory.sortByPrice(sc.nextInt() == 1);
                }

                case 11 -> {
                    System.out.println("Exiting...");
                    return;
                }

                default -> System.out.println("Invalid choice.");
            }
        }
    }
}
