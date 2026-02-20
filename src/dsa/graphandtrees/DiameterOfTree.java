package dsa.graphandtrees;
import java.util.*;

// Program to find the diameter of a binary tree
class DiameterOfTree {

    // Node structure
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
        }
    }

    // Variable to store maximum diameter
    static int diameter = 0;

    // Method to calculate height and update diameter
    static int findHeight(Node root) {

        // Base case: empty tree
        if (root == null)
            return 0;

        // Find height of left subtree
        int leftHeight = findHeight(root.left);

        // Find height of right subtree
        int rightHeight = findHeight(root.right);

        // Update diameter (longest path through current node)
        diameter = Math.max(diameter, leftHeight + rightHeight);

        // Return height of current node
        return 1 + Math.max(leftHeight, rightHeight);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        /*
            Building a simple binary tree using user input

            Example:
                    1
                   / \
                  2   3
                 /
                4
        */

        System.out.print("Enter root value: ");
        Node root = new Node(sc.nextInt());

        System.out.print("Enter left child of root: ");
        root.left = new Node(sc.nextInt());

        System.out.print("Enter right child of root: ");
        root.right = new Node(sc.nextInt());

        System.out.print("Enter left child of left node: ");
        root.left.left = new Node(sc.nextInt());

        // Call height function (this also updates diameter)
        findHeight(root);

        // Output result
        System.out.println("Diameter of the tree: " + diameter);
    }
}
