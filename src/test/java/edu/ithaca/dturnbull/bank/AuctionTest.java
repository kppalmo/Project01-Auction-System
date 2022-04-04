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
        Item testOBJ = new Item(15.00, "str", 15.00);
        //Customer sets new Bid
        cust.placeBid(testOBJ, 20.00);
        assertEquals(20.00, testOBJ.getCurrBid());
        assertEquals(130.00, cust.getCustomerBalance());
        cust.withdrawBid(testOBJ, 20.00);
        //FAILS B/C BID NEEDS TO BE RESET TO OG
        assertEquals(15.00, testOBJ.getCurrBid());
        assertEquals(150.00, cust.getCustomerBalance());

    }
    
}
