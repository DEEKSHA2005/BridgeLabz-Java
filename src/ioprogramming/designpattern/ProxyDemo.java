package ioprogramming.designpattern;
import java.util.Scanner;

/*
 Proxy Pattern
 Controls access to real object
*/

// service interface
interface FileService {
    void readFile();
}

// real service
class RealFileService implements FileService {

    public void readFile() {
        System.out.println("Reading file contents...");
    }
}

// proxy
class FileAccessProxy implements FileService {

    String role;
    RealFileService realService = new RealFileService();

    FileAccessProxy(String role) {
        this.role = role;
    }

    public void readFile() {

        // access control
        if (role.equalsIgnoreCase("admin"))
            realService.readFile();
        else
            System.out.println("Access denied");
    }
}

public class ProxyDemo {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter user role:");
        String role = sc.nextLine();

        FileService file = new FileAccessProxy(role);

        file.readFile();
    }
}
