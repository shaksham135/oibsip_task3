package src;

public class Account {
    private String userId;
    private String pin;
    private double balance;
    private Transaction[] transactions;
    private int transactionCount;

    public Account(String userId, String pin) {
        this.userId = userId;
        this.pin = pin;
        this.balance = 0.0;
        this.transactions = new Transaction[100]; // Assuming max 100 transactions
        this.transactionCount = 0;
    }

    public String getUserId() {
        return userId;
    }

    public String getPin() {
        return pin;
    }

    public void deposit(double amount) {
        balance += amount;
        transactions[transactionCount++] = new Transaction("Deposit", amount);
    }

    public boolean withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            transactions[transactionCount++] = new Transaction("Withdrawal", amount);
            return true;
        } else {
            System.out.println("Insufficient funds.");
            return false;
        }
    }

    public boolean transfer(Account recipient, double amount) {
        if (amount <= balance) {
            balance -= amount;
            recipient.balance += amount;
            transactions[transactionCount++] = new Transaction("Transfer to " + recipient.userId, amount);
            recipient.transactions[recipient.transactionCount++] = new Transaction("Transfer from " + userId, amount);
            return true;
        } else {
            System.out.println("Insufficient funds.");
            return false;
        }
    }

    public void displayTransactionHistory() {
        System.out.println("Transaction History:");
        for (int i = 0; i < transactionCount; i++) {
            Transaction transaction = transactions[i];
            System.out.println(transaction.getType() + ": $" + transaction.getAmount());
        }
    }
}




