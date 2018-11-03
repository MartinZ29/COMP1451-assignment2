/**
 * This is assignment 2 for BCIT COMP 1451
 * Student ID # A01013955    Yuxing Zhang
 * 
 * @author Martin
 * @version Oct 26, 2018
 * 
 */

public class ChequingAccount extends Account{

	private int numberOfCheques;
	
	public final double FEE = 1.0;
	
	/**
	 * 
	 */
	public ChequingAccount() {
		super();
	}
	
	/**
	 * 
	 * @param balance
	 * @param accountNumber
	 * @param active
	 * @param numberOfCheques
	 */
	public ChequingAccount(double balance, String accountNumber, boolean active, int numberOfCheques) {
		super(balance, accountNumber, active);
		setNumberOfCheques(numberOfCheques);
	}
	
	/**
	 * 
	 * @param numberOfCheques
	 */
	public void setNumberOfCheques(int numberOfCheques) {
		if(numberOfCheques >= 0) {
			this.numberOfCheques = numberOfCheques;
		}else {
			this.numberOfCheques = 0;
		}
	}
	
	/**
	 * 
	 * @return
	 */
	public int getNumberOfCheques() {
		return numberOfCheques;
	}
	
}
