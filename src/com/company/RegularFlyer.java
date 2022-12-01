package com.company;

import sun.awt.image.ImageWatched;

import java.util.LinkedList;

public class RegularFlyer extends Passenger{

    //CONSTRUCTOR
    public RegularFlyer(String name, LinkedList<Bag> luggage, LinkedList<Passenger.TimeDelay> timeDelays){
        super(name, luggage, timeDelays);
    }
}
