package edu.ithaca.dturnbull.bank;

import java.util.Stack;

public class Item {

    public Integer itemNum;
    public double startingBid;
    // public static double currBid;
    Stack<Double> bids = new Stack<>();

    public String background;
    Double curBid;
    String name;

    public Item(String name, Double startingBidIn, String backgroundIn, int itemNum) {
        this.name=name;
        this.startingBid = startingBidIn;
        this.background = backgroundIn;
        this.itemNum = itemNum;
        this.bids.push(startingBid);
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

    public int getItemNum(){
        return itemNum;
    }

    public String getItemName(){
        return name;
    }
}