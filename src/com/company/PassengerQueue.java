package com.company;

import java.util.LinkedList;

public class PassengerQueue {

    //FIELDS
    private LinkedList<Passenger> frequentFlyerQueue;
    private LinkedList<Passenger> regularFlyerQueue;
    private boolean blocked;

    //CONSTRUCTOR
    public PassengerQueue(){
        frequentFlyerQueue = new LinkedList<Passenger>();
        regularFlyerQueue = new LinkedList<Passenger>();
    }

    //METHODS
    public boolean hasPassenger(LinkedList<Passenger> queue, Passenger passenger){
        for(Passenger inQueue : queue){
            if(passenger.equals(inQueue)){
                return true;
            }
        }
        return false;
    }

    //Return frequent flyer queue
    public LinkedList<Passenger> getFrequentFlyerQueue(){
        return this.frequentFlyerQueue;
    }

    //Return regular flyer queue
    public LinkedList<Passenger> getRegularFlyerQueue(){
        return this.regularFlyerQueue;
    }

    //Add a passenger to the back of the queue they belong to, McCabe's = 4
    public boolean addPassenger(Passenger passenger){
        if(passenger instanceof RegularFlyer){
            return addRegularFlyer(passenger);
        }
        else if(passenger instanceof  FrequentFlyer) {
            return addFrequentFlyer(passenger);
        }
        else{
            System.out.println("Passenger is not specific enough, must be either a Regular or Frequent flyer");
            return false;
        }
    }

    //Add a passenger to frequent flyer queue if they don't already exist
    public boolean addFrequentFlyer(Passenger passenger){
        if(this.hasPassenger(this.getFrequentFlyerQueue(), passenger)){
            System.out.println("This passenger already exists in the queue, cannot be added twice!");
            return false;
        }
        this.getFrequentFlyerQueue().add(passenger);
        return true;
    }

    //Add a passenger to the regular flyer queue if they don't already exist
    public boolean addRegularFlyer(Passenger passenger){
        if(this.hasPassenger(this.getRegularFlyerQueue(), passenger)){
            System.out.println("This passenger already exists in the queue, cannot be added twice!");
            return false;
        }
        this.getRegularFlyerQueue().add(passenger);
        return true;
    }

    //Removes the passenger, calls the correct remove method based on the instance of passenger
    public boolean removePassenger(Passenger passenger){
        if(passenger instanceof RegularFlyer){
            return removeRegularFlyer(this.getRegularFlyerQueue(), passenger);
        }
            return removeFrequentFlyer(this.getFrequentFlyerQueue(), passenger);
    }

    //Removes specified regular flyer from queue
    public boolean removeRegularFlyer(LinkedList<Passenger> queue, Passenger passenger){
        if(this.hasPassenger(queue, passenger)){
            return queue.remove(passenger);
        }
        System.out.println("This passenger does not exist in the queue, cannot remove!");
        return false;
    }

    //remove specified passenger from specified queue
    public boolean removeFrequentFlyer(LinkedList<Passenger> queue, Passenger passenger){
        if(this.hasPassenger(queue, passenger)){
            return queue.remove(passenger);
        }
        System.out.println("This passenger does not exist in the queue, cannot remove!");
        return false;
    }

    //Return whether the queues are blocked
    public boolean isBlocked(){
        return this.blocked;
    }

    //Set whether or not the queues are blocked
    public void setBlocked(boolean blocked){
        this.blocked = blocked;
    }
}
