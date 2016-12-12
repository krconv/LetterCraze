package scandium.lettercraze.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import scandium.lettercraze.action.IAction;
import scandium.lettercraze.model.Model;
import scandium.lettercraze.undo.UndoManager;
import scandium.lettercraze.view.Application;

/**
 * This controller handles the undoing of an IAction object. It allows the player to undo their 
 * previous move when the undo button is clicked.
 * @author Scandium
 * @date 12/10/2016
 */
public class UndoController implements ActionListener {
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
     * Creates a new controller which will undo the last move.
     * @param model The model.
     * @param app The application.
     */
    public UndoController(Model model, Application app) {
    	this.model = model;
    	this.app = app;
    }

    /**
     * This function handles the undoing of an IAction.
     * 
     * <p>Entry Condition: The user clicked on the undo button.</p>
     * <p>Exit Condition: The previous move was undone (if it exits).</p>
     * 
     * @param ae The action Event representing the user's mouse click on the undo button.
     */
    public void actionPerformed(ActionEvent ae) {    	
    	if (model.getProgress().getCurrentLevelProgress().isPlaying()) {
	    	// undo the last action
	    	IAction action = UndoManager.instance.removeLastAction();
	    	if (action != null)
	    		action.undo();
	    	
	    	// refresh the view
	    	app.getLevelPlayer().refresh();
    	}
    }

}