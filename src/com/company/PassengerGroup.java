package com.company;

import java.util.LinkedList;

public class PassengerGroup {

    //FIELDS
    private LinkedList<Passenger> group;
    private CheckInLine currentCounter;

    //CONSTRUCTOR
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

    //Add a passenger to this passenger group
    public boolean addPassenger(Passenger passenger){

        //Check to see if passenger already exists in the group
        if(hasPassenger(passenger)){
            System.out.println("This passenger already exists in the group!");
            return false;
        }

        //Set the passenger's group to this, add the passenger to the group, set the passenger's setInGroup to be true, and return true
        passenger.setGroup(this);
        this.group.add(passenger);
        passenger.setInGroup(true);
        return true;
    }

    public LinkedList<Passenger> getGroup(){
        return this.group;
    }

    //Check to see if passenger already exists in the group
    public boolean hasPassenger(Passenger passenger){

        //For each passenger in the group check if it exists
        for(Passenger inGroup : this.getGroup()){
            if(passenger.equals(inGroup)){
                return true;
            }
        }
        return false;
    }

    //Removes a passenger if it exists in the list
    public boolean removePassenger(Passenger toBeRemoved){
        if(hasPassenger(toBeRemoved)){
            toBeRemoved.setGroup(null);
            return this.getGroup().remove(toBeRemoved);
        }
        return false;
    }

}
