/**
 * WordTest.java
 * 
 * @author Scandium
 */
package scandium.common.model;

import junit.framework.TestCase;
import scandium.common.tool.LetterDictionary;

/**
 * Test class for {@link scandium.common.model.Word}.
 */
public class WordTest extends TestCase {
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
	 * Test method for {@link scandium.common.model.Word#Word(scandium.common.model.BoardSquare)}.
	 */
	public void testWord() {
		// test that the constructor captures the correct information
		board.fillEmptySquares(dictionary);		
		Word word = new Word(board.getBoardSquare(1, 1));
		assertEquals(1, word.getTiles().size());
		assertEquals(board.getBoardSquare(1, 1).getTile(), word.getTiles().get(0));
		assertEquals(1, word.getBoardSquares().size());
		assertEquals(board.getBoardSquare(1, 1), word.getBoardSquares().get(0));
		
		// test that an exception is thrown if an empty square is selected
		board.clearExistingTiles();
		try {
			word = new Word(board.getBoardSquare(1, 1));
			fail();
		} catch (IllegalArgumentException e) {
			
		} catch (Exception e) {
			fail(); // should have been an illegal argument
		}
		// test that an exception is thrown if a disabled square is selected
		board.getBoardSquare(1, 1).setEnabled(false);
		try {
			word = new Word(board.getBoardSquare(1, 1));
			fail();
		} catch (IllegalArgumentException e) {
			
		} catch (Exception e) {
			fail(); // should have been an illegal argument
		}
		// test that an exception is thrown if a null square is selected
		try {
			word = new Word(null);
			fail();
		} catch (NullPointerException e) {
			
		} catch (Exception e) {
			fail(); // should have been a null pointer exception
		}
	}

	/**
	 * Test method for {@link scandium.common.model.Word#generateString()}.
	 */
	public void testGenerateString() {
		board.fillEmptySquares(dictionary);
		// test that the the first selected square is reflected in the string
		Word word = new Word(board.getBoardSquare(1, 1));
		assertTrue(word.generateString().equalsIgnoreCase(board.getBoardSquare(1, 1).getTile().getContent()));
		
		// test that the generate string is correct for multiple selected squares
		word.addSelectedBoardSquare(board.getBoardSquare(1, 2));
		word.addSelectedBoardSquare(board.getBoardSquare(1, 3));
		assertTrue(word.generateString().equalsIgnoreCase(
				board.getBoardSquare(1, 1).getTile().getContent() +
				board.getBoardSquare(1, 2).getTile().getContent() +
				board.getBoardSquare(1, 3).getTile().getContent()));
	}

	/**
	 * Test method for {@link scandium.common.model.Word#calculateScore()}.
	 */
	public void testCalculateScore() {
		board.fillEmptySquares(dictionary);
		// test that the the first selected square is reflected in the score
		Word word = new Word(board.getBoardSquare(1, 1));
		assertEquals(board.getBoardSquare(1, 1).getTile().getScore(), word.calculateScore());
		
		// test that the score is correct for 3 selected squares
		word.addSelectedBoardSquare(board.getBoardSquare(1, 2));
		word.addSelectedBoardSquare(board.getBoardSquare(1, 3));
		assertEquals(board.getBoardSquare(1, 1).getTile().getScore() +
				board.getBoardSquare(1, 2).getTile().getScore() +
				board.getBoardSquare(1, 3).getTile().getScore(),
				word.calculateScore());
		
		// test that the score is correct for 5 selected squares
		word.addSelectedBoardSquare(board.getBoardSquare(1, 4));
		word.addSelectedBoardSquare(board.getBoardSquare(1, 5));
		assertEquals((board.getBoardSquare(1, 1).getTile().getScore() +
				board.getBoardSquare(1, 2).getTile().getScore() +
				board.getBoardSquare(1, 3).getTile().getScore() +
				board.getBoardSquare(1, 4).getTile().getScore() +
				board.getBoardSquare(1, 5).getTile().getScore()) *
				3,
				word.calculateScore());
	}

	/**
	 * Test method for {@link scandium.common.model.Word#addSelectedBoardSquare(scandium.common.model.BoardSquare)}.
	 */
	public void testAddSelectedBoardSquare() {
		// test that selecting a square captures the correct information
		board.fillEmptySquares(dictionary);
		Word word = new Word(board.getBoardSquare(1, 1));
		word.addSelectedBoardSquare(board.getBoardSquare(1, 2));
		assertEquals(2, word.getTiles().size());
		assertEquals(board.getBoardSquare(1, 2).getTile(), word.getTiles().get(1));
		assertEquals(2, word.getBoardSquares().size());
		assertEquals(board.getBoardSquare(1, 2), word.getBoardSquares().get(1));
		
		// test selecting an already selected square
		assertFalse(word.addSelectedBoardSquare(board.getBoardSquare(1, 1)));
		assertFalse(word.addSelectedBoardSquare(board.getBoardSquare(1, 2)));
		// the number of selected tiles and board squares shouldn't have changed
		assertEquals(2, word.getTiles().size());
		assertEquals(board.getBoardSquare(1, 2).getTile(), word.getTiles().get(1));
		assertEquals(2, word.getBoardSquares().size());
		assertEquals(board.getBoardSquare(1, 2), word.getBoardSquares().get(1));
		
		// test that an exception is thrown if an empty square is selected
		board.clearExistingTiles();
		try {
			word.addSelectedBoardSquare(board.getBoardSquare(1, 3));
			fail();
		} catch (IllegalArgumentException e) {
			
		} catch (Exception e) {
			fail(); // should have been an illegal argument
		}
		// test that an exception is thrown if a disabled square is selected
		board.getBoardSquare(1, 3).setEnabled(false);
		try {
			word.addSelectedBoardSquare(board.getBoardSquare(1, 3));
			fail();
		} catch (IllegalArgumentException e) {
			
		} catch (Exception e) {
			fail(); // should have been an illegal argument
		}
		// test that an exception is thrown if a null square is selected
		try {
			word.addSelectedBoardSquare(null);
			fail();
		} catch (NullPointerException e) {
			
		} catch (Exception e) {
			fail(); // should have been a null pointer exception
		}
		
		// the number of selected tiles and board squares shouldn't have changed
		assertEquals(2, word.getTiles().size());
		assertEquals(board.getBoardSquare(1, 2).getTile(), word.getTiles().get(1));
		assertEquals(2, word.getBoardSquares().size());
		assertEquals(board.getBoardSquare(1, 2), word.getBoardSquares().get(1));
	}
}
