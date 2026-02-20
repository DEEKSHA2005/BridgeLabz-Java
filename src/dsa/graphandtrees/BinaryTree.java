package dsa.graphandtrees;

// Find height of a binary tree
class BinaryTree {

    // Node structure
    static class Node {
        int data;
        Node left, right;
        Node(int data) {
            this.data = data;
        }
    }

    // Method to calculate height
    static int findHeight(Node root) {
        // Base case
        if (root == null)
            return 0;

        // Recursive calls
        int leftHeight = findHeight(root.left);
        int rightHeight = findHeight(root.right);

        // Return max height + 1
        return 1 + Math.max(leftHeight, rightHeight);
    }

    public static void main(String[] args) {
        // Sample tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);

        System.out.println("Height: " + findHeight(root));
    }
}
