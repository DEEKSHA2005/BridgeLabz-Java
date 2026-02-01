package collectionstreams.collections;

import java.util.*;

class WithdrawalRequest {
    int accountNumber;
    double amount;

    WithdrawalRequest(int acc, double amt) {
        accountNumber = acc;
        amount = amt;
    }
}

public class BankingSystem {

    public static void main(String[] args) {

        Map<Integer, Double> accounts = new HashMap<>();
        accounts.put(1001, 5000.0);
        accounts.put(1002, 12000.0);
        accounts.put(1003, 8000.0);

        System.out.println("Accounts: " + accounts);


        TreeMap<Double, Integer> sortedByBalance = new TreeMap<>();
        for (Map.Entry<Integer, Double> entry : accounts.entrySet()) {
            sortedByBalance.put(entry.getValue(), entry.getKey());
        }

        System.out.println("Accounts sorted by balance:");
        sortedByBalance.forEach(
                (bal, acc) -> System.out.println(acc + " -> " + bal));


        Queue<WithdrawalRequest> queue = new LinkedList<>();
        queue.add(new WithdrawalRequest(1001, 2000));
        queue.add(new WithdrawalRequest(1003, 3000));

        System.out.println("\nProcessing Withdrawals:");
        while (!queue.isEmpty()) {
            WithdrawalRequest wr = queue.remove();
            if (accounts.get(wr.accountNumber) >= wr.amount) {
                accounts.put(wr.accountNumber,
                        accounts.get(wr.accountNumber) - wr.amount);
                System.out.println("Withdrawal successful for Account "
                        + wr.accountNumber);
            } else {
                System.out.println("Insufficient balance for Account "
                        + wr.accountNumber);
            }
        }

        System.out.println("\nFinal Balances: " + accounts);
    }
}

