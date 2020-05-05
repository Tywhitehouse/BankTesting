package banking;

import org.junit.Test;

import static org.junit.Assert.*;

import java.time.LocalDateTime;
import java.util.SortedSet;
import java.util.TreeSet;

public class BankingTests 
{
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
    
    @Test
    public void testBankAddCustomer() {
        Bank bank = new Bank("Test Bank");
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
        Bank bank = new Bank("Test Bank");
        Customer customer1 = new Customer(bank, "Tester1","Bletus");
        Customer customer2 = new Customer(bank, "Tester2","Sean");
        Customer customer3 = new Customer(bank, "Tester3","Manny");

        customerList.add(customer1);
        customerList.add(customer2);
        customerList.add(customer3);
        
        SortedSet customerResult = bank.getAllCustomers();

        assertEquals(" customer list equals expected size. ", customerResult,customerList);
    }
   
    // Customer class testing
    
   
    
}
