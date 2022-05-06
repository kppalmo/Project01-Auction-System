package edu.ithaca.dturnbull.bank;

import java.util.ArrayList;
import java.util.Stack;

public class Customer {

    public String name;
    public int id;
    public String status;
    public Double balance;
    public Double bidAmount;
    public ArrayList<Item> ItemsWon;
    public Stack<Double> bidHistory;

    // public static boolean inAuction;
    // static String items;
    // static ArrayList<String> itemsInAuction;

    public Customer(String name, int id, Double balance, String status) {
        this.name = name;
        this.id = id;
        this.balance = balance;
        // green = can bid red = on blacklist, cannot bid
        this.status = status;
        this.ItemsWon = new ArrayList<>();
        this.bidHistory = new Stack<>();
    }

    // Getter for customer balance
    public double getCustomerBalance() {
        return balance;
    }

    public Integer getCustomerId() {
        return id;
    }

    public Integer setCustomerId(int bidNum) {
        return this.id = bidNum;
    }

    public void setCustomerStatus(String newStatus) {
        this.status = newStatus;
    }

    public String getCustomerName(){
        return name;
    }

    // Getter for customer bid
    public double getCustomerBid() {
        return bidHistory.peek();
    }

    public String getCustomerStatus() {
        return this.status;
    }

    public ArrayList<Item> getItemsWon(){
        return ItemsWon;
    }

    public double getBalance(){
        return balance;
    }

    // Place bid on Item / checks for status & bidAmount is available
    public void placeBid(Item obj, Double bidAmount, int auctionId, int bidNum) throws InsufficientFundsException {
        if (bidAmount >= balance){
            CollectionOfAuctions.getCollectionOfAuctions().get(auctionId).addToBlacklist(bidNum);
        }
        
        if (status == "green") {
            if (obj.getCurrBid() < bidAmount) {
                this.bidHistory.push(bidAmount);
                obj.getBids().push(bidAmount);
                balance -= bidAmount;
            } else {
                throw new InsufficientFundsException("Your bid cannot be lower than the current bid!");
            }
        }
    }

    // Withdraw bid from item
    public void withdrawBid(Item obj) {

        if (status == "green") {
            if (obj.getBids().size() > 1) {
                bidAmount = this.bidHistory.peek();
                obj.getBids().pop();
                this.bidHistory.pop();
                balance += bidAmount;
            } else {
                throw new IllegalArgumentException("Cannot withdraw any further.");
            }

        }
    }

    // Let's customer see if they're in the auction
    // public boolean getInAuction() {
    //     return inAuction;
    // }

    // Params: auctionID
    // Purpose: Let's customer see all the items in an auction based on it's id
    // Returns: n/a
    public void viewAllItems(int auctionId) {
        // System.out.println(collectionOfItems.get(auctionId).name+collectionOfItems.get(auctionId).startingBid+collectionOfItems.get(auctionId).background+collectionOfItems.get(auctionId).curBid+collectionOfItems.get(auctionId).itemNum);

        // System.out.println(itemsInAuction.get(auctionId));

    }

}

