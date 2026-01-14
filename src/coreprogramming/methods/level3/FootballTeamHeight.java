package coreprogramming.methods.level3;

import java.util.Scanner;

public class FootballTeamHeight {

    public static int findSum(int[] heights) {
        int sum = 0;
        for (int i = 0; i < heights.length; i++) {
            sum += heights[i];
        }
        return sum;
    }

    public static double findMean(int[] heights) {
        int sum = findSum(heights);
        return (double) sum / heights.length;
    }

    public static int findShortest(int[] heights) {
        int min = heights[0];
        for (int i = 1; i < heights.length; i++) {
            if (heights[i] < min) {
                min = heights[i];
            }
        }
        return min;
    }

    public static int findTallest(int[] heights) {
        int max = heights[0];
        for (int i = 1; i < heights.length; i++) {
            if (heights[i] > max) {
                max = heights[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] heights = new int[11];

        for (int i = 0; i < heights.length; i++) {
            System.out.print("Enter height of player " + (i + 1) + " (in cm): ");
            heights[i] = sc.nextInt();
        }

        System.out.println("Shortest Height = " + findShortest(heights) + " cm");
        System.out.println("Tallest Height = " + findTallest(heights) + " cm");
        System.out.println("Mean Height = " + findMean(heights) + " cm");
    }
}

