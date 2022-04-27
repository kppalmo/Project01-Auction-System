package edu.ithaca.dturnbull.bank;

import java.util.Collection;

public class Auctioneer {
    public String name;
    public static double bidNum=0.0;
    public static int itemNum=0;
    public Auctioneer(String name){
        this.name=name;
    }

    //be able to create a collection of auctions
    //Auction constructor(id, status)
    //add item
    //remove item
    //create collections of auction class                      
    //hashmap for collection of auctions
    //add customer to the auction
    //remove customer from auction

    //Param: Item item
    //Purpose: to display the current bid
    //return double
    public double displayBid(Item item){
        return item.getCurrBid();
    }

    //Params: Customer customer
    //Purpose: To assign a random number to each customer based on the amount of customers in the auction
    //Returns: void

    public double assignBidNum(Customer customer){//Customer customer){
        bidNum+=1;
        customer.id=bidNum;
        return bidNum;
    }

    //Params: n/a
    //Purpose: To end the auction
    //Returns: void
    public void endAuction(int auctionId){
        Auction.auctionStatus=false;
        bidNum=0.0;
        CollectionOfAuctions.collectionOfAuctions.remove(CollectionOfAuctions.auctionId);

    }

    //Params: Auction auction
    //Purpose: To display the item that is being auctioned
    //Returns: the item being auctioned
    public Item displayItem(Item item){
        return item;
        
    }
     
    //add item method
    
    //Params: auctionId
    //Purpose: To begin the auction
    //Returns: void
    public void startAuction(int auctionId){
        //create an auction                
        Auction i=new Auction(false, auctionId);
        Auction.auctionStatus=true;
        CollectionOfAuctions.collectionOfAuctions.put(auctionId,i);
    }

    //add an add customer to auction method 

    //Params: Customer
    //Purpose: To verify the payment of the highest bidding customer
    //Returns: True if payment is verified, false if not
    public Boolean verifyPayment(Customer customer, Auction auction){//Customer customer){//
        if(customer.getCustomerBalance()>=auction.getHighestBid()){
            return true;
        }
        return false;
    } 

    //Params: (Customer,bidNum)
    //Purpose: To verify the bid number of the highest bidding customer
    //Returns: True if bid number is verified, false if not
    public Boolean verifyBidNumber(Customer customer, double d){//Customer customer){//
        if(customer.getCustomerId()==d){
            return true;
        }
        return false;
    }

    //Params: n/a
    //Purpose: To get the status of the auction, if it's over or if it's in progress
    //Returns: Boolean auctionStatus
    //Can probably add if statements that don't allow customers to make bids and such if auctionStatus is false
    public Boolean getAuctionStatus(){
        return Auction.auctionStatus;
    }
     //Params: StartingBid, backgroundIn, curBid
    //Purpose: To create an item object that is going to be auctioned. Increment the itemNum variable
    //Returns: Item
    public Item createItem(String name,Double startingBidIn, String backgroundIn, Double curBid){
        Item item=new Item(name, startingBidIn,backgroundIn,curBid,itemNum);
        itemNum+=1;
        Auction.collectionOfItems.put(item.itemNum, item);
        return item;

    }

     //Params: Item item
    //Purpose: To remove an item from the collection of items hashmap
    //Returns: void
    public void removeItem(Item item){
        Auction.collectionOfItems.remove(item.itemNum);
    }

    //Params: Customer customer
    //Purpose: To add a customer to an auction
    //Returns: void
    public void addCustomer(Customer customer){
        Auction.collectionOfCustomers.put(customer.id,customer);
        Customer.inAuction=true;
        //add boolean for the customer 
        

    }
    //Params: Customer customer
    //Purpose: To remove a customer from an auction
    //Returns: void
    public void removeCustomer(Customer customer){
        Auction.collectionOfCustomers.remove(customer.id);
        Customer.inAuction=false;
    }
}
                            