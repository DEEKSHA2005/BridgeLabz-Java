package collectionstreams.iostreams;

import java.io.*;

public class PipedStreamDemo {
    public static void main(String[] args) throws Exception {

        PipedOutputStream pos = new PipedOutputStream();
        PipedInputStream pis = new PipedInputStream(pos);

        new Thread(() -> {
            try {
                pos.write("Hello Thread".getBytes());
                pos.close();
            } catch (IOException e) {}
        }).start();

        new Thread(() -> {
            try {
                int data;
                while ((data = pis.read()) != -1)
                    System.out.print((char) data);
            } catch (IOException e) {}
        }).start();
    }
}

