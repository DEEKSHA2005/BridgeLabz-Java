package collectionstreams.iostreams;

import java.io.*;

public class ImageByteArray {
    public static void main(String[] args) throws Exception {

        FileInputStream fis = new FileInputStream("image.jpg");
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        int data;
        while ((data = fis.read()) != -1) {
            baos.write(data);
        }

        byte[] imageBytes = baos.toByteArray();

        FileOutputStream fos = new FileOutputStream("copy.jpg");
        fos.write(imageBytes);

        fis.close();
        fos.close();

        System.out.println("Image copied successfully");
    }
}

