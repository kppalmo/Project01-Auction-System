package edu.ithaca.dturnbull.bank;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ItemTest {

    @Test
    void bidHistoryTest() throws InsufficientFundsException{
        Customer cust = new Customer("Vivek", 24.0, 150.00, "green",true);
        Item testOBJ = new Item("test",15.00, "str", 15.00,0);

        // check that the first bid in the stack is the starting bid
        assertEquals(15.00, testOBJ.getCurrBid()); 

        // cannot withdraw the starting bid
        assertThrows(IllegalArgumentException.class, ()-> cust.withdrawBid(testOBJ, 15.00));

        cust.placeBid(testOBJ, 20.00);
        assertEquals(20.00, testOBJ.getCurrBid());
        assertEquals(130.00, cust.getCustomerBalance());

        Customer cust2 = new Customer("Keegan", 24.0, 150.00, "green",true);

        cust2.placeBid(testOBJ, 60.00);
        assertEquals(60.00, testOBJ.getCurrBid());
        assertEquals(90.00, cust2.getCustomerBalance());

        // check that exception is thrown if a customer tries to place a bid lower than the current bid
        assertThrows(InsufficientFundsException.class, ()-> cust.placeBid(testOBJ, 10.00));

        cust2.withdrawBid(testOBJ, 60.00);
        assertEquals(150.00, cust2.getCustomerBalance());
        assertEquals(20.00, testOBJ.getCurrBid());




    } 
    
}
