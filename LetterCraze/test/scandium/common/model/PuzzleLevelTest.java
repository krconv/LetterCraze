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
public class PuzzleLevelTest extends TestCase {
	private PuzzleLevel level;
	private Board board;
	private LetterDictionary dictionary;

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
		board = new Board(true, GravityDirection.Up);
		dictionary = new LetterDictionary(100);
		
		level = new PuzzleLevel();
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	/**
	 * Test method for {@link scandium.common.model.PuzzleLevel#getType()}.
	 */
	public void testGetType() {
		assertEquals("Puzzle", level.getType());
	}

	/**
	 * Test method for {@link scandium.common.model.PuzzleLevel#getMaxNumWords()} and {@link scandium.common.model.PuzzleLevel#setMaxNumWords(int)}.
	 */
	public void testGetSetMaxNumWords() {
		level.setMaxNumWords(20);
		assertEquals(20, level.getMaxNumWords());
	}

	/**
	 * Test method for {@link scandium.common.model.PuzzleLevel#copy()}.
	 */
	public void testCopy() {
		level.setName("This is a level");
		level.setMaxNumWords(20);
		level.setBoard(board);
		PuzzleLevel levelCopy = level.copy();
		assertEquals("This is a level", levelCopy.getName());
		assertNotNull(levelCopy.getBoard());
		assertEquals(20, levelCopy.getMaxNumWords());
	}

	/**
	 * Test method for {@link scandium.common.model.PuzzleLevel#isValid()}.
	 */
	public void testIsValid() { //Test more of this.
		level.setMaxNumWords(20);
		level.setName("This is a level");
		level.setBoard(board);
		level.getStar(0).setThreshold(1);
		level.getStar(1).setThreshold(2);
		level.getStar(2).setThreshold(3);
		board.fillEmptySquares(dictionary);
		assertTrue(level.isValid());
	}
}
