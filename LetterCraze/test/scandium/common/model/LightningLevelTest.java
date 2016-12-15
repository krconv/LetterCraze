/**
 * 
 */
package scandium.common.model;

import junit.framework.TestCase;
import scandium.common.tool.LetterDictionary;

/**
 * @author Connor
 *
 */
public class LightningLevelTest extends TestCase {
	private LightningLevel level;
	private Board board;
	private Star[] stars;
	private LetterDictionary dictionary;

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
		board = new Board(true, GravityDirection.Up);
		stars = new Star[3];
		dictionary = new LetterDictionary(100);
		
		level = new LightningLevel();
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	/**
	 * Test method for {@link scandium.common.model.LightningLevel#getType()}.
	 */
	public void testGetType() {
		assertEquals("Lightning", level.getType());
	}


	/**
	 * Test method for {@link scandium.common.model.LightningLevel#setTimeLimit(int)} and {@link scandium.common.model.LightningLevel#getTimeLimit()}.
	 */
	public void testGetSetTimeLimit() {
		level.setTimeLimit(5000);
		assertEquals(5000, level.getTimeLimit());
	}

	/**
	 * Test method for {@link scandium.common.model.LightningLevel#copy()}.
	 */
	public void testCopy() {
		LightningLevel levelCopy = level.copy();
		assertEquals("", levelCopy.getName());
		assertEquals(0, levelCopy.getTimeLimit());
		level.setName("This is a level");
		level.setTimeLimit(5000);
		level.setBoard(board);
		levelCopy = level.copy();
		assertEquals("This is a level", levelCopy.getName());
		assertNotNull(levelCopy.getBoard());
		assertEquals(5000, levelCopy.getTimeLimit());
	}
	

	/**
	 * Test method for {@link scandium.common.model.Level#setName(java.lang.String)} and {@link scandium.common.model.Level#getName()}.
	 */
	public void testGetSetName() {
		level.setName("This is a level");
		assertEquals("This is a level", level.getName());
	}

	/**
	 * Test method for {@link scandium.common.model.Level#setBoard(scandium.common.model.Board)} and {@link scandium.common.model.Level#getBoard()}.
	 */
	public void testGetSetBoard() {
		level.setBoard(board);
		assertEquals(board, level.getBoard());
	}
	
	/**
	 * Test method for {@link scandium.common.model.Level#getStars()}.
	 */
	public void testGetStars() {
		LightningLevel level2 = new LightningLevel("Hi", board, stars, 5000);
		assertEquals(stars, level2.getStars());
	}

	/**
	 * Test method for {@link scandium.common.model.LightningLevel#isValid()}.
	 */
	public void testIsValid() {
		level.setTimeLimit(5000);
		level.setName("This is a level");
		level.setBoard(board);
		level.getStar(0).setThreshold(1);
		level.getStar(1).setThreshold(2);
		level.getStar(2).setThreshold(3);
		board.fillEmptySquares(dictionary);
		assertTrue(level.isValid());
	}

}
