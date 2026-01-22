package dsa.stackandqueues.hash;

import java.util.*;

class TwoSum {

    static void findTwoSum(int[] arr, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            int complement = target - arr[i];


            if (map.containsKey(complement)) {
                System.out.println(
                        "Indices: " + map.get(complement) + " and " + i
                );
                System.out.println(
                        "Values: " + complement + " and " + arr[i]
                );
                return;
            }


            map.put(arr[i], i);
        }

        System.out.println("No two sum solution found");
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

        findTwoSum(arr, target);
        sc.close();
    }
}

