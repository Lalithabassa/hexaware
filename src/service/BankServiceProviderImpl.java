package service;
	import java.util.ArrayList;
	import java.util.List;

import bean.Account;
import bean.Customer;
import bean.Transaction;
	public class BankServiceProviderImpl extends CustomerServiceProviderImpl implements IBankServiceProvider {
	    private List<Account> accountList = new ArrayList<>();
	    private List<Transaction> transactionList = new ArrayList<>();
	    private String branchName;
	    private String branchAddress;
	    public BankServiceProviderImpl(String branchName, String branchAddress) {
	        this.branchName = branchName;
	        this.branchAddress = branchAddress;
	    }
	    @Override
	    public void create_account(Customer customer, long accNo, String accType, float balance) {
	        Account newAccount = new Account(accType, balance, customer);
	        accountList.add(newAccount);
	        System.out.println("Account created successfully for customer: " + customer.getFirstName() + " " + customer.getLastName());
	    }
	    @Override
	    public List<Account> listAccounts() {
	        return accountList;
	    }
	    @Override
	    public void calculateInterest() {
	        for (Account account : accountList) {
	            if (account.getAccountType().equalsIgnoreCase("Savings")) {
	                float interest = account.getBalance() * 0.05f; // 4% interest
	                account.setBalance(account.getBalance() + interest);
	                System.out.println("Interest applied to Account Number: " + account.getAccountNumber() + " New Balance: " + account.getBalance());
	            }
	        }
	    }
	    @Override
	    public float get_account_balance(long account_number) {
	        for (Account account : accountList) {
	            if (account.getAccountNumber() == account_number) {
	                return account.getBalance();
	            }
	        }
	        System.out.println("Account not found!");
	        return 0;
	    }
	    @Override
	    public float deposit(long account_number, float amount) {
	        for (Account account : accountList) {
	            if (account.getAccountNumber() == account_number) {
	                account.setBalance(account.getBalance() + amount);
	                Transaction transaction = new Transaction(account, "Deposit", "Deposit", amount);
	                transactionList.add(transaction);
	                System.out.println("Deposit successful. New balance: " + account.getBalance());
	                return amount;
	            }
	        }
	        System.out.println("Account not found for deposit!");
			return amount;
	    }
	    @Override
	    public float withdraw(long account_number, float amount) {
	        for (Account account : accountList) {
	            if (account.getAccountNumber() == account_number) {
	                if (account.getAccountType().equalsIgnoreCase("Savings") && (account.getBalance() - amount < 500)) {
	                    System.out.println("Withdrawal violates minimum balance requirement!");
	                } else {
	                    account.setBalance(account.getBalance() - amount);
	                    Transaction transaction = new Transaction(account, "Withdrawal", "Withdraw", amount);
	                    transactionList.add(transaction);
	                    System.out.println("Withdrawal successful. New balance: " + account.getBalance());
	                }
	                return 0;
	            }
	        }
	        System.out.println("Account not found for withdrawal!");
			return amount;
	    }
	    @Override
	    public void transfer(long from_account_number, long to_account_number, float amount) {
	        Account fromAccount = null;
	        Account toAccount = null;
	        for (Account account : accountList) {
	            if (account.getAccountNumber() == from_account_number) {
	                fromAccount = account;
	            } else if (account.getAccountNumber() == to_account_number) {
	                toAccount = account;
	            }
	        }
	        if (fromAccount == null || toAccount == null) {
	            System.out.println("One or both accounts not found!");
	            return;
	        }
	        withdraw(from_account_number, amount);
	        deposit(to_account_number, amount);
	        System.out.println("Transfer successful from Account " + from_account_number + " to Account " + to_account_number);
	    }
	    public static void main(String[] args) {
	        BankServiceProviderImpl bankService = new BankServiceProviderImpl("Main Branch", "RNB, Madhavadhara");
	        Customer customer1 = new Customer(101, "Lalitha", "Bassa", "lalithabassa3@gmail.com", "9876543210", "Vizianagaram");
	        Customer customer2 = new Customer(102, "Girish", "Bassa", "bkavya2212@gmail.com", "1234567890", "Kakinada");
	        bankService.create_account(customer1, customer1.getCustomerId(), "Savings", 23000);
	        bankService.create_account(customer2, customer2.getCustomerId(), "Current", 9000);
	        System.out.println("\nAccounts in the bank:");
	        for (Account account : bankService.listAccounts()) {
	            System.out.println("Account Number: " + account.getAccountNumber() + 
	                               ", Account Type: " + account.getAccountType() + 
	                               ", Balance: " + account.getBalance() + 
	                               ", Customer: " + account.getCustomer().getFirstName() + " " + account.getCustomer().getLastName());
	        }
	        bankService.deposit(1001, 3500); 
	        bankService.withdraw(1001, 8000); 
	        bankService.transfer(1001, 1002, 5000);
	        bankService.calculateInterest();
	    }
		@Override
		public void createAccount(Customer customer, long accNo, String accType, float balance) {
		}

		@Override
		public float calculateInterest(long accountNumber) {
			return 0;
		}
	}