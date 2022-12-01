package com.company.Tests;

import com.company.Bag;
import com.company.Passenger;
import com.company.PassengerGroup;
import org.junit.Test;
import java.util.*;
import static org.junit.Assert.*;

public class PassengerGroupTest {

    PassengerGroup group = new PassengerGroup();

    @Test
    public void testAddPassenger(){

        Passenger passenger1 = new Passenger("John", null, null);
        group.addPassenger(passenger1);

        Passenger passenger2 = new Passenger(null, null, null);

        //passenger was added successfully
        assertFalse(group.getGroup().isEmpty());

        //trying to add the same passenger to the group twice
        assertFalse(group.addPassenger(passenger1));
    }

    @Test
    public void testRemovePassenger(){
        Passenger passenger1 = new Passenger("John", null, null);
        group.addPassenger(passenger1);

        //Passenger is added to list, is not empty
        assertFalse(group.getGroup().isEmpty());

        //Remove passenger, assert group is now empty
        group.removePassenger(passenger1);
        assertTrue(group.getGroup().isEmpty());

    }

    @Test
    public void testHasPassenger(){
        Passenger passenger1 = new Passenger("John", null, null);
        group.addPassenger(passenger1);
        //Check if the passenger can be found in the group
        assertTrue(group.hasPassenger(passenger1));

        //Create new passenger not in list, assert he is not in the list
        Passenger passenger2 = new Passenger("John", null, null);
        assertFalse(group.hasPassenger(passenger2));
    }
}
