package main;

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
public class AlgorithmTest {
    
    public AlgorithmTest() {
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
     * Test of hasMoreCitiesToGo method, of class Algorithm.
     */
    @Test
    public void testHasMoreCitiesToGo() {
        System.out.println("hasMoreCitiesToGo");
        Algorithm instance = new Algorithm(5);
        instance.initializeVisitedCities();
        instance.visitedCities[0] = true;
        instance.visitedCities[1] = true;
        instance.visitedCities[2] = true;
        instance.visitedCities[3] = true;
        instance.visitedCities[4] = true;
        boolean expResult = false;
        boolean result = instance.hasMoreCitiesToGo();
        assertEquals(expResult, result);
    }


    /**
     * Test of getShortestWay method, of class Algorithm.
     */
    @Test
    public void testGetShortestWay() {
        System.out.println("getShortestWay");
        int[][] input = {{0, 44, 1, 53, 48},
                        {94, 0, 41, 1, 44},
                        {54, 44, 0, 111, 1},
                        {1, 42, 46, 0, 1},
                        {111, 1, 48, 45, 0}};
        int size = 5;
        String expResult = "Длина пути: 5 | Путь: -> 1 -> 3 -> 5 -> 2 -> 4 -> 1";
        StringBuilder result = Algorithm.getShortestWay(input, size);
        assertEquals(expResult, result.toString());
    }
}
