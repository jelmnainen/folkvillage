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
    
    private HashMap<String, Integer> resources;
    

    public Treasury(String type, String name, int max_hp) {
        super(type, name, max_hp);
    }
    
    public Treasury(String type){
        super(type);
    }
    
    /*** GETTERS ***/
    
    public int takeResource(String type, int amount){
        
        if( amount > 0){
        
            int initialResources = this.resources.get(type);

            this.resources.put(type, initialResources - amount);
        
        } 
        
        return this.resources.get(type);
        
    }

 
    
}
