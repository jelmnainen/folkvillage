/*
 * Building abstraction class.
 */

package folkvillage;

public abstract class Building {
      
    //default values
    public static int       DEFAULT_HP              = 100;
    public static int       DEFAULT_MAX_HP          = 100;
    public static String    DEFAULT_NAME            = "Unnamed";
    public static String    DEFAULT_STATUS          = "Normal";
    
    //variable values
    private     String  type;
    private     String  name;
    private     int     hp;
    private     int     max_hp;
    private     String  status;
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
    public Building(String type, String name, int max_hp, int hp, String status){
        
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
     * Set a new status, then pass turn to setWorkingCondition to check if the
     * building is still ok
     * 
     * @param status String, the new status
     */
    private void setStatus(String status){
        
        this.status = status;
        
        this.setWorkingCondition();
        
    }
    
    /**
     * Sets the working condition.
     * If status is "Normal", isWorking will be true
     * otherwise it will be false and building is considered inoperable
     */
    private void setWorkingCondition(){
        
        if(this.status.equals("Normal")){
            
            this.isWorking = true;
            
        } else {
            
            this.isWorking = false;
            
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
            
            this.setStatus("Broken");
            this.hp = 0;
            
        }
        
    }
    
    /**
     * Function adds HP to building's HP. HP can't go over building's max hp.
     * @param amount int the amount of HP added to building
     */
    public void repair(int amount){
        
        if(amount > 0){
            
            this.hp = this.hp + amount;
            
        }
        
        if(this.hp > this.max_hp){
            
            this.hp = this.max_hp;
            
        }
    }
    
    /*** GET ***/
    
    public int getHP(){
        
        return this.hp;
        
    }
    
    public int getMaxHP(){
        
        return this.max_hp;
        
    }
    
 
    public String getStatus(){
        
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
