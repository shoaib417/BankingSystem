package dao;
import java.util.Date;
import java.util.List;

import entity.*;

public class CustomerServiceProviderImpl implements ICustomerServiceProvider {

    // Implementation of interface methods

    @Override
    public double getAccountBalance(long accountNumber) {
    	return 0.0;
    }

    @Override
    public double deposit(long accountNumber, double amount) {
       
        return 0.0;
    }

    @Override
    public double withdraw(long accountNumber, double amount) {
        return 0.0;
    }

    @Override
    public void transfer(long fromAccountNumber, long toAccountNumber, double amount) {

        System.out.println("Transferred Rs." + amount + " from account " + fromAccountNumber + " to account " + toAccountNumber);
    }

    @Override
    public String getAccountDetails(long accountNumber) {
        return "Account details for account number " + accountNumber;
    }
    @Override
	public List<Transaction> getTransactions(long accountNumber, String startDate, String endDate) {
		// TODO Auto-generated method stub
		return null;
	}

	
    
    

	

}
