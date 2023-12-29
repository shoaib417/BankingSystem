package app;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import dao.*;
import entity.*;
import exception.InsufficientFundException;
import exception.InvalidAccountException;
import exception.OverDraftLimitExcededException;
public class BankApp {

    public static void main(String[] args) {
        IBankServiceProvider bankServiceProvider = new BankServiceProviderImpl("Main Branch", "123 Main St");
        Scanner scanner = new Scanner(System.in);

        int choice;
        do {
            System.out.println("===== Banking System Menu =====");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Get Balance");
            System.out.println("5. Transfer");
            System.out.println("6. Get Account Details");
            System.out.println("7. List Accounts");
            System.out.println("8. Check Transactions Between Date");
            System.out.println("9. Exit");

            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    createAccountMenu(bankServiceProvider, scanner);
                    break;
                case 2:
                    depositMenu(bankServiceProvider, scanner);
                    break;
                case 3:
                    withdrawMenu(bankServiceProvider, scanner);
                    break;
                case 4:
                    getBalanceMenu(bankServiceProvider, scanner);
                    break;
                case 5:
                    transferMenu(bankServiceProvider, scanner);
                    break;
                case 6:
                	getAccountDetailsMenu(bankServiceProvider, scanner);
                    break;
                case 7:
                    listAccounts(bankServiceProvider);
                    break;
                case 8:
                    getTransactionsBetweenDate(bankServiceProvider, scanner);
                    break;
                case 9:
                    System.out.println("Exiting the Banking System. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }

        } while (choice != 9);

        scanner.close();
    }

    private static void getTransactionsBetweenDate(IBankServiceProvider bankServiceProvider, Scanner scanner) {
		// TODO Auto-generated method stub
    	BankServiceProviderImpl bankService=(BankServiceProviderImpl) bankServiceProvider;
    	System.out.println("Enter account number:");
        long accountNumber = scanner.nextLong();

        System.out.println("Enter start date (YYYY-MM-DD):");
        String startDateStr = scanner.next();
        
        if (!isValidDateFormat(startDateStr, "yyyy-MM-dd")) {
            System.out.println("Invalid date format. Please use YYYY-MM-DD format.");
            return;
        }
        
        System.out.println("Enter end date (YYYY-MM-DD):");
        String endDateStr = scanner.next();

        if (!isValidDateFormat(endDateStr, "yyyy-MM-dd")) {
            System.out.println("Invalid date format. Please use YYYY-MM-DD format.");
            return; // Exit the method if the date format is invalid
        }
        
        List<Transaction> transactions = bankService.getTransactions(accountNumber, startDateStr, endDateStr);

        if (transactions != null && !transactions.isEmpty()) {
            System.out.println("Transactions between " + startDateStr + " and " + endDateStr + ":");
            for (Transaction transaction : transactions) {
                System.out.println("Transaction Type: " + transaction.getTransactionType());
                System.out.println("Transaction Amount: " + transaction.getTransactionAmount());
                System.out.println("Description: " + transaction.getDescription());
                System.out.println("Date and Time: " + transaction.getDateTime());
                System.out.println("-------------------------------------");
            }
        } else {
            System.out.println("No transactions found between " + startDateStr + " and " + endDateStr);
        }  
        
	}

	private static void createAccountMenu(IBankServiceProvider bankServiceProvider, Scanner scanner) {
        System.out.println("===== Create Account Menu =====");
        System.out.println("1. Savings Account");
        System.out.println("2. Current Account");
        System.out.println("3. ZeroBalance");
        System.out.print("Enter account type choice: ");
        int accountTypeChoice = scanner.nextInt();

        System.out.print("Enter customer ID: ");
        int customerId = scanner.nextInt();

        System.out.print("Enter first name: ");
        String firstName = scanner.next();

        System.out.print("Enter last name: ");
        String lastName = scanner.next();

        System.out.print("Enter email address: ");
        String email = scanner.next();

        System.out.print("Enter phone number: ");
        long phoneNumber = scanner.nextLong();

        System.out.print("Enter address: ");
        String address = scanner.next();

        Customer customer = new Customer(customerId, firstName, lastName, email, phoneNumber, address);

        System.out.print("Enter initial balance: ");
        double initialBalance = scanner.nextDouble();

        switch (accountTypeChoice) {
            case 1:
                bankServiceProvider.createAccount(customer,Account.generateAccountNumber(bankServiceProvider.getMaxAcc()), "Savings", initialBalance);
                break;
            case 2:
                bankServiceProvider.createAccount(customer, Account.generateAccountNumber(bankServiceProvider.getMaxAcc()), "Current", initialBalance);
                break;
            case 3:
                bankServiceProvider.createAccount(customer, Account.generateAccountNumber(bankServiceProvider.getMaxAcc()), "ZeroBalance", initialBalance);
                break;
            default:
                System.out.println("Invalid account type choice.");
        }
    }

    private static void depositMenu(IBankServiceProvider bankServiceProvider, Scanner scanner) {
    	BankServiceProviderImpl bankService=(BankServiceProviderImpl) bankServiceProvider;
    	System.out.print("Enter account number to deposit into: ");
        long accountNumber = scanner.nextLong();

        System.out.print("Enter deposit amount: ");
        double amount = scanner.nextDouble();

        // Call bankServiceProvider.deposit() method
        try
        {
            double newBalance = bankService.deposit(accountNumber, amount);

        }
        catch(InvalidAccountException e)
        {
        	System.out.println("Invalid Account Number");
        }
    }

    private static void withdrawMenu(IBankServiceProvider bankServiceProvider, Scanner scanner) {
        // Implement the withdraw menu logic
        // Use bankServiceProvider.withdraw() method
    	BankServiceProviderImpl bankService=(BankServiceProviderImpl) bankServiceProvider;
    	System.out.print("Enter account number to withdraw from: ");
        long accountNumber = scanner.nextLong();

        System.out.print("Enter withdrawal amount: ");
        double amount = scanner.nextDouble();

        // Call bankServiceProvider.withdraw() method
        try
        {
            double newBalance = bankService.withdraw(accountNumber, amount);
        }catch(OverDraftLimitExcededException e)
        {
        	System.out.println("withdraw Failed");
        }
        catch (InvalidAccountException e) {
			// TODO Auto-generated catch block
        	System.out.println("Invalid Account withdraw Failed");
		}
    	catch (InsufficientFundException e) {
			// TODO Auto-generated catch block
    		System.out.println("withdraw Failed");    	
    		}

        
    }

    private static void getBalanceMenu(IBankServiceProvider bankServiceProvider, Scanner scanner) {
        // Implement the get balance menu logic
        // Use bankServiceProvider.getAccountBalance() method
    	BankServiceProviderImpl bankService=(BankServiceProviderImpl) bankServiceProvider;
    	System.out.print("Enter account number to get balance: ");
        long accountNumber = scanner.nextLong();

        // Call bankServiceProvider.getAccountBalance() method
        try
        {
        	double balance = bankService.getAccountBalance(accountNumber);
            System.out.println("Current balance for account " + accountNumber + ": Rs." + balance);
        }
        catch(InvalidAccountException e)
        {
    		System.out.println("No account exist with account number "+accountNumber);
        }
        
    }

    private static void transferMenu(IBankServiceProvider bankServiceProvider, Scanner scanner) {
    	BankServiceProviderImpl bankService=(BankServiceProviderImpl) bankServiceProvider;
    	System.out.print("Enter from account number: ");
        long fromAccountNumber = scanner.nextLong();

        System.out.print("Enter to account number: ");
        long toAccountNumber = scanner.nextLong();

        System.out.print("Enter transfer amount: ");
        double amount = scanner.nextDouble();

        // Call bankServiceProvider.transfer() method
        try
        {
        	bankService.transfer(fromAccountNumber, toAccountNumber, amount);
        	System.out.println("Transfer successful");
        }
        catch(OverDraftLimitExcededException e)
        {
        	System.out.println("Transfer Failed");
        }
        catch (InvalidAccountException e) {
			// TODO Auto-generated catch block
        	System.out.println("Transfer Failed");
		}
    	catch (InsufficientFundException e) {
			// TODO Auto-generated catch block
    		System.out.println("Transfer Failed");    	}
    }

    private static void getAccountDetailsMenu(IBankServiceProvider bankServiceProvider, Scanner scanner) {
    	BankServiceProviderImpl bankService=(BankServiceProviderImpl) bankServiceProvider;
    	System.out.print("Enter from account number: ");
        long AccountNumber = scanner.nextLong();
        try
        {
        	System.out.println(bankService.getAccountDetails(AccountNumber));
        }
        catch(InvalidAccountException e)
        {
        	System.out.println("Invalid Account Number");
        }
    }

    private static void listAccounts(IBankServiceProvider bankServiceProvider) {
        System.out.println("===== List of Accounts =====");
        try
        {
            Map<Long,Account> accountList = bankServiceProvider.listAccounts();
            for (Map.Entry<Long, Account> entry : accountList.entrySet()) {
        		long accountNumber = entry.getKey();
                Account account = entry.getValue();
                System.out.println("Account Number: " + account.getAccountNumber() +
                        ", Type: " + account.getAccountType() +
                        ", Balance: Rs." + account.getAccountBalance());
                }

        }
        catch (NullPointerException e) {
            // Catching the NullPointerException
            System.out.println("NullPointerException caught: " + e.getMessage());
        }
        
    }
    private static boolean isValidDateFormat(String dateStr, String format) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat(format);
            dateFormat.setLenient(false); // Disable lenient mode
            dateFormat.parse(dateStr);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }
}
