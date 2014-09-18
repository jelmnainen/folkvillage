/**
 * Only implements the building abstraction for testing purposes
 * Clean away once project is finished
 */
package folkvillage;

/**
 *
 * @author sanho
 */
public class BuildingTester extends Building {
    
    public BuildingTester(String type, String name, int hp){
        super(type, name, hp);
    }

    public BuildingTester(String type) {
        super(type);
    }
    
}
