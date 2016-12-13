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

/**
 * Test class for {@link scandium.common.model.Star}.
 */
public class StarTest extends TestCase {
	
	/**
	 * Test method for {@link scandium.common.model.Star#Star()}.
	 */
	public void testStar() {
		// test that the default constructor sets the threshold to be valid
		Star star = new Star();
		assertTrue(star.isValid());
		
		// test that the threshold constructor sets the threshold
		star = new Star(1);
		assertEquals(1, star.getThreshold());
		assertTrue(star.isValid());
		
		// test that giving the constructor a negative threshold sets the valid and is invalid
		star = new Star(-1);
		assertEquals(-1, star.getThreshold());
		assertFalse(star.isValid());
	}

	/**
	 * Test method for {@link scandium.common.model.Star#getThreshold()} and {@link scandium.common.model.Star#setThreshold(int)}.
	 */
	public void testGetSetThreshold() {
		// test that we can set and get a valid threshold
		Star star = new Star();
		star.setThreshold(0);
		assertEquals(0, star.getThreshold());
		
		// test that you can set a positive threshold
		star.setThreshold(1);
		assertEquals(1, star.getThreshold());
		
		// test that you can set a negative threshold
		star.setThreshold(-1);
		assertEquals(-1, star.getThreshold());
		
	}

	/**
	 * Test method for {@link scandium.common.model.Star#isObtained(int)}.
	 */
	public void testIsObtained() {
		// test that a score larger than and equal to threshold is obtained
		Star star = new Star(5);
		assertTrue(star.isObtained(5));
		assertTrue(star.isObtained(6));
		
		// test that a score lower than the threshold is not obtained
		assertFalse(star.isObtained(4));
		assertFalse(star.isObtained(-1));
		
		// test that checking is obtained when the threshold is negative is correct
		star.setThreshold(-1);
		assertTrue(star.isObtained(0));
	}

	/**
	 * Test method for {@link scandium.common.model.Star#isValid()}.
	 */
	public void testIsValid() {
		// test that an initialized threshold is valid
		Star star = new Star(5);
		assertTrue(star.isValid());
		
		// test that an uninitialized threshold is invalid
		star = new Star(-1);
		assertFalse(star.isValid());
	}
}
