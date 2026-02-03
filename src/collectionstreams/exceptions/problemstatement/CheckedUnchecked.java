package collectionstreams.exceptions.problemstatement;

import java.io.*;

public class CheckedUnchecked {

    static void processData(boolean flag) throws IOException {
        if (flag)
            throw new IOException("Checked Exception occurred");
        else
            throw new RuntimeException("Unchecked Exception occurred");
    }

    public static void main(String[] args) {

        try {
            processData(true);
        } catch (IOException e) {
            System.out.println("Handled checked exception");
        } catch (RuntimeException e) {
            System.out.println("Handled unchecked exception");
        }
    }
}

