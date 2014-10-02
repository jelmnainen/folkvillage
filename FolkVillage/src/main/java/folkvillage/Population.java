/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package folkvillage;

import static java.lang.Math.*;

/**
 *
 * @author sanho
 */
public class Population implements Tickable {
    
    //static variables
    /**
     * The default amount of population
     */
    public static final int     DEFAULT_POPULATION = 500;
    public static final float   DEFAULT_GROWTHRATE = 1.05F;
     
    //Class variables
    private int amount;
    private float growthrate;
    
    
    /**
     * Class constructor
     * @param amount the amount of villagers
     * @param multiplier the multiplier by which the population will increase
     *                      per tick
     */
    public Population(int amount, float multiplier){
        
        this.amount = amount;
        this.growthrate = multiplier;
        
    }
    
    
    /**
     * Class constructor
     * 
     * Constructor is overloaded, see below
     * 
     * @param amount the amount of population
     */
    public Population(int amount){
        
        this(amount, DEFAULT_GROWTHRATE);        
        
    }
    
    /**
     * Class constructor without arguments: creates a new village with
     * default settings
     */
    public Population(){
        
        this(DEFAULT_POPULATION);
        
    }
    
    
    /*** GETTERS ***/
    
    
    /**
     * Get the amount of population
     * 
     * @return int amount of population
     */
    public int getPopulationAmount(){
        
        return this.amount;
        
    }
    
    public String getPopulationAmountAsString(){
        return Integer.toString(this.amount);
    }
    
    /*** SETTERS ***/
    
    /** Direct population control **/
    
    /**
     * Sets population to x. If x is 0 or lower, population is set to 1
     * 
     * @param x the amount the population is set to
     * @return true if population is set to x, false if set to 1
     */
    public boolean setPopulationAmount(int x){
        
        if( x > 0){
            
            this.amount = (int)x;
            return true;
            
        } else {
            
            this.amount = 1;
            return false;
            
        }
        
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
        
        int originalCount = this.amount;
        int newCount = originalCount + amount;
        
        return this.setPopulationAmount(newCount);
        
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
       
        int originalCount = this.amount;
        float newCount = originalCount * amount;
        int finalCount = (int)newCount;
        
        return this.setPopulationAmount(finalCount);
        
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
       
        int originalCount = this.amount;
        int newCount = originalCount - amount;
        
        return this.setPopulationAmount(newCount);         
        
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
     *  
     * @throws java.lang.Exception  if division by 0 was attempted
     */
    public boolean dividePopulation(float amount) throws Exception{
        
        if(amount != 0){
        
            int subtraction;
            
            int originalCount = this.amount;
            float candidateSubtraction = originalCount / amount;
            
            if(candidateSubtraction > 1){
            
                subtraction = (int)candidateSubtraction;
                
            } else {
                
                subtraction = 1;
                
            }
            
            System.out.println(subtraction);

            return this.subtractPopulation(subtraction);
            
        } else { //someone tried to divide by zero
            
            throw new Exception("Division by 0 in Population.dividePopulation");
            
        }
        
    }
    
    /** Growthrate manipulation **/
    
    /**
     * Sets the village growth rate
     * @param newRate float > 0
     */
    public void setGrowthrate(float newRate){
        
        if(newRate > 0){
        
            this.growthrate = newRate;
        }
        
    }
    
    public float getGrowthrate(){
        
        return this.growthrate;
        
    }
    
    /**
     * adds amount to the growth rate
     * @param amount float > 0
     */
    public void addGrowthrate(float amount){
        
        if(amount > 0){
            
            this.growthrate += amount;
            
        }
        
    }
    
    /**
     * Substracts amount from growth rate
     * @param amount > 0
     */
    public void substractGrowthrate(float amount){
        
        if(amount > 0){
            
            this.growthrate -= amount;
            
        }
    }
      
    /**
     * updates population amount based on current growthrate
     */
    @Override
    public void tick() {
        this.amount = round(this.amount * this.growthrate);
    }
    
    
    
}
