/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package folkvillage;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;
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
public class PopulationTest {
    
    public PopulationTest() {
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
    
    /*** BEGIN POPULATION TESTS ***/
    @org.junit.Test
    public void testSetPopulationReturnsFalseIfArgumentBelowOne(){
        Population i = new Population(100);
        assertFalse(i.setPopulationAmount(0));
    }
    
    public void testSetPopulationSetsPopulationTo1IfArgumentBelowOne(){
        Population i = new Population(100);
        i.setPopulationAmount(0);
        assertEquals(1, i.getPopulationAmount());
    }

    @org.junit.Test
    public void testAddToPopulationrCount() {
        
        int amount = 10; 
        Population instance = new Population(100);
        instance.addPopulation(amount);
        assertEquals(instance.getPopulationAmount(), 110);
        
    }


    @org.junit.Test
    public void testMultiplyPopulationrCount() {
       
        float amount = 1.211F;
        Population instance = new Population(100);
        instance.multiplyPopulation(amount);
        assertEquals(instance.getPopulationAmount(), 121);
        
    }


    @org.junit.Test
    public void testSubstractDoesntGoBelowOne() {
        System.out.println("substractFromPopulationrCount");
        Population instance = new Population(100);
        int amount = 100;
        instance.subtractPopulation(amount);
        assertTrue(instance.getPopulationAmount() == 1);
        
    }
    
    @org.junit.Test
    public void testSubstractionWorksCorrectly(){
        Population instance = new Population(100);
        int amount = 10;
        instance.subtractPopulation(amount);
        assertEquals(instance.getPopulationAmount(), 90);
    }


    @org.junit.Test
    public void testDividePopulationDoesntGoBelowOne() {
        Population instance = new Population(100);
        float amount = 0.5F;
        try{
            instance.dividePopulation(amount);
        } catch (Exception e ){
            fail("Exception thrown during testing");
        }
        assertTrue(instance.getPopulationAmount() == 1);
    }
    
    @org.junit.Test
    public void testDividePopulationDividesProperly(){
        Population instance = new Population(500);
        float amount = 20.01F;
        try{
            instance.dividePopulation(amount);
        } catch (Exception e ){
            fail("Exception thrown during testing");
        }
        assertEquals(instance.getPopulationAmount(), 476 );
    }
    
    @org.junit.Test
    public void testSetGrowthrateDoesntAllowNegativeNumbers(){
        Population instance = new Population(100, 1.2F);
        float amount = -1F;
        instance.setGrowthrate(amount);
        assertEquals(instance.getGrowthrate(), 1.2F);
    }
    
    @org.junit.Test
    public void testAddGrowthrateDoesntAllowNegativeNumbers(){
        Population instance = new Population(100, 1.2F);
        float amount = -1F;
        instance.addGrowthrate(amount);
        assertEquals(instance.getGrowthrate(), 1.2F);
    }
    
    @org.junit.Test
    public void testsubstractGrowthrateDoesntAllowNegativeNumbers(){
        Population instance = new Population(100, 1.2F);
        float amount = -1F;
        instance.substractGrowthrate(amount);
        assertEquals(instance.getGrowthrate(), 1.2F);
    }
    
    public void testTickUpdatesPopulationCorrectly(){
        Population instance = new Population(100, 1.333F);
        instance.tick();
        assertEquals(instance.getGrowthrate(), 133);
    }
    
    
}
