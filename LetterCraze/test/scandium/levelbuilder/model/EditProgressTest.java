/**
 * 
 */
package scandium.levelbuilder.model;

import junit.framework.TestCase;
import scandium.common.model.*;

/**
 * @author Connor
 *
 */
public class EditProgressTest extends TestCase {
	private LightningLevel original;
	private EditProgress ep;
	private Board board;
	
	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
		board = new Board(true, GravityDirection.Up);
		original = new LightningLevel();
		original.setBoard(board);
		original.setName("Hello");
		original.setTimeLimit(5000);
		ep = new EditProgress(original);
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	/**
	 * Test method for {@link scandium.levelbuilder.model.EditProgress#getOriginal()}.
	 */
	public void testGetOriginal() {
		assertEquals(original, ep.getOriginal());
	}

	/**
	 * Test method for {@link scandium.levelbuilder.model.EditProgress#getModified()}.
	 */
	public void testGetModified() {
		assertNotNull(ep.getModified().getBoard());
		assertEquals(5000, ((LightningLevel) ep.getModified()).getTimeLimit()); //GetTimeLimit Not defined for type Level
		assertEquals("Hello", ep.getModified().getName());
	}

}
