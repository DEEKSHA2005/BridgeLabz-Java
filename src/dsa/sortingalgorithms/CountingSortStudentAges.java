package dsa.sortingalgorithms;

import java.util.Scanner;

public class CountingSortStudentAges {

    public static void countingSort(int[] arr) {
        int[] count = new int[19];

        for (int age : arr) {
            count[age]++;
        }

        int index = 0;
        for (int age = 0; age <= 18; age++) {
            while (count[age]-- > 0) {
                arr[index++] = age;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        int[] ages = new int[n];

        System.out.println("Enter student ages:");
        for (int i = 0; i < n; i++) {
            ages[i] = sc.nextInt();
        }

        countingSort(ages);

        System.out.println("Sorted Student Ages:");
        for (int a : ages) {
            System.out.print(a + " ");
        }

        sc.close();
    }
}

