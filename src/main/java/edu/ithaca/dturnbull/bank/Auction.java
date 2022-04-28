package edu.ithaca.dturnbull.bank;

import java.util.HashMap;
import java.util.Map;

public class Auction {


 //if true, auction is in progress, if false, auction is not in progress
    static boolean auctionStatus;
    static HashMap<Integer, Item> collectionOfItems;
    static HashMap<Double, Customer> collectionOfCustomers;
    private int totalBidCount = 0;
    static int auctionId;
    
    public Auction(boolean auctionStatus,int auctionId){
        Auction.auctionStatus=auctionStatus;
        Auction.auctionId=auctionId;
        collectionOfItems=new HashMap<Integer,Item>();
        collectionOfCustomers=new HashMap<Double, Customer>();
    }

    public void increaseBid() {
        totalBidCount++;
    }

    public void decreaseBid() {
        totalBidCount--;
    }

    public double getHighestBid() {
        for (Item bid : collectionOfItems.values()) {
            for (Customer cust : collectionOfCustomers.values()) {
                if (cust.getCustomerBid() == bid.getCurrBid()) {
                    return bid.getCurrBid();
                }
            }
        }
        return totalBidCount;

    }


    public void addToBlacklist(Customer cust){
            if( cust.getCustomerBid() > cust.getCustomerBalance()){
                blackList.put(1, cust);
                cust.status = "red";
            }
    
    }
    public String checkBlackList(){
        for(Customer cust : blackList.values()){
            return cust.name;
        }
        return null;
    }



}
