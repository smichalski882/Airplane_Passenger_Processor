package com.company;

import java.util.LinkedList;

public class FrequentFlyer extends Passenger{

    //CONSTRUCTOR
    public FrequentFlyer(String name, LinkedList<Bag> luggage, LinkedList<Passenger.TimeDelay> timeDelays){
        super(name, luggage, timeDelays);
    }
}
