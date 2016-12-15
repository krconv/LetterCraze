/**
 * SelectLevelController.java
 * 
 * @author Scandium
 */
package scandium.levelbuilder.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import scandium.common.model.Level;
import scandium.levelbuilder.model.Model;
import scandium.levelbuilder.view.Application;

/**
 * This class handles the user's mouse click on a level icon. 
 */
public class SelectLevelController extends MouseAdapter{

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
     * The level that this controller is tied to.
     */
    Level level;
    
    /**
     * This constructor instantiates a new SelectLevelController.
     * @param m The entire LevelBuilder model.
     * @param a The entire LevelBuilder application.
     * @param l The level that would be selected if this controller is clicked.
     */
    public SelectLevelController(Model m, Application a, Level l) {
        this.model = m;
        this.app = a;
        this.level = l;
    }

    
    /**
     * This function handles the mouse click on a level icon.
     * @param me The MouseEvent representing the user's mouse click on the level icon.
     */
    public void mouseClicked(MouseEvent me) {
    	if(model.getSelectedLevel() == null || !model.getSelectedLevel().equals(level))
    		model.setSelectedLevel(level);
    	else model.setSelectedLevel(null);
    	app.getMainMenu().refresh();
    }

}
