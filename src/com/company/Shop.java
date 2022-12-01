package com.company;

import java.util.HashMap;
import java.util.LinkedList;

public class Shop {

    //ENUM
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
    public void addToCart(Shop.Merchandise item){
        cart.add(item);
    }

    public HashMap<Merchandise, Integer> getPriceMap(){
        return priceMap;
    }

    public int computeCartPrice(){
        Integer totalPrice = Integer.valueOf(0);
        for(Merchandise item : this.getCart()){
            totalPrice = totalPrice + this.getPriceMap().get(item);
        }
        return totalPrice.intValue();
    }

    public HashMap<Merchandise, Integer> makePriceMap(){
        HashMap<Merchandise, Integer> priceMap = new HashMap<>();
        priceMap.put(Merchandise.AGENT, this.getAgentPrice());
        priceMap.put(Merchandise.SUPERVISOR, this.getSupervisorPrice());
        priceMap.put(Merchandise.AUTOMATED_COUNTER, this.getAutomatedCounterPrice());
        priceMap.put(Merchandise.IN_PERSON_COUNTER, this.getInPersonCounterPrice());
        return priceMap;
    }

    public LinkedList<Merchandise> getCart(){
        return this.cart;
    }

    public void emptyCart(){
        this.getCart().clear();
    }

    public Integer getSupervisorPrice(){
        return this.supervisorPrice;
    }

    public Integer getAgentPrice(){
        return this.agentPrice;
    }

    public Integer getAutomatedCounterPrice(){
        return this.automatedCounterPrice;
    }

    public Integer getInPersonCounterPrice(){
        return this.inPersonCounterPrice;
    }

}
