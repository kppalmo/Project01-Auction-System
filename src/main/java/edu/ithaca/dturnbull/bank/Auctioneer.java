package edu.ithaca.dturnbull.bank;

import java.util.Collection;
import java.util.HashMap;

public class Auctioneer{
    public String name;
    public int auctioneerId;
    public int bidNum = 0;
    public int itemNum = 0;
    public int currentItem = 0;

    public Auctioneer (String name, int auctioneerId){
        this.name = name;
        this.auctioneerId = auctioneerId;
    }

    public void startAuction(int auctioneerId, int auctionId, String auctionName){
        //create an auction
        CollectionOfAuctions.getCollectionOfAuctions().put(auctionId, new Auction(true, auctionId, auctionName));        

    }

    public void endAuction(int auctionId){
        CollectionOfAuctions.getCollectionOfAuctions().get(auctionId).closeAuction();
        this.bidNum = 0;
        this.itemNum = 0;
        this.currentItem = 0;
    }

    public Auction getAuction(int auctionId){
        return CollectionOfAuctions.getCollectionOfAuctions().get(auctionId);
    }

    public void removeAuction(int auctioneerId, int auctionId){
        CollectionOfAuctions.getCollectionOfAuctions().remove(auctionId);

    }

    public void addCustomer(Customer customer, int auctionId){

        if (customer.getCustomerStatus().equals("green")){
            bidNum+=1;
            customer.setCustomerId(bidNum);
            CollectionOfAuctions.getCollectionOfAuctions().get(auctionId).getCollectionOfCustomers().put(customer.getCustomerId(), customer);
        }
        
        else {
            throw new IllegalArgumentException("Cannot add blacklisted customer!");
        }
    }

    public void removeCustomer(Customer customer, int auctionId){
        CollectionOfAuctions.getCollectionOfAuctions().get(auctionId).getCollectionOfCustomers().remove(customer.getCustomerId(), customer);
    }

    public double displayBid(Item item){
        return item.getCurrBid();
    }

    public void placeItem(int auctionId, String name, Double startingBidIn, String backgroundIn){
        CollectionOfAuctions.getCollectionOfAuctions().get(auctionId).getCollectionOfItems().put(itemNum, new Item(name, startingBidIn, backgroundIn, itemNum));
        itemNum+=1;
    }

    public void withdrawItem(int auctionId, int itemNum){
        CollectionOfAuctions.getCollectionOfAuctions().get(auctionId).getCollectionOfItems().remove(itemNum);
    }

    public Item displayCurrentItem(int auctionId){
        return CollectionOfAuctions.getCollectionOfAuctions().get(auctionId).getCollectionOfItems().get(currentItem);
    }

    public Item getCurrentItem(int auctionId){
        return CollectionOfAuctions.getCollectionOfAuctions().get(auctionId).getCollectionOfItems().get(currentItem);
    }

    public void nextItem(){
        currentItem+=1;
    }
     
    public Boolean verifyPayment(Customer customer, int auctionId, int itemNum){
        if(customer.getCustomerBalance() >= CollectionOfAuctions.getCollectionOfAuctions().get(auctionId).getCollectionOfItems().get(itemNum).getCurrBid()){
            return true;
        }
        return false;
    } 

    //Params: n/a
    //Purpose: To get the status of the auction, if it's over or if it's in progress
    //Returns: Boolean auctionStatus
    //Can probably add if statements that don't allow customers to make bids and such if auctionStatus is false
    public Boolean getAuctionStatus(int auctionId){
        return CollectionOfAuctions.getCollectionOfAuctions().get(auctionId).getAuctionStatus();
    }
}