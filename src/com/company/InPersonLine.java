package com.company;

public class InPersonLine extends CheckInLine{

    //FIELDS


    //CONSTRUCTOR
    public InPersonLine(PassengerProcessor processor) {
        super(processor);
    }

    //METHODS

    /**
     * @param transfer - the counter you want to transfer the agent to
     * @return boolean if the transfer is successful
     */
    public boolean transferAgent(CheckInLine transfer){
        //Check if transfer has agent already
        if(transfer.hasAgent()){
            System.out.println("This check in line already has an agent!");
            return false;
        }
        //Transfer does not have agent, set appropriate pointers to transfer
        transfer.setAssignedAgent(this.getAssignedAgent());
        this.setAssignedAgent(null);
        return true;
    }

    /**
     * @param transfer - the counter you want to transfer the supervisor to
     * @return boolean if the transfer is successful
     */
    public boolean transferSupervisor(CheckInLine transfer){
        //Check if transfer has supervisor already
        if(transfer.hasSupervisor()){
            System.out.println("This check in line already has a supervisor!");
            return false;
        }
        //Transfer does not have supervisor, set appropriate pointers to transfer
        transfer.setAssignedSupervisor(this.getAssignedSupervisor());
        this.setAssignedSupervisor(null);
        return true;
    }
}
