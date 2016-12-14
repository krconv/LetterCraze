package scandium.levelbuilder.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import scandium.common.model.Level;
import scandium.levelbuilder.model.Model;
import scandium.levelbuilder.view.Application;

/**
 * This class handles the user's mouse click on the delete level button in the LevelBuilder Main Menu.
 * @author Scandium
 * @Date 13/12/16
 */
public class DeleteLevelController extends MouseAdapter{
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
     * This constructor instantiates a new DeleteLevelController.
     * @param model The EntireLevelBuilder Model
     * @param app The EntireLevelBuilder Application
     */
    public DeleteLevelController(Model model, Application app) {
        this.model = model;
        this.app = app;
    }


    /**
     * This function handles the User's mouseClick on the delete level button. 
     * It Deletes the level from the model, saves it to file, and updates the view. 
     * @param me The MouseEvent representing the user's mouseClick on the delete Level Button
     */
	public void mouseClicked(MouseEvent me) {
		Level level = model.getSelectedLevel();
		if(level == null) return;
		
		/* Remove Level from Model */
		model.getLevels().remove(level);
		model.setSelectedLevel(null);
		/* Remove Level from File */
    	model.SaveLevels();
		
		app.refresh();
	}

}