package banking;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BankTest {
	
	private Bank bank;

	@Test
	// Creating an account
	@DisplayName("Bank.addCustomer Test")
	void AddAccountTest() {
		final String lname = bank.getNAME();
		final String fname = bank.getNAME();
		final String NAME = lname + fname;
		bank.addCustomer(lname, fname);
		assertEquals(NAME, bank.addCustomer(lname, fname));
	}
	

}
