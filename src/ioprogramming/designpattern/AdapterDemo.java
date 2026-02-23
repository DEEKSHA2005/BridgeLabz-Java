package ioprogramming.designpattern;
import java.util.Scanner;

/*
 Adapter Pattern
 Converts old interface to new interface
*/

// Old class
class OldPrinter {
    public void oldPrint(String text) {
        System.out.println("Old Printer: " + text);
    }
}

// New interface
interface NewPrinter {
    void print(String text);
}

// Adapter class
class PrinterAdapter implements NewPrinter {

    OldPrinter oldPrinter;

    // constructor
    PrinterAdapter(OldPrinter oldPrinter) {
        this.oldPrinter = oldPrinter;
    }

    // adapting method
    public void print(String text) {
        oldPrinter.oldPrint(text);
    }
}

public class AdapterDemo {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter text to print:");
        String text = sc.nextLine();

        OldPrinter oldPrinter = new OldPrinter();

        // adapter used
        NewPrinter printer = new PrinterAdapter(oldPrinter);

        printer.print(text);
    }
}
