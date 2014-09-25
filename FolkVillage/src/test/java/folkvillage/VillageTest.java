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
        HashMap<Resource, Integer> r = new HashMap();
        r.put(Resource.GOLD, 200);
        r.put(Resource.WOOD, 200);
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
        Village village = new Village(100);
        assertFalse(village.setPopulation(0));
    }
    
    public void testSetPopulationSetsPopulationTo1IfArgumentBelowOne(){
        Village village = new Village(100);
        village.setPopulation(0);
        assertEquals(1, village.getPopulationAmount());
    }

    @org.junit.Test
    public void testAddToVillagerCount() {
        
        int amount = 10; 
        Village instance = new Village(100);
        instance.addPopulation(amount);
        assertEquals(instance.getPopulationAmount(), 110);
        
    }


    @org.junit.Test
    public void testMultiplyVillagerCount() {
       
        float amount = 1.211F;
        Village instance = new Village(100);
        instance.multiplyPopulation(amount);
        assertEquals(instance.getPopulationAmount(), 121);
        
    }


    @org.junit.Test
    public void testSubstractDoesntGoBelowOne() {
        System.out.println("substractFromVillagerCount");
        Village instance = new Village(100);
        int amount = 100;
        instance.subtractPopulation(amount);
        assertTrue(instance.getPopulationAmount() == 1);
        
    }
    
    @org.junit.Test
    public void testSubstractionWorksCorrectly(){
        Village instance = new Village(100);
        int amount = 10;
        instance.subtractPopulation(amount);
        assertEquals(instance.getPopulationAmount(), 90);
    }


    @org.junit.Test
    public void testDividePopulationDoesntGoBelowOne() {
        Village instance = new Village(100);
        float amount = 0.5F;
        instance.dividePopulation(amount);
        assertTrue(instance.getPopulationAmount() == 1);
    }
    
    @org.junit.Test
    public void testDividePopulationDividesProperly(){
        Village instance = new Village();
        float amount = 20.01F;
        instance.dividePopulation(amount);
        assertEquals(instance.getPopulationAmount(), 96 );
    }
    

    /*** end population tests ***/
    
    /*** Begin building tests ***/
    
    /*@org.junit.Test
    
    public void testBeginConstructionStartsConstructing(){
        Village village = new Village(this.b);
        village.beginConstruction(new MeadHall("Flying Goose"));
       assertEquals(village.getBuildingsUnderConstruction().get(0).getType(), "MeadHall" );
    }
    */
}
 
