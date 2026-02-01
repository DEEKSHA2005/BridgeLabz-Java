package collectionstreams.collections.listinterface;

import java.util.*;

public class ReverseList {
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4,5));
        List<Integer> reversed = new ArrayList<>();

        for(int i = list.size() - 1; i >= 0; i--) {
            reversed.add(list.get(i));
        }

        System.out.println("Original List: " + list);
        System.out.println("Reversed List: " + reversed);
    }
}

