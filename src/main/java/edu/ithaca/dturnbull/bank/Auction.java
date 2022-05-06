package edu.ithaca.dturnbull.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Auction {

    // if true, auction is in progress, if false, auction is not in progress
    public boolean auctionStatus;
    public int totalBidCount = 0;
    public int auctionId;
    public String auctionName;
    public HashMap<Integer, Item> collectionOfItems;
    public HashMap<Integer, Customer> collectionOfCustomers;
    public HashMap<Integer, Customer> blackList;

    public Auction(boolean auctionStatus, int auctionId, String auctionName) {
        this.auctionStatus = auctionStatus;
        this.auctionId = auctionId;
        this.auctionName = auctionName;
        this.collectionOfItems = new HashMap<>();
        this.collectionOfCustomers = new HashMap<>();
        this.blackList = new HashMap<>();
    }

    public void increaseBid() {
        totalBidCount++;
    }

    public void decreaseBid() {
        totalBidCount--;
    }

    public Customer getHighestBidder(int itemNum) {
        for (Customer customer : collectionOfCustomers.values()) {
            if (customer.getCustomerBid() == collectionOfItems.get(itemNum).getCurrBid()) {
                return customer;
            }
        }
        return null;
    }

    public void addToBlacklist(int bidNum) {
        Customer customer = collectionOfCustomers.get(bidNum);
        if (customer.getCustomerBid() > customer.getCustomerBalance()) {
            customer.setCustomerStatus("red");
            blackList.put(customer.getCustomerId(), customer);
        }

    }

    public boolean checkBlackList(Customer customer) {
        if (blackList.containsKey(customer.getCustomerId())) {
            return true;
        } else {
            return false;
        }
    }

    public void payBlacklistFine(Customer customer, double amount) {
        if (customer.getBalance() >= amount) {
            customer.setCustomerStatus("green");
            blackList.remove(customer.getCustomerId());
        }
    }

    public int getAuctionId() {
        return this.auctionId;
    }

    public boolean getAuctionStatus() {
        return this.auctionStatus;
    }

    public String getAuctionName() {
        return this.auctionName;
    }

    public HashMap<Integer, Customer> getBlacklist() {
        return blackList;
    }

    public void openAuction() {
        this.auctionStatus = true;
    }

    public void closeAuction() {
        this.auctionStatus = false;
    }

    public HashMap<Integer, Item> getCollectionOfItems() {
        return this.collectionOfItems;
    }

    public HashMap<Integer, Customer> getCollectionOfCustomers() {
        return this.collectionOfCustomers;
    }

}
