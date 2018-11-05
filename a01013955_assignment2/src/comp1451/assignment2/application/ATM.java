package comp1451.assignment2.application;

import comp1451.assignment2.collection.*;
import comp1451.assignment2.reader.InputReader;
import comp1451.assignment2.data.*;

/**
 * This is assignment 2 for BCIT COMP 1451
 * Student ID # A01013955    Yuxing Zhang
 * 
 * @author Martin
 * @version Oct 26, 2018
 * 
 */

public class ATM {
	
	private Bank bank;
	private InputReader inputReader;
	private boolean login;
	private String accountNumber;
	private String passcode;
	private boolean exit;
	
	/**
	 * Default constructor to 
	 */
	public ATM() {
		initialize();
		inputReader = new InputReader();
	}
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		new ATM().run();
	}
	
	/**
	 * 
	 */
	public void run() {
		displayMenu();
		
		while(!exit) {
			int input = inputReader.getIntInput();
			System.out.println("> " + input);
			switch(input) {
			case 1:
				verifyCustomer();
				break;
			case 2:
				transactDeposit();
				break;
			case 3:
				transactWithdraw();
				break;
			case 4:
				displayAccountInformation();
				break;
			case 5:
				exit = true;
				
				System.out.println("Thank you for banking at Bullwinkle's Bank");
				System.out.println("ACCOUNT SUMMARY:");
				Bank.displayCustomerInformation(Bank.theBank.get(accountNumber));
				login = false;
				System.out.println();
				System.out.println("DEBUG: Displaying all the accounts in the Bank.");
				Bank.displayAllCustomers();
				break;
			default:
				System.out.println("Please enter valid number of option.");
				run();
				break;
			}
			
		}
	}
	
	/**
	 * Add references of bank customer for test use.
	 */
	public void initialize() {
		BankCustomer customerOne;
		BankCustomer customerTwo;
		BankCustomer customerThree;
		
		customerOne = new BankCustomer("Darby", "Dog", "123", 35, new SavingsAccount(100, "SA-123", true));
		customerTwo = new BankCustomer("Freckle", "Cat", "789", 65, new GoldAccount(200, "GL-123", true));
		((GoldAccount) customerTwo.getAccount()).setInterestRate(0.025);
		((GoldAccount) customerTwo.getAccount()).setInOverdraft(false);
		customerThree = new BankCustomer("Myia", "Dog", "456", 12, new ChequingAccount(50, "CH-123", true));
		((ChequingAccount) customerThree.getAccount()).setNumberOfCheques(0);
		
		bank = new Bank();
		bank.createAccount(customerOne);
		bank.createAccount(customerTwo);
		bank.createAccount(customerThree);
	}
	
	/**
	 * Performs a deposit into a BankCustomer's account.
	 */
	public void transactDeposit() {
		if(!login) {
			System.out.println("ERROR: You must LOGIN before you can perform a transaction.");
			verifyCustomer();			
		}else {
			System.out.println("Enter the amount to deposit:");
			bank.deposit(accountNumber, inputReader.getDoubleInput());
			run();
		}
	}
	
	/**
	 * Performs a withdraw from a BankCustomer's account.
	 */
	public void transactWithdraw() {
		if(!login) {
			System.out.println("ERROR: You must LOGIN before you can perform a transaction.");
			verifyCustomer();
		}else {
			System.out.println("Enter the amount to withdraw:");
			bank.withdraw(accountNumber, inputReader.getDoubleInput());
			run();
		}
	}
	
	/**
	 * Display account information for verified BankCustomer
	 */
	public void displayAccountInformation() {
		if(!login) {
			System.out.println("ERROR: You must LOGIN before you can perform a transaction.");
			verifyCustomer();
		}else {
			System.out.println("Here is your information.");
			Bank.displayCustomerInformation(Bank.theBank.get(accountNumber));
			run();
		}
	}
	
	/**
	 * 
	 */
	public void verifyCustomer() {
		if(!login) {
			System.out.println("Enter Account Number:");
			accountNumber = inputReader.getStringInput();
			
			System.out.println("Enter Passcode:");
			passcode = inputReader.getStringInput();
			if(passcode != null && Bank.theBank.containsKey(accountNumber) && passcode.equals(Bank.theBank.get(accountNumber).getPasscode())) {
				login = true;
				run();
			}else {
				System.out.println("ERROR: Either account number or passcode is not corret.");
				run();
			}
		}else {
			System.out.println("You've already login.");
			run();
		}
	}
	
	/**
	 * Display menu on the ATM
	 */
	public void displayMenu() {
		if(!login) {
			System.out.println("Welcome to Bullwinkle's Bank.");
			System.out.println("Choose one of the following options:");
			System.out.println("1 - Sign In");
			System.out.println("2 - Deposit");
			System.out.println("3 - Withdraw");
			System.out.println("4 - Display Account Info");
			System.out.println("5 - Exit");
		}else {
			System.out.println("Choose one of the following options:");
			System.out.println("1 - Sign In");
			System.out.println("2 - Deposit");
			System.out.println("3 - Withdraw");
			System.out.println("4 - Display Account Info");
			System.out.println("5 - Exit");
		}
	}
	
	
}

