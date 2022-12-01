package com.company;

public class Supervisor extends AbstractEmployee{

    //CONSTRUCTOR
    public Supervisor(){
        super();
    }

    //METHODS
    public boolean canMove(CheckInLine counter){
        if(counter instanceof InPersonLine){
            return canMoveInPersonCounter(counter);
        }
        return canMoveAutomatedCounter(counter);
    }

    public boolean canMoveInPersonCounter(CheckInLine counter){
        return !counter.hasSupervisor();
    }

    public boolean canMoveAutomatedCounter(CheckInLine counter){
        return !counter.hasSupervisor();
    }

    public boolean move(CheckInLine counter){
        if(canMove(counter)) {
            counter.setAssignedSupervisor(this);
            this.setAssignedCounter(counter);
            return true;
        }
        return false;
    }
}
