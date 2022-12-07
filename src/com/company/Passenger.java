package com.company;

import java.util.LinkedList;

public class Passenger {

    //ENUMS

    //Time delay enum, each time delay increases the processing time of the passenger
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

    /**
     * @param luggage to be checked for overweight bags
     * @return boolean if the luggage has an overweight bag
     */
    public boolean hasOverWeight(LinkedList<Bag> luggage){
        //Check weight of all bags against baggageLimit variable
        for(Bag bag : luggage){
            if(bag.getWeight() > this.getBaggageLimit())
                return true; //a bag is overweight
        }
        //No overweight bag found
        return false;
    }

    /**
     * @return the luggage belonging to an instance of a passenger
     */
    public LinkedList<Bag> getLuggage(){
        return this.luggage;
    }

    /**
     * @return the string name of the passenger
     */
    public String getName(){
        return this.name;
    }

    /**
     * @return whether or not the passenger is in a group
     */
    public boolean hasGroup(){
        return inGroup;
    }

    /**
     * @param inGroup boolean to set whether the passenger belongs to a group
     */
    public void setInGroup(Boolean inGroup){
        this.inGroup = inGroup;
    }

    /**
     * @param group that you want to assign the passenger to
     */
    public void setGroup(PassengerGroup group){
        this.group = group;
    }

    /**
     * @return the group that the passenger belongs to
     */
    public PassengerGroup getGroup(){
        return this.group;
    }

}
