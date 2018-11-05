package comp1451.assignment2.data;
import java.util.ArrayList;
import java.util.Date;

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
	protected String accountType;

	
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
		setActive(active);

		transactionInfo = new ArrayList<String>();
	}
	
	/**
	 * Mutator of balance
	 * @param balance
	 * 			- is the balance of the account
	 */
	public void setBalance(double balance) {
		if(balance >= 0) {
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
			System.out.println("Account number cannot be null.");
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
	 * Mutator of accountType
	 * @param accountType
	 * 				- is the account type of the account
	 */
	public void setAccountType(String accountType) {
		if(accountType != null && !accountType.trim().isEmpty()) {
			this.accountType = accountType;
		}else {
			System.out.println("Account type cannot be null.");
		}
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
	 * Accessor to accountType
	 * @return accountType in String
	 */
	public String getAccountType() {
		return accountType;
	}
	
	/**
	 * Add an amount of money to the balance
	 * @param amount is how much money added
	 */
	public void addToBalance(double amount) {
		if(amount >=0 ) {
			this.balance += amount;
			addTransactionInfo(new Date() + " - deposit: $" + amount);
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
			addTransactionInfo(new Date() + " - withdraw: $" + amount);
			System.out.println(amount + " has been subtracted from the account.");
		}else {
			System.out.println("Please enter valid amount");
		}
	}
	
	/**
	 * Add transaction information to the ArrayList
	 * @param s
	 * 		- is the transaction information
	 */
	public void addTransactionInfo(String s) {
		transactionInfo.add(s);
	}
	
	/**
	 * Display all the transaction information in the ArrayList of transactionInfo
	 */
	public void displayTransactionInfo() {
		for(String s : transactionInfo) {
			if(transactionInfo.size() > 0) {
				System.out.println(s);
			}
		}
	}
	
	/**
	 * toString method to check variables to be correct
	 */
	public String toString() {
		return ("toString()=Account [balance=" +getBalance() + ", accountNubmer=" + getAccountNumber() + ", active=" + getActive() + "]");
	}
}
