package dsa.stackandqueues.hash;

import java.util.*;

class ZeroSumSubarrays {

    static void findZeroSumSubarrays(int[] arr) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int sum = 0;
        boolean found = false;

        // To handle subarrays starting from index 0
        map.put(0, new ArrayList<>());
        map.get(0).add(-1);

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            // If same prefix sum seen before
            if (map.containsKey(sum)) {
                for (int startIndex : map.get(sum)) {
                    System.out.println(
                            "Zero-sum subarray found from index " +
                                    (startIndex + 1) + " to " + i
                    );
                    found = true;
                }
            }

            // Store current prefix sum index
            map.putIfAbsent(sum, new ArrayList<>());
            map.get(sum).add(i);
        }

        // If no zero-sum subarray exists
        if (!found) {
            System.out.println("No zero-sum subarray found");
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

        findZeroSumSubarrays(arr);

        sc.close();
    }
}
