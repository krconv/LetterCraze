/**
 * 
 */
package scandium.common.tool;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.Callable;

import junit.framework.TestCase;

/**
 * @author Connor
 *
 */
public class TimeLevelRestrictorTest extends TestCase {
	private int tl;
	private TimeLevelRestrictor tlr;
	int foo;
	Callable<Void> callback;
	
	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
		tl = 1;
		tlr = new TimeLevelRestrictor(tl);
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	/**
	 * Test method for {@link scandium.common.tool.TimeLevelRestrictor#start()} and {@link scandium.common.tool.TimeLevelRestrictor#stop()}.
	 */
	public void testStartStop() {
		assertFalse(tlr.isRestricting());
		tlr.start();
		assertTrue(tlr.isRestricting());
		foo = Integer.parseInt(tlr.getValue());
		assertTrue(foo > 0);
		tlr.stop();
		assertFalse(tlr.isRestricting());
		foo = Integer.parseInt(tlr.getValue());
		assertTrue(foo == 0);
	}

	/**
	 * Test method for {@link scandium.common.tool.TimeLevelRestrictor#getLabel()}.
	 */
	public void testGetLabel() {
		assertEquals("Time Left", tlr.getLabel());
	}

	/**
	 * Test method for {@link scandium.common.tool.TimeLevelRestrictor#getValue()}.
	 */
	public void testGetValue() {
		tlr.start();
		assertEquals("1", tlr.getValue());
		tlr.stop();
	}

	/**
	 * Test method for {@link scandium.common.tool.TimeLevelRestrictor#getValueUnit()}.
	 */
	public void testGetValueUnit() {
		tlr.start();
		assertEquals("second", tlr.getValueUnit());
		tlr.stop();
		tlr = new TimeLevelRestrictor(5);
		tlr.start();
		assertEquals("seconds", tlr.getValueUnit());
		tlr.stop();
	}

	/**
	 * Test method for {@link scandium.common.tool.LevelRestrictor#restrict()}.
	 */
	public void testRestrict() {
		tlr.start();
		assertFalse(tlr.restrict());
		tlr.stop();
		assertFalse(tlr.restrict());
	}

	/**
	 * Test method for {@link scandium.common.tool.LevelRestrictor#setOnValueChanged(java.util.concurrent.Callable)}.
	 */
	public void testSetOnValueChanged() {
		tlr.setOnValueChanged(callback);
		tlr.valueChanged();
	}
}
