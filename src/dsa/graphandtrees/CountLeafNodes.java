package dsa.graphandtrees;
import java.util.Scanner;

// Class to count leaf nodes in a binary tree
class CountLeafNodes {

    // Node structure for Binary Tree
    static class Node {
        int data;
        Node left, right;

        // Constructor to create a new node
        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    /*
     * This method counts the number of leaf nodes
     * in a binary tree.
     *
     * A leaf node is a node with:
     * no left child and no right child.
     */
    static int countLeaves(Node root) {

        // Base case: if tree is empty
        if (root == null)
            return 0;

        /*
         * If current node is a leaf node
         * (no left and right children)
         */
        if (root.left == null && root.right == null)
            return 1;

        /*
         * Recursively count leaf nodes
         * in left and right subtrees
         */
        return countLeaves(root.left) + countLeaves(root.right);
    }

    /*
     * Main method
     * Takes user input and builds a sample tree
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        /*
         * Creating a binary tree manually
         * Example Tree:
         *        1
         *       / \
         *      2   3
         *     / \
         *    4   5
         */

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        // Calling function to count leaf nodes
        int result = countLeaves(root);

        // Printing the result
        System.out.println("Number of leaf nodes: " + result);
    }
}
