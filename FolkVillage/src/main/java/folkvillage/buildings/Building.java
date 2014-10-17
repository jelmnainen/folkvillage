
package folkvillage.buildings;

import folkvillage.Resource;
import java.util.HashMap;

/**
 * Building is an abstraction of all buildings, defining some core functions
 * and class variables all buildings share
 * 
 * @author sanho
 */
public abstract class Building {
      
    //default values
    public static final int             DEFAULT_HP              = 100;
    public static final int             DEFAULT_MAX_HP          = 100;
    public static final int             DEFAULT_START_HP        = 0;
    public static final String          DEFAULT_NAME            = "Unnamed";
    public static final BuildingStatus  DEFAULT_STATUS          = BuildingStatus.UNDER_CONSTRUCTION;
    
    //building price
    public static final HashMap<Resource, Integer> COST = new HashMap();
    
    static{
        
        COST.put(Resource.GOLD, 25);
        COST.put(Resource.WOOD, 50);
        
    }
    
    //class variables
    private     String  type;
    private     String  name;
    private     int     hp;
    private     int     max_hp;
    private     int     repairingCoefficient;
    private     BuildingStatus  status;
    private     boolean isWorking;
    
    
    /***********************
     *    CONSTRUCTORS     *
     ***********************/
    
    
    /**
     * 
     * @param type      String  the building archetype
     * @param name      String  building's name
     * @param max_hp    int     the maximum hitpoints the building has
     * @param hp        int     the current hitpoints the building has
     * @param status    String  the current status of the building. 
     *                          "Normal" is the only one recognized as working
     *                          building 
     */
    public Building(String type, String name, int max_hp, int hp, BuildingStatus status){
        
        this.type                   =   type;
        this.name                   =   name;
        this.max_hp                 =   max_hp;
        this.hp                     =   hp;
        this.status                 =   status;
        this.repairingCoefficient   =   5;
        
        this.setWorkingCondition();
    }
    
       
    /**
     * 
     * @param type      String  the building archetype
     * @param name      String  building's name
     * @param max_hp    int     the maximum hitpoints the building has
     */
    public Building(String type, String name, int max_hp){
        
        this (type, name, max_hp, DEFAULT_START_HP, DEFAULT_STATUS);
        
    }

    /**
     * 
     * @param type      String  the building archetype
     * @param max_hp    int     the maximum hitpoints the building has
     */
    public Building(String type, int max_hp){
        
        this(type, DEFAULT_NAME, max_hp, DEFAULT_START_HP, DEFAULT_STATUS);
        
    }
    
    /**
     * 
     * @param type      String  the building archetype
     */
    public Building(String type){
        
        this(type, DEFAULT_MAX_HP);
        
    }
    
    /************* 
     *    SET    *
     *************/
    
    /**
     * Set a new status, then calls setWorkingCondition to check if the
     * building is still ok
     * 
     * @param status String, the new status
     */
    private void setStatus(BuildingStatus status){
        
        this.status = status;
        
        this.setWorkingCondition();
        
    }
    
    /**
     * sets this.repairingCoefficient to amount if amount is larger than 0
     *
     * @param amount    int     the number coefficient should be set to, 
     *                          larger than 0
     * @return true on success, false on failure
     */
    public boolean setRepairingCoefficient(int amount){
        
        if( amount > 0 ){
            
            this.repairingCoefficient = amount;
                
            return true;
            
        }
        
        return false;
        
    }
    
    /**
     * Sets the working condition.
     * If status is BuildingStatus.WORKING, isWorking will be true
     * otherwise it will be false and building is considered inoperable
     */
    private void setWorkingCondition(){
        
        if(this.status.equals(BuildingStatus.WORKING)){
            
            this.isWorking = true;
            
        } else {
            
            this.isWorking = false;
            
        }
    }
    
    /**
     * Checks if building's current hp has reached max_hp. If it has,
     * calls setStatus with BuildingStatus.WOKRING
     */
    private void checkIfRepaired() {
        
        if(this.hp == this.max_hp){
            this.setStatus(BuildingStatus.WORKING);
        }
        
    }
    
    /**
     * Reduces the building's HP by amount. If HP is taken below 0, it's 
     * reset to 0 and status is set to be broken (also causes isWorking to 
     * change to false)
     * @param amount int must be over 0
     */
    public void reduceHP(int amount){
        
        if (amount > 0){
            
            this.hp = this.hp - amount;
            
        }
        
        if (this.hp <= 0){
            
            this.setStatus(BuildingStatus.DAMAGED);
            this.hp = 0;
            
        }
        
    }
    
    /**
     * Function adds HP to building's HP. HP can't go over building's max hp.
     * Calls checkIfRepaired to figure out if building should be set to 
     * BuildingStatus.WOKRING
     * 
     * @param amount int the amount of HP added to building
     */
    public void repair(int amount){
        
        if(amount > 0){
            
            this.hp = this.hp + amount * this.repairingCoefficient;
            
        }
        
        if(this.hp > this.max_hp){
            
            this.hp = this.max_hp;
            
        }
        
        this.checkIfRepaired();
    }
    
    /**
     * Calls repair() with default value of 1
     */
    public void repair(){
        this.repair(1);
    }
    
    /********
     * GET  *
     ********/
    
    /**
     * 
     * @return String
     */
    public String getType(){
        return this.type;
    }
    
    /**
     * 
     * @return String
     */
    public String getName(){
        return this.name;
    }
    
    /**
     * 
     * @return int current amount of hit points
     */
    public int getHP(){
        
        return this.hp;
        
    }
    
    /**
     * 
     * @return int the maximum amount of hit points
     */
    public int getMaxHP(){
        
        return this.max_hp;
        
    }
    
    /**
     * 
     * @return BuildingStatus the operating status of the building
     */
    public BuildingStatus getStatus(){
        
        return this.status;
        
    }

    /**
     * Tells if the building is considered to be in working condition
     * @return bool if true, building is considered to be working, else not
     */
    public boolean isWorking(){
        
        return this.isWorking;
        
    }
    
    
    /**************
     *    MISC    *
     **************/
    
    /**
     * Building turn update logic
     */
    public void tick(){
        
        switch(status){
            
            case UNDER_CONSTRUCTION:
                this.repair(20); //building is faster than repairing
                break;
                
            case UNDER_REPAIR:
                this.repair();
                break;
                
        }
        
    }

    
}
