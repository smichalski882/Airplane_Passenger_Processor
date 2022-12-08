package com.company;

import java.util.LinkedList;

public class AutomatedLine extends CheckInLine{

    //FIELDS
    private final int maxPerAgent = 3;
    public static LinkedList<Agent> automatedAgents;
    public static int agentsAssigned;
    private Agent agent;

    //CONSTRUCTOR

    /**
     * Create new instance of automated line
     * @param processor assigned to this line so it can process passengers
     */
    public AutomatedLine(PassengerProcessor processor) {
        super(processor);
    }

    //METHODS

    /**
     * @param agent you are assigning to this counter
     */
    @Override
    public void setAssignedAgent(Agent agent){
        //Find if the agent already is working on automated counter
        for(Agent onAuto : automatedAgents){
            if(onAuto.equals(agent)){
                System.out.println("This agent is already working the automated lines!"); //cannot set agent
                return;
            }
        }
        //This agent can be assigned
        this.agent = agent;
        agentsAssigned++;
    }

}
