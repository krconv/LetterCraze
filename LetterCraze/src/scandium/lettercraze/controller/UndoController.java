package scandium.lettercraze.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import scandium.lettercraze.action.IAction;
import scandium.lettercraze.model.Model;
import scandium.lettercraze.undo.UndoManager;
import scandium.lettercraze.view.Application;

/**
 * @author Scandium
 */
public class UndoController implements ActionListener {
    Model model;
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
     * Handles the undo button being clicked on.
     * @param The event arguments.
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