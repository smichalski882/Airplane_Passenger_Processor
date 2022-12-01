package com.company;

import java.util.LinkedList;

public class AutomatedLine extends CheckInLine{

    //FIELDS
    private final int maxPerAgent = 3;
    public static LinkedList<Agent> automatedAgents;
    public static int agentsAssigned;
    private Agent agent;

    //CONSTRUCTOR
    public AutomatedLine(PassengerProcessor processor) {
        super(processor);
    }

    //METHODS
    @Override
    public void setAssignedAgent(Agent agent){
        for(Agent onAuto : automatedAgents){
            if(onAuto.equals(agent)){
                System.out.println("This agent is already working the automated lines!");
            }
        }
        this.agent = agent;
        agentsAssigned++;
    }

}
