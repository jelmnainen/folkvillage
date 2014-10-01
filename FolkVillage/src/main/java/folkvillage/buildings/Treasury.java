/**
 * Class models a Treasury building, which is responsible of holding
 * resources
 * 
 * Resource is enum, defined in folkvillage.Resource
 */

package folkvillage.buildings;


import folkvillage.Resource;
import java.util.HashMap;

/**
 *
 * @author sanho
 */ 
public class Treasury extends Building {
    
    //Building cost
    public static final HashMap<Resource, Integer> COST;
    
    static{
        
        HashMap<Resource, Integer> tempCost = new HashMap();
        tempCost.put(Resource.GOLD, 25);
        tempCost.put(Resource.WOOD, 50);
        COST = tempCost;
        
    }
    
    //class variables
    private HashMap<Resource, Integer> resources;
    
    
    /*** CONSTRUCTORS ***/    

    public Treasury(String type, String name, int max_hp, HashMap<Resource, Integer> resources) {
       
        super(type, name, max_hp);
        this.resources = resources;
        
    }
    
    public Treasury(String type, HashMap<Resource, Integer> resources){
        
        super(type);
        this.resources = resources;
        
    }
    
    public Treasury(String type){
        super(type);
        this.resources = getDefaultResources();
        
    }
    
    private HashMap getDefaultResources(){
        HashMap<Resource, Integer> resources = new HashMap();
        resources.put(Resource.GOLD, 100);
        resources.put(Resource.IRON, 50);
        resources.put(Resource.WOOD, 200);
        resources.put(Resource.FOOD, 300);
        return resources;
    }
    
    /*** GETTERS ***/
    
    public HashMap getAllResources(){
        return this.resources;
    }
    
    public int getResourceAmount(Resource type){
        return this.resources.get(type);
    }
    
    /*** SETTERS ***/
    
    /**
     * Sets the type resource to amount
     * @param type  String, name of resource type 
     *              (first letter can be either lower- or uppercase)
     * @param amount int, amount the resource should be set to 
     */
    public void setResourceAmount(Resource type, int amount){
        
        if(resources.containsKey(type)){
            
            //prevent treasury from going negative
            if( amount > 0 ){

                this.resources.put(type, amount);

            }
            
        }
        
    }
    
    /*** CLASS LOGIC ***/
    
    /**
     * Takes amount number of resource type from the treasury. Won't go below
     * 0. The first letter of type can be either lowercase or uppercase
     * 
     * @param type String, the resource type name
     * @param amount int the amount to be taken from Treasury
     * @return the amount of resources left after operation
     */
    public int takeResource(Resource type, int amount){
        
        if( amount > 0){
        
            int initialResources = this.resources.get(type);
            
            this.setResourceAmount(type, initialResources - amount);
        
        } 
        
        return this.getResourceAmount(type);
        
    }
    
    public int putResource(Resource type, int amount){
        
        if(amount > 0){
            //add current resources to amount
            this.resources.put(type, this.getResourceAmount(type) + amount);
            
        }
        
        return this.getResourceAmount(type);
    }
        
}
