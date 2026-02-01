package collectionstreams.collections;

import java.time.LocalDate;
import java.util.*;


class Policy {
    int policyNumber;
    String holderName;
    LocalDate expiryDate;
    String coverageType;
    double premium;

    Policy(int policyNumber, String holderName,
           LocalDate expiryDate, String coverageType, double premium) {
        this.policyNumber = policyNumber;
        this.holderName = holderName;
        this.expiryDate = expiryDate;
        this.coverageType = coverageType;
        this.premium = premium;
    }

    public String toString() {
        return policyNumber + " | " + holderName + " | " +
                coverageType + " | Expiry: " + expiryDate;
    }
}


public class InsurancePolicySystem {

    public static void main(String[] args) {

        Map<Integer, Policy> policyMap = new HashMap<>();

        policyMap.put(101, new Policy(101, "Alice",
                LocalDate.now().plusDays(20), "Health", 5000));
        policyMap.put(102, new Policy(102, "Bob",
                LocalDate.now().minusDays(5), "Auto", 3000));
        policyMap.put(103, new Policy(103, "Alice",
                LocalDate.now().plusDays(40), "Home", 7000));


        System.out.println("Policy 101: " + policyMap.get(101));


        System.out.println("\nExpiring within 30 days:");
        for (Policy p : policyMap.values()) {
            if (!p.expiryDate.isBefore(LocalDate.now()) &&
                    p.expiryDate.isBefore(LocalDate.now().plusDays(30))) {
                System.out.println(p);
            }
        }


        System.out.println("\nPolicies for Alice:");
        for (Policy p : policyMap.values()) {
            if (p.holderName.equalsIgnoreCase("Alice")) {
                System.out.println(p);
            }
        }


        policyMap.values().removeIf(
                p -> p.expiryDate.isBefore(LocalDate.now()));

        System.out.println("\nAfter removing expired policies:");
        policyMap.values().forEach(System.out::println);


        TreeMap<LocalDate, Policy> sortedByExpiry = new TreeMap<>();
        for (Policy p : policyMap.values()) {
            sortedByExpiry.put(p.expiryDate, p);
        }

        System.out.println("\nPolicies sorted by expiry date:");
        sortedByExpiry.values().forEach(System.out::println);
    }
}

