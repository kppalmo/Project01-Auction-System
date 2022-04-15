package edu.ithaca.dturnbull.bank;

import java.util.Random;

public class Auctioneer {
    private String name;
    static double bidNum=0.0;
    public Auctioneer(String name){
        this.name=name;
    }

    //if true, auction is in progress, if false, auction is not in progress
    public Boolean auctionStatus=false;
    

    //Param: n/a
    //Purpose: to display the current bid
    //return double
    public double displayBid(Item item){
        return item.getCurrBid();
    }

    //Params: numCustomers(the amount of customers in the auction),Customer 
    //Purpose: To assign a random number to each customer based on the amount of customers in the auction
    //Returns: void

    public double assignBidNum(Customer customer){//Customer customer){
        bidNum+=1;
        customer.id=bidNum;
        return bidNum;
    }
    //make sure the id is unique each time so customers don't have repeating bidId possibly make it sequential instead

    //Params: n/a
    //Purpose: To end the auction
    //Returns: void
    public void endAuction(){
        auctionStatus=false;
        bidNum=0.0;
    }

    //Params: Auction auction
    //Purpose: To display the item that is being auctioned
    //Returns: the item being auctioned
    public Item displayItem(Item item){
        return item;
        
    }

    //Params: n/a
    //Purpose: To begin the auction
    //Returns: void
    public void startAuction(){
        auctionStatus=true;
    }

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
        return auctionStatus;
    }
    
}
