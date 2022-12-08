package com.company;

import java.util.LinkedList;

public class PassengerGroup {

    //FIELDS
    private LinkedList<Passenger> group;
    private CheckInLine currentCounter;

    //CONSTRUCTOR

    /**
     * Create a new instance of passenger group, no parameters needed
     */
    public PassengerGroup(){
        this.group = new LinkedList<Passenger>();
    }

    //METHODS

    public CheckInLine getCurrentCounter(){
        return currentCounter;
    }

    public void setCurrentCounter(CheckInLine currentCounter) {
        this.currentCounter = currentCounter;
    }

    /**
     * @param passenger to be added to this passenger group
     * @return boolean if the passenger is successfully added
     */
    public boolean addPassenger(Passenger passenger){

        //Check to see if passenger already exists in the group
        if(hasPassenger(passenger)){
            System.out.println("This passenger already exists in the group!");
            return false;
        }

        passenger.setGroup(this); //Add this group to the passenger
        this.group.add(passenger); //Add this passenger to the group
        passenger.setInGroup(true); //Passenger is inGroup
        return true;
    }

    public LinkedList<Passenger> getGroup(){
        return this.group;
    }

    /**
     * @param passenger to be checked
     * @return boolean if this group already has the passenger
     */
    public boolean hasPassenger(Passenger passenger){

        //For each passenger in the group check if it exists
        for(Passenger inGroup : this.getGroup()){
            if(passenger.equals(inGroup)){
                return true;
            }
        }
        return false; //Passenger does not exist in group already
    }

    /**
     * @param toBeRemoved passenger to be removed fromm the group
     * @return boolean if the passenger was removed
     */
    public boolean removePassenger(Passenger toBeRemoved){
        if(hasPassenger(toBeRemoved)){ //Ensure passenger exists in group
            toBeRemoved.setGroup(null);
            return this.getGroup().remove(toBeRemoved);
        }
        return false; //Passenger does not exist in group, cannot be removed
    }

}
