package dsa.algorithmruntime;

public class StringConcatPerformance {

    public static void main(String[] args) {
        int n = 1_000_000;

        long s = System.nanoTime();
        String str = "";
        for (int i = 0; i < n; i++) str += "a";
        System.out.println("String time: " + (System.nanoTime() - s));

        s = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) sb.append("a");
        System.out.println("StringBuilder time: " + (System.nanoTime() - s));

        s = System.nanoTime();
        StringBuffer sbf = new StringBuffer();
        for (int i = 0; i < n; i++) sbf.append("a");
        System.out.println("StringBuffer time: " + (System.nanoTime() - s));
    }
}
