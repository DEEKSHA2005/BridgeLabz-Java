package dsa.sortingalgorithms;

import java.util.Scanner;

public class InsertionSortStudentIDs {

    public static void insertionSort(int[] arr) {
        int n = arr.length;

        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        int[] ids = new int[n];

        System.out.println("Enter student IDs:");
        for (int i = 0; i < n; i++) {
            ids[i] = sc.nextInt();
        }

        insertionSort(ids);

        System.out.println("Sorted Student IDs:");
        for (int id : ids) {
            System.out.print(id + " ");
        }

        sc.close();
    }
}
