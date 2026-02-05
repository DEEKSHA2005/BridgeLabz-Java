package javacollectionsstream.java8features.java8feature;
import java.util.*;
import java.util.stream.Collectors;
import java.time.LocalDate;

public class ClaimsAnalysisExample {

    public static void main(String[] args) {

        List<Claim> claims = List.of(
                new Claim(1, "POL100", 7000, LocalDate.now(), "Approved"),
                new Claim(2, "POL100", 9000, LocalDate.now(), "Approved"),
                new Claim(3, "POL200", 4000, LocalDate.now(), "Rejected"),
                new Claim(4, "POL200", 12000, LocalDate.now(), "Approved"),
                new Claim(5, "POL300", 15000, LocalDate.now(), "Approved"),
                new Claim(6, "POL300", 8000, LocalDate.now(), "Approved")
        );

        // 1️⃣ Filter + 2️⃣ Group + 3️⃣ Aggregate
        Map<String, DoubleSummaryStatistics> statsByPolicy =
                claims.stream()
                        .filter(c -> c.getStatus().equals("Approved"))
                        .filter(c -> c.getClaimAmount() > 5000)
                        .collect(Collectors.groupingBy(
                                Claim::getPolicyNumber,
                                Collectors.summarizingDouble(Claim::getClaimAmount)
                        ));

        // 4️⃣ Top 3 policies by total claim amount
        statsByPolicy.entrySet().stream()
                .sorted((e1, e2) ->
                        Double.compare(e2.getValue().getSum(),
                                e1.getValue().getSum()))
                .limit(3)
                .forEach(e -> {
                    System.out.println("Policy: " + e.getKey());
                    System.out.println("Total Amount: " + e.getValue().getSum());
                    System.out.println("Average Amount: " + e.getValue().getAverage());
                    System.out.println("----");
                });
    }
}
class Claim {
    private int claimId;
    private String policyNumber;
    private double claimAmount;
    private LocalDate claimDate;
    private String status;

    public Claim(int claimId, String policyNumber, double claimAmount,
                 LocalDate claimDate, String status) {
        this.claimId = claimId;
        this.policyNumber = policyNumber;
        this.claimAmount = claimAmount;
        this.claimDate = claimDate;
        this.status = status;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public double getClaimAmount() {
        return claimAmount;
    }

    public String getStatus() {
        return status;
    }
}


