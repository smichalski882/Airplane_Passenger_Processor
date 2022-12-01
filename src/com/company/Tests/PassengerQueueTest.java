package com.company.Tests;

import com.company.FrequentFlyer;
import com.company.Passenger;
import com.company.PassengerQueue;
import com.company.RegularFlyer;
import org.junit.Test;
import static org.junit.Assert.*;

public class PassengerQueueTest {

    PassengerQueue queue = new PassengerQueue();

    @Test
    public void testAdd(){
        FrequentFlyer frequentFlyer1 = new FrequentFlyer("John", null, null);
        RegularFlyer regularFlyer1 = new RegularFlyer("Ryan", null, null);
        Passenger passenger = new Passenger("Generic", null, null);
        //Add frequent flyer to list, assert that the frequent flyer list is not empty
        queue.addPassenger(frequentFlyer1);
        assertFalse(queue.getFrequentFlyerQueue().isEmpty());

        //Add regular flyer to list, assert that the regular flyer list is not empty
        queue.addPassenger(regularFlyer1);
        assertFalse(queue.getRegularFlyerQueue().isEmpty());

        //Try to add a generic passenger, fails since they must be either regular or frequent flyer objects
        assertFalse(queue.addPassenger(passenger));

        //Try to add the same frequent flyer twice, assert it fails
        assertFalse(queue.addPassenger(frequentFlyer1));

        //Try to add the same regular flyer twice, assert it fails
        assertFalse(queue.addPassenger(regularFlyer1));
    }

    @Test
    public void testRemove(){
        FrequentFlyer frequentFlyer1 = new FrequentFlyer("John", null, null);
        RegularFlyer regularFlyer1 = new RegularFlyer("Ryan", null, null);
        Passenger passenger = new Passenger("Generic", null, null);
        queue.addPassenger(frequentFlyer1);
        queue.addPassenger(regularFlyer1);

        //Assert that the queues are both not empty
        assertFalse(queue.getRegularFlyerQueue().isEmpty());
        assertFalse(queue.getFrequentFlyerQueue().isEmpty());

        //Remove the passengers from each queue, assert that their queues are not empty
        queue.removePassenger(frequentFlyer1);
        queue.removePassenger(regularFlyer1);
        assertTrue(queue.getFrequentFlyerQueue().isEmpty());
        assertTrue(queue.getRegularFlyerQueue().isEmpty());
    }
}
