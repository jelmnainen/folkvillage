package folkvillage;

/**
 *The class represents a single Folk village
 * 
 * @author jelmnain
 */

public class Village {
    
    private int         villagerCount;
    //private Buildings   buildings;
    //private Resources   resources;
    
    
    /**
     * Constructor for a new Village
     * 
     * For now, the village will have default values when we start
     */
    public Village(){
        
        this.villagerCount  = 100;
        
    }
    
    /***********
     * GETTERS *
     ***********/
    
    public int getVillagerCount(){
        
        return this.villagerCount;
        
    }
    
    /***********
     * SETTERS *
     ***********/
    
    public void setVillagerCount(int x){
        
        this.villagerCount = x;
        
    }
    
    /********************
     * Villager related *
     ********************/
    
    /**
     * Adds the amount to villagerCount
     * 
     * @param amount integer the amount that should be added to villagers
     */
    public void addToVillagerCount(int amount){
        
        int originalCount = this.villagerCount;
        int newCount = originalCount + amount;
        
        this.setVillagerCount(newCount);
        
    }
    
    /**
     * Multiplies villagerCount with amount, rounded down to nearest natural 
     * number
     * 
     * @param amount float the number villagerCount should be multiplied with
     */
    public void multiplyVillagerCount(float amount){
       
        int originalCount = this.villagerCount;
        float newCount = originalCount * amount;
        int finalCount = (int)Math.floor(newCount);
        
        this.setVillagerCount(finalCount);
        
    }
    
    /**
     * Substracts the amount from VillagerCount
     * 
     * @param amount  integer   the amount that should be substracted from
     *                          VillagerCount
     */
    public void substractFromVillagerCount(int amount){
       
        int originalCount = this.villagerCount;
        int newCount = originalCount - amount;
        
        this.setVillagerCount(newCount);
        
    }
    
    /**
     * Divides villagerCount by amount, rounded down to nearest natural number
     * 
     * @param amount float the number villagerCount should be divided by
     */
    public void divideVillagerCount(float amount){
        
        int originalCount = this.villagerCount;
        float newCount = originalCount / amount;
        int finalCount = (int)Math.floor(newCount);
        
        this.setVillagerCount(finalCount);
        
    }
    
}
