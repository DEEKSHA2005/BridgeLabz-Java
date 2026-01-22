package dsa.stackandqueues.hash;

import java.util.*;

class PairWithGivenSum {

    static void checkPair(int[] arr, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        boolean found = false;

        for (int i = 0; i < arr.length; i++) {
            int complement = target - arr[i];


            if (map.containsKey(complement)) {
                System.out.println(
                        "Pair found: (" + complement + ", " + arr[i] + ")"
                );
                found = true;
                return;
            }


            map.put(arr[i], i);
        }

        if (!found) {
            System.out.println("No pair found with given sum");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter array size: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter target sum: ");
        int target = sc.nextInt();

        checkPair(arr, target);

        sc.close();
    }
}

