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
public class AddressCompanyTest {

    public static AddressCompany instance = new AddressCompany();

    public AddressCompanyTest() {

    }

    @BeforeClass
    public static void setUpClass() {
                instance.setState("Nuevo Leon");
                instance.setCity("Monterrey");
                instance.setNumber(7);
                instance.setStreet("Hidalgo");
                instance.setZipcode("82000");
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
     * Test of setState method, of class AddressCompany.
     */
    @Test
    public void testSetState() {
        System.out.println("setState");
        String state = "Nuevo Leon";
        instance.setState(state);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of getState method, of class AddressCompany.
     */
    @Test
    public void testGetState() {
        System.out.println("getState");
        String expResult = "Nuevo Leon";
        String result = instance.getState();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getCity method, of class AddressCompany.
     */
    @Test
    public void testGetCity() {
        System.out.println("getCity");
        String expResult = "Monterrey";
        String result = instance.getCity();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of setCity method, of class AddressCompany.
     */
    @Test
    public void testSetCity() {
        System.out.println("setCity");
        String city = "Monterrey";
        instance.setCity(city);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of getStreet method, of class AddressCompany.
     */
    @Test
    public void testGetStreet() {
        System.out.println("getStreet");
        String expResult = "Hidalgo";
        String result = instance.getStreet();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setStreet method, of class AddressCompany.
     */
    @Test
    public void testSetStreet() {
        System.out.println("setStreet");
        String street = "Hidalgo";
        instance.setStreet(street);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of getZipcode method, of class AddressCompany.
     */
    @Test
    public void testGetZipcode() {
        System.out.println("getZipcode");
        String expResult = "82000";
        String result = instance.getZipcode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setZipcode method, of class AddressCompany.
     */
    @Test
    public void testSetZipcode() {
        System.out.println("setZipcode");
        String zipcode = "82000";
        instance.setZipcode(zipcode);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getNumber method, of class AddressCompany.
     */
    @Test
    public void testGetNumber() {
        System.out.println("getNumber");
        int expResult = 7;
        int result = instance.getNumber();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setNumber method, of class AddressCompany.
     */
    @Test
    public void testSetNumber() {
        System.out.println("setNumber");
        int number = 7;
        instance.setNumber(number);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class AddressCompany.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        String expResult = "[Nuevo Leon, Monterrey, Hidalgo, 7\n C.P.:82000]";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

}
