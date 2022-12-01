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
        return false;
    }

    public boolean move(CheckInLine counter){
        return false;
    }
}
