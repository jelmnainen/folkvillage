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
    private int                     population;
    private ArrayList<Building>     buildings;
    private ArrayList<Resource>     resources;
    
    
    /**
     * First constructor for a new Village
     * 
     * The first constructor will use the default values
     */
    public Village(){
        
        this(DEFAULT_POPULATION);
        
    }
    
    /**
     * Second constructor for a new Village
     * 
     * @param population    int     the starting population
     */
    public Village( int population ){
        
        this.population = population;
        
    }
    
    /***********
     * GETTERS *
     ***********/
    
    public int getPopulation(){
        
        return this.population;
        
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
        
        if( x > 0){
            
            this.population = (int)x;
            return true;
            
        } else {
            
            this.population = 1;
            return false;
            
        }
        
    }
    
    /********************
     * Villager related *
     ********************/
    
    //TODO: move these to their own class
    
    /**
     * Adds the amount to villagerCount
     * 
     * @param amount integer the amount that should be added to villagers
     * @return boolean  true, if adding was successful
     *                  false, if population was set under 1 
     */
    public boolean addPopulation(int amount){
        
        int originalCount = this.population;
        int newCount = originalCount + amount;
        
        return this.setPopulation(newCount);
        
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
       
        int originalCount = this.population;
        float newCount = originalCount * amount;
        int finalCount = (int)newCount;
        
        return this.setPopulation(finalCount);
        
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
    public boolean substractPopulation(int amount){
       
        int originalCount = this.population;
        int newCount = originalCount - amount;
        
        return this.setPopulation(newCount);         
        
    }
    
    /**
     * Subtracts population by %amount, rounded down to nearest natural number.
     * Can't go below one villager.
     * 
     * @param amount float the number villagerCount should be divided by
     * 
     * @return  true    if population was correctly divided
     *          false   if population was set under 1 OR
     *                  if 0 division was attempted
     */
    public boolean dividePopulation(float amount){
        
        if(amount != 0){
        
            int subtraction;
            
            int originalCount = this.population;
            float candidateSubtraction = originalCount / amount;
            
            if(candidateSubtraction > 1){
            
                subtraction = (int)candidateSubtraction;
                
            } else {
                
                subtraction = 1;
                
            }

            return this.substractPopulation(subtraction);
            
        } else { //someone tried to divide by zero
            
            return false;
            
        }
        
    }
    
}
