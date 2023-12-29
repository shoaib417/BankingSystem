package entity;

public class Account {
    private static long lastAccNo = 1000; // Starting account number
    private long accountNumber;
    private String accountType;
    private double accountBalance;
    private Customer customer;

    // Default constructor
    public Account() {
        this.accountNumber = generateAccountNumber(lastAccNo);
    }

    // Overloaded constructor
    public Account(String accountType, double accountBalance, Customer customer) {
        this.accountNumber = lastAccNo;
        this.accountType = accountType;
        this.accountBalance = accountBalance;
        this.customer = customer;
    }
    public Account(long accNo,String accountType, double accountBalance, Customer customer) {
        this.accountNumber = accNo;
        this.accountType = accountType;
        this.accountBalance = accountBalance;
        this.customer = customer;
    }

    // Getter methods
    public long getAccountNumber() {
        return accountNumber;
    }

    public String getAccountType() {
        return accountType;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public Customer getCustomer() {
        return customer;
    }

    // Setter methods
    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }
    
    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    // Method to generate a unique account number
    public static long generateAccountNumber(long lastAccNo) {
        return ++lastAccNo;
    }

    // Method to print account information
    public void printAccountInfo() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Type: " + accountType);
        System.out.println("Account Balance: $" + accountBalance);
        System.out.println("Customer Information:");
        customer.printInfo();
    }

	public void withdraw(double amount) {
		// TODO Auto-generated method stub
		
	}
}