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
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void getResourceGetsGold(){
        Treasury t = new Treasury("Treasury");
        t.getResource("Gold", 20);
    }
}
