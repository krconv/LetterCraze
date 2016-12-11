package scandium.lettercraze.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import scandium.common.model.Board;
import scandium.common.tool.LetterDictionary;
import scandium.lettercraze.model.Model;
import scandium.lettercraze.undo.UndoManager;
import scandium.lettercraze.view.Application;

/**
 * This class handles the reseting of the board in a LetterCraze Game. 
 * It is initiated by a user mouse click on the reset button. For a theme level, 
 * The board is returned to its initial configuration. For a lightning Level, the
 * tiles are regenerated but the timer is not refreshed. For a puzzle level, 
 * the tiles are regenerated. 
 * @author Scandium
 * @date 12/6/2016
 */
public class ResetLevelController extends MouseAdapter{

	/** 
	 * The entire LetterCraze model. With this, the controller has access to all entities
	 * that it may need. 
	 */
	Model model;
	/** 
	 * The entire LetterCraze GUI. With this, the controller has access to all widgets
	 * that it may need. 
	 */
    Application app;
    /**
     * A instance of a LetterDictionary. With this, the controller can populate the board's tiles.
     */
    LetterDictionary dictionary;


    /**
     * This constructor instantiates a new instance of the Reset level Controller.
     * @param model The entire LetterCraze Model
     * @param app The entire LetterCraze GUI
     */
    public ResetLevelController(Model model, Application app) {
        this.model = model;
        this.app = app;
        this.dictionary = new LetterDictionary();
    }

    /**
     * This function handles the user's Mouse click on the reset board button.
     * It resets the level specific fields (except for the lightning level's timer),
     * removes all found words, and creates a new auto generation of tiles (unless
     * the level is a theme level, in which the tiles are generated as before 
     * 
     * <p>Entry Condition:  </p>
     * <p>Exit Condition: </p>
     * 
     * @param me The user's mouse click on the reset button
     */
    @Override
    public void mouseClicked(MouseEvent me) {
    	if (model.getProgress().getCurrentLevelProgress().isPlaying()) {
	    	// reset the board
	    	Board board = model.getProgress().getCurrentLevelProgress().getLevel().getBoard();
	    	if (board.shouldRegenerate()) {
	    		board.clearExistingTiles();
	    		board.fillEmptySquares(dictionary);
	    	} else {
	    		UndoManager.instance.removeAllActions();
	    	}
	    	board.removeSelectedWord();
	    	
	    	// reset the players progress
	    	model.getProgress().getCurrentLevelProgress().reset();
	    	
	    	// Clear the Move actions from the undo manager
	    	UndoManager.instance.forgetActions();
	    	
	    	// refresh the player
	    	app.getLevelPlayer().refresh();
    	}
    } 	

}