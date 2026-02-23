package ioprogramming.designpattern;
import java.util.Scanner;

/*
 Singleton Pattern
 Ensures only one object of Logger exists
*/
class Logger {

    // private static instance
    private static Logger instance;

    // private constructor
    private Logger() {
        System.out.println("Logger instance created");
    }

    // public method to get instance
    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    // logging method
    public void log(String message) {
        System.out.println("LOG: " + message);
    }
}

public class SingletonDemo {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // user input
        System.out.println("Enter first log message:");
        String msg1 = sc.nextLine();

        System.out.println("Enter second log message:");
        String msg2 = sc.nextLine();

        // get instance multiple times
        Logger log1 = Logger.getInstance();
        Logger log2 = Logger.getInstance();

        // logging messages
        log1.log(msg1);
        log2.log(msg2);

        // check if both objects are same
        System.out.println("Are both instances same? " + (log1 == log2));
    }
}
