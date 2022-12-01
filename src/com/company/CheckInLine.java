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
    public CheckInLine(PassengerProcessor processor){
        assertNotNull(processor);
        this.processor = processor;
        processingGroup = false;
    }

    //METHODS

    //Gets the next passenger
    public Passenger calculateNextPassenger(PassengerQueue passengerQueue){

        //IF PROCESSING A GROUP CURRENTLY
        if(processingGroup){
            //If there are no more members in the group to process, set processingGroup to false and return the next method again
            if(this.getGroup().getGroup().isEmpty()){
                processingGroup = false;
                this.setGroup(null);
                return calculateNextPassenger(passengerQueue);
            }

            //if a group is being processed by this check in line, take the next passenger in the group
            Passenger next = this.getCurrentPassenger().getGroup().getGroup().getFirst();
            this.getCurrentPassenger().getGroup().getGroup().removeFirst();
            return next;
        }
        //Take the next passenger from the queue
        return takeNextFromQueue(passengerQueue);
    }

    public Passenger getNext(){
        return next;
    }

    public void process(PassengerQueue passengerQueue){
        if(this.hasSupervisor()){
            processWithSupervisor(passengerQueue);
        }
        processWithAgent(passengerQueue);
    }

    public void processWithSupervisor(PassengerQueue passengerQueue){
        setNext(calculateNextPassenger(passengerQueue));
        this.getProcessor().process(this.getNext(), this.getAssignedAgent(), this.getAssignedSupervisor());
    }

    public void processWithAgent(PassengerQueue passengerQueue){
        setNext(calculateNextPassenger(passengerQueue));
        this.getProcessor().process(this.getNext(), this.getAssignedAgent());
    }

    //Takes the next passenger from the passenger queue
    public Passenger takeNextFromQueue(PassengerQueue passengerQueue){
        //Take from frequent flyers if any exist
        if(!passengerQueue.getFrequentFlyerQueue().isEmpty()){
            Passenger next = passengerQueue.getFrequentFlyerQueue().getFirst();
            passengerQueue.getFrequentFlyerQueue().removeFirst();
            return next;
        }
        //Take regular passengers next
        Passenger next = passengerQueue.getRegularFlyerQueue().getFirst();
        passengerQueue.getRegularFlyerQueue().removeFirst();
        return next;
    }

    //Set the group to this check in line


    //Set the next passenger
    public void setNext(Passenger next){
        if(next.hasGroup() && !processingGroup){
            this.setGroup(next.getGroup());
            this.processingGroup = true;
        }
        this.next = next;
    }

    public int getBaggageLimit(){
        return this.baggageLimit;
    }

    public Agent getAssignedAgent(){
        return this.assignedAgent;
    }

    public void setAssignedAgent(Agent agent){
        this.assignedAgent = agent;
    }

    public Supervisor getAssignedSupervisor(){
        return this.assignedSupervisor;
    }

    public void setAssignedSupervisor(Supervisor supervisor){
        this.assignedSupervisor = supervisor;
    }

    public Passenger getCurrentPassenger(){
        return this.currentPassenger;
    }

    public void setCurrentPassenger(Passenger passenger){
        this.currentPassenger = passenger;
    }

    public boolean hasSupervisor(){
        if(this.getAssignedSupervisor() != null){
            return true;
        }
        return false;
    }

    public boolean hasAgent(){
        if(this.getAssignedAgent() != null){
            return true;
        }
        return false;
    }

    public boolean hasPassenger(){
        if(this.getCurrentPassenger() != null){
            return true;
        }
        return false;
    }

    public boolean transferPassenger(CheckInLine counter){
        if(!counter.hasPassenger()){
            counter.setCurrentPassenger(this.getCurrentPassenger());
            this.setCurrentPassenger(null);
            return true;
        }
        return false;
    }

    public PassengerProcessor getProcessor(){
        return this.processor;
    }

    public PassengerGroup getGroup(){
        return group;
    }

    public void setGroup(PassengerGroup group){
        this.group = group;
    }

}
