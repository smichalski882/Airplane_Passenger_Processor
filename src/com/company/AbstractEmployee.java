package com.company;

/**
 * Abstract employee class to be implemented by employees
 */
public abstract class AbstractEmployee {

    //FIELDS
    private CheckInLine assignedCounter;

    //CONSTRUCTOR
    public AbstractEmployee(){
        ;
    }

    //METHODS

    /**
     * @return the counter assigned to this employee
     */
    public CheckInLine getAssignedCounter() {
        return assignedCounter;
    }

    /**
     * @param counter you want to assign this employee to
     */
    public void setAssignedCounter(CheckInLine counter){
        this.assignedCounter = counter;
    }

}
