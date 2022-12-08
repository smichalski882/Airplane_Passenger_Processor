package com.company;

import java.util.LinkedList;

/**
 * Class to hold passengers waiting to be processed
 */
public class PassengerQueue {

    //FIELDS
    private LinkedList<Passenger> frequentFlyerQueue;
    private LinkedList<Passenger> regularFlyerQueue;
    private boolean blocked;

    //CONSTRUCTOR

    /**
     * Create a new instance of passenger queue
     * Automatically assigns linked lists for frequent flyer and regular flyer queues, no parameters necessary
     */
    public PassengerQueue(){
        frequentFlyerQueue = new LinkedList<Passenger>();
        regularFlyerQueue = new LinkedList<Passenger>();
    }

    //METHODS

    /**
     * @param queue to check for a specified passenger
     * @param passenger that you are checking to see the existence of in the queue
     * @return whether or not the passenger is in the queue
     */
    public boolean hasPassenger(LinkedList<Passenger> queue, Passenger passenger){

        //Check if the passenger matches any in the queue
        for(Passenger inQueue : queue){
            if(passenger.equals(inQueue)){
                return true; //the queue already has the passenger
            }
        }
        return false; //the queue does not currently have the passenger
    }

    /**
     * @return the linked list representing the frequent flyer queue
     */
    public LinkedList<Passenger> getFrequentFlyerQueue(){
        return this.frequentFlyerQueue;
    }

    /**
     * @return the linked list representing the regular flyer queue
     */
    public LinkedList<Passenger> getRegularFlyerQueue(){
        return this.regularFlyerQueue;
    }

    /**
     * McCabes = 4
     * @param passenger to be added to the queue
     * @return boolean if the passenger is successfully added
     */
    public boolean addPassenger(Passenger passenger){

        //Return the corresponding add method to the instance of passenger passed through
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

    /**
     * @param passenger that you want to add to the frequent flyer queue
     * @return boolean of whether or not the passenger is successfully added
     */
    public boolean addFrequentFlyer(Passenger passenger){

        //Only add passenger if they don't already exist in the queue
        if(this.hasPassenger(this.getFrequentFlyerQueue(), passenger)){
            System.out.println("This passenger already exists in the queue, cannot be added twice!");
            return false;
        }
        this.getFrequentFlyerQueue().add(passenger);
        return true;
    }

    /**
     * @param passenger that you want to add to the regular flyer queue
     * @return boolean of whether or not the passenger is successfully added
     */
    public boolean addRegularFlyer(Passenger passenger){

        //Only add passenger if they don't already exist in the queue
        if(this.hasPassenger(this.getRegularFlyerQueue(), passenger)){
            System.out.println("This passenger already exists in the queue, cannot be added twice!");
            return false;
        }
        this.getRegularFlyerQueue().add(passenger);
        return true;
    }

    /**
     * @param passenger you want to remove from the queue
     * @return boolean if the passenger is successfully removed
     */
    public boolean removePassenger(Passenger passenger){

        //Call the remove method based on the instance of passenger being passed through
        if(passenger instanceof RegularFlyer){
            return removeRegularFlyer(this.getRegularFlyerQueue(), passenger);
        }
            return removeFrequentFlyer(this.getFrequentFlyerQueue(), passenger);
    }

    /**
     * @param queue that you want to remove the passenger from (regular flyer)
     * @param passenger that you want to remove from the queue
     * @return boolean if removing the passenger is successful
     */
    public boolean removeRegularFlyer(LinkedList<Passenger> queue, Passenger passenger){

        //Can only remove regular flyer from queue if they exist in the queue
        if(this.hasPassenger(queue, passenger)){
            return queue.remove(passenger);
        }
        System.out.println("This passenger does not exist in the queue, cannot remove!");
        return false;
    }

    /**
     * @param queue that you want to remove the passenger from (frequent flyer)
     * @param passenger that you want to remove from the queue
     * @return boolean if removing the passenger is successful
     */
    public boolean removeFrequentFlyer(LinkedList<Passenger> queue, Passenger passenger){

        //Can only remove this passenger if they exist in the queue
        if(this.hasPassenger(queue, passenger)){
            return queue.remove(passenger);
        }
        System.out.println("This passenger does not exist in the queue, cannot remove!");
        return false;
    }

    /**
     * @return boolean if the queues are being blocked by something
     */
    public boolean isBlocked(){
        return this.blocked;
    }

    /**
     * @param blocked boolean value you want to set the block status of the queue to
     */
    public void setBlocked(boolean blocked){
        this.blocked = blocked;
    }
}
