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
    public Vault getVault(){
        return this.vault;
    }

    public String getUsername(){
        return this.username;
    }
}
