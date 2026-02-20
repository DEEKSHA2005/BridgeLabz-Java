package dsa.graphandtrees;
import java.util.*;

// Program to find height of a binary tree
class HeightOfBinaryTree {

    // Node structure
    static class Node {
        int data;
        Node left, right;
        Node(int data) {
            this.data = data;
        }
    }

    // Method to find height
    static int findHeight(Node root) {
        // Base case
        if (root == null)
            return 0;

        int leftHeight = findHeight(root.left);
        int rightHeight = findHeight(root.right);

        return 1 + Math.max(leftHeight, rightHeight);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Creating tree manually using user input
        System.out.print("Enter root value: ");
        Node root = new Node(sc.nextInt());

        System.out.print("Enter left child of root: ");
        root.left = new Node(sc.nextInt());

        System.out.print("Enter right child of root: ");
        root.right = new Node(sc.nextInt());

        System.out.println("Height of tree: " + findHeight(root));
    }
}
