package edu.ithaca.dturnbull.bank;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AuctionTest {

    // Tests to insure all parts of Customer are working
    @Test
    void validCustomerTest() {
        Customer cust = new Customer("Vivek", 0, 150.0, "green");
        assertEquals(150, cust.getCustomerBalance());
        assertEquals("green", cust.status);
        assertEquals(0, cust.id);
    }

    // Tests to check place bid on Item
    @Test
    void placeBidTest() throws InsufficientFundsException {
        Customer cust = new Customer("Vivek", 0, 150.0, "green");
        Customer cust2 = new Customer("Keegan", 1, 100.0, "green");
        Auctioneer auctioneer = new Auctioneer("jim", 25);
        auctioneer.startAuction(25,0,"Auction 0");
        auctioneer.placeItem(0, "test", 15.00, "str");
        cust.placeBid(auctioneer.getCurrentItem(0),  25.00, 0, 1);
        //Makes sure that place bid worked correctly
        assertEquals(25.00, auctioneer.getCurrentItem(0).getCurrBid());
        cust2.placeBid(auctioneer.getCurrentItem(0),  35.00, 0, 2);
        assertEquals(35.00, auctioneer.getCurrentItem(0).getCurrBid());
        cust2.withdrawBid(auctioneer.getCurrentItem(0));
        //Makes sure that withdraw bid works correctly
        assertEquals(25.00, auctioneer.getCurrentItem(0).getCurrBid());

    }

    //Tests to check if customer is on Blacklist / cannot place bid
    @Test
    void checkBlackListTest(){


    }

}
