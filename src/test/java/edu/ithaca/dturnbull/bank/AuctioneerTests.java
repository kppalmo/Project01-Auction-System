
package edu.ithaca.dturnbull.bank;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AuctioneerTests {

@Test
    public void auctionStartEndtest() {
        Auctioneer auctioneer = new Auctioneer("jim", 25);

        //Start the auction
        auctioneer.startAuction(25,0,"Auction 0");


        auctioneer.placeItem(0, "cup", 500.00, "Porcelain cup");
        auctioneer.placeItem(0, "chair", 250.00, " wooden chair");
        auctioneer.placeItem(0, "fan", 100.00, " old fan");
        
        //True because the auction is in progress
        assertTrue(auctioneer.getAuctionStatus(0));
        //End auction
        auctioneer.endAuction(0);
        //False because the auction ended
        assertFalse(auctioneer.getAuctionStatus(0));
} 
@Test
    void assignBidNumTest() {
        //Create 3 customers
        Customer customer1 = new Customer("jim", 0, 900.0, "green");
        Customer customer2 = new Customer("jam", 0, 900.0, "green");
        Customer customer3 = new Customer("joe", 0, 900.0, "green");

        Auctioneer auctioneer = new Auctioneer("jim", 25);
        auctioneer.startAuction(25,1,"Auction 1");

        auctioneer.addCustomer(customer1, 1);
        auctioneer.addCustomer(customer2, 1);
        auctioneer.addCustomer(customer3, 1);
        //Make sure they all received the write id's
        assertEquals(customer1.id,1);
        assertEquals(customer2.id,2);
        assertEquals(customer3.id,3);
    }
@Test
    void currentBid() throws InsufficientFundsException {
        Auctioneer auctioneer = new Auctioneer("jim", 25);
        auctioneer.startAuction(25,2,"Auction 2");

        auctioneer.placeItem(2, "plate", 500.00, "Porcelain plate");
        Customer customer1 = new Customer("jim", 0, 900.0, "green");
        Customer customer2 = new Customer("jam", 0, 900.0, "green");

        customer1.placeBid(auctioneer.getCurrentItem(2),  550.00, 2, 1);
        customer2.placeBid(auctioneer.getCurrentItem(2),  600.00, 2, 2);
        auctioneer.endAuction(2);
        //Should equal the current highest bid 
        assertEquals(600.00,auctioneer.getCurrentItem(2).getCurrBid());
    }
@Test
    void displayTest() throws InsufficientFundsException { 
    Auctioneer auctioneer = new Auctioneer("jim", 25);
    auctioneer.startAuction(25,3,"Auction 3");
    Customer customer1 = new Customer("jam", 0, 900.0, "green");
     auctioneer.placeItem(3, "shoe", 160.00, "royal toe");
     customer1.placeBid(auctioneer.getCurrentItem(3),  220.00, 2, 1);
     //Auctioneer should be able to display the current highest bid
     assertEquals(220.00,auctioneer.displayBid(auctioneer.getCurrentItem(3)));
}

@Test
void addRemoveItemTest(){
    Auctioneer auctioneer = new Auctioneer("jim", 25);
    auctioneer.startAuction(25,4,"Auction 4");
    auctioneer.placeItem(4, "hat", 80.00, "newEra");
    auctioneer.placeItem(4, "cat", 50.00, "persian");
    auctioneer.withdrawItem(4, 0);
    auctioneer.withdrawItem(4, 1);
    //Should be null after the items get withdrawn
    assertEquals(null,auctioneer.getCurrentItem(4));

    
}




}
