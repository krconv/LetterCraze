package scandium.lettercraze.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import scandium.lettercraze.model.LevelProgress;
import scandium.lettercraze.model.Model;
import scandium.lettercraze.view.Application;

/**
 * This class handles the beginning of the user's word selection in LetterCraze. It uses 
 * a mouse press event to determine which tile starts the currently selected word. 
 * @author Scandium
 * @date 12/5/16
 */
public class SelectTileController extends MouseAdapter{
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
    int row;
    int col;

    /**
     * This constructor instantiates a new SelectTileController. It accepts the LetterCraze model
     * and the LetterCraze GUI.
     * @param model The entire LetterCraze model.
     * @param app The entire LetterCraze GUI.
     */
    public SelectTileController(Model model, Application app, int row, int col) {
        this.model = model;
        this.app = app;
        this.row = row;
        this.col = col;
    }

    /**
     * This function handles a mouse press on one of the board Squares in the Level Player. 
     * This signals the start of a word selection by the user. It creates a new word entity in
     * the LetterCraze Model and highlights the selected board square in the GUI.
     * 
     * <p>Entry Condition: The user generates a mouse press on a board square</p>
     * <p>Exit Condition: The board square has been selected and a new word has been started</p>
     * 
     * @param me The mouse event for this controller
     */
    @Override
    public void mousePressed(MouseEvent me){
    	LevelProgress progress = model.getProgress().getCurrentLevelProgress();
    	/* Check that the game is being played */
    	if(!progress.isPlaying()) return;

    	// select the square
    	progress.getLevel().getBoard().selectSquare(row, col);
    	
    	// refresh the display
    	app.getLevelPlayer().getBoardView().refresh();
    }
}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    