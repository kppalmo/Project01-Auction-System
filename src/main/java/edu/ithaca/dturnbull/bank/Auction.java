package edu.ithaca.dturnbull.bank;

import java.util.HashMap;

public class Auction {

    private HashMap<Integer, Item> collectionOfItems;
    private HashMap<Integer, Customer> collectionOfCustomers;
    private int totalBidCount = 0;

    public void increaseBid(){
        totalBidCount++;
    }

    public void decreaseBid(){
        totalBidCount--;
    }

    public double getHighestBid(){
        for (Item bid : collectionOfItems.values()){
            for (Customer cust : collectionOfCustomers.values()){
                if (cust.getBidAmount == bid.getCurrBid()){
                    return bid.getCurrBid();
                }
            }
        }
        
    }


    
}
