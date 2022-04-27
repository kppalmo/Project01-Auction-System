package edu.ithaca.dturnbull.bank;

import java.util.Collection;

public class Customer {

    public String name;
    public Double id;
    public String status;
    public Double balance;
    public Double bidAmount;
    public static boolean inAuction;

    public Customer(String name, Double id, Double balance, String status,boolean inAuction) {
        this.name = name;
        this.id = id;
        this.balance = balance;
        // green = can bid red = on blacklist, cannot bid
        this.status = "green";
        inAuction=false;
    }

    // Getter for customer balance
    public double getCustomerBalance() {
        return balance;
    }

    public double getCustomerId(){
        return id;
    }

    // Getter for customer bid
    public double getCustomerBid() {
        return bidAmount;
    }

    // Place bid on Item / checks for status & bidAmount is available
    public void placeBid(Item obj, Double bidAmount) throws InsufficientFundsException {
        if (status == "green") {
            if (bidAmount <= balance && obj.getCurrBid() < bidAmount) {
                obj.getBids().push(bidAmount);
                balance -= bidAmount;
            }
            else{
                throw new InsufficientFundsException("Your bid cannot be lower than the current bid!");
            }
        }
    }

    // Withdraw bid from item
    public void withdrawBid(Item obj, Double bidAmount) {
        if (status == "green") {
            if (obj.getBids().size() > 1) {
                obj.getBids().pop();
                balance += bidAmount;
            }
            else{
                throw new IllegalArgumentException("Cannot withdraw any further.");
            }

        }
    }

    //Let's customer see if they're in the auction
    public boolean getInAuction(){
        return inAuction;
    }


    public void viewAllItems(int auctionId){
        Item item=Auction.collectionOfItems.get(auctionId);
        System.out.println("Items:"+item);

    }















    //public void viewItems(Auction auction){
      //  for (Integer item: Auction.collectionOfItems.keySet()) {
        //    System.out.println(item);
        //}
        //Collection<String> values= Auction.collectionOfItems.values().toString();
        //for(String value : values){
          //  System.out.println( value );
        //}
    //}

}
