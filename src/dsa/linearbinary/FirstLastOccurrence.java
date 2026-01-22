package dsa.linearbinary;

import java.util.Scanner;

public class FirstLastOccurrence {

    static int first(int[] arr, int x) {
        int l = 0, r = arr.length - 1, ans = -1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (arr[m] == x) { ans = m; r = m - 1; }
            else if (arr[m] < x) l = m + 1;
            else r = m - 1;
        }
        return ans;
    }

    static int last(int[] arr, int x) {
        int l = 0, r = arr.length - 1, ans = -1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (arr[m] == x) { ans = m; l = m + 1; }
            else if (arr[m] < x) l = m + 1;
            else r = m - 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter array size: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter sorted array:");
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        System.out.print("Enter target element: ");
        int x = sc.nextInt();

        int f = first(arr, x);
        int l = last(arr, x);

        if (f == -1)
            System.out.println("Element not found");
        else
            System.out.println("First index: " + f + ", Last index: " + l);

        sc.close();
    }
}
