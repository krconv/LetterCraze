package scandium.lettercraze.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import scandium.common.model.Word;
import scandium.common.tool.LetterDictionary;
import scandium.lettercraze.action.RemoveWordAction;
import scandium.lettercraze.model.LevelProgress;
import scandium.lettercraze.model.Model;
import scandium.lettercraze.undo.UndoManager;
import scandium.lettercraze.view.Application;

/**
 * This class handles the removal of a word from the board in LetterCraze. It is initiated 
 * when the user releases their pressed mouse. If the selected word is valid, it is removed
 * from the board and new tiles are inserted to fill its place (dependent on level type). 
 * Both the model and the GUI are updated to reflect these changes. 
 * @author Scandium
 */
public class RemoveWordController extends MouseAdapter{

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
     * The Letter Dictionary of all letters and their respective frequencies and score. 
     * With this the controller has the ability to refill non-populated tiles.
     */
    LetterDictionary letter_dictionary;

    /**
     * This constructor instantiates a new RemoveWordController. It accepts the LetterCraze 
     * model, the LetterCraze GUI, and a word dictionary.
     * @param model The Entire LetterCraze model.
     * @param app The Entire LetterCraze GUI
     * @param dictionary The dictionary to generate new tiles using.
     */
    public RemoveWordController(Model model, Application app, LetterDictionary dictionary) {
        this.model = model;
        this.app = app;
        this.letter_dictionary = dictionary;
    }

    /**
     * This function handles a mouse release on one of the board square in the Level Player. 
     * It either removes the tiles from the board (if a valid word) or it simply unselects
     * them. Both the view and the model are updated to reflect this change. 
     * 
     * <p> Entry Condition: The mouse is released on a board square </p>
     * <p> Exit Condition: LetterCraze has been updated to reflect the changes. </p>
     * 
     * @param me The mouse event for this controller
     */
    @Override
    public void mouseReleased(MouseEvent me){
    	LevelProgress progress = model.getProgress().getCurrentLevelProgress();
    	
    	// don't do anything if the game isn't being played
    	if (!progress.isPlaying()) {
    		if (progress.getLevel().getBoard().deselectWord())
    			app.getLevelPlayer().refresh(); // update the board if a word was deselected
    		return;
    	}
    	
		Word selectedWord = progress.getLevel().getBoard().getSelectedWord();
		// if the player has selected a word, see if it is valid
		if (selectedWord != null) {
			RemoveWordAction action = new RemoveWordAction(progress, selectedWord, progress.getLevel().getWordDictionary(), letter_dictionary);
			if (action.isValid()) { // try to execute the remove word and record it if anything changed
				UndoManager.instance.recordAction(action);
				progress.getRestrictor().recordAction(action);
				action.execute();
			}
			progress.getLevel().getBoard().deselectWord();
			// refresh the player with the updates
			app.getLevelPlayer().refresh();
		}
    }

}