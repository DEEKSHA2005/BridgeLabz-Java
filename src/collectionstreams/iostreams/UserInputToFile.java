package collectionstreams.iostreams;

import java.io.*;

public class UserInputToFile {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        FileWriter fw = new FileWriter("user.txt");

        System.out.print("Enter Name: ");
        fw.write("Name: " + br.readLine() + "\n");

        System.out.print("Enter Age: ");
        fw.write("Age: " + br.readLine() + "\n");

        System.out.print("Favorite Language: ");
        fw.write("Language: " + br.readLine());

        fw.close();
        System.out.println("Data saved successfully");
    }
}

