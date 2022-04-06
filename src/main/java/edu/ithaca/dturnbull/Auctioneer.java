package edu.ithaca.dturnbull;

import java.util.Random;

public class Auctioneer {

    public String auctionStatus="";

    public void displayBid(){

    }

    //Params: numCustomers(the amount of customers in the auction),Customer 
    //Purpose: To assign a random number to each customer based on the amount of customers in the auction
    //Returns: void

    public void assignBidNum(int numCustomers){//Customer customer){
        //Random rand=new Random();
        //int bidNum=rand.nextInt(numCustomers);
    }
    //Params: n/a
    //Purpose: To end the auction
    //Returns: void
    public void endAuction(){
        auctionStatus="Auction is over";
    }
    //Params: Auction auction
    //Purpose: To display the item that is being auctioned
    //Returns: the item being auctioned
    public void displayItem(){//Auction auction){
        
    }

    //Params: n/a
    //Purpose: To begin the auction
    //Returns: void
    public void startAuction(){
        auctionStatus="Auction in progress";
    }

    //Params: (Customer///)
    //Purpose: To verify the payment of the highest bidding customer
    //Returns: True if payment is verified, false if not
    public Boolean verifyPayment(){//Customer customer){//
        return false;
    }

    //Params: (Customer///)
    //Purpose: To verify the bid number of the highest bidding customer
    //Returns: True if bid number is verified, false if not
    public Boolean verifyBidNumber(){//Customer customer){//
        return false;
    }

    //Params: n/a
    //Purpose: To get the status of the auction, if it's over or if it's in progress
    //Returns: String auctionStatus
    public String getAuctionStatus(){
        return auctionStatus;
    }
    
}
