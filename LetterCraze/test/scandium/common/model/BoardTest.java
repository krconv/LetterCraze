/**
 * BoardTest.java
 * 
 * @author Scandium
 */
package scandium.common.model;

import java.util.List;

import junit.framework.TestCase;
import scandium.common.tool.LetterDictionary;

/**
 * Test class for {@link scandium.common.model.Board}.
 */
public class BoardTest extends TestCase {
	private Board board;
	private LetterDictionary dictionary;
	
	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
		board = new Board(true, GravityDirection.Down);
		dictionary = new LetterDictionary(100);
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	/**
	 * Test method for {@link scandium.common.model.Board#Board(boolean, scandium.common.model.GravityDirection)}.
	 */
	public void testBoard() {
		// validate that the squares got created
		for (int row = 0; row < 6; row++) {
			for (int col = 0; col < 6; col++) {
				BoardSquare square = board.getSquare(row, col);
				assertNotNull(square);
				assertTrue(square.isEnabled());
				assertTrue(square.isEmpty());
				assertBoardSquarePosition(row, col, square);
			}
		}
		
		// validate that the values that we passed in were saved
		assertEquals(true, board.shouldRegenerate());
		assertEquals(GravityDirection.Down, board.getGravityDirection());
		
		// and with different values
		board = new Board(false, GravityDirection.Up);
		assertEquals(false, board.shouldRegenerate());
		assertEquals(GravityDirection.Up, board.getGravityDirection());
	}

	/**
	 * Test method for selecting a word.
	 */
	public void testValidSelection() {
		board.fillEmptySquares(dictionary);
		
		// the selection should currently be null
		assertNull(board.getSelectedWord());
		
		// make a valid selection
		assertTrue(board.selectSquare(1, 1)); // starting point
		assertTrue(board.selectSquare(1, 2)); // to the right
		assertTrue(board.selectSquare(2, 3)); // down/right
		assertTrue(board.selectSquare(3, 3)); // down
		assertTrue(board.selectSquare(4, 2)); // down/left
		assertTrue(board.selectSquare(4, 1)); // left
		assertTrue(board.selectSquare(3, 0)); // up/left
		assertTrue(board.selectSquare(2, 0)); // up
		assertTrue(board.selectSquare(1, 1)); // up/right
		
		// make sure all of the selections were captured
		Word word = board.getSelectedWord();
		assertNotNull(word);
		List<BoardSquare> squares = word.getBoardSquares();
		assertBoardSquarePosition(1, 1, squares.get(0));
		assertBoardSquarePosition(1, 2, squares.get(1));
		assertBoardSquarePosition(2, 3, squares.get(2));
		assertBoardSquarePosition(3, 3, squares.get(3));
		assertBoardSquarePosition(4, 2, squares.get(4));
		assertBoardSquarePosition(4, 1, squares.get(5));
		assertBoardSquarePosition(3, 0, squares.get(6));
		assertBoardSquarePosition(2, 0, squares.get(7));
		assertBoardSquarePosition(1, 1, squares.get(8));
		
		// test deselecting a word
		board.deselectWord();
	}
	

