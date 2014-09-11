package folkvillage;

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

    /**
     * 
     */
    public void addingVillagersWorks()
    { 
        
        assertTrue( true );
    }

    /**
     * Test of getVillagerCount method, of class Village.
     */
    @org.junit.Test
    public void testGetVillagerCount() {
        System.out.println("getVillagerCount");
        Village instance = new Village();
        int expResult = 100;
        int result = instance.getVillagerCount();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setVillagerCount method, of class Village.
     */
    @org.junit.Test
    public void testSetVillagerCount() {
        System.out.println("setVillagerCount");
        int x = 0;
        Village instance = new Village();
        instance.setVillagerCount(x);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addToVillagerCount method, of class Village.
     */
    @org.junit.Test
    public void testAddToVillagerCount() {
        System.out.println("addToVillagerCount");
        int amount = 0;
        Village instance = new Village();
        instance.addToVillagerCount(amount);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of multiplyVillagerCount method, of class Village.
     */
    @org.junit.Test
    public void testMultiplyVillagerCount() {
        System.out.println("multiplyVillagerCount");
        float amount = 0.0F;
        Village instance = new Village();
        instance.multiplyVillagerCount(amount);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of substractFromVillagerCount method, of class Village.
     */
    @org.junit.Test
    public void testSubstractFromVillagerCount() {
        System.out.println("substractFromVillagerCount");
        int amount = 0;
        Village instance = new Village();
        instance.substractFromVillagerCount(amount);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of divideVillagerCount method, of class Village.
     */
    @org.junit.Test
    public void testDivideVillagerCount() {
        System.out.println("divideVillagerCount");
        float amount = 0.0F;
        Village instance = new Village();
        instance.divideVillagerCount(amount);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}

