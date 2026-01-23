package dsa.algorithmruntime;

import java.util.*;

public class DataStructureSearch {

    public static void main(String[] args) {
        int n = 1_000_000, target = n - 1;

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = i;

        HashSet<Integer> hs = new HashSet<>();
        TreeSet<Integer> ts = new TreeSet<>();
        for (int x : arr) { hs.add(x); ts.add(x); }

        long s = System.nanoTime();
        for (int x : arr) if (x == target) break;
        System.out.println("Array search: " + (System.nanoTime() - s));

        s = System.nanoTime();
        hs.contains(target);
        System.out.println("HashSet search: " + (System.nanoTime() - s));

        s = System.nanoTime();
        ts.contains(target);
        System.out.println("TreeSet search: " + (System.nanoTime() - s));
    }
}

