package edu.ithaca.dturnbull.bank;

import java.util.HashMap;

public class CollectionOfAuctions extends Auction {
    public CollectionOfAuctions(boolean auctionStatus, int auctionId) {
        super(auctionStatus, auctionId);
        //TODO Auto-generated constructor stub
    }

    //use the auction id and auction to store different auctions
    static HashMap<Integer, Auction> collectionOfAuctions=new HashMap<Integer,Auction>();

}
