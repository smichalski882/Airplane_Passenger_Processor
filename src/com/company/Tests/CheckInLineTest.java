package com.company.Tests;

import com.company.*;
import org.junit.Test;

import java.util.LinkedList;

import static org.junit.Assert.*;

public class CheckInLineTest {

    PassengerProcessor processor1 = new PassengerProcessor();
    CheckInLine checkInLine = new CheckInLine(processor1);
    Bag bag = new Bag(51);
    Bag bag2 = new Bag(45);
    LinkedList<Bag> luggage = new LinkedList<Bag>();
    PassengerProcessor processor2 = new PassengerProcessor();
    CheckInLine checkInLine2 = new CheckInLine(processor2);

    @Test
    public void testTransferPassenger(){
        luggage.add(bag);
        luggage.add(bag2);
        Passenger passenger = new Passenger("John", luggage, null);
        checkInLine.setCurrentPassenger(passenger);

        //Assert transfer of passenger to the empty check in line
        assertTrue(checkInLine.transferPassenger(checkInLine2));

        //Assert from both ends the change has been made
        assertEquals(passenger, checkInLine2.getCurrentPassenger());
        assertEquals(null, checkInLine.getCurrentPassenger());
    }

    //Tests taking the next passenger from the queue
    @Test
    public void testTakeNextFromQueue(){
        PassengerQueue passengerQueue = new PassengerQueue();
        FrequentFlyer passenger = new FrequentFlyer("David", null, null);
        RegularFlyer passenger1 = new RegularFlyer("John", null, null);
        passengerQueue.addPassenger(passenger);
        passengerQueue.addPassenger(passenger1);

        //Assert that it takes the first passenger from the frequent flyer queue
        assertEquals(passenger, checkInLine.takeNextFromQueue(passengerQueue));

        //Assert that it takes the next passenger from the regular queue
        assertEquals(passenger1, checkInLine.takeNextFromQueue(passengerQueue));

        PassengerGroup group1 = new PassengerGroup();
        group1.addPassenger(passenger);
        group1.addPassenger(passenger1);

        passengerQueue.addPassenger(passenger);
        passengerQueue.addPassenger(passenger1);

        //Process passengers, should print time 0 to process passenger since has no bags or delays
        checkInLine.process(passengerQueue);
    }
}

