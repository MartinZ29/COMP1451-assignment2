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
	 * 
	 * @param balance
	 * @param accountNumber
	 * @param active
	 * @param MIN_AMOUNT
	 */
	public SavingsAccount(double balance, String accountNumber, boolean active) {
		super(balance, accountNumber, active);
		setActive(isActive());
	}
	
	/**
	 * 
	 */
	public boolean isActive() {
		if(this.getBalance() < MIN_AMOUNT) {
			return false;
		}else {
			return true;
		}
	}
	
}
