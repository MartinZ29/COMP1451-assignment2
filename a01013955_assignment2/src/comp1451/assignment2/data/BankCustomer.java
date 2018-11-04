package comp1451.assignment2.data;
/**
 * This is assignment 2 for BCIT COMP 1451
 * Student ID # A01013955    Yuxing Zhang
 * 
 * @author Martin
 * @version Oct 26, 2018
 * 
 */

public class BankCustomer {

	private String firstName;
	private String lastName;
	private String passcode;
	private int age;
	private Account myAccount;
	
	/**
	 * Default constructor
	 */
	public BankCustomer() {
		myAccount = new Account();
	}
	
	/**
	 * Overload constructor which initialize the BankCustomer with five parameters
	 * @param firstName
	 * 				- is the first name of the bank customer
	 * @param lastName
	 * 				- is the last name of the bank customer
	 * @param passcode
	 * 				- is the passcode for the account
	 * @param age
	 * 				- is the age of the bank customer
	 * @param myAccount
	 * 				- is the Account collection of the bank customer
	 */
	public BankCustomer(String firstName, String lastName, String passcode, int age, Account myAccount) {
		setFirstName(firstName);
		setLastName(lastName);
		setPasscode(passcode);
		setAge(age);
		setAccount(myAccount);
	}
	
	/**
	 * mutator for firstName
	 * @param firstName is the first name of the bank customer
	 */
	public void setFirstName(String firstName) {
		if(firstName != null && !firstName.trim().isEmpty()) {
			this.firstName = formatName(firstName);
		}else {
			System.out.println("Please enter valid first name");
		}
	}
	
	/**
	 * mutator for lastName
	 * @param lastName is the last name of the bank customer
	 */
	public void setLastName(String lastName) {
		if(lastName != null && !lastName.trim().isEmpty()) {
			this.lastName = formatName(lastName);
		}else {
			System.out.println("Please enter valid last name");
		}
	}
	
	/**
	 * mutator for passcode
	 * @param passcode is the passcode of the bank account
	 */
	public void setPasscode(String passcode) {
		if(passcode != null && !passcode.trim().isEmpty()) {
			this.passcode = passcode;
			System.out.println("passcode has been set.");
		}else {
			System.out.println("Please enter valid passcode");
		}
	}
	
	/**
	 * Mutator for age
	 * @param age
	 * 			- is the age of the customer
	 */
	public void setAge(int age) {
		if(age > 0) {
			this.age = age;
		}else {
			this.age = 0;
		}
	}
	
	/**
	 * Mutator of setAccount
	 * @param myAccount
	 */
	public void setAccount(Account myAccount) {
		if(myAccount.getAccountNumber().substring(0, 1).equals("CH")) {
			this.myAccount = new ChequingAccount();
		}else if(myAccount.getAccountNumber().substring(0, 1).equals("SA")) {
			this.myAccount = new SavingsAccount();
		}else if(myAccount.getAccountNumber().substring(0, 1).equals("GL") && age >= 65) {
			this.myAccount = new GoldAccount();
		}else {
			System.out.println("please check account number.");
		}
	}
	
	/**
	 * Accessor for the firstName
	 * @return first name in String
	 */
	public String getFirstName() {
		return firstName;
	}
	
	/**
	 * Accessor for the lastName
	 * @return last name in String
	 */
	public String getLastName() {
		return lastName;
	}
	
	/**
	 * Accessor for passcode
	 * @return passcode in String
	 */
	public String getPasscode() {
		return passcode;
	}
	
	/**
	 * Accessor of age
	 * @return age in int
	 */
	public int getAge() {
		return age;
	}
	
	/**
	 * Accessore of Account
	 * @return myAccount collection
	 */
	public Account getAccount() {
		return myAccount;
	}
	
	/**
	 *  Formats a name so the name will be upper case with first letter and lower case
	 *  with rest of the letters.
	 *  
	 *  @param name is the name pass in and transfer to formatted name
	 *  @return the properly-formatted name
	 */
	private String formatName(String name) {
		if(name != null && name.length() > 0) {
			return name.substring(0,1).toUpperCase() + name.substring(1).toLowerCase();
		}else {
			return("");
		}
	}
	
	/**
	 * toString() to check variables
	 */
	public String toString() {
		return ("BankCustomer [firstName=" + getFirstName() + ", lastName=" + getLastName() + ", passcode=" + getPasscode() + ", " + myAccount.toString() + "age=" +getAge() + "]");
	}
}
