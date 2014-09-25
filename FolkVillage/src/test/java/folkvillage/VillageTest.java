package folkvillage;

import java.math.*;
import java.util.ArrayList;
import java.util.HashMap;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

/**
 * Unit test for Village class.
 */
public class VillageTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    
    ArrayList<Building> b;
    
    public VillageTest( String testName )
    {
        super( testName );
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
        HashMap<String, Integer> r = new HashMap();
        r.put("Gold", 200);
        r.put("Wood", 200);
        Treasury t = new Treasury("Treasury", r);
        ArrayList<Building> b = new ArrayList();
        b.add(t);
        this.b = b;
        
    }

    @After
    public void tearDown() throws Exception {
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( VillageTest.class );
    }
    
    /*** Population tests ***/
    @org.junit.Test
    public void testSetPopulationReturnsFalseIfArgumentBelowOne(){
        Village i = new Village(100);
        assertFalse(i.setPopulation(0));
    }
    
    public void testSetPopulationSetsPopulationTo1IfArgumentBelowOne(){
        Village i = new Village(100);
        i.setPopulation(0);
        assertEquals(1, i.getPopulation());
    }

    @org.junit.Test
    public void testAddToVillagerCount() {
        
        int amount = 10; 
        Village instance = new Village(100);
        instance.addPopulation(amount);
        assertEquals(instance.getPopulation(), 110);
        
    }


    @org.junit.Test
    public void testMultiplyVillagerCount() {
       
        float amount = 1.211F;
        Village instance = new Village(100);
        instance.multiplyPopulation(amount);
        assertEquals(instance.getPopulation(), 121);
        
    }


    @org.junit.Test
    public void testSubstractDoesntGoBelowOne() {
        System.out.println("substractFromVillagerCount");
        Village instance = new Village(100);
        int amount = 100;
        instance.subtractPopulation(amount);
        assertTrue(instance.getPopulation() == 1);
        
    }
    
    @org.junit.Test
    public void testSubstractionWorksCorrectly(){
        Village instance = new Village(100);
        int amount = 10;
        instance.subtractPopulation(amount);
        assertEquals(instance.getPopulation(), 90);
    }


    @org.junit.Test
    public void testDividePopulationDoesntGoBelowOne() {
        Village instance = new Village(100);
        float amount = 0.5F;
        instance.dividePopulation(amount);
        assertTrue(instance.getPopulation() == 1);
    }
    
    @org.junit.Test
    public void testDividePopulationDividesProperly(){
        Village instance = new Village();
        float amount = 20.01F;
        instance.dividePopulation(amount);
        assertEquals(instance.getPopulation(), 96 );
    }
    

    /*** end population tests ***/
    
    /*** Begin building tests ***/
    
    @org.junit.Test
    public void testBeginConstructionStartsConstructing(){
        Village i = new Village(this.b);
        i.beginConstruction();
        assertEquals(i.getBuildingsUnderConstruction()[0].getType, "MeadHall" );
    }
    
}

