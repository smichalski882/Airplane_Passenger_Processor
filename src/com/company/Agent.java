package com.company;

public class Agent extends AbstractEmployee {


    //CONSTRUCTOR
    public Agent() {
        super();
    }

    //METHODS

    //Returns if you can move to a check in line counter
    public boolean canMove(CheckInLine counter) {
        if (counter instanceof InPersonLine) {
            return canMoveInPersonCounter(counter);
        }
        return canMoveAutomatedCounter(counter);
    }

    //Checks if you can move to the input automated counter
    public boolean canMoveAutomatedCounter(CheckInLine counter) {
        return !counter.hasAgent();
    }

    //Checks if you can move to the input in person counter
    public boolean canMoveInPersonCounter(CheckInLine counter) {
        return !counter.hasAgent();
    }

    //Move agent to specified checkInLine, true if successful, false if unsuccessful
    public boolean move(CheckInLine counter) {
        if(canMove(counter)) {
            counter.setAssignedAgent(this);
            this.setAssignedCounter(counter);
            return true;
        }
        return false;
    }
}
