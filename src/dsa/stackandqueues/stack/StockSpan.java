package dsa.stackandqueues.stack;

import java.util.Scanner;
import java.util.Stack;

class StockSpan {

    public static int[] calculateSpan(int[] prices) {
        int n = prices.length;
        int[] span = new int[n];
        Stack<Integer> stack = new Stack<>();


        span[0] = 1;
        stack.push(0);

        for (int i = 1; i < n; i++) {


            while (!stack.isEmpty() && prices[i] >= prices[stack.peek()]) {
                stack.pop();
            }


            span[i] = stack.isEmpty() ? i + 1 : i - stack.peek();


            stack.push(i);
        }
        return span;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of days: ");
        int n = sc.nextInt();

        int[] prices = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter price for day " + (i + 1) + ": ");
            prices[i] = sc.nextInt();
        }

        int[] span = calculateSpan(prices);

        System.out.println("Stock Span Values:");
        for (int i = 0; i < n; i++) {
            System.out.println("Day " + (i + 1) + " Span: " + span[i]);
        }

        sc.close();
    }
}
