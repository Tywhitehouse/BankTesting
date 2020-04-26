package banking;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class BankingTests {

    private Bank bank;
    private Customer customer;
    private String custID;
    private Account account;

    // Test Fixture:
    @BeforeEach
    void setUp () {
        bank = new Bank( "My Bank" );
        custID = bank.addCustomer("Bebop", "Rocksteady");
        Customer customer = bank.getCustomer( custID );
        Account savings = customer.addSavingsAccount( 0.00, "My Savings Account" );
    }

    // Test a deposit of $10.00 works:
    @Test
    @DisplayName("Account.deposit Tests")
    void depositShouldIncreaseBalance () {
        final double initialBalance = account.getBalance();
        final double amount = 10.00;
        account.deposit( amount );
        final double finalBalance = account.getBalance();
        assertEquals( finalBalance, initialBalance + amount,
                "Balance should be " +
                        (initialBalance+amount) + "but was " + finalBalance );
    }

    // Test a deposit of $0.00 has no impact:
    @Test
    @DisplayName("Account.deposit Tests")
    void depositShouldNotImpactBalance () {
        final double initialBalance = account.getBalance();
        final double amount = 0.00;
        account.deposit( amount );
        final double finalBalance = account.getBalance();
        assertEquals( finalBalance, initialBalance,
                "Balance should be " +
                        (initialBalance) + "but was " + finalBalance );
    }

    // Test a deposit of $-5.00 is rejected and balance remains untouched:
    @Test
    @DisplayName("Account.deposit Tests")
    void negativeDepositShouldNotBeAccepted () {
        final double initialBalance = account.getBalance();
        final double amount = -5.00;
        account.deposit( amount );
        final double finalBalance = account.getBalance();
        assertEquals( finalBalance, initialBalance,
                "Balance should be " +
                        (initialBalance) + "but was " + finalBalance );
    }

    // Test a deposit of $999,999,999 is rejected and balance remains untouched:
    @Test
    @DisplayName("Account.deposit Tests")
    void veryLargeDepositShouldNotBeAccepted () {
        final double initialBalance = account.getBalance();
        final double amount = 999999999;
        account.deposit( amount );
        final double finalBalance = account.getBalance();
        assertEquals( finalBalance, initialBalance,
                "Balance should be " +
                        (initialBalance) + "but was " + finalBalance );
    }

}