	/**
	 * Test method for selecting a word in an invalid way.
	 */
	public void testInvalidSelection() {
		// test selecting a board square that doesn't have a tile
		assertFalse(board.selectSquare(1, 1));
		assertNull(board.getSelectedWord());
		
		// test selecting boards squares that aren't consecutive
		board.fillEmptySquares(dictionary);
		board.selectSquare(4, 3);
		board.selectSquare(3, 3);
		// selecting any square on the outside rim should fail
		for (int row = 0; row < 6; row++) {
			for (int col = 0; col < 6; col++) {
				if (row == 0 || row == 5 || col == 0 || col == 5) {
					assertFalse(board.selectSquare(row, col));
				}
			}
		}
		List<BoardSquare> selection = board.getSelectedWord().getBoardSquares();
		assertEquals(1, selection.size());
		assertBoardSquarePosition(3, 3, selection.get(0));
		board.deselectWord();
		
		// test selecting squares which are already selected
		board.selectSquare(1, 1);
		board.selectSquare(1, 2);
		board.selectSquare(2, 2);
		assertFalse(board.selectSquare(1, 1));
		selection = board.getSelectedWord().getBoardSquares();
		assertEquals(3, selection.size());
		assertBoardSquarePosition(1, 1, selection.get(0));
		assertBoardSquarePosition(1, 2, selection.get(1));
		assertBoardSquarePosition(2, 2, selection.get(2));
		board.deselectWord();
		
		// test selecting a square out of bounds
		try {
			board.selectSquare(-1, 0);
			fail(); // should have thrown exception
		} catch (IndexOutOfBoundsException e) {
		} catch (Exception e) {
			fail(); // should have thrown illegal argument exception
		}
		try {
			board.selectSquare(0, -1);
			fail(); // should have thrown exception
		} catch (IndexOutOfBoundsException e) {
		} catch (Exception e) {
			fail(); // should have thrown illegal argument exception
		}
		try {
			board.selectSquare(6, 0);
			fail(); // should have thrown exception
		} catch (IndexOutOfBoundsException e) {
		} catch (Exception e) {
			fail(); // should have thrown illegal argument exception
		}
		try {
			board.selectSquare(0, 6);
			fail(); // should have thrown exception
		} catch (IndexOutOfBoundsException e) {
		} catch (Exception e) {
			fail(); // should have thrown illegal argument exception
		}
		
		// test selecting a board square that isn't on the board
		try {
			board.selectSquare(new BoardSquare(2, 2, new Board(true, GravityDirection.Down), true));
			fail(); // should have thrown exception
		} catch (IllegalArgumentException e) {
		} catch (Exception e) {
			fail(); // should have thrown illegal argument exception
		}
		
		// test selecting a board square that is disabled
		board.deselectWord();
		board.getSquare(1, 1).setEnabled(false);
		assertFalse(board.selectSquare(1, 1));
		assertNull(board.getSelectedWord());
		board.selectSquare(1, 0);
		assertFalse(board.selectSquare(1, 1));
		selection = board.getSelectedWord().getBoardSquares();
		assertEquals(1, selection.size());
		assertBoardSquarePosition(1, 0, selection.get(0));
	}

	/**
	 * Test method for {@link scandium.common.model.Board#insertWord(scandium.common.model.Word)}.
	 */
	public void testInsertWord() {
		// test that inserting a word with no tiles does nothing
		board.selectSquare(1, 1);
		assertFalse(board.insertWord(board.getSelectedWord()));
		board.deselectWord();
		
		// test that inserting a valid word puts the tiles in the correct place by removing a word,
		// applying gravity and then reinserting the word
		board.fillEmptySquares(dictionary);
		String[][] tiles = new String[6][6];
		board.clearExistingTiles();
		board.fillEmptySquares(new LetterDictionary(1));
		for (int row = 0; row < 6; row++) {
			for (int col = 0; col < 6; col++) {
				tiles[row][col] = board.getSquare(row, col).getTile().getContent();
			}
		}
		board.selectSquare(3, 3);
		board.selectSquare(3, 4);
		board.selectSquare(4, 5);
		Word word = board.getSelectedWord();
		board.removeSelectedWord();
		board.applyGravity();
		assertBoardTiles(tiles, board, false);
		board.insertWord(word);
		assertBoardTiles(tiles, board, true);
	}

	/**
	 * Test method for {@link scandium.common.model.Board#removeSelectedWord()}.
	 */
	public void testRemoveSelectedWord() {
		// test that removing when nothing is selected does nothing
		assertFalse(board.removeSelectedWord());
		board.fillEmptySquares(dictionary);
		assertFalse(board.removeSelectedWord());
		
		// test that removing a selected word removes it from the board
		board.selectSquare(1, 1);
		board.selectSquare(1, 2);
		assertTrue(board.removeSelectedWord());
		assertNull(board.getSelectedWord());
		assertTrue(board.getSquare(1, 1).isEmpty());
		assertTrue(board.getSquare(1, 2).isEmpty());
		
	}

