package com.company;

import java.util.HashMap;

public class PassengerProcessor {

    //FIELDS
    private int processTime;
    private final int extraBagFee = 50;

    //METHODS

    //Process a passenger with an agent
    public void process(Passenger passenger, Agent agent){
        setProcessTime(calculateProcessTime(passenger));
        System.out.println("Time to process this passenger: " + this.getProcessTime());
    }

    //process a passenger with an agent and supervisor
    public void process(Passenger passenger, Agent agent, Supervisor supervisor){
        //With supervisor takes 2/3rds of regular time
        setProcessTime((calculateProcessTime(passenger)/3)*2);
        System.out.println("Time to process this passenger: " + this.getProcessTime());
    }

    public HashMap<Passenger.TimeDelay, Integer> makeDelayMap(){
        HashMap<Passenger.TimeDelay, Integer> delayMap = new HashMap<>();
        delayMap.put(Passenger.TimeDelay.DELAYED_FLIGHT, Integer.valueOf(180));
        delayMap.put(Passenger.TimeDelay.OVERWEIGHT_LUGGAGE, Integer.valueOf(50));
        delayMap.put(Passenger.TimeDelay.OVERBOOKED_FLIGHT, Integer.valueOf(180));
        return delayMap;
    }

    public int calculateProcessTime(Passenger passenger){
        Integer delayTime = Integer.valueOf(0);
        HashMap<Passenger.TimeDelay, Integer> delayMap = makeDelayMap();
        for(Passenger.TimeDelay delay : passenger.getTimeDelays()){
            delayTime = delayTime + delayMap.get(delay);
        }
        return delayTime.intValue();
    }

    public void setProcessTime(int processTime){
        this.processTime = processTime;
    }

    public int getProcessTime(){
        return processTime;
    }
}
