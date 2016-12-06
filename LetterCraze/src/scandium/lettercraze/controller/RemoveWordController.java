package scandium.lettercraze.controller;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import scandium.common.tool.WordDictionary;
import scandium.lettercraze.model.Model;
import scandium.lettercraze.view.Application;

/**
 * This class handles the removal of a word from the board in LetterCraze. It is initiated 
 * when the user releases their pressed mouse. If the selected word is valid, it is removed
 * from the board and new tiles are inserted to fill its place (dependent on level type). 
 * Both the model and the GUI are updated to reflect these changes. 
 * @author Scandium
 * @date 12/5/2016
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
     * The dictionary of possible words for puzzle and lightning levels. With this, the 
     * controller has the ability to determine if a word is valid. 
     */
    WordDictionary dictionary;



    /**
     * This constructor instantiates a new RemoveWordController. It accepts the LetterCraze 
     * model, the LetterCraze GUI, and a word dictionary.
     * @param model The Entire LetterCraze model.
     * @param app The Entire LetterCraze GUI
     * @param dictionary A word dictionary
     */
    public RemoveWordController(Model model, Application app, WordDictionary dictionary) {
        this.model = model;
        this.app = app;
        this.dictionary = dictionary;
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
    	
    	/* Adjust View */
    	for(int i = 0; i < 6; i++){
    		for(int j = 0; j < 6; j++){
    			app.getLevelPlayer().getBoardView().getJLabel(i, j).setBackground(Color.WHITE);
    		}
    	}
    }

}