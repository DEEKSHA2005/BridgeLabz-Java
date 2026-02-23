package ioprogramming.designpattern;
import java.util.*;

/*
 Mediator Pattern
 Central object handles communication
*/

interface MessageHub {
    void sendMessage(String msg, Participant user);
}

class CommunicationCenter implements MessageHub {

    List<Participant> users = new ArrayList<>();

    void addUser(Participant u) {
        users.add(u);
    }

    public void sendMessage(String msg, Participant sender) {

        for (Participant u : users) {
            if (u != sender)
                u.receive(msg);
        }
    }
}

class Participant {

    MessageHub hub;
    String name;

    Participant(MessageHub hub, String name) {
        this.hub = hub;
        this.name = name;
    }

    void send(String msg) {
        hub.sendMessage(msg, this);
    }

    void receive(String msg) {
        System.out.println(name + " received: " + msg);
    }
}

public class ChatSimulation {

    public static void main(String[] args) {

        CommunicationCenter room = new CommunicationCenter();

        Participant u1 = new Participant(room, "Alice");
        Participant u2 = new Participant(room, "Bob");

        room.addUser(u1);
        room.addUser(u2);

        u1.send("Hello Bob!");
    }
}