package com.company.Tests;

import com.company.Bag;
import com.company.Passenger;
import org.junit.Test;
import sun.awt.image.ImageWatched;

import javax.swing.plaf.LabelUI;

import java.util.LinkedList;

import static org.junit.Assert.*;

public class PassengerTest {

    //TESTING VARIABLES
    Bag bag = new Bag(52);
    Bag bag2 = new Bag(42);
    Bag bag3 = new Bag(48);
    LinkedList<Bag> luggage1 = new LinkedList<>();
    LinkedList<Bag> luggage2 = new LinkedList<>();

    @Test
    public void testHasOverWeight(){
        luggage1.add(bag);
        luggage1.add(bag2);
        luggage2.add(bag2);
        luggage2.add(bag3);
        Passenger passenger1 = new Passenger("John", luggage1, null);
        Passenger passenger2 = new Passenger("David", luggage2, null);

        //Assert that passenger1 has overweight bag
        assertTrue(passenger1.hasOverWeight(passenger1.getLuggage()));

        //Assert that passenger2 has no overweight bags
        assertFalse(passenger2.hasOverWeight(passenger2.getLuggage()));

        //Assert that passenger1 has added the enum for being overweight luggage, passenger2 no time delays
        assertTrue(!passenger1.getTimeDelays().isEmpty());
        assertTrue(passenger2.getTimeDelays().isEmpty());
    }

}
