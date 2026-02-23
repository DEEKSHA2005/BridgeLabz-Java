package ioprogramming.designpattern;
import java.util.Scanner;

/*
 Command Pattern
 Encapsulates request as object
*/

// command interface
interface SwitchCommand {
    void execute();
}

// receiver
class Lamp {

    void turnOn() {
        System.out.println("Lamp turned ON");
    }

    void turnOff() {
        System.out.println("Lamp turned OFF");
    }
}

// command classes
class TurnOnLamp implements SwitchCommand {

    Lamp lamp;

    TurnOnLamp(Lamp lamp) {
        this.lamp = lamp;
    }

    public void execute() {
        lamp.turnOn();
    }
}

class TurnOffLamp implements SwitchCommand {

    Lamp lamp;

    TurnOffLamp(Lamp lamp) {
        this.lamp = lamp;
    }

    public void execute() {
        lamp.turnOff();
    }
}

// invoker
class SwitchPanel {

    void pressButton(SwitchCommand cmd) {
        cmd.execute();
    }
}

public class SmartHome {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Lamp lamp = new Lamp();
        SwitchPanel panel = new SwitchPanel();

        System.out.println("Enter command (on/off):");
        String input = sc.nextLine();

        if (input.equalsIgnoreCase("on"))
            panel.pressButton(new TurnOnLamp(lamp));
        else
            panel.pressButton(new TurnOffLamp(lamp));
    }
}
