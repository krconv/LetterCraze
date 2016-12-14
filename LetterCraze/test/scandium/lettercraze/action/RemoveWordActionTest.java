package scandium.lettercraze.action;

import junit.framework.TestCase;
import scandium.common.model.Board;
import scandium.common.model.PuzzleLevel;
import scandium.common.model.Tile;
import scandium.common.model.Word;
import scandium.common.tool.LetterDictionary;
import scandium.common.tool.WordDictionary;
import scandium.lettercraze.model.LevelProgress;

/**
 * This class tests the scandium.lettercraze.action.RemoveWordAction class
 * @author scandium
 * @date 14/12/16
 */
public class RemoveWordActionTest extends TestCase{
	protected RemoveWordAction RWA;
	
	protected void setUp(){
		PuzzleLevel level = new PuzzleLevel();
		LetterDictionary letter_dictionary = new LetterDictionary();
		level.getBoard().getSquare(0,0).setTile(new Tile ("C", 3));
		level.getBoard().getSquare(0, 1).setTile(new Tile("A", 2));
		level.getBoard().getSquare(0, 2).setTile(new Tile("T", 2));
		Word word = new Word(level.getBoard().getSquare(0,0));
		word.addSelectedBoardSquare(level.getBoard().getSquare(0, 1));
		word.addSelectedBoardSquare(level.getBoard().getSquare(0, 2));
		LevelProgress level_progress = new LevelProgress(level);
		WordDictionary word_dictionary = WordDictionary.instance;
		RWA = new RemoveWordAction(level_progress, word, word_dictionary, letter_dictionary);
	}
	
	protected void tearDown(){
		RWA = null;
	}
	
	/**
	 * This function tests the isValid method. 
	 */
	public void testIsValid(){
		assertTrue(RWA.isValid());
		RWA.progress.getLevel().getBoard().getSquare(0, 4).setTile(new Tile("Z", 10));
		RWA.word.addSelectedBoardSquare(RWA.progress.getLevel().getBoard().getSquare(0, 4));
		RWA.generatedString = RWA.word.generateString();
		assertFalse(RWA.isValid());
	}
	
	/** 
	 * This function tests the execute method. 
	 */
	public void testExecute(){
		assertTrue(RWA.execute());
		Board board = RWA.progress.getLevel().getBoard();
		/* Assert that the board has been populated */
		for(int i = 0; i < 6; i ++){
			for(int j = 0; j
					< 6; j++){
				assertTrue(board.getSquare(i, j).getTile() != null);
			}
		}
		/* validate that the score is updated */
		assertEquals(RWA.progress.getScore(), 7);
		/* validate that the word was added to found words */
		assertEquals(RWA.progress.getFoundWords().get(0), "CAT");
	}
	
	/**
	 * This function tests the undo method.
	 */
	public void testUndo(){
		assertTrue(RWA.execute());
		assertTrue(RWA.undo());
		/* validate that cat is in the first 3 board squares */
		Board board = RWA.progress.getLevel().getBoard();
		assertEquals(board.getSquare(0, 0).getTile().getContent(), "C");
		assertEquals(board.getSquare(0, 1).getTile().getContent(), "A");
		assertEquals(board.getSquare(0, 2).getTile().getContent(), "T");
		/* Validate that the score is back to normal */
		assertEquals(RWA.progress.getScore(), 0);
		/* Validate that there are no found words */
		assertEquals(RWA.progress.getFoundWords().size(), 0);
	}
	
	
}
