package bean;
public class CurrentAccount extends Account {
    private float overdraftLimit;
    public CurrentAccount(float accountBalance, Customer customer, float overdraftLimit) {
        super("Current", accountBalance, customer);
        this.overdraftLimit = overdraftLimit;
    }
    public static void main(String[] args) {
        Customer customer = new Customer(102, "Lalitha", "Bassa", "lalithabassa3@gmail.com", "8106656560", "Vizianagaram");
        CurrentAccount currentAccount = new CurrentAccount(7000.0f, customer, 10000.0f);
        System.out.println("Current Account Details:");
        System.out.println("Account Number: " + currentAccount.getAccountNumber());
        System.out.println("Account Balance: " + currentAccount.getBalance());
        System.out.println("Overdraft Limit: " + currentAccount.overdraftLimit);
    }
}
