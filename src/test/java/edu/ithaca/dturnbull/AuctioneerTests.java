
package edu.ithaca.dturnbull;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AuctioneerTests {

@Test
    void auctionStartEndtest() {
        Auctioneer auctioneer=new Auctioneer("auctioneer");
        assertFalse(auctioneer.getAuctionStatus());
        //Start the auction
        auctioneer.startAuction();
        assertTrue(auctioneer.getAuctionStatus());
        //End auction
        auctioneer.endAuction();
        assertFalse(auctioneer.getAuctionStatus());
} 
@Test
    void assignBidNumTest() {
        Customer customer=new Customer("jim",0.250,"green");
        Auctioneer auctioneer=new Auctioneer("auctioneer");
        assertEquals(auctioneer.assignBidNum(25, customer),customer.id);
    }
@Test
    void verifyTests() {
        //Auction auction=new Auction(itemList);
        Auctioneer auctioneer=new Auctioneer("auctioneer");
        //Customer customer1=new Customer();
        //Customer customer2=new Customer();
        auctioneer.startAuction();
        //customer1.makeBid();
        //customer2.makeBid();
        //customer1.makeBid();
        auctioneer.endAuction();
        //auction.getHighestBid();
        //assertTrue(auctioneer.verifyPayment(customer1));
        //assertTrue(auctioneer.verifyBidNumber(customer1));
    }
    @Test
    void displayTest() { 
    //Auction auction=new Auction(itemList);
     Auctioneer auctioneer=new Auctioneer("auctioneer"); 
     //assertEquals(item,auctioneer.displayItem());
}
}
