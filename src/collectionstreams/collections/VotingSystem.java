package collectionstreams.collections;

import java.util.*;

public class VotingSystem {

    public static void main(String[] args) {


        Map<String, Integer> votes = new HashMap<>();
        votes.put("Alice", 120);
        votes.put("Bob", 95);
        votes.put("Charlie", 150);


        Map<String, Integer> orderedVotes = new LinkedHashMap<>(votes);


        Map<String, Integer> sortedVotes = new TreeMap<>(votes);

        System.out.println("Votes (HashMap): " + votes);
        System.out.println("Votes (Insertion Order): " + orderedVotes);
        System.out.println("Votes (Sorted Order): " + sortedVotes);
    }
}
