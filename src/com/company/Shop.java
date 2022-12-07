package com.company;

import java.util.HashMap;
import java.util.LinkedList;

public class Shop {

    //ENUMS

    //All purchasable items in AirVille
    public enum Merchandise{
        SUPERVISOR, AGENT, AUTOMATED_COUNTER, IN_PERSON_COUNTER
    }

    //FIELDS
    private final Integer supervisorPrice;
    private final Integer agentPrice;
    private final Integer automatedCounterPrice;
    private final Integer inPersonCounterPrice;
    private LinkedList<Merchandise> cart;
    private final HashMap<Merchandise, Integer> priceMap;

    //CONSTRUCTOR
    public Shop(){
        supervisorPrice = Integer.valueOf(1000);
        agentPrice = Integer.valueOf(1000);
        automatedCounterPrice = Integer.valueOf(500);
        inPersonCounterPrice = Integer.valueOf(300);
        cart = new LinkedList<Merchandise>();
        priceMap = makePriceMap();
    }

    //METHODS

    /**
     * @param item that you are adding to the cart
     */
    public void addToCart(Shop.Merchandise item){
        cart.add(item);
    }

    /**
     * @return the pricemap for the merchandise enums belonging to this shop
     */
    public HashMap<Merchandise, Integer> getPriceMap(){
        return priceMap;
    }

    /**
     * @return the current price of the cart based on it's contents
     */
    public int computeCartPrice(){
        Integer totalPrice = Integer.valueOf(0);    //variable to keep track of current price

        //add price of enum to the total for each in the cart
        for(Merchandise item : this.getCart()){
            totalPrice = totalPrice + this.getPriceMap().get(item);
        }
        return totalPrice.intValue();   //return the total value of the cart
    }

    /**
     * @return a hashmap mapping each item of merchandise to its corresponding price
     */
    public HashMap<Merchandise, Integer> makePriceMap(){
        HashMap<Merchandise, Integer> priceMap = new HashMap<>();
        priceMap.put(Merchandise.AGENT, this.getAgentPrice());
        priceMap.put(Merchandise.SUPERVISOR, this.getSupervisorPrice());
        priceMap.put(Merchandise.AUTOMATED_COUNTER, this.getAutomatedCounterPrice());
        priceMap.put(Merchandise.IN_PERSON_COUNTER, this.getInPersonCounterPrice());
        return priceMap;
    }

    /**
     * @return a linked list representing the cart
     */
    public LinkedList<Merchandise> getCart(){
        return this.cart;
    }

    /**
     * Empty all of the contents in the cart
     */
    public void emptyCart(){
        this.getCart().clear();
    }

    /**
     * @return the Integer value corresponding to the price of a supervisor
     */
    public Integer getSupervisorPrice(){
        return this.supervisorPrice;
    }

    /**
     * @return the Integer value corresponding to the price of an agent
     */
    public Integer getAgentPrice(){
        return this.agentPrice;
    }

    /**
     * @return the Integer value corresponding to the price of an automated counter
     */
    public Integer getAutomatedCounterPrice(){
        return this.automatedCounterPrice;
    }

    /**
     * @return the Integer value corresponding to the price of an in person counter
     */
    public Integer getInPersonCounterPrice(){
        return this.inPersonCounterPrice;
    }

}
