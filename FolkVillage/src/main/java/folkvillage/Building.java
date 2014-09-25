
package folkvillage;

import java.util.HashMap;

/**
 * Building is an abstraction of all buildings, defining some core functions
 * and class variables all buildings share
 * 
 * @author sanho
 */
public abstract class Building {
      
    //default values
    public static int               DEFAULT_HP              = 100;
    public static int               DEFAULT_MAX_HP          = 100;
    public static String            DEFAULT_NAME            = "Unnamed";
    public static BuildingStatus    DEFAULT_STATUS          = BuildingStatus.WORKING;
    //building price
    public static final HashMap<Resource, Integer> COST;
    
    static{
        
        HashMap<Resource, Integer> theCost = new HashMap();
        theCost.put(Resource.GOLD, 25);
        theCost.put(Resource.WOOD, 50);
        COST = theCost;
        
    }
    
    //class variables
    private     String  type;
    private     String  name;
    private     int     hp;
    private     int     max_hp;
    private     BuildingStatus  status;
    private     boolean isWorking;
    
    
    
    /**
     * Constructors
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
        
        this.type   =   type;
        this.name   =   name;
        this.max_hp =   max_hp;
        this.hp     =   hp;
        this.status =   status;
        
        this.setWorkingCondition();
    }
    
    public Building(String type, String name, int max_hp){
        
        this (type, name, max_hp, max_hp, DEFAULT_STATUS);
        
    }

    
    public Building(String type, int max_hp){
        
        this(type, DEFAULT_NAME, max_hp, max_hp, DEFAULT_STATUS);
        
    }
    
    public Building(String type){
        
        this(type, DEFAULT_MAX_HP);
        
    }
    
    /*** SET ***/
    
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
            
            this.hp = this.hp + amount;
            
        }
        
        if(this.hp > this.max_hp){
            
            this.hp = this.max_hp;
            
        }
        
        this.checkIfRepaired();
    }
    
    /*** GET ***/
    
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

    
}
