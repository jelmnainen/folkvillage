/*
 * Test Building abstract class via BuildingTester implementation.
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
    public void defaultCostAreConstructed(){
        int amount = BuildingTester.COST.get(Resource.GOLD);
        assertEquals(amount, 25);
    }
    
    @Test
    public void reduceHPReducesHitpoints(){
        BuildingTester t = new BuildingTester("BuildingTester", "Main Vault", 100, 100, BuildingStatus.WORKING);
        t.reduceHP(20);
        assertEquals(t.getHP(), 80);
    }
    
    @Test
    public void buildingIsDamagedIfHPBelowOne(){
        BuildingTester t = new BuildingTester("BuildingTester", "Main Vault", 100, 100, BuildingStatus.WORKING);
        t.reduceHP(100);
        assertEquals(t.getStatus(), BuildingStatus.DAMAGED);
    }
    
    @Test
    public void buildingIsWorkingReturnsFalseIfHPIsBelowOne(){
        BuildingTester t = new BuildingTester("BuildingTester", "Main Vault", 100, 100, BuildingStatus.WORKING);
        t.reduceHP(100);
        assertEquals(t.isWorking(), false);
    }
    
    @Test
    public void repairingIncreasesHitPoints(){
        BuildingTester t = new BuildingTester("BuildingTester", "Main Vault", 100, 100, BuildingStatus.WORKING);
        t.reduceHP(20);
        int beginningHP = t.getHP();
        t.repair(2);
        int endHP = t.getHP();
        assertTrue("Building HP in beginning / at the end:" + beginningHP + " / " + endHP, endHP > beginningHP );
    }
    
    @Test
    public void repairingIncreasesHitpointsByCoefficient(){
        BuildingTester t = new BuildingTester("BuildingTester", "Main Vault", 100, 100, BuildingStatus.WORKING);
        t.reduceHP(50); 
        t.setRepairingCoefficient(10);
        t.repair();
        assertEquals(t.getHP(), 60);
    }
    
    @Test
    public void repairingWontMakeHPGoOverMaxHP(){
        BuildingTester t = new BuildingTester("BuildingTester", "Main Vault", 100, 100, BuildingStatus.WORKING);
        t.repair(10);
        assertEquals(t.getHP(), 100); 
    }
    
    @Test
    public void repairingWillChangeIsWorkingToTrue(){
        BuildingTester t = new BuildingTester("BuildingTester", "Main Vault", 100);
        t.reduceHP(100);
        t.repair(100);
        assertEquals(t.isWorking(), true);
    }
    
    @Test
    public void repairingWillChangeStatusToWorking(){
        BuildingTester t = new BuildingTester("BuildingTester", "Main Vault", 100);
        t.reduceHP(100);
        t.repair(100);
        assertEquals(t.getStatus(), BuildingStatus.WORKING);
    }
    
    @Test
    public void statusUnderConstructionAddsHPPerTick(){
        BuildingTester t = new BuildingTester("BuildingTester", "Main Vault", 100);
        t.setRepairingCoefficient(100);
        int startHP = t.getHP();
        t.tick();
        int endHP = t.getHP();
        assertTrue("Start / End HP: " + startHP + "/" + endHP, startHP < endHP);
    }
    
    @Test
    public void statusUnderRepairAddsHPPerTick(){
        BuildingTester t = new BuildingTester("BuildingTester", "Main Vault",
                100, 0, BuildingStatus.UNDER_REPAIR);
        t.tick();
        assertTrue("Start / End HP: " + 0 + "/" + t.getHP(), 0 < t.getHP());
        
    }
    
    
    
}
