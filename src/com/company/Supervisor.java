package com.company;

public class Supervisor extends AbstractEmployee{

    //CONSTRUCTOR
    public Supervisor(){
        super();
    }

    //METHODS

    /**
     * @param counter that you want to check if this supervisor can move to
     * @return boolean if you can move to the coutner
     */
    public boolean canMove(CheckInLine counter){

        //call the can move method depending on the instance of the counter
        if(counter instanceof InPersonLine){
            return canMoveInPersonCounter(counter);
        }
        return canMoveAutomatedCounter(counter);
    }

    /**
     * @param counter
     * @return whether or not the in person counter can be moved to by a supervisor
     */
    public boolean canMoveInPersonCounter(CheckInLine counter){
        return !counter.hasSupervisor();
    }

    /**
     * @param counter
     * @return whether or not the automated counter can be moved to by a supervisor
     */
    public boolean canMoveAutomatedCounter(CheckInLine counter){
        return !counter.hasSupervisor();
    }

    /**
     * @param counter that you are moving this instance of the supervisor to
     * @return boolean if the move was successful
     */
    public boolean move(CheckInLine counter){

        //Only move the supervisor if it can be moved to the counter
        if(canMove(counter)) {
            counter.setAssignedSupervisor(this);
            this.setAssignedCounter(counter);
            return true;
        }
        return false;
    }
}
