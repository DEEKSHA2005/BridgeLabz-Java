package dsa.algorithmruntime;

import java.util.*;

public class SortingPerformance {

    static void bubbleSort(int[] a) {
        for (int i = 0; i < a.length - 1; i++)
            for (int j = 0; j < a.length - i - 1; j++)
                if (a[j] > a[j + 1]) {
                    int t = a[j]; a[j] = a[j + 1]; a[j + 1] = t;
                }
    }

    static void mergeSort(int[] a, int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;
            mergeSort(a, l, m);
            mergeSort(a, m + 1, r);
            merge(a, l, m, r);
        }
    }

    static void merge(int[] a, int l, int m, int r) {
        int[] t = new int[r - l + 1];
        int i = l, j = m + 1, k = 0;
        while (i <= m && j <= r) t[k++] = a[i] <= a[j] ? a[i++] : a[j++];
        while (i <= m) t[k++] = a[i++];
        while (j <= r) t[k++] = a[j++];
        for (int x = 0; x < t.length; x++) a[l + x] = t[x];
    }

    static void quickSort(int[] a, int l, int r) {
        if (l < r) {
            int p = partition(a, l, r);
            quickSort(a, l, p - 1);
            quickSort(a, p + 1, r);
        }
    }

    static int partition(int[] a, int l, int r) {
        int pivot = a[r], i = l - 1;
        for (int j = l; j < r; j++)
            if (a[j] < pivot) { i++; int t = a[i]; a[i] = a[j]; a[j] = t; }
        int t = a[i + 1]; a[i + 1] = a[r]; a[r] = t;
        return i + 1;
    }

    public static void main(String[] args) {
        int n = 10_000;
        Random rnd = new Random();
        int[] a = rnd.ints(n, 0, n).toArray();
        int[] b = a.clone(), c = a.clone();

        long s = System.nanoTime();
        bubbleSort(a);
        System.out.println("Bubble Sort: " + (System.nanoTime() - s));

        s = System.nanoTime();
        mergeSort(b, 0, b.length - 1);
        System.out.println("Merge Sort: " + (System.nanoTime() - s));

        s = System.nanoTime();
        quickSort(c, 0, c.length - 1);
        System.out.println("Quick Sort: " + (System.nanoTime() - s));
    }
}

