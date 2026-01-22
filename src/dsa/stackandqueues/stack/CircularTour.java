package dsa.stackandqueues.stack;

import java.util.*;

class CircularTour {

    static int findStartingPoint(int[] petrol, int[] distance) {
        Queue<Integer> queue = new LinkedList<>();
        int surplus = 0;
        int start = 0;

        for (int i = 0; i < petrol.length; i++) {
            surplus += petrol[i] - distance[i];
            queue.offer(i);


            while (surplus < 0 && !queue.isEmpty()) {
                int removed = queue.poll();
                surplus -= petrol[removed] - distance[removed];
                start = removed + 1;
            }
        }

        return surplus >= 0 ? start : -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of petrol pumps: ");
        int n = sc.nextInt();

        int[] petrol = new int[n];
        int[] distance = new int[n];

        System.out.println("Enter petrol at each pump:");
        for (int i = 0; i < n; i++) {
            petrol[i] = sc.nextInt();
        }

        System.out.println("Enter distance to next pump:");
        for (int i = 0; i < n; i++) {
            distance[i] = sc.nextInt();
        }

        int start = findStartingPoint(petrol, distance);

        if (start == -1) {
            System.out.println("No possible circular tour");
        } else {
            System.out.println("Start at petrol pump index: " + start);
        }

        sc.close();
    }
}
