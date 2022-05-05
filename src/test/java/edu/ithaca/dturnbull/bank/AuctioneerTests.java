
package edu.ithaca.dturnbull.bank;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AuctioneerTests {

@Test
    void auctionStartEndtest() {
        Auctioneer auctioneer=new Auctioneer("auctioneer",null,0);
        auctioneer.createItem("cup", 10.00, "glass cup", 15.00);
        auctioneer.createItem("chair", 10.00, "wooden chair", 15.00);
        auctioneer.createItem("fan", 10.00, "old fan", 15.00);

        //Start the auction
        auctioneer.startAuction(0);
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

        Auctioneer auctioneer=new Auctioneer("auctioneer",null,0);
        auctioneer.assignBidNum(customer2);
        auctioneer.assignBidNum(customer3);
        assertEquals(auctioneer.assignBidNum(customer),customer.id);

        assertEquals(1.0,customer2.id);
        assertEquals(2.0,customer3.id);
    }
@Test
        //Need to fix tests
    void verifyTests() throws InsufficientFundsException {
        Auctioneer auctioneer=new Auctioneer("auctioneer",null,0);

        auctioneer.createItem("cup", 10.00, "glass cup", 15.00);
        Item cup = new Item("cup",10.00, "glass cup", 15.00, 0);
        Customer customer1=new Customer("jim", 34.0, 150.00, "green",true);
        Customer customer2=new Customer("jam", 35.0, 200.00, "green",true);
        auctioneer.startAuction(0);
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
     Auctioneer auctioneer=new Auctioneer("auctioneer",null,0);
     Customer customer1=new Customer("jon", 34.0, 150.00, "green", true); 
     Item chair = new Item("shoe",10.00, "nike", 15.00, 1);
     customer1.placeBid(chair, 20.00);;
     assertEquals(20.00,auctioneer.displayBid(chair));
}
@Test
void createItemTest(){
Auctioneer auctioneer=new Auctioneer("auctioneer",null,0);
auctioneer.createItem("cat",5.00, "persian", 5.00);
auctioneer.createItem("chair",15.00, "wooden chair", 15.00);
auctioneer.createItem("broom",20.00, "made in 2000", 20.00);


}
@Test
void addRemoveItemTest(){
    Auctioneer auctioneer=new Auctioneer("auctioneer",null,0);
    auctioneer.startAuction(0);
    auctioneer.createItem("hat",12.00, "newEra", 25.00);
    auctioneer.createItem("cat",10.00, "persian", 10.00);
    
    assertEquals(auctioneer.createItem("cup",10.00, "plastic cup", 20.00),Auction.collectionOfItems.get(2));
    assertEquals(auctioneer.createItem("phone",100.00, "nokia", 100.00),Auction.collectionOfItems.get(3));
    auctioneer.removeItem(2);
    assertEquals(null,Auction.collectionOfItems.get(2));
    auctioneer.removeItem(1);
    assertEquals(null,Auction.collectionOfItems.get(1));
    

}

@Test
void itemListTest(){
    Auctioneer auctioneer=new Auctioneer("auctioneer",null,0);
    Customer customer=new Customer("Jim", 1.00, 100.00, "green", true);
 
    auctioneer.createItem("hat",12.00, "newEra", 25.00);
    auctioneer.createItem("cat",10.00, "persian", 10.00);
    auctioneer.auctionItemList(0);
    auctioneer.startAuction(0);
   

    //Should print
    //Item name: hat Starting bid: 12.0 Background: newEra Current bid: 25.0 Item num: 1 Item name: cat Starting bid: 10.0 Background: persian Current bid: 10.0 Item num: 2 
    customer.viewAllItems(0);
    auctioneer.endAuction(0);
  
    auctioneer.createItem("clock",35.00, "Old Wooden Clock", 35.00);
    auctioneer.auctionItemList(1);
    auctioneer.startAuction(1);
    //Should print
    //Item name: clock Starting bid: 35.0 Background: Old Wooden Clock Current bid: 35.0 Item num: 1 
    customer.viewAllItems(1);
    auctioneer.startAuction(1);


}
@Test
void addCustomerandBidTest(){
    Auctioneer auctioneer=new Auctioneer("auctioneer",null,0);
    Customer customer=new Customer("Jim", 1.00, 100.00, "green", true);
    Customer customer2=new Customer("Jam", 1.00, 100.00, "green", true);
    auctioneer.addCustomer(customer,0);
    auctioneer.addCustomer(customer2,0);
    auctioneer.startAuction(0);

}

}
