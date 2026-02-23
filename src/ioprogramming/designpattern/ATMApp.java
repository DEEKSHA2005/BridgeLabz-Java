package ioprogramming.designpattern;
import java.util.Scanner;

/*
 State Pattern
 Object behavior changes based on state
*/

interface ATMState {
    void handle();
}

class IdleState implements ATMState {

    public void handle() {
        System.out.println("ATM waiting for card");
    }
}

class CardInsertedState implements ATMState {

    public void handle() {
        System.out.println("Card inserted, enter PIN");
    }
}

class TransactionState implements ATMState {

    public void handle() {
        System.out.println("Processing transaction");
    }
}

class ATMController {

    ATMState state;

    void setState(ATMState s) {
        state = s;
    }

    void process() {
        state.handle();
    }
}

public class ATMApp {

    public static void main(String[] args) {

        ATMController atm = new ATMController();

        atm.setState(new IdleState());
        atm.process();

        atm.setState(new CardInsertedState());
        atm.process();

        atm.setState(new TransactionState());
        atm.process();
    }
}