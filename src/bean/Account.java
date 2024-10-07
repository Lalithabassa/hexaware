package bean;
public class Account {
    private static long lastAccNo = 1000;
    private long accountNumber;
    private String accountType;
    private float balance;
    private Customer customer;
    public Account(String accountType, float balance, Customer customer) {
        this.accountNumber = ++lastAccNo;
        this.accountType = accountType;
        this.balance = balance;
        this.customer = customer;
    }
    public long getAccountNumber() {
        return accountNumber;
    }
    public String getAccountType() {
        return accountType;
    }
    public float getBalance() {
        return balance;
    }
    public void setBalance(float balance) {
        this.balance = balance;
    }
    public Customer getCustomer() {
        return customer;
    }
    public static void main(String[] args) {
        Customer customer = new Customer(101, "Lalitha", "Bassa", "lalithabassa3@gmail.com", "8106656560", "vizag");
        Account account = new Account("Savings", 1000.0f, customer);
        System.out.println("Account Details:");
        System.out.println("Account Number: " + account.accountNumber);
        System.out.println("Account Type: " + account.accountType);
        System.out.println("Account Balance: " + account.getBalance());
        System.out.println("Customer: " + account.getCustomer().getFirstName() + " " + account.getCustomer().getLastName());
    }
}
