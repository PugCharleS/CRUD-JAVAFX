/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import static Modelo.AddressCompanyTest.instance;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author e-emgarza
 */
public class CompanyTest {
    
    public static Company instance = new Company();
    
    public CompanyTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        instance.setPhone("12345");
        instance.setName("Alvaro");
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getId method, of class Company.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        int expResult = 0;
        int result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of getName method, of class Company.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        String expResult = "Alvaro";
        String result = instance.getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of getPhone method, of class Company.
     */
    @Test
    public void testGetPhone() {
        System.out.println("getPhone");
        String expResult = "12345";
        String result = instance.getPhone();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of getAddressCompany method, of class Company.
     */
    @Test
    public void testGetAddressCompany() {
        System.out.println("getAddressCompany");
        AddressCompany expResult = null;
        AddressCompany result = instance.getAddressCompany();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of getCeoCompany method, of class Company.
     */
    @Test
    public void testGetCeoCompany() {
        System.out.println("getCeoCompany");
        CEOCompany expResult = null;
        CEOCompany result = instance.getCeoCompany();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Company.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        String expResult = "Company{id=0, name=Alvaro, phone=12345, CEOCompany=null, addressCompany=null}";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }
    
}