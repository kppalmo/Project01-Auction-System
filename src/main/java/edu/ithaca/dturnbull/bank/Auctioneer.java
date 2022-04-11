package edu.ithaca.dturnbull.bank;

import java.util.Random;

public class Auctioneer {
    private String name;
    
    public Auctioneer(String name){
        this.name=name;
    }

    //if true, auction is in progress, if false, auction is not in progress
    public Boolean auctionStatus=false;
    

    //Param: n/a
    //Purpose: to display the current bid
    //return double
    public double displayBid(){
        Item.getCurrBid();
    }

    //Params: numCustomers(the amount of customers in the auction),Customer 
    //Purpose: To assign a random number to each customer based on the amount of customers in the auction
    //Returns: void

    public int assignBidNum(int numCustomers, Customer customer){//Customer customer){
        Random rand=new Random();
        int bidNum=rand.nextInt(numCustomers);
        customer.id=bidNum;
        return bidNum;
    }
    //make sure the id is unique each time so customers don't have repeating bidId possibly make it sequential instead

    //Params: n/a
    //Purpose: To end the auction
    //Returns: void
    public void endAuction(){
        auctionStatus=false;
    }

    //Params: Auction auction
    //Purpose: To display the item that is being auctioned
    //Returns: the item being auctioned
    public void displayItem(Item item){
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
    public Boolean verifyPayment(Customer customer){//Customer customer){//
        if(Customer.getCustomerBalance()>=Auction.getHighestBid()){
            return true;
        }
        return false;
    } 

    //Params: (Customer,bidNum)
    //Purpose: To verify the bid number of the highest bidding customer
    //Returns: True if bid number is verified, false if not
    public Boolean verifyBidNumber(Customer customer, int bidNum){//Customer customer){//
        if(customer.getBidNum==bidNum){
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