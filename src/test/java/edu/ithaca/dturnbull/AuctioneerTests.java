
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
        Item cup = new Item(30.00, "str", 40.00);
        Customer customer1=new Customer("jim", 34.0, 150.00, "green");
        Customer customer2=new Customer("jam", 34.0, 200.00, "green");
        auctioneer.startAuction();
        customer1.placeBid(cup, 20.00);;
        customer2.placeBid(cup, 25.00);
        customer1.placeBid(cup, 30.00);
        auctioneer.endAuction();
        auction.getHighestBid();
        assertTrue(auctioneer.verifyPayment(customer1));
        assertTrue(auctioneer.verifyBidNumber(customer1,34.0));
    }
    @Test
    void displayTest() { 
    //Auction auction=new Auction(itemList);
     Auctioneer auctioneer=new Auctioneer("auctioneer"); 
     //assertEquals(item,auctioneer.displayItem());
}
}
