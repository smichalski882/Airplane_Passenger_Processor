package com.company;

/**
 * Class for diamonds that are worth points for the player
 */
public class Diamond {

    //FIELDS
    public final int pointValue = 1000;

    //CONSTRUCTOR

    /**
     * Create a new instance of diamond, no parameters necessary
     */
    public Diamond(){
        ;
    }

    //METHODS

    /**
     * @return the point value for a single diamond as an int
     */
    public int getPointValue(){
        return this.pointValue;
    }
}
