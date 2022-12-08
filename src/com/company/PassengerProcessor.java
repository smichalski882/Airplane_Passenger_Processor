package com.company;

import java.util.HashMap;

/**
 * Class to handle passenger processing
 */
public class PassengerProcessor {

    //FIELDS
    private int processTime;
    private final int extraBagFee = 50;

    //METHODS

    /**
     * Processes a passenger with only an agent at the counter
     * @param passenger
     * @param agent
     */
    public void process(Passenger passenger, Agent agent){
        setProcessTime(calculateProcessTime(passenger));
        System.out.println("Time to process this passenger: " + this.getProcessTime());
    }

    /**
     * Process a passenger with both an agent and supervisor at the counter
     * @param passenger
     * @param agent
     * @param supervisor
     */
    public void process(Passenger passenger, Agent agent, Supervisor supervisor){
        //With supervisor takes 2/3rds of regular time
        setProcessTime((calculateProcessTime(passenger)/3)*2);
        System.out.println("Time to process this passenger: " + this.getProcessTime());
    }

    /**
     * Create a map to get the delay times
     * @return a hash map for each time delay enum to it's delay time Integer
     */
    public HashMap<Passenger.TimeDelay, Integer> makeDelayMap(){
        HashMap<Passenger.TimeDelay, Integer> delayMap = new HashMap<>();
        delayMap.put(Passenger.TimeDelay.DELAYED_FLIGHT, Integer.valueOf(180));
        delayMap.put(Passenger.TimeDelay.OVERWEIGHT_LUGGAGE, Integer.valueOf(50));
        delayMap.put(Passenger.TimeDelay.OVERBOOKED_FLIGHT, Integer.valueOf(180));
        return delayMap;
    }

    /**
     * @param passenger to calculate the process time of
     * @return the int value of the process time of the passenger
     */
    public int calculateProcessTime(Passenger passenger){
        Integer delayTime = Integer.valueOf(0);     //variable to store the process time
        HashMap<Passenger.TimeDelay, Integer> delayMap = makeDelayMap();       //Create the map of delay enums to their delay times

        //Increment the delayTime variable for each time delay the passenger has
        for(Passenger.TimeDelay delay : passenger.getTimeDelays()){
            delayTime = delayTime + delayMap.get(delay);
        }
        return delayTime.intValue();
    }

    /**
     * @param processTime that you are setting to be this processor's process time
     */
    public void setProcessTime(int processTime){
        this.processTime = processTime;
    }

    /**
     * @return the process time of this passenger processor
     */
    public int getProcessTime(){
        return processTime;
    }
}
