/*
 * Test Building abstract class via Treasury implementation.
 */
package folkvillage;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author sanho
 */
public class BuildingTest {
    
    public BuildingTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void reduceHPReducesHitpoints(){
        Treasury t = new Treasury("Treasury", "Main Vault", 100);
        t.reduceHP(20);
        assertEquals(t.getHP(), 80);
    }
    
    @Test
    public void buildingIsBrokenIfHPBelowOne(){
        Treasury t = new Treasury("Treasury", "Main Vault", 100);
        t.reduceHP(100);
        assertEquals(t.getStatus(), "Broken");
    }
    
    @Test
    public void buildingIsNotInOperationIfHPIsBelowOne(){
        Treasury t = new Treasury("Treasury", "Main Vault", 100);
        t.reduceHP(100);
        assertEquals(t.isWorking(), false);
    }
    
    @Test
    public void repairingIncreasesHitPoints(){
        Treasury t = new Treasury("Treasury", "Main Vault", 100);
        t.reduceHP(20);
        t.repair(10);
        assertEquals(t.getHP(), 90);
    }
    
    @Test
    public void repairingWontMakeHPGoOverMaxHP(){
        Treasury t = new Treasury("Treasury", "Main Vault", 100);
        t.repair(10);
        assertEquals(t.getHP(), 100); 
    }
    
    
}
