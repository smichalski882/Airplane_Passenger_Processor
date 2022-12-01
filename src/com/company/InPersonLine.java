package com.company;

public class InPersonLine extends CheckInLine{

    //FIELDS


    //CONSTRUCTOR
    public InPersonLine(PassengerProcessor processor) {
        super(processor);
    }

    //METHODS

    //Transfer agent to a different counter if possible
    public boolean transferAgent(CheckInLine transfer){
        if(transfer.hasAgent()){
            System.out.println("This check in line already has an agent!");
            return false;
        }
        transfer.setAssignedAgent(this.getAssignedAgent());
        this.setAssignedAgent(null);
        return true;
    }

    //Transfers supervisor to a different counter if possible
    public boolean transferSupervisor(CheckInLine transfer){
        if(transfer.hasSupervisor()){
            System.out.println("This check in line already has a supervisor!");
            return false;
        }
        transfer.setAssignedSupervisor(this.getAssignedSupervisor());
        this.setAssignedSupervisor(null);
        return true;
    }
}
