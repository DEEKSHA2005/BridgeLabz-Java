package dsa.graphandtrees;
import java.util.*;

// Program to find Lowest Common Ancestor (LCA) of two nodes in a binary tree
class LCA {

    // Node structure
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
        }
    }

    // Method to find LCA
    static Node findLCA(Node root, int p, int q) {

        // Base case:
        // If tree is empty OR root is equal to p or q
        if (root == null || root.data == p || root.data == q)
            return root;

        // Recur on left subtree
        Node left = findLCA(root.left, p, q);

        // Recur on right subtree
        Node right = findLCA(root.right, p, q);

        // If both sides return non-null, root is LCA
        if (left != null && right != null)
            return root;

        // Otherwise return the non-null side
        return left != null ? left : right;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        /*
            Building a simple binary tree using user input

            Example:
                    1
                   / \
                  2   3
        */

        System.out.print("Enter root value: ");
        Node root = new Node(sc.nextInt());

        System.out.print("Enter left child of root: ");
        root.left = new Node(sc.nextInt());

        System.out.print("Enter right child of root: ");
        root.right = new Node(sc.nextInt());

        // Input nodes to find LCA
        System.out.print("Enter first node value (p): ");
        int p = sc.nextInt();

        System.out.print("Enter second node value (q): ");
        int q = sc.nextInt();

        // Find LCA
        Node lcaNode = findLCA(root, p, q);

        // Output result
        if (lcaNode != null)
            System.out.println("LCA of " + p + " and " + q + " is: " + lcaNode.data);
        else
            System.out.println("LCA not found");
    }
}

