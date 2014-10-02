package folkvillage;

import folkvillage.buildings.*;
import java.util.ArrayList;

/**
 *The class represents a single Folk village
 * 
 * @author jelmnain
 */

public class Village implements Tickable {
    
    //static variables
    public static final int     DEFAULT_POPULATION  = 100;
    public static final String  DEFAULT_NAME        = "Froljvell";
    
    
    //dynamic variables
    private Population              population;
    private String                  name;
    private ArrayList<Building>     buildings;
    private ArrayList<Building>     buildingsUnderConstruction;
    private Treasury                treasury;
    private int                     turn;
    
     
    /**
     * Constructors for Village
     * 
     * 
     */
    
    public Village(){
        
        this(DEFAULT_POPULATION);
        
    }
    
    /**
     *
     * @param populationAmount int the amount of population Village should have
     */
    public Village(int populationAmount ){
        
        this(populationAmount, DEFAULT_NAME);
        
    }
    
    public Village(ArrayList<Building> buildings){
        
        this(DEFAULT_POPULATION, DEFAULT_NAME, buildings);
        
    }
    
    public Village(int populationAmount, String name){
        
        this.name           = name;
        this.population     = new Population(populationAmount);
        this.buildings      = getDefaultBuildings();
        
    }
    
    public Village(int populationAmount, String name, ArrayList<Building> buildings){
        
        this.population = new Population(populationAmount);
        this.name       = name;
        this.buildings  = buildings;
        this.turn       = 0;
    }
    
    /**
     * 
     * @return Default buildings
     */
    private ArrayList<Building> getDefaultBuildings(){

        ArrayList<Building> buildings = new ArrayList();

        buildings.add(new Treasury("Treasury"));

        return buildings;
    }
    
    /*******************
     * VILLAGE RELATED *
     *******************/
    
    /**
     * 
     * @return String representation of this.turn
     */
    public String getTurnCountAsString(){
        return Integer.toString(this.turn);
    }
    
    /********************
     * VILLAGER RELATED *
     ********************/
    
    /***********
     * GETTERS *
     ***********/
    
    public Population getPopulation(){
        return this.population;
    }
    
    /**
     * 
     * @return int the amount of population
     */
    public int getPopulationAmount(){
        
        return this.population.getPopulationAmount();
        
    }
    
    /***********
     * SETTERS *
     ***********/
    
    /**
     * Sets population to be x. Can't go below 1 population. If population
     * goes below 1, it is set to 1.
     * 
     * @param x the new population
     * @return boolean  true, if setting was successful
     *                  false, if population was set under 1
     */    
    public boolean setPopulation(int x){
        
        return this.population.setPopulationAmount(x);
        
    }
    
    
    
    /**
     * Adds the amount to villagerCount. If population would go below 1,
     * sets population to 1 instead
     * 
     * @param amount integer the amount that should be added to villagers
     * @return boolean  true, if adding was successful
     *                  false, if population was set to 1 
     */
    public boolean addPopulation(int amount){
        
        return this.population.addPopulation(amount);
        
    }
    
    /**
     * Multiplies villagerCount with amount, rounded down to nearest natural 
     * number. Can't go below 1 population
     * 
     * @param amount float the number villagerCount should be multiplied with
     * @return boolean  true, if multiplying was successful
     *                  false, if population was set under 1 
     */
    public boolean multiplyPopulation(float amount){
        
        return this.population.multiplyPopulation(amount);
        
    }
    
    /**
     * Subtracts the given amount from VillagerCount. Can't go below 1 
     * villager.
     * 
     * @param amount  integer   the amount that should be subtracted from
     *                          VillagerCount
     * @return  true if the amount of villagers was adjusted properly, 
     *          if population was set under 1
     */
    public boolean subtractPopulation(int amount){
        
        return this.population.subtractPopulation(amount);
        
    }
    
        /**
     * Subtracts population by %amount, rounded down to nearest natural number.
     * Can't go below one villager.
     * 
     * @param amount float the number villagerCount should be divided by
     * 
     * @return  true    if population was correctly divided
     *          false   if population was set under 1 
    *                  
     */
    public boolean dividePopulation(float amount){
        
        try{
            
            return this.population.dividePopulation(amount);
            
        } catch (Exception e){
            
            System.out.println(e.toString());
            
        }
        
        return false;            
        
    }
    
    /*********************
     * BUILDINGS RELATED *
     *********************/
    
    /***********
     * GETTERS *
     ***********/
    
    /**
     * Returns all buildings that are not BuildingStatus.UNDER_CONSTRUCTION
     * @return ArrayList all buildings from this.buildings
     */
    public ArrayList<Building> getReadyBuildings(){
        return this.buildings;
    }
    
    public ArrayList<Building> getBuildingsUnderConstruction(){
        return this.buildingsUnderConstruction;
    }
    
    /**
     * Inserts 
     * @param building 
     */
    public void beginConstruction(Building building){
        
    }
    
    /**************
     * GAME LOGIC *
     **************/
    
    public void tick(){
        this.turn += 1;
        this.population.tick();
    }
    
  
    
 
    
}
