/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ *
 * ~~~~~ Team Scandium                                                                           *
 * ~~~~~ CS 3733                                                                                 *
 * ~~~~~ Project: Level Builder                                                                  *
 * ~~~~~ Created: November 28th                                                                  *
 * ~~~~~ Class: StarTest                                                                         *
 * ~~~~~        This class tests the source class scandium.common.model.Star                     *
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
package scandium.common.model;

import junit.framework.TestCase;

public class StarTest extends TestCase {
	
	/**~~~~~                                                                               ~~~~~ *
	 * testDefaultConstructor()                                                                  *
	 * This function tests the default constructor method of the star class                      *
	 * ~~~~~                                                                               ~~~~~ */
	public void testDefaultConstructor(){
		Star star = new Star();
		assertEquals(star.threshold, -1);
	}
	
	/**~~~~~                                                                               ~~~~~ *
	 * testConstructor()                                                                         *
	 * This function tests the constructor method of the star class that takes a threshold param *
	 * ~~~~~                                                                               ~~~~~ */
	public void testConstructor(){
		int threshold = 10;
		Star star = new Star(threshold);
		assertEquals(star.threshold, threshold);
	}
	
	/**~~~~~                                                                               ~~~~~ *
	 * testGetThreshold()                                                                        *
	 * This function tests the function Star.getThreshold()                                      *
	 * ~~~~~                                                                               ~~~~~ */
	public void testGetThreshold(){
		int threshold_orig = 10;
		Star star = new Star(threshold_orig);
		int threshold_new = star.getThreshold();
		assertEquals(threshold_orig, threshold_new);
	}
	
	/**~~~~~                                                                               ~~~~~ *
	 * testSetThreshold()                                                                        *
	 * This function tests the function Star.setThreshold()                                      *
	 * ~~~~~                                                                               ~~~~~ */
	public void testSetThreshold(){
		int threshold_set = 10;
		Star star = new Star();
		star.setThreshold(threshold_set);
		assertEquals(threshold_set, star.threshold);
	}
	
	/**~~~~~                                                                               ~~~~~ *
	 * testIsObtained()                                                                          *
	 * This function tests the function Star.IsObtained()                                        *
	 * ~~~~~                                                                               ~~~~~ */
	public void testIsObtained(){
		int threshold = 10;
		Star star = new Star(threshold);
		/* Test false when below threshold */
		assertFalse(star.isObtained(threshold - 1));
		/* Test true when above threshold */
		assertTrue(star.isObtained(threshold + 1));
		/* Test true when at threshold */
		assertTrue(star.isObtained(threshold));
	}
	
	/**~~~~~                                                                               ~~~~~ *
	 * testIsValid()                                                                             *
	 * This function tests the function Star.isValid()                                           *
	 * ~~~~~                                                                               ~~~~~ */
	public void testIsValid(){
		Star star = new Star();
		/* Test false when unitialized */
		assertFalse(star.isValid());
		/* Test false when initialized to an incorrect value */
		star.setThreshold(-5);
		assertFalse(star.isValid());
		/* Test True when initialized to a proper value */
		star.setThreshold(10);
		assertTrue(star.isValid());
	}
}
