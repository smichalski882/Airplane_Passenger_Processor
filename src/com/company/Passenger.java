package com.company;

import java.util.LinkedList;

public class Passenger {

    //ENUM
    public enum TimeDelay{
        DELAYED_FLIGHT, OVERBOOKED_FLIGHT, OVERWEIGHT_LUGGAGE
    }

    //FIELDS
    private String name;
    private LinkedList<Bag> luggage;
    private LinkedList<Passenger.TimeDelay> timeDelays;
    private boolean inGroup;
    private PassengerGroup group;
    private final int baggageLimit;

    //CONSTRUCTOR
    public Passenger(String name, LinkedList<Bag> luggage, LinkedList<Passenger.TimeDelay> timeDelays){
        this.name = name;
        this.luggage = luggage;
        baggageLimit = 50;
        this.timeDelays = timeDelays;
        if(this.getTimeDelays() == null){
            this.timeDelays = new LinkedList<>();
        }
        //Add overweight enum if they have an overweight bag
        if(luggage != null) {
            addOverweightTagIfNeeded();
        }

    }


    //METHODS

    //Adds overweight tag in the constructor
    public void addOverweightTagIfNeeded(){
        if(this.hasOverWeight(this.getLuggage())) {
            this.getTimeDelays().add(TimeDelay.OVERWEIGHT_LUGGAGE);
        }
    }


    public LinkedList<Passenger.TimeDelay> getTimeDelays(){
        return this.timeDelays;
    }

    public int getBaggageLimit(){
        return this.baggageLimit;
    }

    //Returns whether this passenger has an overweight bag in their luggage
    public boolean hasOverWeight(LinkedList<Bag> luggage){
        for(Bag bag : luggage){
            if(bag.getWeight() > this.getBaggageLimit())
                return true;
        }
        return false;
    }

    public LinkedList<Bag> getLuggage(){
        return this.luggage;
    }

    public String getName(){
        return this.name;
    }

    public boolean hasGroup(){
        return inGroup;
    }

    public void setInGroup(Boolean inGroup){
        this.inGroup = inGroup;
    }

    public void setGroup(PassengerGroup group){
        this.group = group;
    }

    public PassengerGroup getGroup(){
        return this.group;
    }

}
