/**
 * BoardSquareTest.java
 * 
 * @author Scandium
 */
package scandium.common.model;

import junit.framework.TestCase;

/**
 * Test class for {@link scandium.common.model.BoardSquare}.
 */
public class BoardSquareTest extends TestCase {
	private Board board;

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
		board = new Board(true, GravityDirection.Down);
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	/**
	 * Test method for {@link scandium.common.model.BoardSquare#BoardSquare(int, int, scandium.common.model.Board, boolean)}.
	 */
	public void testBoardSquare() {
		// make sure that the square has the information passed to it stored
		board = new Board(true, GravityDirection.Down);
		BoardSquare square = board.getSquare(1, 1);
		assertEquals(1, square.getRow());
		assertEquals(1, square.getCol());
		assertEquals(board, square.getBoard());
		
	}

	/**
	 * Test method for {@link scandium.common.model.BoardSquare#getTile()} and {@link scandium.common.model.BoardSquare#setTile(scandium.common.model.Tile)}.
	 */
	public void testGetSetTile() {
		BoardSquare square = board.getSquare(0, 0);
		
		// set the tile and make sure get tile returns the tile we gave it
		Tile tile = new Tile("A", 1);
		square.setTile(tile);
		assertEquals(tile, square.getTile());
		
		// test that clearing the square removes the tile
		square.removeTile();
		assertNull(square.getTile());
	}

	/**
	 * Test method for {@link scandium.common.model.BoardSquare#isEnabled()} and {@link scandium.common.model.BoardSquare#setEnabled(boolean)}.
	 */
	public void testIsSetEnabled() {
		BoardSquare square = board.getSquare(0, 0);
		
		// set the enabled flag and make sure get returns the value we give it
		square.setEnabled(true);
		assertEquals(true, square.isEnabled());
		square.setEnabled(false);
		assertEquals(false, square.isEnabled());
	}

	/**
	 * Test method for {@link scandium.common.model.BoardSquare#isEmpty()}.
	 */
	public void testIsEmpty() {
		// test that a non-empty square is not empty
		BoardSquare square = board.getSquare(0, 0);
		square.setTile(new Tile("A", 1));
		assertFalse(square.isEmpty());
		
		// test that setting the squares value to empty makes it empty
		square.removeTile();
		assertTrue(square.isEmpty());
	}
}
