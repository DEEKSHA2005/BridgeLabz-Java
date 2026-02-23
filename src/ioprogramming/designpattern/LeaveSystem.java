package ioprogramming.designpattern;
import java.util.Scanner;

/*
 Chain of Responsibility
 Request passes through multiple handlers
*/

abstract class RequestProcessor {

    RequestProcessor nextProcessor;

    void setNext(RequestProcessor next) {
        this.nextProcessor = next;
    }

    abstract void processRequest(int days);
}

// first handler
class Supervisor extends RequestProcessor {

    void processRequest(int days) {

        if (days <= 2)
            System.out.println("Supervisor approved leave");
        else if (nextProcessor != null)
            nextProcessor.processRequest(days);
    }
}

// second handler
class DepartmentHead extends RequestProcessor {

    void processRequest(int days) {

        if (days <= 5)
            System.out.println("Department Head approved leave");
        else if (nextProcessor != null)
            nextProcessor.processRequest(days);
    }
}

// final handler
class Director extends RequestProcessor {

    void processRequest(int days) {

        if (days <= 10)
            System.out.println("Director approved leave");
        else
            System.out.println("Leave request rejected");
    }
}

public class LeaveSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter leave days:");
        int days = sc.nextInt();

        Supervisor s = new Supervisor();
        DepartmentHead d = new DepartmentHead();
        Director dir = new Director();

        s.setNext(d);
        d.setNext(dir);

        s.processRequest(days);
    }
}