	/**
	 * Test method for {@link scandium.common.model.Board#applyGravity()}.
	 */
	public void testApplyGravity() {
		// applying gravity on an empty board shouldn't change anything
		assertFalse(board.applyGravity());
		
		// apply gravity to four items in every direction
		board.fillEmptySquares(dictionary);
		board.selectSquare(2, 2);
		board.selectSquare(2, 3);
		board.selectSquare(3, 3);
		board.selectSquare(3, 2);
		Word word = board.getSelectedWord();
		
		// in down direction
		board.deselectWord();
		board.clearExistingTiles();
		board.insertWord(word);
		assertTrue(board.applyGravity());
		board.selectSquare(4, 2);
		board.selectSquare(4, 3);
		board.selectSquare(5, 3);
		board.selectSquare(5, 2);
		assertTrue(board.getSquare(2, 2).isEmpty());
		assertTrue(board.getSquare(2, 3).isEmpty());
		assertTrue(board.getSquare(3, 3).isEmpty());
		assertTrue(board.getSquare(3, 2).isEmpty());
		assertEquals(board.getSelectedWord().generateString(), word.generateString());
		board.clearExistingTiles();
		
		// in left direction
		board.setGravityDirection(GravityDirection.Left);
		board.deselectWord();
		board.clearExistingTiles();
		board.insertWord(word);
		assertTrue(board.applyGravity());
		board.selectSquare(2, 0);
		board.selectSquare(2, 1);
		board.selectSquare(3, 1);
		board.selectSquare(3, 0);
		assertTrue(board.getSquare(2, 2).isEmpty());
		assertTrue(board.getSquare(2, 3).isEmpty());
		assertTrue(board.getSquare(3, 3).isEmpty());
		assertTrue(board.getSquare(3, 2).isEmpty());
		assertEquals(board.getSelectedWord().generateString(), word.generateString());
		
		// in up direction
		board.setGravityDirection(GravityDirection.Up);
		board.deselectWord();
		board.clearExistingTiles();
		board.insertWord(word);
		assertTrue(board.applyGravity());
		board.selectSquare(0, 2);
		board.selectSquare(0, 3);
		board.selectSquare(1, 3);
		board.selectSquare(1, 2);
		assertTrue(board.getSquare(2, 2).isEmpty());
		assertTrue(board.getSquare(2, 3).isEmpty());
		assertTrue(board.getSquare(3, 3).isEmpty());
		assertTrue(board.getSquare(3, 2).isEmpty());
		assertEquals(board.getSelectedWord().generateString(), word.generateString());
		
		// in right direction
		board.setGravityDirection(GravityDirection.Right);
		board.deselectWord();
		board.clearExistingTiles();
		board.insertWord(word);
		assertTrue(board.applyGravity());
		board.selectSquare(2, 4);
		board.selectSquare(2, 5);
		board.selectSquare(3, 5);
		board.selectSquare(3, 4);
		assertTrue(board.getSquare(2, 2).isEmpty());
		assertTrue(board.getSquare(2, 3).isEmpty());
		assertTrue(board.getSquare(3, 3).isEmpty());
		assertTrue(board.getSquare(3, 2).isEmpty());
		assertEquals(board.getSelectedWord().generateString(), word.generateString());
		
		// test that disabled squares in the middle of the board are skipped over
		board.setGravityDirection(GravityDirection.Down);
		board.deselectWord();
		board.clearExistingTiles();
		board.insertWord(word);
		board.getSquare(4, 2).setEnabled(false);
		assertTrue(board.applyGravity());
		board.getSquare(4, 2).setEnabled(true);
		board.selectSquare(3, 2);
		board.selectSquare(4, 3);
		board.selectSquare(5, 3);
		board.selectSquare(5, 2);
		assertTrue(board.getSquare(2, 2).isEmpty());
		assertTrue(board.getSquare(2, 3).isEmpty());
		assertTrue(board.getSquare(3, 3).isEmpty());
		assertTrue(board.getSquare(4, 2).isEmpty());
		assertEquals(board.getSelectedWord().generateString(), word.generateString());
		
		// test that disabled squares on the edges act like a barrier
		board.setGravityDirection(GravityDirection.Down);
		board.deselectWord();
		board.clearExistingTiles();
		board.insertWord(word);
		board.getSquare(5, 2).setEnabled(false);
		assertTrue(board.applyGravity());
		board.selectSquare(3, 2);
		board.selectSquare(4, 3);
		board.selectSquare(5, 3);
		board.selectSquare(4, 2);
		assertTrue(board.getSquare(2, 2).isEmpty());
		assertTrue(board.getSquare(2, 3).isEmpty());
		assertTrue(board.getSquare(3, 3).isEmpty());
		assertTrue(board.getSquare(5, 2).isEmpty());
		assertEquals(board.getSelectedWord().generateString(), word.generateString());
	}

