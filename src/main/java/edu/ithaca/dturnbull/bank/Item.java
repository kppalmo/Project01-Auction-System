package edu.ithaca.dturnbull.bank;

import java.util.Stack;

public class Item {

    public double startingBid;
    // public static double currBid;
    Stack<Double> bids = new Stack<>();

    public String background;

    public Item(Double startingBidIn, String backgroundIn, Double curBid) {
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
