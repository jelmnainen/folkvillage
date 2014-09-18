/**
 * Class models a Treasury building, which is responsible of holding
 * resources
 */

package folkvillage;


import java.util.HashMap;

/**
 *
 * @author sanho
 */
class Treasury extends Building {
    
    //class variables
    private HashMap<String, Integer> resources;
    
    
    /*** CONSTRUCTORS ***/    

    public Treasury(String type, String name, int max_hp, HashMap<String, Integer> resources) {
       
        super(type, name, max_hp);
        this.resources = resources;
        
    }
    
    public Treasury(String type, HashMap<String, Integer> resources){
        
        super(type);
        this.resources = resources;
        
    }
    
    /*** GETTERS ***/
    
    public HashMap getAllResources(){
        return this.resources;
    }
    
    public int getResourceAmount(String type){
        return this.resources.get(type);
    }
    
    /*** SETTERS ***/
    
    /**
     * Sets the type resource to amount
     * @param type  String, name of resource type 
     *              (first letter can be either lower- or uppercase)
     * @param amount int, amount the resource should be set to 
     */
    public void setResourceAmount(String type, int amount){
        
        //make function first carachter case agnostic
        type = this.ucFirst(type);
        
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
    public int takeResource(String type, int amount){
        
        if( amount > 0){
        
            int initialResources = this.resources.get(type);
            
            this.setResourceAmount(type, initialResources - amount);
        
        } 
        
        return this.getResourceAmount(type);
        
    }
    
    public int putResource(String type, int amount){
        
        if(amount > 0){
            //add current resources to amount
            this.resources.put(type, this.getResourceAmount(type) + amount);
            
        }
        
        return this.getResourceAmount(type);
    }
    
    /*** HELPERS ***/
    
    /**
     * Makes the first charachter of a String uppercase
     * @param str String
     * @return String 
     */
    public String ucFirst(String str){
        
        String res = "";
        
        if(str.length()>0){
        
            char[] stringArray = str.trim().toCharArray();
            stringArray[0] = Character.toUpperCase(stringArray[0]);
            res = new String(stringArray);            
            
        }
        
        return res;
        
    }

 
    
}
