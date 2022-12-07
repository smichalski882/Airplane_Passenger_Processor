package com.company;

public class Player {

    //FIELDS
    private final Vault vault;
    private final String username;
    private final PassengerQueue passengerQueue;

    //CONSTRUCTOR
    public Player(String username){
        this.vault = new Vault();
        this.username = username;
        passengerQueue = new PassengerQueue();
    }

    //METHODS

    /**
     * @return the vault corresponding to this player
     */
    public Vault getVault(){
        return this.vault;
    }

    /**
     * @return the string username corresponding to this character
     */
    public String getUsername(){
        return this.username;
    }
}