	/**
	 * Test method for {@link scandium.common.model.Board#fillEmptySquares(scandium.common.tool.LetterDictionary)}.
	 */
	public void testFillEmptySquares() {
		// test that we can fill the board
		assertTrue(board.fillEmptySquares(dictionary));
		// make sure every square has a tile
		for (int row = 0; row < 6; row++) {
			for (int col = 0; col < 6; col++) {
				assertFalse(board.getSquare(row, col).isEmpty());
			}
		}
				
		// make sure that the board is getting letters from the dictionary
		// by comparing the result of the board with different/same seeds
		String[][] tiles = new String[6][6];
		board.clearExistingTiles();
		board.fillEmptySquares(new LetterDictionary(1));
		for (int row = 0; row < 6; row++) {
			for (int col = 0; col < 6; col++) {
				tiles[row][col] = board.getSquare(row, col).getTile().getContent();
			}
		}
		
		// filling a full board shouldn't change anything (even with a different dictionary)
		assertFalse(board.fillEmptySquares(dictionary));
		assertBoardTiles(tiles, board, true);
		
		// try clearing the board and filling again with an identical dictionary
		board.clearExistingTiles();
		board.fillEmptySquares(new LetterDictionary(1));
		assertBoardTiles(tiles, board, true);
		
		// try clearing the board and filling it with a different dictionary
		board.clearExistingTiles();
		board.fillEmptySquares(new LetterDictionary(2));
		assertBoardTiles(tiles, board, false);
		
		// test filling a board with only some tiles missing
		board.clearExistingTiles();
		board.fillEmptySquares(new LetterDictionary(1));
		board.selectSquare(1, 1);
		board.selectSquare(1, 2);
		board.selectSquare(2, 1);
		board.removeSelectedWord();
		assertTrue(board.fillEmptySquares(dictionary));
		// now make sure the board is full, and only the empty squares have new tiles
		tiles[1][1] = board.getSquare(1, 1).getTile().getContent();
		tiles[1][2] = board.getSquare(1, 2).getTile().getContent();
		tiles[2][1] = board.getSquare(2, 1).getTile().getContent();
		assertBoardTiles(tiles, board, true);
		
		// test that filling the board doesn't add to disabled board squares
		board.getSquare(1,  1).setEnabled(false);
		board.clearExistingTiles();
		board.fillEmptySquares(dictionary);
		assertTrue(board.getSquare(1, 1).isEmpty());
	}

	/**
	 * Test method for {@link scandium.common.model.Board#clearExistingTiles()}.
	 */
	public void testClearExistingTiles() {
		// test clearing an already empty board
		assertFalse(board.clearExistingTiles());
		
		// test clearing a board with all tiles
		board.fillEmptySquares(dictionary);
		assertTrue(board.clearExistingTiles());
		// make sure all of the squares are now empty
		for (int row = 0; row < 6; row++) {
			for (int col = 0; col < 6; col++) {
				assertTrue(board.getSquare(row, col).isEmpty());
			}
		}
		
		// test clearing a board with only one tile on it by selecting a word
		// saving it, clearing the board and then inserting the word back in
		board.fillEmptySquares(dictionary);
		board.selectSquare(3, 3);
		Word word = board.getSelectedWord();
		board.clearExistingTiles();
		board.insertWord(word);
		assertTrue(board.clearExistingTiles());
		// make sure all of the squares are now empty
		for (int row = 0; row < 6; row++) {
			for (int col = 0; col < 6; col++) {
				assertTrue(board.getSquare(row, col).isEmpty());
			}
		}
		
		// test that clearing clears out disabled squares
		board.fillEmptySquares(dictionary);
		board.getSquare(1, 1).setEnabled(false);
		assertFalse(board.getSquare(1, 1).isEmpty());
		board.clearExistingTiles();
		assertTrue(board.getSquare(1, 1).isEmpty());
	}

	/**
	 * Test method for {@link scandium.common.model.Board#deselectWord()}.
	 */
	public void testDeselectWord() {
		// test that we can deselect when there is no selected word
		assertFalse(board.deselectWord());
		assertNull(board.getSelectedWord());
		
		// test that we can deselect a selected word
		board.selectSquare(1, 1);
		board.selectSquare(1, 2);
		assertTrue(board.deselectWord());
		assertNull(board.getSelectedWord());
	}

	/**
	 * Test method for {@link scandium.common.model.Board#isValid()}.
	 */
	public void testIsValid() {
		fail("Not yet implemented");
	}

	/**
	 * Asserts that the given board square has the given position.
	 * @param row The expected row.
	 * @param col The expected column.
	 * @param square The square to assert.
	 */
	private void assertBoardSquarePosition(int row, int col, BoardSquare square) {
		assertEquals(row, square.getRow());
		assertEquals(col, square.getCol());
	}
	
	/**
	 * Asserts that the configuration of a board's tiles matches the expected
	 * string array.
	 * @param tiles The expected tile configuration.
	 * @param board The board to assert.
	 * @param same Whether the expected value should be the same or different from actual.
	 */
	private void assertBoardTiles(String[][] tiles, Board board, boolean same) {
		for (int row = 0; row < 6; row++) {
			for (int col = 0; col < 6; col++) {
				assertFalse(board.getSquare(row, col).isEmpty());
				assertEquals(same, tiles[row][col].equals(board.getSquare(row, col).getTile().getContent()));
			}
		}
	}
}
