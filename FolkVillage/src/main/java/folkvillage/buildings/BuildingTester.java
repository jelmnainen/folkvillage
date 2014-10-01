
package folkvillage.buildings;

/**
 * Only implements the building abstraction for testing purposes
 * Clean away once project is finished
 * 
 * @author Johannes
 */
public class BuildingTester extends Building {
    
    public BuildingTester(String type, String name, int max_hp, int hp, BuildingStatus status){
        super(type, name, max_hp, hp, status);
    }
    
    public BuildingTester(String type, String name, int hp){
        super(type, name, hp);
    }

    public BuildingTester(String type) {
        super(type);
    }
    
}
