package dsa.linearbinary;

import java.util.Scanner;

public class RotationPoint {

    static int rotationPoint(int[] arr) {
        int l = 0, r = arr.length - 1;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (arr[m] > arr[r]) l = m + 1;
            else r = m;
        }
        return l;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter array size: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter rotated sorted array:");
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        int index = rotationPoint(arr);
        System.out.println("Rotation point index: " + index);
        System.out.println("Smallest element: " + arr[index]);

        sc.close();
    }
}
