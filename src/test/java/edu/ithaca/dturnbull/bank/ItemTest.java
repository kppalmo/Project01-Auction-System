package edu.ithaca.dturnbull.bank;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ItemTest {

    @Test
    void bidHistoryTest() throws InsufficientFundsException{
        Customer cust = new Customer("Vivek", 0, 150.0, "green");
        Auctioneer auctioneer = new Auctioneer("jim", 25);
        auctioneer.startAuction(25,5,"Auction 5");

        auctioneer.placeItem(5, "test", 15.00, "str");

        // check that the first bid in the stack is the starting bid
        assertEquals(15.00, auctioneer.getCurrentItem(5).getCurrBid()); 

        // cannot withdraw the starting bid
        assertThrows(IllegalArgumentException.class, ()-> cust.withdrawBid(auctioneer.getCurrentItem(5)));
        cust.placeBid(auctioneer.getCurrentItem(5),  20.00, 0, 1);
        assertEquals(20.00, auctioneer.getCurrentItem(5).getCurrBid());
        assertEquals(130.00, cust.getCustomerBalance());

        Customer cust2 = new Customer("Keegan", 1, 150.0, "green");
        cust2.placeBid(auctioneer.getCurrentItem(5),  60.00, 5, 2);
        assertEquals(60.00, auctioneer.getCurrentItem(5).getCurrBid());
        assertEquals(90.00, cust2.getCustomerBalance());

        // check that exception is thrown if a customer tries to place a bid lower than the current bid
        assertThrows(InsufficientFundsException.class, ()-> cust.placeBid(auctioneer.getCurrentItem(5),  10.00, 5, 3));
        cust2.withdrawBid(auctioneer.getCurrentItem(5));
        assertEquals(150.00, cust2.getCustomerBalance());
        assertEquals(20.00, auctioneer.getCurrentItem(5).getCurrBid());




    } 
    
}
