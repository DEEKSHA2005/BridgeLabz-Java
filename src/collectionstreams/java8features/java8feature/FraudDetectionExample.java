package javacollectionsstream.java8features.java8feature;
import java.util.*;
import java.util.stream.Collectors;
import java.time.LocalDate;

public class FraudDetectionExample {

    public static void main(String[] args) {

        List<Transaction> transactions = List.of(
                new Transaction(1, "POL100", 12000, LocalDate.now(), true),
                new Transaction(2, "POL100", 15000, LocalDate.now(), true),
                new Transaction(3, "POL100", 8000, LocalDate.now(), true),
                new Transaction(4, "POL100", 20000, LocalDate.now(), true),
                new Transaction(5, "POL100", 17000, LocalDate.now(), true),
                new Transaction(6, "POL100", 11000, LocalDate.now(), true),

                new Transaction(7, "POL200", 9000, LocalDate.now(), true),
                new Transaction(8, "POL200", 13000, LocalDate.now(), true),

                new Transaction(9, "POL300", 25000, LocalDate.now(), false)
        );

        // 1️⃣ Filter + 2️⃣ Group + 3️⃣ Aggregate
        Map<String, DoubleSummaryStatistics> fraudStats =
                transactions.stream()
                        .filter(Transaction::isFraudulent)
                        .filter(t -> t.getAmount() > 10000)
                        .collect(Collectors.groupingBy(
                                Transaction::getPolicyNumber,
                                Collectors.summarizingDouble(Transaction::getAmount)
                        ));

        // 4️⃣ Alert logic
        fraudStats.forEach((policy, stats) -> {
            if (stats.getCount() > 5 || stats.getSum() > 50000) {
                System.out.println("🚨 ALERT GENERATED 🚨");
                System.out.println("Policy Number: " + policy);
                System.out.println("Fraud Count: " + stats.getCount());
                System.out.println("Total Fraud Amount: " + stats.getSum());
                System.out.println("----");
            }
        });
    }
}
class Transaction {
    private int transactionId;
    private String policyNumber;
    private double amount;
    private LocalDate transactionDate;
    private boolean isFraudulent;

    public Transaction(int transactionId, String policyNumber,
                       double amount, LocalDate transactionDate,
                       boolean isFraudulent) {
        this.transactionId = transactionId;
        this.policyNumber = policyNumber;
        this.amount = amount;
        this.transactionDate = transactionDate;
        this.isFraudulent = isFraudulent;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public double getAmount() {
        return amount;
    }

    public boolean isFraudulent() {
        return isFraudulent;
    }
}
