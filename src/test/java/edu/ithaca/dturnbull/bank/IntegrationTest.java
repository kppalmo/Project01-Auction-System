package edu.ithaca.dturnbull.bank;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.EmptyStackException;

public class IntegrationTest {

    @Test
    public void AuctionSystemIntegrationTest() throws InsufficientFundsException{

        Auctioneer auctioneer1 = new Auctioneer("Keegan", 118);
        Customer customer1 = new Customer("Vivek", 0, 900.0, "green");
        Customer customer2 = new Customer("Mateo", 0, 4000.0, "green");
        auctioneer1.startAuction(118, 12, "Keegan's Auction");
        Auction auction1 = CollectionOfAuctions.getCollectionOfAuctions().get(12);

        auctioneer1.placeItem(12, "iPhone", 700.0, "An Apple Smartphone");
        auctioneer1.placeItem(12, "Game Boy", 200.0, "A 90s Handheld Console");

        // Feature 1. Sequential Bid Number being assigned to customers by the auctioneer
        auctioneer1.addCustomer(customer1, 12);
        auctioneer1.addCustomer(customer2, 12);
        assertEquals(1, customer1.getCustomerId());
        assertEquals(2, customer2.getCustomerId());

        assertTrue(auctioneer1.getAuctionStatus(12));
        assertEquals(2, auctioneer1.getAuction(12).getCollectionOfCustomers().size());

        // Feature 2. Cannot add blacklisted customer to an auction
        Customer customer3 = new Customer("James", 0, 2000.0, "red");
        assertThrows(IllegalArgumentException.class, ()-> auctioneer1.addCustomer(customer3, 12));

        // Current item being auctioned is an iPhone
        Item item1 = auctioneer1.getCurrentItem(12);
        assertEquals("iPhone", auctioneer1.displayCurrentItem(12).getItemName());
        assertThrows(InsufficientFundsException.class, ()-> customer1.placeBid(item1, 500.0, 12, 1));
        assertThrows(EmptyStackException.class, ()-> customer1.getCustomerBid());
        assertThrows(EmptyStackException.class, ()-> customer2.getCustomerBid());

        customer1.placeBid(item1, 800.0, 12, 1);
        assertEquals(800.0, customer1.getCustomerBid());
        assertEquals(100.0, customer1.getBalance());
        assertEquals(800.0, item1.getCurrBid());

        customer2.placeBid(item1, 900.0, 12, 2);
        assertEquals(900.0, customer2.getCustomerBid());
        assertEquals(3100.0, customer2.getBalance());
        assertEquals(900.0, item1.getCurrBid());

        customer2.placeBid(item1, 1000.0, 12, 2);
        assertEquals(1000.0, customer2.getCustomerBid());
        assertEquals(2100.0, customer2.getBalance());
        assertEquals(1000.0, item1.getCurrBid());

        customer2.withdrawBid(item1);
        assertEquals(900.0, customer2.getCustomerBid());
        assertEquals(3100.0, customer2.getBalance());
        assertEquals(900.0, item1.getCurrBid());

        // Checking who is the highest bidder for item 0 (iPhone)
        assertEquals("Mateo", auction1.getHighestBidder(0).getCustomerName());

        // Moving on to the next item
        auctioneer1.nextItem();
        // Current item being auctioned is a Game Boy (item 1)
        Item item2 = auctioneer1.getCurrentItem(12);
        assertEquals("Game Boy", auctioneer1.displayCurrentItem(12).getItemName());

        assertEquals("green", customer1.getCustomerStatus());
        assertEquals(800.0, customer1.getCustomerBid());

        assertEquals(100.0, customer1.getBalance());
        customer1.placeBid(item2, 1000.0, 12, 1);
        assertEquals(800.0, customer1.getCustomerBid());

        // Feature 3. Customer1 is added to blacklist since he cannot afford the bid
        // Customer1's status is now red.
        assertNotEquals("green", customer1.getCustomerStatus());
        assertEquals("red", customer1.getCustomerStatus());
        assertEquals(1, auction1.getBlacklist().size());
        assertTrue(auction1.checkBlackList(customer1));

        // Feature 4. Customer1 pays the $50 fine for Auction1
        auction1.payBlacklistFine(customer1, 50.0);
        assertEquals("green", customer1.getCustomerStatus());
        assertEquals(0, auction1.getBlacklist().size());
        assertFalse(auction1.checkBlackList(customer1));

        auctioneer1.endAuction(12);
        // False since auction has ended
        assertFalse(auctioneer1.getAuctionStatus(12));







        


    }

    
}
