/**
 * 
 */
package scandium.common.tool;

import junit.framework.TestCase;
import scandium.common.model.Board;
import scandium.common.model.GravityDirection;
import scandium.common.model.LightningLevel;
import scandium.common.model.Star;
import scandium.common.model.Tile;
import scandium.common.model.Word;
import scandium.lettercraze.action.RemoveWordAction;
import scandium.lettercraze.model.LevelProgress;

/**
 * @author Connor
 *
 */
public class WordLevelRestrictorTest extends TestCase {
	private int wl;
	private WordLevelRestrictor wlr;
	int foo;

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
		wl = 1;
		wlr = new WordLevelRestrictor(wl);
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	/**
	 * Test method for {@link scandium.common.tool.WordLevelRestrictor#start()}.
	 */
	public void testStart() {
		assertFalse(wlr.isRestricting());
		wlr.start();
		assertTrue(wlr.isRestricting());
		foo = Integer.parseInt(wlr.getValue());
		assertTrue(foo > 0);
		wlr.stop();
		assertFalse(wlr.isRestricting());
	}

	/**
	 * Test method for {@link scandium.common.tool.WordLevelRestrictor#recordAction(scandium.lettercraze.action.IAction)} and {@link scandium.common.tool.WordLevelRestrictor#removeAction(scandium.lettercraze.action.IAction)}.
	 */
	public void testRecordRemoveAction() {
		RemoveWordAction action;
		LightningLevel level;
		LetterDictionary dictionary;
		Star[] stars;
		LevelProgress lp;
		Word word;
		WordDictionary wd;
		Board board;
		
		dictionary = new LetterDictionary(1);
		wd = WordDictionary.instance;
		board = new Board(false, GravityDirection.Up);
		stars = new Star[3];
		for (int i = 0; i < 3; i++){
			stars[i] = new Star(20+i);
		}
		for (int i = 0; i < 6; i++){
        	for (int j = 0; j < 6; j++){
        		board.getSquare(i, j).setEnabled(true);
        	}
        }
		board.fillEmptySquares(dictionary);
		board.getSquare(0, 0).setTile(new Tile("A", 2));
		board.getSquare(0, 1).setTile(new Tile("N", 2));
		board.getSquare(0, 2).setTile(new Tile("D", 3));
		word = new Word(board.getSquare(0, 0));
		word.addSelectedBoardSquare(board.getSquare(0, 1));
		word.addSelectedBoardSquare(board.getSquare(0, 2));
		level = new LightningLevel("ThemeLevel", board, stars, 10000);
		lp = new LevelProgress(level);
		lp.setPlaying(true);
		action = new RemoveWordAction(lp, word, wd, dictionary);
		
		wlr = new WordLevelRestrictor(2);
		
		assertFalse(wlr.isRestricting());
		wlr.start();
		assertTrue(wlr.isRestricting());
		wlr.recordAction(action);
		assertEquals(1, Integer.parseInt(wlr.getValue()));
		wlr.removeAction(action);
		assertEquals(2, Integer.parseInt(wlr.getValue()));
		wlr.recordAction(action);
		assertEquals(1, Integer.parseInt(wlr.getValue()));
		populateSpecificBoardSquares(board, word, dictionary);
		lp.getLevel().setBoard(board);
		wlr.recordAction(action);
		assertEquals(0, Integer.parseInt(wlr.getValue()));
		wlr.removeAction(action);
		assertEquals(0, Integer.parseInt(wlr.getValue()));
		wlr.stop();
	}

	/**
	 * Test method for {@link scandium.common.tool.WordLevelRestrictor#getLabel()}.
	 */
	public void testGetLabel() {
		assertEquals("Words Left", wlr.getLabel());
	}

	/**
	 * Test method for {@link scandium.common.tool.WordLevelRestrictor#getValue()}.
	 */
	public void testGetValue() {
		wlr.start();
		assertEquals("1", wlr.getValue());
		wlr.stop();
	}

	/**
	 * Test method for {@link scandium.common.tool.WordLevelRestrictor#getValueUnit()}.
	 */
	public void testGetValueUnit() {
		wlr.start();
		assertEquals("word", wlr.getValueUnit());
		wlr.stop();
		wlr = new WordLevelRestrictor(5);
		wlr.start();
		assertEquals("words", wlr.getValueUnit());
		wlr.stop();
	}
	
	/**
	 * Helper method to populate BoardSquares with predetermined letters for easy removal.
	 * @param board The board whose squares you wish to change.
	 * @param word The word you wish to form again.
	 * @param ld The LetterDictionary for filling the boards squares initially.
	 */
	private void populateSpecificBoardSquares(Board board, Word word, LetterDictionary ld){
		board.fillEmptySquares(ld);
		board.getSquare(0, 0).setTile(new Tile("A", 2));
		board.getSquare(0, 1).setTile(new Tile("N", 2));
		board.getSquare(0, 2).setTile(new Tile("D", 3));
		word = new Word(board.getSquare(0, 0));
		word.addSelectedBoardSquare(board.getSquare(0, 1));
		word.addSelectedBoardSquare(board.getSquare(0, 2));
	}
}
