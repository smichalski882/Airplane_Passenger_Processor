package com.company;

/**
 * Agent employee to process passengers
 */
public class Agent extends AbstractEmployee {


    //CONSTRUCTOR

    /**
     * Construct a new agent from the abstract employee superclass, no parameters necessary
     */
    public Agent() {
        super();
    }

    //METHODS

    /**
     * @param counter checkInLine that the agent is checking if it can move to
     * @return boolean whether the agent can be moved to the counter
     */
    public boolean canMove(CheckInLine counter) {
        //Check the instance of the input counter
        if (counter instanceof InPersonLine) {
            return canMoveInPersonCounter(counter); //call the in person line method
        }
        return canMoveAutomatedCounter(counter); //call the automated line method
    }

    /**
     * @param counter to check if the counter has an agent
     * @return true if the counter has no agent
     */
    public boolean canMoveAutomatedCounter(CheckInLine counter) {
        return !counter.hasAgent();
    }

    /**
     * @param counter to check if the counter has an agent
     * @return true if the counter has no agent
     */
    public boolean canMoveInPersonCounter(CheckInLine counter) {
        return !counter.hasAgent();
    }

    /**
     * @param counter that you want to move the agent to
     * @return boolean if the operation is successful
     */
    public boolean move(CheckInLine counter) {
        //check if the counter can be moved to
        if(canMove(counter)) {
            counter.setAssignedAgent(this); //set the counter's agent to this
            this.setAssignedCounter(counter); //set this agent's counter to counter
            return true;
        }
        return false; //Unable to move to counter
    }
}
