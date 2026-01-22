package dsa.linearbinary;

import java.util.Scanner;

public class PeakElement {

    static int findPeak(int[] arr) {
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            boolean leftOK = (m == 0) || arr[m] > arr[m - 1];
            boolean rightOK = (m == arr.length - 1) || arr[m] > arr[m + 1];
            if (leftOK && rightOK) return m;
            if (m > 0 && arr[m - 1] > arr[m]) r = m - 1;
            else l = m + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter array size: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        int index = findPeak(arr);

        if (index == -1)
            System.out.println("No peak element found");
        else
            System.out.println("Peak element at index " + index +
                    " with value " + arr[index]);

        sc.close();
    }
}

