package comp1451.assignment2.data;
/**
 * This is assignment 2 for BCIT COMP 1451
 * Student ID # A01013955    Yuxing Zhang
 * 
 * @author Martin
 * @version Oct 26, 2018
 * 
 */

public class SavingsAccount extends Account {

	public final double MIN_AMOUNT = 10;
	
	/**
	 * Default constructor which inherits from super class
	 */
	public SavingsAccount() {
		super();
	}
	
	/**
	 * Overload constructor which inherits from supertype but has unique requirement
	 * @param balance
	 * 				- is the balance of the account
	 * @param accountNumber
	 * 				- is the account number of the account
	 * @param active
	 * 				- is the status of the account
	 */
	public SavingsAccount(double balance, String accountNumber, boolean active) {
		super(balance, accountNumber, active);
		setActive(isActive());
	}
	
	/**
	 * Check balance with MIN_AMOUNT requirement to set status of the account
	 * @return active in boolean;
	 */
	public boolean isActive() {
		if(this.getBalance() < MIN_AMOUNT) {
			return false;
		}else {
			return true;
		}
	}
	
	/**
	 * Add an amount of money to the balance
	 * @param amount is how much money added
	 */
	public void addToBalance(double amount) {
		super.addToBalance(amount);
	}
	
	/**
	 * Subtract an amount of money from the balance and check whether the account is active
	 * @param amount is how much subtracted
	 */
	public void subtractFromBalance(double amount) {
		super.subtractFromBalance(amount);
		setActive(isActive());
	}
	
	/**
	 * toString method to check variables
	 */
	public String toString() {
		return ("account=" + " [" + super.toString() + "], ");
	}
}
