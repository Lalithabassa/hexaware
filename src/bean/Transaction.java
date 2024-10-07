package bean;

import java.time.LocalDateTime;

public class Transaction {
    private Account account;
    private String description;
    private LocalDateTime dateTime;
    private String transactionType;
    private float transactionAmount;

    public Transaction(Account account, String description, String transactionType, float transactionAmount) {
        this.account = account;
        this.description = description;
        this.dateTime = LocalDateTime.now();
        this.transactionType = transactionType;
        this.transactionAmount = transactionAmount;
    }

    public Account getAccount() {
        return account;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public float getTransactionAmount() {
        return transactionAmount;
    }
    public static void main(String[] args) {
        Customer customer = new Customer(101, "Lalitha", "Bassa", "lalithabassa3@gmail.com", "8106656560", "vizag");
        Account account = new Account("Savings", 1000.0f, customer);
        Transaction transaction = new Transaction(account, "ATM Withdrawal", "Withdraw", 200.0f);
        System.out.println("Transaction Details:");
        System.out.println("Account Number: " + transaction.account.getAccountNumber());
        System.out.println("Description: " + transaction.description);
        System.out.println("Date and Time: " + transaction.dateTime);
        System.out.println("Transaction Type: " + transaction.transactionType);
        System.out.println("Transaction Amount: " + transaction.transactionAmount);
    }
}