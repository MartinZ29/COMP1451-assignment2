package comp1451.assignment2.collection;
import java.util.HashMap;

import comp1451.assignment2.data.BankCustomer;

/**
 * This is assignment 2 for BCIT COMP 1451
 * Student ID # A01013955    Yuxing Zhang
 * 
 * @author Martin
 * @version Oct 26, 2018
 * 
 */

public class Bank {

	public static HashMap<String, BankCustomer> theBank;
	
	/**
	 * Default constructor and initialize the HashMap
	 */
	public Bank() {
		theBank = new HashMap<String, BankCustomer>();
	}
	
	/**
	 * Create an account/ Add a new BankCustomer to the HashMap, account number as the key, new BankCustomer as the value
	 * @param newCustomer the new element added to the HashMap using the account number as the key, new BankCustomer as the value
	 */
	public void createAccount(BankCustomer newCustomer) {
		if(newCustomer != null) {
			theBank.put(newCustomer.getAccount().getAccountNumber(), newCustomer);
			//System.out.println(newCustomer.getAccountNumber() + " has been added to the bank.");      //This is not required yet, just comment out.
		}else {
			System.out.println("please add a valid new customer");
		}
	}
	
	/**
	 * Deactivate a BankCustomer's account from the HashMap to make the active to false
	 * @param accountNumber is the key of the element to remove from the HashMap
	 */
	public void deactivateAccount(String accountNumber) {
		if(accountNumber != null && theBank.containsKey(accountNumber)) {
			theBank.get(accountNumber).getAccount().setActive(false);
			System.out.println(accountNumber + " has been deactivated.");
		}else {
			System.out.println("Cannot find " + accountNumber + " in the Bank.");
		}
	}
	
	/**
	 * Add an amount of money to the bank customer of the accountNumber
	 * @param accountNumber is the key to get the BankCustomer from theBank
	 * @param amount is the amount of money added to the balance of the BankCustomer
	 */
	public void deposit(String accountNumber, double amount) {
		if(accountNumber != null && theBank.containsKey(accountNumber)) {
			theBank.get(accountNumber).getAccount().addToBalance(amount);
		}else {
			System.out.println("Please enter valid account number.");
		}
	}
	
	/**
	 * Remove an amount of money from the bank customer of the accuntNumber
	 * @param accountNumber is the key to get the BankCustomer from theBank
	 * @param amount is the amount of money removed from the balance of the BankCustomer
	 */
	public void withdraw(String accountNumber, double amount) {
		if(accountNumber != null && theBank.containsKey(accountNumber)) {
			theBank.get(accountNumber).getAccount().subtractFromBalance(amount);
		}else {
			System.out.println("Please enter valid account number.");
		}
	}
}
