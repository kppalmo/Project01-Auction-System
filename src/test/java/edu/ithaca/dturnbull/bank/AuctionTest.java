package edu.ithaca.dturnbull.bank;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class AuctionTest {

    //Tests to insure all parts of Customer are working
    @Test
    void validCustomerTest(){
        Customer cust = new Customer("Keegan", 34.0, 150.00, "green");
        assertEquals(150, cust.getCustomerBalance());
        assertEquals("green", cust.status);
        assertEquals(34.0, cust.id);
    }

    //Tests to check place bid on Item 
    @Test
    void placeBidTest(){
        Customer cust = new Customer("Vivek", 24.0, 150.00, "green");
        Customer cust2 = new Customer("Keegan", 2.0,100.00, "green");
        Item testOBJ = new Item(20.00, "str", 15.00);
        cust.placeBid(testOBJ, 25.00);
        assertEquals(25.00, testOBJ.getCurrBid());
        cust2.placeBid(testOBJ, 35.00);
        assertEquals(35.00, testOBJ.getCurrBid());
        cust2.withdrawBid(testOBJ, 35.00);
        assertEquals(25.00, testOBJ.getCurrBid());

    }
    
}
