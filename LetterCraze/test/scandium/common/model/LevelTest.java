  /**
 * 
 */
package scandium.common.model;

import junit.framework.TestCase;

/**
 * @author Connor
 *
 */
public class LevelTest extends TestCase {
	private Level level;
	private Board board;
	private Star[] stars;

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
		board = new Board(true, GravityDirection.Up);
		stars = new Star[3];
		
		//level = new Level("Level1", board, stars);
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	/**
	 * Test method for {@link scandium.common.model.Level#Level()}.
	 */
	public void testLevel() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link scandium.common.model.Level#Level(java.lang.String, scandium.common.model.Board, scandium.common.model.Star[])}.
	 */
	public void testLevelStringBoardStarArray() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link scandium.common.model.Level#getName()}.
	 */
	public void testGetName() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link scandium.common.model.Level#setName(java.lang.String)}.
	 */
	public void testSetName() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link scandium.common.model.Level#getBoard()}.
	 */
	public void testGetBoard() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link scandium.common.model.Level#setBoard(scandium.common.model.Board)}.
	 */
	public void testSetBoard() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link scandium.common.model.Level#getStars()}.
	 */
	public void testGetStars() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link scandium.common.model.Level#getType()}.
	 */
	public void testGetType() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link scandium.common.model.Level#copy()}.
	 */
	public void testCopy() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link scandium.common.model.Level#isValid()}.
	 */
	public void testIsValid() {
		fail("Not yet implemented");
	}

}
