package com.company;

public class Bag implements Comparable<Bag>{

    //FIELDS
    private int weight;
    private boolean isFlagged;

    //CONSTRUCTOR
    public Bag(int weight){
        this.weight = weight;
    }

    //METHODS
    public void setWeight(int weight){
        this.weight = weight;
    }

    public int getWeight(){
        return this.weight;
    }

    public boolean isFlagged(){
        return this.isFlagged;
    }

    @Override
    public int compareTo(Bag otherBag) {
        if(this.getWeight() < otherBag.getWeight()){
            return -1;
        }
        else if(this.getWeight() == otherBag.getWeight()){
            return 0;
        }
        else
            return 1;
    }
}
