package scandium.levelbuilder.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import scandium.levelbuilder.model.LevelBuilderState;
import scandium.levelbuilder.model.Model;
import scandium.levelbuilder.view.Application;

public class LeaveLevelEditorController extends MouseAdapter{
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
     * This constructor instantiates a new copy of the LeaveLevelEditorController.
     * @param model The entire LevelBuilder Controller.
     * @param app The entire LevelBuilder application
     */
    public LeaveLevelEditorController(Model model, Application app) {
        this.model = model;
        this.app = app;
    }

    
    /**
     * This function handles the user's mouse click on the Leave Level button.
     * @param me The Mouse Event representing the user's mouse click on the leave level button.
     */
    public void mouseClicked(MouseEvent me) {
    	model.setEditProgress(null);
    	model.setLevelBuilderState(LevelBuilderState.MainMenu);
    	app.refresh();
    }
}