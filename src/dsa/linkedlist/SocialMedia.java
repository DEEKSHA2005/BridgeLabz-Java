package dsa.linkedlist;

import java.util.Scanner;


class FriendNode {
    int friendId;
    FriendNode next;

    FriendNode(int friendId) {
        this.friendId = friendId;
        this.next = null;
    }
}


class UserNode {
    int userId;
    String name;
    int age;
    FriendNode friendHead;
    UserNode next;

    UserNode(int userId, String name, int age) {
        this.userId = userId;
        this.name = name;
        this.age = age;
        this.friendHead = null;
        this.next = null;
    }
}


class SocialMediaList {
    private UserNode head;


    public void addUser(int id, String name, int age) {
        UserNode newUser = new UserNode(id, name, age);
        newUser.next = head;
        head = newUser;
        System.out.println("User added successfully.");
    }


    private UserNode findUser(int id) {
        UserNode temp = head;
        while (temp != null) {
            if (temp.userId == id)
                return temp;
            temp = temp.next;
        }
        return null;
    }


    public void addFriend(int id1, int id2) {
        if (id1 == id2) {
            System.out.println("Cannot add same user as friend.");
            return;
        }

        UserNode u1 = findUser(id1);
        UserNode u2 = findUser(id2);

        if (u1 == null || u2 == null) {
            System.out.println("User not found.");
            return;
        }

        addFriendNode(u1, id2);
        addFriendNode(u2, id1);

        System.out.println("Friend connection added.");
    }


    private void addFriendNode(UserNode user, int friendId) {
        FriendNode f = new FriendNode(friendId);
        f.next = user.friendHead;
        user.friendHead = f;
    }


    public void removeFriend(int id1, int id2) {
        UserNode u1 = findUser(id1);
        UserNode u2 = findUser(id2);

        if (u1 == null || u2 == null) {
            System.out.println("User not found.");
            return;
        }

        removeFriendNode(u1, id2);
        removeFriendNode(u2, id1);

        System.out.println("Friend connection removed.");
    }


    private void removeFriendNode(UserNode user, int friendId) {
        FriendNode temp = user.friendHead;
        FriendNode prev = null;

        while (temp != null) {
            if (temp.friendId == friendId) {
                if (prev == null)
                    user.friendHead = temp.next;
                else
                    prev.next = temp.next;
                return;
            }
            prev = temp;
            temp = temp.next;
        }
    }


    public void displayFriends(int userId) {
        UserNode user = findUser(userId);

        if (user == null) {
            System.out.println("User not found.");
            return;
        }

        System.out.print("Friends of " + user.name + ": ");
        FriendNode temp = user.friendHead;

        if (temp == null) {
            System.out.println("No friends.");
            return;
        }

        while (temp != null) {
            System.out.print("User" + temp.friendId + " ");
            temp = temp.next;
        }
        System.out.println();
    }


    public void mutualFriends(int id1, int id2) {
        UserNode u1 = findUser(id1);
        UserNode u2 = findUser(id2);

        if (u1 == null || u2 == null) {
            System.out.println("User not found.");
            return;
        }

        System.out.print("Mutual friends: ");
        FriendNode f1 = u1.friendHead;
        boolean found = false;

        while (f1 != null) {
            FriendNode f2 = u2.friendHead;
            while (f2 != null) {
                if (f1.friendId == f2.friendId) {
                    System.out.print("User" + f1.friendId + " ");
                    found = true;
                }
                f2 = f2.next;
            }
            f1 = f1.next;
        }

        if (!found)
            System.out.println("None");
        else
            System.out.println();
    }


    public void searchUser(int id, String name) {
        UserNode temp = head;
        boolean found = false;

        while (temp != null) {
            if (temp.userId == id || temp.name.equalsIgnoreCase(name)) {
                System.out.println("User Found:");
                System.out.println("ID: " + temp.userId);
                System.out.println("Name: " + temp.name);
                System.out.println("Age: " + temp.age);
                found = true;
            }
            temp = temp.next;
        }

        if (!found)
            System.out.println("User not found.");
    }


    public void countFriends() {
        UserNode temp = head;

        while (temp != null) {
            int count = 0;
            FriendNode f = temp.friendHead;
            while (f != null) {
                count++;
                f = f.next;
            }
            System.out.println(temp.name + " has " + count + " friends.");
            temp = temp.next;
        }
    }
}


public class SocialMedia {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SocialMediaList sm = new SocialMediaList();

        while (true) {
            System.out.println("\n--- Social Media System ---");
            System.out.println("1. Add User");
            System.out.println("2. Add Friend Connection");
            System.out.println("3. Remove Friend Connection");
            System.out.println("4. Display Friends");
            System.out.println("5. Mutual Friends");
            System.out.println("6. Search User");
            System.out.println("7. Count Friends");
            System.out.println("8. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.print("User ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Name: ");
                    String name = sc.nextLine();
                    System.out.print("Age: ");
                    int age = sc.nextInt();
                    sm.addUser(id, name, age);
                }

                case 2 -> {
                    System.out.print("User 1 ID: ");
                    int id1 = sc.nextInt();
                    System.out.print("User 2 ID: ");
                    int id2 = sc.nextInt();
                    sm.addFriend(id1, id2);
                }

                case 3 -> {
                    System.out.print("User 1 ID: ");
                    int id1 = sc.nextInt();
                    System.out.print("User 2 ID: ");
                    int id2 = sc.nextInt();
                    sm.removeFriend(id1, id2);
                }

                case 4 -> {
                    System.out.print("User ID: ");
                    sm.displayFriends(sc.nextInt());
                }

                case 5 -> {
                    System.out.print("User 1 ID: ");
                    int id1 = sc.nextInt();
                    System.out.print("User 2 ID: ");
                    int id2 = sc.nextInt();
                    sm.mutualFriends(id1, id2);
                }

                case 6 -> {
                    System.out.print("User ID (or -1): ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Name (or NA): ");
                    String name = sc.nextLine();
                    sm.searchUser(id, name.equalsIgnoreCase("NA") ? "" : name);
                }

                case 7 -> sm.countFriends();

                case 8 -> {
                    System.out.println("Exiting...");
                    return;
                }

                default -> System.out.println("Invalid choice.");
            }
        }
    }
}
