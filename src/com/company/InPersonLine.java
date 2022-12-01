package com.company;

public class InPersonLine extends CheckInLine{

    //FIELDS


    //CONSTRUCTOR
    public InPersonLine(PassengerProcessor processor) {
        super(processor);
    }

    //METHODS
    public int getProcessTime(Passenger passenger){
        return 4;
    }
    public boolean transferAgent(CheckInLine transfer){
        if(transfer.hasAgent()){
            System.out.println("This check in line already has an agent!");
            return false;
        }
        transfer.setAssignedAgent(this.getAssignedAgent());
        this.setAssignedAgent(null);
        return true;
    }


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
