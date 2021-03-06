package banking;

import org.junit.Test;

import static org.junit.Assert.*;

import java.time.LocalDateTime;
import java.util.SortedSet;
import java.util.TreeSet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

public class BankingTests 
{
    private Bank bank;
    private Customer customer;
    private String custID;
    private Account account;
    
    @BeforeEach
    void setUp () 
    {
        bank = new Bank( "My Bank" );
        custID = bank.addCustomer("Bebop", "Rocksteady");
        Customer customer = bank.getCustomer( custID );
        Account savings = customer.addSavingsAccount( 10.00, "My Savings Account" );
    }
    
    //checks if main actually runs
    @Test
    public final void testMain() {
        String expectedResult = "Main running sucessfully";
        String actualResult;

        try{
            Bank.main(new String[0]);
            actualResult = "Main running sucessfully";
        }
        catch (RuntimeException e){
            actualResult = e.toString();
        }
        assertEquals("Should run without throwing an error.", expectedResult, actualResult);
    }
    
    //Bank tests
    @Test
    public void testBankAddCustomer() {
        String expFirstName = "Francis";
        String expLastName = "Tester";

        String returnedID = bank.addCustomer(expLastName,expFirstName);
        Customer returnedCustomer = bank.getCustomer(returnedID);

        String returnedFName = returnedCustomer.getFirstName();
        assertEquals(" The passed Customer name equals the expected Customer name ", expFirstName, returnedFName);

        String returnedLName = returnedCustomer.getLastName();
        assertEquals(" The passed Customer last name equals the expected Customer last name. ", expLastName,returnedLName);
    }
    
     @Test
     // need to know implementation for proper testing 
    public void testBankGetAllCustomers() {
        SortedSet<Customer> customerList = new TreeSet();
        Customer customer1 = new Customer(bank, "Tester1","Bletus");
        Customer customer2 = new Customer(bank, "Tester2","Sean");

        customerList.add(customer1);
        customerList.add(customer2);
        
        SortedSet customerResult = bank.getAllCustomers();

        assertEquals(" customer list equals expected size. ", customerResult,customerList);
    }
   
    //Account tests

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

    // Test a withdraw of $10.00 works:
    @Test
    @DisplayName("Account.withdraw Tests")
    void withdrawShouldDecreaseBalance () {
        final double initialBalance = account.getBalance();
        final double amount = 10.00;
        account.withdraw(amount);
        final double finalBalance = account.getBalance();
        assertEquals( finalBalance, 0,
                "Balance should be 0 but was " + finalBalance );
    }

    // Test a withdraw of $-5.00 is rejected and balance remains untouched:
    @Test
    @DisplayName("Account.withdraw Tests")
    void negativeWithdrawShouldNotBeAccepted () {
        final double initialBalance = account.getBalance();
        final double amount = -5.00;
        account.withdraw( amount );
        final double finalBalance = account.getBalance();
        assertEquals( finalBalance, initialBalance,
                "Balance should be " +
                        (initialBalance) + "but was " + finalBalance );
    }

    // Test a withdraw of $999,999,999 is rejected and balance remains untouched:
    @Test
    @DisplayName("Account.withdraw Tests")
    void veryLargeWithdrawShouldNotBeAccepted () {
        final double initialBalance = account.getBalance();
        final double amount = 999999999;
        account.withdraw(amount);
        final double finalBalance = account.getBalance();
        assertEquals( finalBalance, initialBalance,
                "Balance should be " +
                        (initialBalance) + "but was " + finalBalance );
    }


    //Customer tests

    //Remove the account from user then try to get it, should be null.
    @Test
    @DisplayName("Customer.removeAccount Tests")
    void removeAccountRemovesAccountFromCustomer () {
        customer.removeAccount("1");
        var customerAccount = customer.getAccount("1");
        assertNull(customerAccount, "Did not receive the expected null account value.");
    }
}