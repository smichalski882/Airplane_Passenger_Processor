package com.company;

public class Agent extends AbstractEmployee {


    //CONSTRUCTOR
    public Agent() {
        super();
    }

    //METHODS
    public boolean canMove(CheckInLine counter) {
        if (counter instanceof InPersonLine) {
            return canMoveInPersonCounter(counter);
        }
        return canMoveAutomatedCounter(counter);
    }

    public boolean canMoveAutomatedCounter(CheckInLine counter) {
        return false;
    }

    public boolean canMoveInPersonCounter(CheckInLine counter) {
        return !counter.hasAgent();
    }

    public boolean move(CheckInLine counter) {
        return false;
    }
}
