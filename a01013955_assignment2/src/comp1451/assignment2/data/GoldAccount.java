package comp1451.assignment2.data;

import java.util.Date;

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
	 * Default constructor
	 */
	public GoldAccount() {
		super();
	}
	
	/**
	 * Overload constructor which inherits from super type and passes more parameters to the constructor
	 * @param balance
	 * 				- is the balance of the account
	 * @param accountNumber
	 * 				- is the account number of the account
	 * @param active
	 * 				- is the active status of the account
	 * @param interestRate
	 * 				- is the monthly interest rate of the account
	 * @param inOverdraft
	 * 				- is the overdraft status of the account
	 * @param accountType
	 * 				- is the account type of the account
	 */
	public GoldAccount(double balance, String accountNumber, boolean active, double interestRate, boolean inOverdraft, String accountType) {
		super(balance, accountNumber, active, accountType);
		setAccountType("GoldAccount");
		setInterestRate(interestRate);
		setInOverdraft(inOverdraft);
	}
	
	/**
	 * Mutator of interestRate
	 * @param interestRate
	 * 				- is the monthly interest rate of the account
	 */
	public void setInterestRate(double interestRate) {
		if(interestRate >= 0) {
			this.interestRate = interestRate;
		}else {
			this.interestRate = 0;
		}
	}
	
	/**
	 * Mutator of overdraft
	 * @param inOverdraft
	 *               - is the overdraft status of the account
	 */
	public void setInOverdraft(boolean inOverdraft) {
		this.inOverdraft = inOverdraft;
	}
	
	/**
	 * Accessor of interestRate
	 * @return interestRate in double
	 */
	public double getInterestRate() {
		return interestRate;
	}
	
	/**
	 * Accessor of inOverdraft
	 * @return inOverDraft in boolean
	 */
	public boolean getInOverdraft() {
		return inOverdraft;
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
		if(amount <= getBalance() && amount > 0) {
			super.subtractFromBalance(amount);
		}else if(amount > 0 && amount > getBalance() && amount - getBalance() <= OVERDRAFT_AMT) {
			setBalance(getBalance() - amount - FEE);
			addTransactionInfo(new Date() + " - withdraw: $" + amount);
			setInOverdraft(true);
		}else {
			System.out.println("Please enter valid amount");
		}
	}
	
}
