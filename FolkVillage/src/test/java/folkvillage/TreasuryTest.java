/*
 * TODO everything
 */
package folkvillage;

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
        r.put("Gold", 100);
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void takeResourceGetsGold(){
        Treasury t = new Treasury("Treasury", r);
        t.takeResource("Gold", 20);
        assertEquals(t.getResourceAmount("Gold"), 80);
    }
    
    @Test
    public void takeResourceDoesntWorkWithNegativeNumbers(){
        Treasury t = new Treasury("Treasury", r);
        t.takeResource("Gold", -20);
        assertEquals(t.getResourceAmount("Gold"), 100);
    }
    
    @Test
    public void takeResourceWontBringResourcesToNegative(){
        Treasury t = new Treasury("Treasury", r);
        t.takeResource("Gold", 110);
        assertEquals(100, t.getResourceAmount("Gold"));
    }
    
    @Test
    public void puttingResourcesWontWorkWithNegativeNumbers(){
        Treasury t = new Treasury("Treasury", r);
        t.putResource("Gold", -20);
        assertEquals(t.getResourceAmount("Gold"), 100);
                
    }
    
    @Test
    public void ucFirstMakesFirstAndOnlyFirstCharUpperCase(){
        Treasury t = new Treasury("Treasury", r);
        String res = t.ucFirst("oujeah");
        assertEquals(res, "Oujeah");
    }
}
