package com.company.Tests;
import com.company.Agent;
import com.company.InPersonLine;
import com.company.PassengerProcessor;
import com.company.Supervisor;
import org.junit.Test;

import static org.junit.Assert.*;

//Tests both the Agent and the Supervisor classes
public class EmployeeTest {
    Agent agent = new Agent();
    Agent agent2 = new Agent();
    Supervisor supervisor = new Supervisor();
    Supervisor supervisor2 = new Supervisor();
    InPersonLine line1 = new InPersonLine(new PassengerProcessor());
    InPersonLine line2 = new InPersonLine(new PassengerProcessor());
    InPersonLine line3 = new InPersonLine(new PassengerProcessor());

    //TESTS MOVE AND CANMOVE FROM EMPLOYEES
    @Test
    public void testMove(){
        line1.setAssignedAgent(agent);

        //Assert that agent 2 cannot move to line1
        assertFalse(agent2.move(line1));

        //Assert that agent 2 can move to line 2
        assertTrue(agent2.move(line2));

        //Assert that line2 has agent2
        assertTrue(line2.getAssignedAgent().equals(agent2));

        //Assert that this agent's counter is line2
        assertTrue(agent2.getAssignedCounter().equals(line2));

        line1.setAssignedSupervisor(supervisor);

        //Assert that supervisor2 cannot move to line1
        assertFalse(supervisor2.move(line1));

        //Assert that supervisor2 can move to line2
        assertTrue(supervisor2.move(line2));

        //Assert that line2 has supervisor2
        assertTrue(line2.getAssignedSupervisor().equals(supervisor2));

        //Assert that supervisor2's counter is line2
        assertTrue(supervisor2.getAssignedCounter().equals(line2));
    }
}
