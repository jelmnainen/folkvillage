package folkvillage;
import java.util.ArrayList;

/**
 *The class represents a single Folk village
 * 
 * @author jelmnain
 */

public class Village {
    
    //static variables
    public static final int DEFAULT_POPULATION = 100;
    
    //dynamic variables
    private Population              population;
    private ArrayList<Building>     buildings;
    private Treasury                treasury;
    
    
    /**
     * First constructor for a new Village
     * 
     * The first constructor will use the default values
     */
    public Village(){
        
        this.population = new Population();
        
    }
    
    /**
     * Second constructor for a new Village
     * 
     * @param population    int     the starting population
     */
    public Village( int population ){
        
        this.population = new Population(population);
        
    }
    
    /***********
     * GETTERS *
     ***********/
    
    public int getPopulation(){
        
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
    
    /********************
     * Villager related *
     ********************/
    
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
    
  
    
 
    
}
