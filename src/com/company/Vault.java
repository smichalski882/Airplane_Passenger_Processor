package com.company;

import java.util.HashMap;
import java.util.LinkedList;

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

    public HashMap<Shop.Merchandise, LinkedList> getListMap(){
        return listMap;
    }

    public HashMap<Shop.Merchandise, Object> getItemMap(){
        return itemMap;
    }

    public void addDiamond(Diamond diamond){
        diamonds.add(diamond);
    }

    //Checks if the player has sufficient points to afford the content of their cart
    public boolean canAffordCart(Shop shop){
        if(this.getPoints() < shop.computeCartPrice()){
            return false;
        }
        return true;
    }

    //Checks out the cart if the player can afford the content
    public boolean checkOutCart(Shop shop){
        if(canAffordCart(shop)){
            for(Shop.Merchandise item : shop.getCart()){
                this.getListMap().get(item).add(this.getItemMap().get(item));
            }
            this.subtractFromPoints(shop.computeCartPrice());
            shop.emptyCart();
            return true;
        }
        System.out.println("Insufficient Funds for Purchase");
        return false;
    }

    //Creates a map of each merchandise item to a new instance of the item being purchased
    public HashMap<Shop.Merchandise, Object> makeItemMap(){
        HashMap<Shop.Merchandise, Object> itemMap = new HashMap<>();
        itemMap.put(Shop.Merchandise.AGENT, new Agent());
        itemMap.put(Shop.Merchandise.SUPERVISOR, new Supervisor());
        itemMap.put(Shop.Merchandise.IN_PERSON_COUNTER, new InPersonLine(new PassengerProcessor()));
        itemMap.put(Shop.Merchandise.AUTOMATED_COUNTER, new AutomatedLine(new PassengerProcessor()));
        return itemMap;
    }

    //Creates a map of each merchandise to the corresponding linked list in player where the merchandise will be stored
    public HashMap<Shop.Merchandise, LinkedList> makeListMap(){
        HashMap<Shop.Merchandise, LinkedList> listMap = new HashMap<>();
        listMap.put(Shop.Merchandise.AGENT, this.getAgents());
        listMap.put(Shop.Merchandise.SUPERVISOR, this.getSupervisors());
        listMap.put(Shop.Merchandise.IN_PERSON_COUNTER, this.getInPersonLines());
        listMap.put(Shop.Merchandise.AUTOMATED_COUNTER, this.getAutomatedLines());
        return listMap;
    }

    public Shop getShop(){
        return shop;
    }

    public LinkedList<Diamond> getDiamonds(){
        return this.diamonds;
    }

    //Converts diamonds to points based on how many and the value of the diamonds
    public void convertDiamondToPoints(){
        if(diamonds.size() == 0){
            return;
        }
        points = points + diamonds.size() * diamonds.getFirst().getPointValue();
        diamonds.clear();
    }

    public int getPoints(){
        return this.points;
    }

    public void addToPoints(int value){
        points = points + value;
    }

    //Subtracts int from points (cannot go negative)
    public boolean subtractFromPoints(int value){
        if(points - value < 0){
            System.out.println("Insufficient Funds");
            return false;
        }
        points = points - value;
        return true;
    }

    public int getNumAgents(){
        return agents.size();
    }

    public int getNumAutomatedLines(){
        return automatedLines.size();
    }

    public int getNumInPersonLines(){
        return inPersonLines.size();
    }

    public LinkedList<Agent> getAgents() {
        return agents;
    }

    public LinkedList<AutomatedLine> getAutomatedLines() {
        return automatedLines;
    }

    public LinkedList<InPersonLine> getInPersonLines() {
        return inPersonLines;
    }

    public LinkedList<Supervisor> getSupervisors() {
        return supervisors;
    }
}
