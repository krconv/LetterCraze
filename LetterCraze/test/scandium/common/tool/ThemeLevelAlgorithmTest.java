/**
 * 
 */
package scandium.common.tool;

import java.util.ArrayList;

import junit.framework.TestCase;
import scandium.common.model.*;

/**
 * @author Connor
 *
 */
public class ThemeLevelAlgorithmTest extends TestCase {
	private ThemeLevel level;
	private long seed;
	private Board board;
	private Star[] stars;
	private ArrayList<String> themeWords;

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
		board = new Board(false, GravityDirection.Up);
		stars = new Star[3];
		for (int i = 0; i < 3; i++){
			stars[i] = new Star(20+i);
		}
		themeWords = new ArrayList<String>();
		themeWords.add("apple");
		themeWords.add("banana");
		themeWords.add("orange");
		for (int i = 0; i < 6; i++){
        	for (int j = 0; j < 6; j++){
        		board.getSquare(i, j).setEnabled(true);
        	}
        }
		level = new ThemeLevel("ThemeLevel", board, stars, "Fruits", themeWords);
		seed = 1;
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	/**
	 * Test method for {@link scandium.common.tool.ThemeLevelTileGenerationAlgorithm#populateThemeLevelWithTiles(scandium.common.model.ThemeLevel, long)}.
	 */
	public void testPopulateThemeLevelWithTiles() {
		ThemeLevelTileGenerationAlgorithm.populateThemeLevelWithTiles(level, seed);
		board = level.getBoard();
		assertEquals("A", board.getSquare(0, 0).getTile().getContent());
		assertEquals("P", board.getSquare(0, 1).getTile().getContent());
		assertEquals("P", board.getSquare(0, 2).getTile().getContent());
		assertEquals("L", board.getSquare(0, 3).getTile().getContent());
		assertEquals("E", board.getSquare(0, 4).getTile().getContent());
		assertEquals("G", board.getSquare(0, 5).getTile().getContent());
		assertEquals("B", board.getSquare(1, 0).getTile().getContent());
		assertEquals("O", board.getSquare(1, 1).getTile().getContent());
		assertEquals("R", board.getSquare(1, 2).getTile().getContent());
		assertEquals("A", board.getSquare(1, 3).getTile().getContent());
		assertEquals("N", board.getSquare(1, 4).getTile().getContent());
		assertEquals("E", board.getSquare(1, 5).getTile().getContent());
		assertNotNull(board.getSquare(2, 0).getTile().getContent());
		assertEquals("A", board.getSquare(2, 1).getTile().getContent());
		assertEquals("N", board.getSquare(2, 2).getTile().getContent());
		assertEquals("A", board.getSquare(2, 3).getTile().getContent());
		assertEquals("N", board.getSquare(2, 4).getTile().getContent());
		assertEquals("A", board.getSquare(2, 5).getTile().getContent());
		assertNotNull(board.getSquare(3, 0).getTile().getContent());
		assertNotNull(board.getSquare(3, 1).getTile().getContent());
		assertNotNull(board.getSquare(3, 2).getTile().getContent());
		assertNotNull(board.getSquare(3, 3).getTile().getContent());
		assertNotNull(board.getSquare(3, 4).getTile().getContent());
		assertNotNull(board.getSquare(3, 5).getTile().getContent());
		assertNotNull(board.getSquare(4, 0).getTile().getContent());
		assertNotNull(board.getSquare(4, 1).getTile().getContent());
		assertNotNull(board.getSquare(4, 2).getTile().getContent());
		assertNotNull(board.getSquare(4, 3).getTile().getContent());
		assertNotNull(board.getSquare(4, 4).getTile().getContent());
		assertNotNull(board.getSquare(4, 5).getTile().getContent());
		assertNotNull(board.getSquare(5, 0).getTile().getContent());
		assertNotNull(board.getSquare(5, 1).getTile().getContent());
		assertNotNull(board.getSquare(5, 2).getTile().getContent());
		assertNotNull(board.getSquare(5, 3).getTile().getContent());
		assertNotNull(board.getSquare(5, 4).getTile().getContent());
		assertNotNull(board.getSquare(5, 5).getTile().getContent());
		//So, fun fact, it'll always put the themeWords in the same spot, but populates with new letters every time elsewhere.
	}

}
