/**
 * 
 */
package com.Finra.Rokin.Test;


import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.validator.*;

import junit.framework.Assert;

/**
 * @author rokin.gala
 *
 */
public class PhoneNumberControllerTest {

	PhoneNumberObj phObj;
	@Before
    public void setUp() throws Exception {
		PhoneNumberObj phObj= new PhoneNumberObj();
	}
	@After
    public void tearDown() throws Exception {
		phObj =null;
    }

	/**
	 * This Method would Unit Test the Implementation Method of 
	 * Generating the Alpha numeric combination for the input Phone number.
	 * This test would also test any input number string 
	 * and Provide alhpa numeric combination.
	 * @throws Exception
	 */
    @Test
    public void testletterCombinations() throws Exception {
    	
    	String inputPhNo="9834210";
    	PhoneNumberController phnC= new PhoneNumberController();
    	List<String> output= phnC.letterCombinations(inputPhNo);
    	assertNotNull(output);
    	
    }
}
