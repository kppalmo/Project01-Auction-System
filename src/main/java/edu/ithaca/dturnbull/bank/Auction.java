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

    public int getHighestBid(){
        
    }


    
}
