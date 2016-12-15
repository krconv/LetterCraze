package scandium.levelbuilder.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import scandium.common.model.PuzzleLevel;
import scandium.levelbuilder.model.EditProgress;
import scandium.levelbuilder.model.LevelBuilderState;
import scandium.levelbuilder.model.Model;
import scandium.levelbuilder.view.Application;

/**
 * This class handles the user's request to create a new level. 
 * It creates a new level and and new EditProgress for the model. 
 * It updates the view to show the levelEditor view.
 * @author Scandium
 */
public class CreateNewLevelController extends MouseAdapter{

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
     * This constructor creates a new instance of the CreateNewLevelController.
     * It passes in the entire LevelBuilder model and the EntireLevelBuilder GUI.
     * @param m The LevelBuilder Model.
     * @param a The LevelBuilder application.
     */
    public CreateNewLevelController(Model m, Application a) {
        this.model = m;
        this.app = a;
    }

    
    /**
     * This function handles the user's mouse press on the create new level button.
     * It creates a new level and a new edit progress for the model and updates the view accordingly. 
     * @param me The MouseEvent representing the user's mousePress.
     */
    public void mouseClicked(MouseEvent me) {
    	/* Initialize to puzzle level */
    	PuzzleLevel level = new PuzzleLevel();
    	EditProgress progress = new EditProgress(level);
    	model.setEditProgress(progress);
    	app.getLevelEditor().setSelectedLevel(level.getType());
    	app.getLevelEditor().clearFields();
    	app.getLevelEditor().setEditProgress(progress);
    	model.setLevelBuilderState(LevelBuilderState.Editor);
    	/* refresh view */
    	app.refresh();
    }

}