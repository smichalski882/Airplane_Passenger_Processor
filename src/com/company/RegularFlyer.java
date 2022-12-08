package com.company;

import sun.awt.image.ImageWatched;

import java.util.LinkedList;

public class RegularFlyer extends Passenger{

    //CONSTRUCTOR

    /**
     * Create a new instance of regular flyer
     * @param name of this passenger
     * @param luggage belonging to this passenger
     * @param timeDelays that increase the processing time of this passenger
     */
    public RegularFlyer(String name, LinkedList<Bag> luggage, LinkedList<Passenger.TimeDelay> timeDelays){
        super(name, luggage, timeDelays);
    }
}
