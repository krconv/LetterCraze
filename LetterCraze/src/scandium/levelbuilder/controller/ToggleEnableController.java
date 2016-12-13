package scandium.levelbuilder.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import scandium.common.model.BoardSquare;
import scandium.common.model.Level;
import scandium.levelbuilder.model.EditProgress;
import scandium.levelbuilder.model.Model;
import scandium.levelbuilder.view.Application;

/**
 * This controller handles the toggling of board squares in the level builder. 
 * @author Scandium
 * @date 12/13/16
 */
public class ToggleEnableController extends MouseAdapter{
	/** 
	 * The entire LevelBuilder model. With this, the controller has access to all entities
	 * that it may need. 
	 */
	Model model;
	/** 
	 * The entire LevelBuilder GUI. With this, the controller has access to all widgets
	 * that it may need. 
	 */
    Application app;
    /**
     * The row of this board square
     */
    int row;
    /**
     * The column of this board square
     */
    int col;
    
    /**
     * This constructor instantiates a new ToggleEnableController.
     * @param model The entire LevelBuilder model.
     * @param app The entire LevelBuilder application.
     * @param row The row of this BoardSquare.
     * @param col The Column of this BoardSquare.
     */
    public ToggleEnableController(Model model, Application app, int row, int col) {
    	this.model = model;
    	this.app = app;
    	this.row = row;
    	this.col = col;
    }

    /**
     * This function handles the user's mouse click on a board square. It toggles
     * the selected board square.
     * @param Mme The MouseEvent representing the mouseClick
     */
    public void mouseClicked(MouseEvent me) {
    	//finding boardSquare
    	EditProgress progress = model.getEditProgress();
    	Level current = progress.getModified();
    	BoardSquare board_square = current.getBoard().getSquare(row, col);
    	
    	//enable/disable toggle logic
    	if(board_square.isEnabled() == true){
    		board_square.setEnabled(false);
    	}
    	else{
    		board_square.setEnabled(true);
    	}
    	
    	//refresh the display
    	app.refresh();
    }
    
}
