/*
 * TODO everything
 */
package folkvillage.buildings;

import folkvillage.Resource;
import folkvillage.buildings.Treasury;
import java.util.*;
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
public class TreasuryTest {
    
    public HashMap r;
    
    public TreasuryTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        this.r = new HashMap();
        r.put(Resource.GOLD, 100);
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void takeResourceGetsGold(){
        Treasury t = new Treasury("Treasury", r);
        t.takeResource(Resource.GOLD, 20);
        assertEquals(t.getResourceAmount(Resource.GOLD), 80);
    }
    
    @Test
    public void takeResourceDoesntWorkWithNegativeNumbers(){
        Treasury t = new Treasury("Treasury", r);
        t.takeResource(Resource.GOLD, -20);
        assertEquals(t.getResourceAmount(Resource.GOLD), 100);
    }
    
    @Test
    public void takeResourceWontBringResourcesToNegative(){
        Treasury t = new Treasury("Treasury", r);
        t.takeResource(Resource.GOLD, 110);
        assertEquals(100, t.getResourceAmount(Resource.GOLD));
    }
    
    @Test
    public void puttingResourcesWontWorkWithNegativeNumbers(){
        Treasury t = new Treasury("Treasury", r);
        t.putResource(Resource.GOLD, -20);
        assertEquals(t.getResourceAmount(Resource.GOLD), 100);
                
    }
    
}
