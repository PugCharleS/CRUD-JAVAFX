/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author charl
 */
public class CEOCompanyTest {
    public static CEOCompany instance = new CEOCompany();
    public CEOCompanyTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        instance.setName("Alvaro");
        instance.setPhone("9876543210");
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
     * Test of getName method, of class CEOCompany.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        String expResult = "Alvaro";
        String result = instance.getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setName method, of class CEOCompany.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String name = "Alvaro";
        instance.setName(name);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getPhone method, of class CEOCompany.
     */
    @Test
    public void testGetPhone() {
        System.out.println("getPhone");
        String expResult = "9876543210";
        String result = instance.getPhone();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setPhone method, of class CEOCompany.
     */
    @Test
    public void testSetPhone() {
        System.out.println("setPhone");
        String phone = "9876543210";
        instance.setPhone(phone);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class CEOCompany.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        String expResult = "[Alvaro, \nPhone = 9876543210]";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
}