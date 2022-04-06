package edu.ithaca.dturnbull.bank;

public class Customer {

    public String name;
    public Double id;
    public String status;
    public Double balance;
    public Double bidAmount;

    public Customer(String name, Double id, Double balance, String status) {
        this.name = name;
        this.id = id;
        this.balance = balance;
        // green = can bid red = on blacklist, cannot bid
        this.status = "green";
    }

    // Getter for customer balance
    public double getCustomerBalance() {
        return balance;
    }

    // Getter for customer bid
    public double getCustomerBid() {
        return bidAmount;
    }

    // Place bid on Item / checks for status & bidAmount is available
    public void placeBid(Item obj, Double bidAmount) {
        if (status == "green") {
            if (bidAmount <= balance && obj.getCurrBid() < bidAmount) {
                // Item.currBid = bidAmount;
                obj.getBids().push(bidAmount);
                balance -= bidAmount;
            }
        }
    }

    // Withdraw bid from item
    public void withdrawBid(Item obj, Double bidAmount) {
        if (status == "green") {
            // Item.currBid = (bidAmount - Item.startingBid) - Item.startingBid;
            obj.getBids().pop();
            balance += bidAmount;

        }

    }

}
