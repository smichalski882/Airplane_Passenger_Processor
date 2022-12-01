package com.company.Tests;

import com.company.Bag;
import static org.junit.Assert.*;
import org.junit.Test;

public class BagTest {

    Bag bag = new Bag(45);
    Bag bag2 = new Bag(35);

    @Test
    public void testGetSetWeight(){
        //Test if the initial weight is set
        assertEquals(45, bag.getWeight());

        //Change the weight of bag and see if it carries through
        bag.setWeight(37);
        assertEquals(37, bag.getWeight());
    }

    @Test
    public void testCompareTo(){
        assertEquals(1, bag.compareTo(bag2));
        bag2.setWeight(45);
        assertEquals(0, bag.compareTo(bag2));
        bag2.setWeight(48);
        assertEquals(-1, bag.compareTo(bag2));
    }
}
