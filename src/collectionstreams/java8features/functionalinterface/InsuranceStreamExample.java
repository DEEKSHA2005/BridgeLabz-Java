package javacollectionsstream.java8features.day7FunctionalInterface;

import java.util.*;
import java.util.stream.Collectors;

public class InsuranceStreamExample {

    public static void main(String[] args) {

        List<Policy> policies = List.of(
                new Policy("P101", "Smith", 800),
                new Policy("P102", "John", 1500),
                new Policy("P103", "Alice", 2200),
                new Policy("P104", "Smithson", 1800),
                new Policy("P105", "Bob", 3000),
                new Policy("P106", "Anu", 1200)
        );

        // 1️⃣ Filter policies with premium > 1200
        policies.stream()
                .filter(p -> p.getPremiumAmount() > 1200)
                .forEach(System.out::println);

        // 2️⃣ Sort policies by holder name
        policies.stream()
                .sorted(Comparator.comparing(Policy::getHolderName))
                .forEach(System.out::println);

        // 3️⃣ Compute total premium
        double totalPremium =
                policies.stream()
                        .mapToDouble(Policy::getPremiumAmount)
                        .sum();
        System.out.println("Total Premium = " + totalPremium);

        // 4️⃣ Print policy details (formatted)
        policies.forEach(p ->
                System.out.println(
                        "Policy[" + p.getPolicyNumber() +
                                "] Holder=" + p.getHolderName() +
                                ", Premium=" + p.getPremiumAmount()
                ));

        // 5️⃣ Filter policies with premium between 1000 and 2000
        policies.stream()
                .filter(p -> p.getPremiumAmount() >= 1000
                        && p.getPremiumAmount() <= 2000)
                .forEach(System.out::println);

        // 6️⃣ Policy with highest premium
        policies.stream()
                .max(Comparator.comparingDouble(Policy::getPremiumAmount))
                .ifPresent(p ->
                        System.out.println("Highest Premium Policy: " + p));

        // 7️⃣ Group policies by holder name initial
        Map<Character, List<Policy>> groupedByInitial =
                policies.stream()
                        .collect(Collectors.groupingBy(
                                p -> p.getHolderName().charAt(0)
                        ));
        System.out.println(groupedByInitial);

        // 8️⃣ Compute average premium
        double averagePremium =
                policies.stream()
                        .mapToDouble(Policy::getPremiumAmount)
                        .average()
                        .orElse(0);
        System.out.println("Average Premium = " + averagePremium);

        // 9️⃣ Sort policies by premium (ascending) and print
        policies.stream()
                .sorted(Comparator.comparingDouble(Policy::getPremiumAmount))
                .forEach(System.out::println);

        // 🔟 Check if any policy exceeds 2000
        boolean anyAbove2000 =
                policies.stream()
                        .anyMatch(p -> p.getPremiumAmount() > 2000);
        System.out.println("Any premium > 2000? " + anyAbove2000);

        // 1️⃣1️⃣ Count policies for each premium range
        Map<String, Long> premiumRangeCount =
                policies.stream()
                        .collect(Collectors.groupingBy(p -> {
                            if (p.getPremiumAmount() <= 1000) return "0-1000";
                            else if (p.getPremiumAmount() <= 2000) return "1001-2000";
                            else return ">2000";
                        }, Collectors.counting()));
        System.out.println(premiumRangeCount);

        // 1️⃣2️⃣ Extract unique holder names
        policies.stream()
                .map(Policy::getHolderName)
                .distinct()
                .forEach(System.out::println);

        // 1️⃣3️⃣ Find policies with holder name containing "Smith"
        policies.stream()
                .filter(p -> p.getHolderName().contains("Smith"))
                .forEach(System.out::println);

        // 1️⃣4️⃣ Map policy number → premium amount
        Map<String, Double> policyPremiumMap =
                policies.stream()
                        .collect(Collectors.toMap(
                                Policy::getPolicyNumber,
                                Policy::getPremiumAmount
                        ));
        System.out.println(policyPremiumMap);
    }
}

class Policy {
    private String policyNumber;
    private String holderName;
    private double premiumAmount;

    public Policy(String policyNumber, String holderName, double premiumAmount) {
        this.policyNumber = policyNumber;
        this.holderName = holderName;
        this.premiumAmount = premiumAmount;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public double getPremiumAmount() {
        return premiumAmount;
    }

    @Override
    public String toString() {
        return "PolicyNumber=" + policyNumber +
                ", HolderName=" + holderName +
                ", Premium=" + premiumAmount;
    }
}
