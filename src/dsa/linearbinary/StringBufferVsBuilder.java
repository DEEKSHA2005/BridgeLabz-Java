package dsa.linearbinary;


public class StringBufferVsBuilder {

    public static void main(String[] args) {

        int n = 1_000_000;

        long start, end;

        StringBuilder sbuilder = new StringBuilder();
        start = System.nanoTime();
        for (int i = 0; i < n; i++) {
            sbuilder.append("hello");
        }
        end = System.nanoTime();
        System.out.println("StringBuilder time: " + (end - start) + " ns");

        StringBuffer sbuffer = new StringBuffer();
        start = System.nanoTime();
        for (int i = 0; i < n; i++) {
            sbuffer.append("hello");
        }
        end = System.nanoTime();
        System.out.println("StringBuffer time: " + (end - start) + " ns");
    }
}
