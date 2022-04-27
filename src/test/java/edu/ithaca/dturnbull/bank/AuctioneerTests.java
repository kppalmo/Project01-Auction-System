
package edu.ithaca.dturnbull.bank;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AuctioneerTests {

@Test
    void auctionStartEndtest() {
        Auctioneer auctioneer=new Auctioneer("auctioneer");
        assertFalse(auctioneer.getAuctionStatus());
        //Start the auction
        auctioneer.startAuction(1);
        assertTrue(auctioneer.getAuctionStatus());
        //End auction
        auctioneer.endAuction(1);
        assertFalse(auctioneer.getAuctionStatus());
} 
@Test
    void assignBidNumTest() {
        Customer customer=new Customer("jim",0.0,250.0,"green",true);
        Customer customer2=new Customer("jam",0.0,250.0,"green",true);
        Customer customer3=new Customer("joe",0.0,250.0,"green",true);

        Auctioneer auctioneer=new Auctioneer("auctioneer");
        auctioneer.assignBidNum(customer2);
        auctioneer.assignBidNum(customer3);
        assertEquals(auctioneer.assignBidNum(customer),customer.id);

        assertEquals(1.0,customer2.id);
        assertEquals(2.0,customer3.id);
    }
@Test
        //Need to fix tests
    void verifyTests() throws InsufficientFundsException {
        Auctioneer auctioneer=new Auctioneer("auctioneer");

        Item cup = new Item("cup",10.00, "glass cup", 15.00, 0);
        Customer customer1=new Customer("jim", 34.0, 150.00, "green",true);
        Customer customer2=new Customer("jam", 35.0, 200.00, "green",true);
        auctioneer.startAuction(1);
        customer1.placeBid(cup, 20.00);;
        customer2.placeBid(cup, 25.00);
        customer1.placeBid(cup, 30.00);
        auctioneer.endAuction(1);
        //auction.getHighestBid();
        //assertTrue(auctioneer.verifyPayment(customer1, auction));
        //assertTrue(auctioneer.verifyBidNumber(customer1,34.0));
    }
    @Test
    void displayTest() throws InsufficientFundsException { 
    //Auction auction=new Auction(itemList);
     Auctioneer auctioneer=new Auctioneer("auctioneer");
     Customer customer1=new Customer("jon", 34.0, 150.00, "green", true); 
     Item chair = new Item("shoe",10.00, "nike", 15.00, 1);
     customer1.placeBid(chair, 20.00);;
     assertEquals(20.00,auctioneer.displayBid(chair));
}
@Test
void createItemTest(){
Auctioneer auctioneer=new Auctioneer("auctioneer");
auctioneer.createItem("cat",5.00, "persian", 5.00);
auctioneer.createItem("chair",15.00, "wooden chair", 15.00);
auctioneer.createItem("broom",20.00, "made in 2000", 20.00);


}
@Test
void addRemoveItemTest(){
    Auctioneer auctioneer=new Auctioneer("auctioneer");
    auctioneer.startAuction(0);
    //need to fix this test
    auctioneer.createItem("hat",12.00, "newEra", 25.00);
    //assertEquals(Auction.collectionOfItems.get(1),auctioneer.createItem(10.00, "cup", 20.00));
}


}
