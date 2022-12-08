package com.company;

/**
 * Bag class to be used for passenger luggage
 */
public class Bag implements Comparable<Bag>{

    //FIELDS
    private int weight;
    private boolean isFlagged;

    //CONSTRUCTOR

    /**
     * Create a new instance of Bag
     * @param weight int value to assign to the bag
     */
    public Bag(int weight){
        this.weight = weight;
    }

    //METHODS

    /**
     * @param weight that you want to set the bag to
     */
    public void setWeight(int weight){
        this.weight = weight;
    }

    /**
     * @return the weight of the bag
     */
    public int getWeight(){
        return this.weight;
    }

    /**
     * @return if the bag has been flagged for any kind of danger
     */
    public boolean isFlagged(){
        return this.isFlagged;
    }

    /**
     * @param otherBag to be compared to from this bag
     * @return whether or not the other instance is greater, equal, or less than this bag in weight
     */
    @Override
    public int compareTo(Bag otherBag) {
        if(this.getWeight() < otherBag.getWeight()){ //this weighs less than other bag
            return -1;
        }
        else if(this.getWeight() == otherBag.getWeight()){ //this weighs equal to other bag
            return 0;
        }
        else //this must weight more than other bag
            return 1;
    }
}
