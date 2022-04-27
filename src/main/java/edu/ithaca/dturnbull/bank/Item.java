package edu.ithaca.dturnbull.bank;

import java.util.Stack;

public class Item {

    public static Integer itemNum;
    public double startingBid;
    // public static double currBid;
    Stack<Double> bids = new Stack<>();

    public String background;

    public Item(String name,Double startingBidIn, String backgroundIn, Double curBid,int itemNum) {
        this.startingBid = startingBidIn;
        this.background = backgroundIn;
        bids.push(startingBid);
    }

    public double getStartingBid() {
        return startingBid;
    }

    public Stack<Double> getBids() {
        return bids;
    }

    public double getCurrBid() {
        return bids.peek();
    }

}
