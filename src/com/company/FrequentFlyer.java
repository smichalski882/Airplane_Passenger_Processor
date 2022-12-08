package com.company;

import java.util.LinkedList;

public class FrequentFlyer extends Passenger{

    //CONSTRUCTOR

    /**
     * Create a new instance of a frequent flyer
     * @param name of this passenger
     * @param luggage that this passenger is travelling with
     * @param timeDelays that increase the passenger's process time
     */
    public FrequentFlyer(String name, LinkedList<Bag> luggage, LinkedList<Passenger.TimeDelay> timeDelays){
        super(name, luggage, timeDelays);
    }
}
