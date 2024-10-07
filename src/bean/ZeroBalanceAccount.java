package bean;
public class ZeroBalanceAccount extends Account {
    public ZeroBalanceAccount(Customer customer) {
        super("ZeroBalance", 0, customer);
    }
    public static void main(String[] args) {
        Customer customer = new Customer(103, "Girish", "Bassa", "girishbassa2001@.com", "9988776655", "Kakinada");
        ZeroBalanceAccount zeroBalanceAccount = new ZeroBalanceAccount(customer);
        System.out.println("Zero Balance Account Details:");
        System.out.println("Account Number: " + zeroBalanceAccount.getAccountNumber());
        System.out.println("Account Balance: " + zeroBalanceAccount.getBalance());
    }
}
