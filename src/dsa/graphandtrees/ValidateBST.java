package dsa.graphandtrees;
import java.util.*;

// Program to validate whether a binary tree is a BST
class ValidateBST {

    // Node structure
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
        }
    }

    // Method to check if tree is a valid BST
    static boolean isValidBST(Node root, long min, long max) {

        // Base case: empty tree is BST
        if (root == null)
            return true;

        // Check BST property for current node
        if (root.data <= min || root.data >= max)
            return false;

        // Recursively check left and right subtrees
        return isValidBST(root.left, min, root.data) &&
                isValidBST(root.right, root.data, max);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        /*
            Building tree using user input
            Example input:
            Root = 10
            Left = 5
            Right = 15
        */

        System.out.print("Enter root value: ");
        Node root = new Node(sc.nextInt());

        System.out.print("Enter left child of root: ");
        root.left = new Node(sc.nextInt());

        System.out.print("Enter right child of root: ");
        root.right = new Node(sc.nextInt());

        // Call validation method
        boolean result = isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);

        // Output result
        if (result)
            System.out.println("The tree is a Valid BST");
        else
            System.out.println("The tree is NOT a Valid BST");
    }
}

