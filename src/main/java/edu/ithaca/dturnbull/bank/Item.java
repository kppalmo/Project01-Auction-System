package edu.ithaca.dturnbull.bank;

public class Item {

    public static double startingBid;
    public static double currBid;
    public String background;

    public Item(Double startingBidIn, String backgroundIn, Double curBid){
        this.startingBid = startingBidIn;
        this.background = backgroundIn;
    }

    public double getStartingBid(){
        return startingBid;
    }

    public double getCurrBid(){
        return currBid;
    }



}
