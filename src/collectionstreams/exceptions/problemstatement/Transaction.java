package collectionstreams.exceptions.problemstatement;

class TransactionException extends Exception {
    TransactionException(String msg) {
        super(msg);
    }
}

class TransactionProcessor {

    void processTransaction(double amount) throws TransactionException {
        try {
            if (amount < 0)
                throw new IllegalArgumentException();
        } catch (IllegalArgumentException e) {
            throw new TransactionException("Transaction failed: Invalid amount " + amount);
        }
    }
}

public class Transaction {
    public static void main(String[] args) {

        try {
            new TransactionProcessor().processTransaction(-500);
        } catch (TransactionException e) {
            System.out.println(e.getMessage());
        }
    }
}

