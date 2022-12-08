package com.company;

import java.util.LinkedList;
import static org.junit.Assert.*;

public class CheckInLine {

    //FIELDS
    private final int baggageLimit = 50;
    private Agent assignedAgent;
    private Supervisor assignedSupervisor;
    private Passenger currentPassenger;
    private PassengerProcessor processor;
    private boolean processingGroup;
    private Passenger next;
    private PassengerGroup group;

    //CONSTRUCTOR

    /**
     * Create a new instance of a check in line
     * @param processor assigned to process passengers
     */
    public CheckInLine(PassengerProcessor processor){
        assertNotNull(processor);
        this.processor = processor;
        processingGroup = false;
    }

    //METHODS

    /**
     * @param passengerQueue to draw the next passengers from
     * @return the next passenger that should be processed from the queue
     */
    public Passenger calculateNextPassenger(PassengerQueue passengerQueue){
        //If calculating new passenger
        if(processingGroup){
            if(this.getGroup().getGroup().isEmpty()){       //no more group members to process, change pointers to reflect
                processingGroup = false;
                this.setGroup(null);
                return calculateNextPassenger(passengerQueue); //call the same method again
            }

            //group is not empty, take next from the group
            Passenger next = this.getCurrentPassenger().getGroup().getGroup().getFirst();
            this.getCurrentPassenger().getGroup().getGroup().removeFirst();
            return next;
        }
        //No group, take the next from the queue
        return takeNextFromQueue(passengerQueue);
    }

    //Returns the stored next passenger
    public Passenger getNext(){
        return next;
    }

    /**
     * Process passengers based on Passenger Queue
     * @param passengerQueue to process passengers from
     */
    public void process(PassengerQueue passengerQueue){
        //Decide whether to process with agent or with both agent and supervisor
        if(this.hasSupervisor()){
            processWithSupervisor(passengerQueue);
        }
        processWithAgent(passengerQueue);
    }

    /**
     * @param passengerQueue to draw next passenger from
     */
    public void processWithSupervisor(PassengerQueue passengerQueue){
        setNext(calculateNextPassenger(passengerQueue));
        this.getProcessor().process(this.getNext(), this.getAssignedAgent(), this.getAssignedSupervisor()); //call process method with both agent and supervisor
    }

    /**
     * @param passengerQueue to draw next passenger from
     */
    public void processWithAgent(PassengerQueue passengerQueue){
        setNext(calculateNextPassenger(passengerQueue));
        this.getProcessor().process(this.getNext(), this.getAssignedAgent()); //call process method with just agent
    }

    /**
     * @param passengerQueue to draw new passengers from
     * @return the passenger that was taken from the queue
     */
    public Passenger takeNextFromQueue(PassengerQueue passengerQueue){
        //Take from frequent flyers if any exist
        if(!passengerQueue.getFrequentFlyerQueue().isEmpty()){
            Passenger next = passengerQueue.getFrequentFlyerQueue().removeFirst();
            return next;
        }
        //Take regular passengers next
        Passenger next = passengerQueue.getRegularFlyerQueue().getFirst();
        passengerQueue.getRegularFlyerQueue().removeFirst();
        return next;
    }


    /**
     * @param next passenger you are setting to be the next processed
     */
    public void setNext(Passenger next){
        if(next.hasGroup() && !processingGroup){ //if the next has a group, change pointers to reflect
            this.setGroup(next.getGroup());
            this.processingGroup = true;
        }
        this.next = next;
    }

    /**
     * @return the baggage weight limit
     */
    public int getBaggageLimit(){
        return this.baggageLimit;
    }

    /**
     * @return the agent assigned to this check in line
     */
    public Agent getAssignedAgent(){
        return this.assignedAgent;
    }

    /**
     * @param agent that you are assigning to this check in line
     */
    public void setAssignedAgent(Agent agent){
        this.assignedAgent = agent;
    }

    /**
     * @return the supervisor assigned to this check in line
     */
    public Supervisor getAssignedSupervisor(){
        return this.assignedSupervisor;
    }

    /**
     * @param supervisor that you want to set assigned to this check in line
     */
    public void setAssignedSupervisor(Supervisor supervisor){
        this.assignedSupervisor = supervisor;
    }

    /**
     * @return the current passenger at the check in line
     */
    public Passenger getCurrentPassenger(){
        return this.currentPassenger;
    }

    /**
     * @param passenger to set as the current passenger at the check in line
     */
    public void setCurrentPassenger(Passenger passenger){
        this.currentPassenger = passenger;
    }

    public boolean hasSupervisor(){
        if(this.getAssignedSupervisor() != null){
            return true;
        }
        return false;
    }

    /**
     * @return whether or not the check in line has an agent
     */
    public boolean hasAgent(){
        if(this.getAssignedAgent() != null){
            return true;
        }
        return false;
    }

    /**
     * @return whether or not this check in line has a passenger
     */
    public boolean hasPassenger(){
        if(this.getCurrentPassenger() != null){
            return true;
        }
        return false;
    }

    /**
     * @param counter you want to transfer the passenger to
     * @return boolean whether the passenger was able to be transferred
     */
    public boolean transferPassenger(CheckInLine counter){
        //Check if it is possible passenger
        if(!counter.hasPassenger()){
            //set the pointers to reflect the transfer
            counter.setCurrentPassenger(this.getCurrentPassenger());
            this.setCurrentPassenger(null);
            return true;
        }
        //Not possible to move passenger
        return false;
    }

    /**
     * @return the passenger processor for this check in line
     */
    public PassengerProcessor getProcessor(){
        return this.processor;
    }

    /**
     * @return the group being checked in by this check in line
     */
    public PassengerGroup getGroup(){
        return group;
    }

    /**
     * @param group to set the group of this check in line to
     */
    public void setGroup(PassengerGroup group){
        this.group = group;
    }

}
