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
	public SavingsAccount(double balance, String accountNumber, boolean active, String accountType) {
		super(balance, accountNumber, active, accountType);
		setAccountType("SavingAccount");
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
	
	
}
