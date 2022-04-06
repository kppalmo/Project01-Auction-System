package edu.ithaca.dturnbull;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AuctioneerTests {

    @Test
    void auctionStartEndtest() {
        Auctioneer auctioneer=new Auctioneer();
        assertEquals("",auctioneer.getAuctionStatus());
        //Start the auction
        auctioneer.startAuction();
        assertEquals("Auction in progress",auctioneer.getAuctionStatus());
        //End auction
        auctioneer.endAuction();
        assertEquals("Auction is over",auctioneer.getAuctionStatus());
} 
@Test
    void assignBidNumTest() {
        //Customer customer=new Customer();
        Auctioneer auctioneer=new Auctioneer();
        //auctioneer.assignBidNum(customer);
        //assertEquals(customer.getBidNum(),3);
    }
@Test
    void verifyTests() {
        //Auction auction=new Auction(itemList);
        Auctioneer auctioneer=new Auctioneer();
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
     Auctioneer auctioneer=new Auctioneer(); 
     //assertEquals(item,auctioneer.displayItem());
}
}
