package dsa.linearbinary;

import java.util.Scanner;

public class Search2DMatrix {

    static boolean search(int[][] mat, int target) {
        int r = mat.length, c = mat[0].length;
        int l = 0, h = r * c - 1;

        while (l <= h) {
            int m = l + (h - l) / 2;
            int val = mat[m / c][m % c];

            if (val == target) return true;
            if (val < target) l = m + 1;
            else h = m - 1;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter rows and columns: ");
        int r = sc.nextInt(), c = sc.nextInt();

        int[][] mat = new int[r][c];
        System.out.println("Enter matrix elements:");
        for (int i = 0; i < r; i++)
            for (int j = 0; j < c; j++)
                mat[i][j] = sc.nextInt();

        System.out.print("Enter target element: ");
        int target = sc.nextInt();

        if (search(mat, target))
            System.out.println("Target found in matrix");
        else
            System.out.println("Target not found in matrix");

        sc.close();
    }
}
