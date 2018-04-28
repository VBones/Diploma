/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyVers;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Влад
 */
public class RealisationTest {
    
    public RealisationTest() {
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

    /**
     * Test of start method, of class Realisation.
     */
    @Test
    public void testStart() {
        System.out.println("start");
        Realisation instance = new Realisation();
        instance.start();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getProbabilityForCity method, of class Realisation.
     */
    @Test
    public void testGetProbabilityForCity() {
        System.out.println("getProbabilityForCity");
        int city = 0;
        Realisation instance = new Realisation();
        instance.getProbabilityForCity(city);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of chooseCity method, of class Realisation.
     */
    @Test
    public void testChooseCity() {
        System.out.println("chooseCity");
        int currentCity = 0;
        Realisation instance = new Realisation();
        int expResult = 2;
        int result = instance.chooseCity(currentCity);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of updateSumProbability method, of class Realisation.
     */
    @Test
    public void testUpdateSumProbability() {
        System.out.println("updateSumProbability");
        Realisation instance = new Realisation();
        instance.updateSumProbability();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class Realisation.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        Realisation.main(args);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
