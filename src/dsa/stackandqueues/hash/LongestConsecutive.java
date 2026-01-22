package dsa.stackandqueues.hash;

import java.util.*;

class LongestConsecutive {

    static int longestConsecutive(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        int longest = 0;


        for (int num : arr) {
            set.add(num);
        }


        for (int num : arr) {


            if (!set.contains(num - 1)) {
                int currentNum = num;
                int count = 1;

                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    count++;
                }

                longest = Math.max(longest, count);
            }
        }
        return longest;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter array size: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int result = longestConsecutive(arr);
        System.out.println("Length of longest consecutive sequence: " + result);

        sc.close();
    }
}
