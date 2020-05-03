package banking;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SavingsAccountTest {

	private Bank bank;
	private Customer customer;
	private double initialbalance;
	private double amount;
	private double newbalance;
	private String desc;
	private SavingsAccount savings;
	
	
	@BeforeEach
	void setup() {
		bank = new Bank("My Bank");
		//SavingsAccount savings = new SavingsAccount(customer, initialbalance, desc);
	}
	
	@Test
	// $10 deposit works
	@DisplayName("SavingsAccount.deposit Tests")
	void DepositSavingsAccount() {
		final double initialbalance = savings.getBalance();
		final double amount = 10;
		savings.deposit(amount);
		final double newbalance = savings.getBalance();
		assertEquals(newbalance, initialbalance + amount, "Balance should be " + (initialbalance + amount) + "but was "+ newbalance);
	}
	
	@Test
	@DisplayName("SavingsAccount.deposit Tests")
	// -$10 deposit and account remains unchanged
	void DepositSavingsAccountNegative() {
		final double initialbalance = savings.getBalance();
		final double amount = -10;
		savings.deposit(amount);
		final double newbalance = savings.getBalance();
		assertEquals(newbalance, initialbalance, "Balance should be " + (initialbalance) + "but was "+ newbalance);
	}
	
	@Test
	@DisplayName("SavingsAccount.deposit Tests")
	// $0 deposit and account remains unchanged
	void DepositSavingsAccountZero() {
		final double initialbalance = savings.getBalance();
		final double amount = 0;
		savings.deposit(amount);
		final double newbalance = savings.getBalance();
		assertEquals(newbalance, initialbalance, "Balance should be " + (initialbalance) + "but was "+ newbalance);
	}
	
	// withdraw of $10 works
	@Test
	@DisplayName("SavingsAccount.withdraw Tests")
	void WithdrawSavingsAccount() {
		final double initialbalance = savings.getBalance();
		final double amount = 10;
		savings.withdraw(amount);
		final double newbalance = savings.getBalance();
		assertEquals(newbalance, initialbalance - amount, "Balance should be " + (initialbalance - amount )+"but was "+ newbalance);
	}
	
	// withdraw of $-10 does not work
	@Test
	@DisplayName("SavingsAccount.withdraw Tests")
	void WithdrawSavingsAccountNegative() {
		final double initialbalance = savings.getBalance();
		final double amount = -10;
		savings.withdraw(amount);
		final double newbalance = savings.getBalance();
		assertEquals(newbalance, initialbalance, "Balance should be " + (initialbalance)+"but was "+ newbalance);
	}
	
	// withdraw of $0 changes nothing
	@Test
	@DisplayName("SavingsAccount.withdraw Tests")
	void WithdrawSavingsAccountZero() {
		final double initialbalance = savings.getBalance();
		final double amount = 0;
		savings.withdraw(amount);
		final double newbalance = savings.getBalance();
		assertEquals(newbalance, initialbalance, "Balance should be " + (initialbalance)+"but was "+ newbalance);
	}
		

}
