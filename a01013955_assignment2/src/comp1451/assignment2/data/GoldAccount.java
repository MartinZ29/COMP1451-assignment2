package comp1451.assignment2.data;
/**
 * This is assignment 2 for BCIT COMP 1451
 * Student ID # A01013955    Yuxing Zhang
 * 
 * @author Martin
 * @version Oct 26, 2018
 * 
 */

public class GoldAccount extends Account{

	private double interestRate;
	private boolean inOverdraft;
	
	public final double FEE = 1.0;
	public final double OVERDRAFT_AMT = 100.0;
	
	/**
	 * 
	 */
	public GoldAccount() {
		super();
	}
	
	public GoldAccount(double balance, String accountNumber, boolean active, double interestRate, boolean inOverdraft, String accountType) {
		super(balance, accountNumber, active, accountType);
		setAccountType("GoldAccount");
		setInterestRate(interestRate);
		setInOverdraft(inOverdraft);
	}
	
	public void setInterestRate(double interestRate) {
		if(interestRate >= 0) {
			this.interestRate = interestRate;
		}else {
			this.interestRate = 0;
		}
	}
	
	public void setInOverdraft(boolean inOverdraft) {
		this.inOverdraft = inOverdraft;
	}
	
	public double getInterestRate() {
		return interestRate;
	}
	
	public boolean getInOverDraft() {
		return inOverdraft;
	}
}
