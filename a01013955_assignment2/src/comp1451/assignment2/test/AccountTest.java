package comp1451.assignment2.test;

import static org.junit.Assert.*;
import comp1451.assignment2.data.Account;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AccountTest {

	private Account accountOne;
	@Before
	public void setUp() throws Exception {
		accountOne = new Account(100.0, "CH-123", true);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAddToBalancePositive() {
		accountOne.addToBalance(100.0);
		assertEquals(200.0, accountOne.getBalance());
	}

	@Test
	public void testSubtractFromBalance() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddTransactionInfo() {
		fail("Not yet implemented");
	}

	@Test
	public void testDisplayTransactionInfo() {
		fail("Not yet implemented");
	}

}
