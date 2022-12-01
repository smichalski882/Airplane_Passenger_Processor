package com.company;

public abstract class AbstractEmployee {

    //FIELDS
    private CheckInLine assignedCounter;

    //CONSTRUCTOR
    public AbstractEmployee(){
        ;
    }

    //METHODS
    public CheckInLine getAssignedCounter() {
        return assignedCounter;
    }

    public void setAssignedCounter(CheckInLine counter){
        this.assignedCounter = counter;
    }

}
