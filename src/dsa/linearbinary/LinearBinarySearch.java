package dsa.linearbinary;

import java.util.Arrays;
import java.util.Scanner;

public class LinearBinarySearch {


    static int firstMissingPositive(int[] arr) {
        int n = arr.length;
        boolean[] visited = new boolean[n + 1];


        for (int x : arr) {
            if (x > 0 && x <= n) {
                visited[x] = true;
            }
        }


        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                return i;
            }
        }

        return n + 1;
    }


    static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target)
                return mid;
            else if (arr[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }

        return -1;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter array size: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }


        int missing = firstMissingPositive(arr);
        System.out.println("First missing positive integer: " + missing);


        Arrays.sort(arr);
        System.out.println("Sorted array: " + Arrays.toString(arr));

        System.out.print("Enter target to search: ");
        int target = sc.nextInt();

        int index = binarySearch(arr, target);

        if (index == -1)
            System.out.println("Target not found");
        else
            System.out.println("Target found at index: " + index);

        sc.close();
    }
}
