package edu.ithaca.dturnbull.bank;

public class Item {

    private double startingBid;
    private double currBid;
    private String background;

    public Item(int startingBidIn, String backgroundIn){
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
