package service;
	import java.util.HashMap;
	import java.util.Map;

import bean.Account;
import bean.Customer;
	public class CustomerServiceProviderImpl implements ICustomerServiceProvider {
	    private Map<Long, Account> accountMap = new HashMap<>();
	    @Override
	    public float get_account_balance(long account_number) {
	        Account account = accountMap.get(account_number);
	        return account != null ? account.getBalance() : 0;
	    }
	    @Override
	    public float deposit(long account_number, float amount) {
	        Account account = accountMap.get(account_number);
	        if (account != null) {
	            account.setBalance(account.getBalance() + amount);
	            return account.getBalance();
	        }
	        return 0;
	    }
	    @Override
	    public float withdraw(long account_number, float amount) {
	        Account account = accountMap.get(account_number);
	        if (account != null) {
	            if (account.getBalance() >= amount) {
	                account.setBalance(account.getBalance() - amount);
	                return account.getBalance();
	            } else {
	                System.out.println("Insufficient balance!");
	            }
	        }
	        return 0;
	    }
	    @Override
	    public void transfer(long from_account_number, long to_account_number, float amount) {
	        Account fromAccount = accountMap.get(from_account_number);
	        Account toAccount = accountMap.get(to_account_number);

	        if (fromAccount != null && toAccount != null && fromAccount.getBalance() >= amount) {
	            fromAccount.setBalance(fromAccount.getBalance() - amount);
	            toAccount.setBalance(toAccount.getBalance() + amount);
	            System.out.println("Transfer successful.");
	        } else {
	            System.out.println("Transfer failed.");
	        }
	    }
	    @Override
	    public Account getAccountDetails(long account_number) {
	        return accountMap.get(account_number);
	    }
	    public void addAccount(Account account) {
	        accountMap.put(account.getAccountNumber(), account);
	    }
	 public static void main(String[] args) {
	        CustomerServiceProviderImpl customerService = new CustomerServiceProviderImpl();
	        Customer customer1 = new Customer(101, "Lalitha", "Bassa", "lalithabassa3@gmail.com", "9876543210", "vizag");
	        Customer customer2 = new Customer(102, "Kavitha", "Bammidi", "bkavya2212@gmail.com", "9876543211", "Kakinada");
	        Account account1 = new Account("Savings", 1000.0f, customer1);
	        Account account2 = new Account("Current", 2000.0f, customer2);
	        customerService.addAccount(account1);
	        customerService.addAccount(account2);
	        System.out.println("Initial balance for Account 1: " + customerService.get_account_balance(account1.getAccountNumber()));
	        customerService.deposit(account1.getAccountNumber(), 500.0f);
	        System.out.println("Balance after deposit into Account 1: " + customerService.get_account_balance(account1.getAccountNumber()));
	        customerService.withdraw(account1.getAccountNumber(), 300.0f);
	        System.out.println("Balance after withdrawal from Account 1: " + customerService.get_account_balance(account1.getAccountNumber()));
	        customerService.transfer(account2.getAccountNumber(), account1.getAccountNumber(), 200.0f);
	        System.out.println("Balance for Account 1 after transfer: " + customerService.get_account_balance(account1.getAccountNumber()));
	        System.out.println("Balance for Account 2 after transfer: " + customerService.get_account_balance(account2.getAccountNumber()));
	        Account details = customerService.getAccountDetails(account1.getAccountNumber());
	        System.out.println("Account Holder: " + details.getCustomer().getFirstName() + " " + details.getCustomer().getLastName());
	        System.out.println("Account Type: " + details.getAccountType());
	        System.out.println("Current Balance: " + details.getBalance());
	    }
	@Override
	public float getAccountBalance(long accountNumber) {
		// TODO Auto-generated method stub
		return 0;
	}
	public void create_account(Customer customer, long accNo, String accType, float balance) {
		// TODO Auto-generated method stub
		
	}
	public void calculateInterest() {
		// TODO Auto-generated method stub
		
	}
	}