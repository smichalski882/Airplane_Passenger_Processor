package com.company;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * Class that contains all of the player's items
 */
public class Vault {

    //FIELDS
    private int points;
    private LinkedList<Diamond> diamonds;
    private LinkedList<Agent> agents;
    private LinkedList<Supervisor> supervisors;
    private LinkedList<AutomatedLine> automatedLines;
    private LinkedList<InPersonLine> inPersonLines;
    private final Shop shop;
    private final HashMap<Shop.Merchandise, LinkedList> listMap;
    private final HashMap<Shop.Merchandise, Object> itemMap;

    //CONSTRUCTOR

    /**
     * Create a new instance of the vault
     * All fields automatically assigned on creation, no parameters necessary
     */
    public Vault(){
        diamonds = new LinkedList<Diamond>();
        agents = new LinkedList<Agent>();
        supervisors = new LinkedList<Supervisor>();
        automatedLines = new LinkedList<AutomatedLine>();
        inPersonLines = new LinkedList<InPersonLine>();
        shop = new Shop();
        listMap = makeListMap();
        itemMap = makeItemMap();
    }

    //METHODS

    /**
     * @return the map of merchandise to the linked list of the merchandise's type
     */
    public HashMap<Shop.Merchandise, LinkedList> getListMap(){
        return listMap;
    }

    /**
     * @return a map of a new object for each new instance of the merchandise being purchased
     */
    public HashMap<Shop.Merchandise, Object> getItemMap(){
        return itemMap;
    }

    /**
     * @param diamond earned by the player to be added to their collection
     */
    public void addDiamond(Diamond diamond){
        diamonds.add(diamond);
    }

    /**
     * @param shop that the cart belongs to
     * @return boolean if the player is able to afford their current cart contents with given their points
     */
    public boolean canAffordCart(Shop shop){
        if(this.getPoints() < shop.computeCartPrice()){
            return false;
        }
        return true;
    }

    /**
     * @param shop that you are checking out the cart from
     * @return whether or not the cart is successfully checked out
     */
    public boolean checkOutCart(Shop shop){

        //Only check out the cart if the player has enough points in the vault to afford it
        if(canAffordCart(shop)){

            //Add a new instance of the item to the corresponding list for the type of merchandise
            for(Shop.Merchandise item : shop.getCart()){
                this.getListMap().get(item).add(this.getItemMap().get(item));
            }
            this.subtractFromPoints(shop.computeCartPrice());   //subtract cart price from points
            shop.emptyCart();   //empty cart
            return true;
        }
        System.out.println("Insufficient Funds for Purchase");
        return false;
    }

    /**
     * @return the hashmap mapping each merchandise enum to a new object instance for the corresponding merchandise
     */
    public HashMap<Shop.Merchandise, Object> makeItemMap(){
        HashMap<Shop.Merchandise, Object> itemMap = new HashMap<>();
        itemMap.put(Shop.Merchandise.AGENT, new Agent());
        itemMap.put(Shop.Merchandise.SUPERVISOR, new Supervisor());
        itemMap.put(Shop.Merchandise.IN_PERSON_COUNTER, new InPersonLine(new PassengerProcessor()));
        itemMap.put(Shop.Merchandise.AUTOMATED_COUNTER, new AutomatedLine(new PassengerProcessor()));
        return itemMap;
    }

    /**
     * @return the hashmap mapping each merchandise enum to the list for the corresponding merchandise
     */
    public HashMap<Shop.Merchandise, LinkedList> makeListMap(){
        HashMap<Shop.Merchandise, LinkedList> listMap = new HashMap<>();
        listMap.put(Shop.Merchandise.AGENT, this.getAgents());
        listMap.put(Shop.Merchandise.SUPERVISOR, this.getSupervisors());
        listMap.put(Shop.Merchandise.IN_PERSON_COUNTER, this.getInPersonLines());
        listMap.put(Shop.Merchandise.AUTOMATED_COUNTER, this.getAutomatedLines());
        return listMap;
    }

    /**
     * @return the shop belonging to this vault
     */
    public Shop getShop(){
        return shop;
    }

    /**
     * @return all of the diamonds belonging to the player
     */
    public LinkedList<Diamond> getDiamonds(){
        return this.diamonds;
    }

    /**
     * Converts all the diamonds belonging to the player to points to be used
     */
    public void convertDiamondToPoints(){

        //Only convert the diamonds to points of the list is not empty
        if(diamonds.size() == 0){
            return;
        }
        points = points + diamonds.size() * diamonds.getFirst().getPointValue();    //Add value of diamonds to this player's points
        diamonds.clear();
    }

    /**
     * @return the number of points this player has that can be used
     */
    public int getPoints(){
        return this.points;
    }

    /**
     * @param value to be added to to the player's points
     */
    public void addToPoints(int value){
        points = points + value;
    }

    /**
     * @param value to be subtracted from the player's points
     * @return boolean if the subtraction was successful
     */
    public boolean subtractFromPoints(int value){

        //Only subtract the points of the player can afford to subtract the points
        if(points - value < 0){
            System.out.println("Insufficient Funds");
            return false;
        }
        points = points - value;
        return true;
    }

    /**
     * @return the number of agents the player owns
     */
    public int getNumAgents(){
        return agents.size();
    }

    /**
     * @return the number of automated lines the player owns
     */
    public int getNumAutomatedLines(){
        return automatedLines.size();
    }

    /**
     * @return the number of in person lines the player owns
     */
    public int getNumInPersonLines(){
        return inPersonLines.size();
    }

    /**
     * @return the list of agents the player owns
     */
    public LinkedList<Agent> getAgents() {
        return agents;
    }

    /**
     * @return the list of automated lines the player owns
     */
    public LinkedList<AutomatedLine> getAutomatedLines() {
        return automatedLines;
    }

    /**
     * @return the list of agents the player owns
     */
    public LinkedList<InPersonLine> getInPersonLines() {
        return inPersonLines;
    }

    /**
     * @return the list of supervisors the player owns
     */
    public LinkedList<Supervisor> getSupervisors() {
        return supervisors;
    }
}
