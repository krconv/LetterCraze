/**
 * 
 */
package scandium.lettercraze.undo;

import junit.framework.TestCase;
import scandium.common.model.*;
import scandium.common.tool.LetterDictionary;
import scandium.common.tool.WordDictionary;
import scandium.lettercraze.action.*;
import scandium.lettercraze.model.*;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author Connor
 *
 */
public class UndoManagerTest extends TestCase {
	private RemoveWordAction action;
	private UndoManager um;
	private LevelProgress lp;
	private Word word;
	private Board board;
	private Star[] stars;
	private LightningLevel level;
	private LetterDictionary dictionary;
	private WordDictionary wd;
	
	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
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
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		super.tearDown();
		um = UndoManager.instance;
	}

	/**
	 * Test method for {@link scandium.lettercraze.undo.UndoManager#recordAction(scandium.lettercraze.action.IAction)} and {@link scandium.lettercraze.undo.UndoManager#removeLastAction()}.
	 */
	public void testRecordRemoveAction() {
		um.recordAction(action);
		assertEquals(action, um.removeLastAction());
	}

	/**
	 * Test method for {@link scandium.lettercraze.undo.UndoManager#removeAllActions()}.
	 */
	public void testRemoveAllActions() {
		assertFalse(um.removeAllActions());
		um.recordAction(action);
		assertTrue(um.removeAllActions());
		assertFalse(um.removeAllActions());
	}

	/**
	 * Test method for {@link scandium.lettercraze.undo.UndoManager#forgetActions()}.
	 */
	public void testForgetActions() {
		um.recordAction(action);
		um.forgetActions();
	}

}
