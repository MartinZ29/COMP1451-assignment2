package comp1451.assignment2.data;
import java.util.ArrayList;

/**
 * This is assignment 2 for BCIT COMP 1451
 * Student ID # A01013955    Yuxing Zhang
 * 
 * @author Martin
 * @version Oct 26, 2018
 * 
 */
public class Account {

	private double balance;
	private String accountNumber;
	private boolean active;
	private ArrayList<String> transactionInfo;
	
	/**
	 * Default constructor
	 */
	public Account() {
		
	}
	
	/**
	 * Overload constructor which passes three parameters in it
	 * @param balance
	 * 				- is the balance of the account
	 * @param accountNumber
	 * 				- is the account number of the account
	 * @param active
	 * 				- is whether this account is active
	 */
	public Account(double balance, String accountNumber, boolean active) {
		setBalance(balance);
		setAccountNumber(accountNumber);
		this.active = active;
		transactionInfo = new ArrayList<String>();
	}
	
	/**
	 * Mutator of balance
	 * @param balance
	 * 			- is the balance of the account
	 */
	public void setBalance(double balance) {
		if(balance > 0) {
			this.balance = balance;
		}else {
			this.balance = 0.0;
		}
	}
	
	/**
	 * Mutator of the accountNumber
	 * @param accountNumber
	 * 			- is the account number of the account
	 */
	public void setAccountNumber(String accountNumber) {
		if(accountNumber != null && !accountNumber.trim().isEmpty()) {
			this.accountNumber = accountNumber;
		}else {
			
		}
	}
	
	/**
	 * Mutator of active, account status
	 * @param active
	 * 			- is the active of the account
	 */
	public void setActive(boolean active) {
		this.active = active;
	}
	
	/**
	 * Accessor to balance
	 * @return balance in double
	 */
	public double getBalance() {
		return balance;
	}
	
	/**
	 * Accessor to accountNumber
	 * @return accountNumber in String
	 */
	public String getAccountNumber() {
		return accountNumber;
	}
	
	/**
	 * Accessor to active
	 * @return active in boolean
	 */
	public boolean getActive() {
		return active;
	}
	
	/**
	 * Add an amount of money to the balance
	 * @param amount is how much money added
	 */
	public void addToBalance(double amount) {
		if(amount >=0 ) {
			this.balance += amount;
			System.out.println(amount + " added to the account.");
		}else {
			System.out.println("Please enter valid amount");
		}
	}
	
	/**
	 * Subtract an amount of money from the balance
	 * @param amount is how much subtracted
	 */
	public void subtractFromBalance(double amount) {
		if(amount >= 0 && amount <= balance) {
			this.balance -= amount;
			System.out.println(amount + " has been subtracted from the account.");
		}else {
			System.out.println("Please enter valid amount");
		}
	}
	
	/**
	 * 
	 * @param s
	 */
	public void addTransactionInfo(String s) {
		transactionInfo.add(s);
	}
	
}
