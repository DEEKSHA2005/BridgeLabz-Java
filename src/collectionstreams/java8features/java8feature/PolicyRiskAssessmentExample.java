package javacollectionsstream.java8features.java8feature;

import java.util.*;
import java.util.stream.Collectors;

public class PolicyRiskAssessmentExample {

    public static void main(String[] args) {

        List<PolicyHolder> holders = List.of(
                new PolicyHolder(1, "Ravi", 65, "Life", 40000),
                new PolicyHolder(2, "Anu", 45, "Health", 30000),
                new PolicyHolder(3, "Kumar", 70, "Life", 50000),
                new PolicyHolder(4, "Meena", 62, "Life", 20000),
                new PolicyHolder(5, "John", 75, "Life", 45000)
        );

        Map<String, List<RiskAssessment>> riskGroups =
                holders.stream()

                        // 1️⃣ Filter
                        .filter(h -> h.getPolicyType().equals("Life"))
                        .filter(h -> h.getAge() > 60)

                        // 2️⃣ Transform
                        .map(h -> new RiskAssessment(
                                h.getHolderId(),
                                h.getName(),
                                h.getPremiumAmount() / h.getAge()
                        ))

                        // 3️⃣ Sort
                        .sorted(Comparator.comparingDouble(
                                RiskAssessment::getRiskScore).reversed())

                        // 4️⃣ Categorize
                        .collect(Collectors.groupingBy(
                                r -> r.getRiskScore() > 0.5
                                        ? "High Risk"
                                        : "Low Risk"
                        ));

        riskGroups.forEach((k, v) -> {
            System.out.println(k);
            v.forEach(System.out::println);
            System.out.println("----");
        });
    }
}
class PolicyHolder {
    private int holderId;
    private String name;
    private int age;
    private String policyType;
    private double premiumAmount;

    public PolicyHolder(int holderId, String name, int age,
                        String policyType, double premiumAmount) {
        this.holderId = holderId;
        this.name = name;
        this.age = age;
        this.policyType = policyType;
        this.premiumAmount = premiumAmount;
    }

    public int getHolderId() {
        return holderId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getPolicyType() {
        return policyType;
    }

    public double getPremiumAmount() {
        return premiumAmount;
    }
}
class RiskAssessment {
    private int holderId;
    private String name;
    private double riskScore;

    public RiskAssessment(int holderId, String name, double riskScore) {
        this.holderId = holderId;
        this.name = name;
        this.riskScore = riskScore;
    }

    public double getRiskScore() {
        return riskScore;
    }

    @Override
    public String toString() {
        return holderId + " " + name + " RiskScore=" + riskScore;
    }
}

