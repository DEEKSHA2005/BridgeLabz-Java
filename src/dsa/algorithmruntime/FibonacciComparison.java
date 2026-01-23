package dsa.algorithmruntime;

public class FibonacciComparison {

    static int fibRec(int n) {
        if (n <= 1) return n;
        return fibRec(n - 1) + fibRec(n - 2);
    }

    static int fibItr(int n) {
        if (n <= 1) return n;
        int a = 0, b = 1;
        for (int i = 2; i <= n; i++) {
            int s = a + b; a = b; b = s;
        }
        return b;
    }

    public static void main(String[] args) {
        int n = 30;

        long s = System.nanoTime();
        fibRec(n);
        System.out.println("Recursive time: " + (System.nanoTime() - s));

        s = System.nanoTime();
        fibItr(n);
        System.out.println("Iterative time: " + (System.nanoTime() - s));
    }
}
