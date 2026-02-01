package collectionstreams.iostreams;

import java.io.*;

public class BufferedFileCopy {
    public static void main(String[] args) throws Exception {

        FileInputStream fis = new FileInputStream("large.txt");
        FileOutputStream fos = new FileOutputStream("copy.txt");

        BufferedInputStream bis = new BufferedInputStream(fis);
        BufferedOutputStream bos = new BufferedOutputStream(fos);

        byte[] buffer = new byte[4096];
        int bytesRead;

        long start = System.nanoTime();
        while ((bytesRead = bis.read(buffer)) != -1) {
            bos.write(buffer, 0, bytesRead);
        }
        long end = System.nanoTime();

        bis.close();
        bos.close();

        System.out.println("Time taken: " + (end - start) + " ns");
    }
}

