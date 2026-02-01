package collectionstreams.collections.listinterface;

import java.util.*;

public class NthFromEnd {
    public static void main(String[] args) {

        LinkedList<String> list = new LinkedList<>(Arrays.asList("A","B","C","D","E"));
        int n = 2;

        System.out.println("Nth Element from End: " + list.get(list.size() - n));
    }
}

