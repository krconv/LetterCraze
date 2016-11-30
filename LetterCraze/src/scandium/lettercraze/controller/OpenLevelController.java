package scandium.lettercraze.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import scandium.lettercraze.model.Model;
import scandium.lettercraze.view.Application;

/**
 * @author Scandium
 */
public class OpenLevelController extends MouseAdapter{
	
	@SuppressWarnings("unused")
	private Model model;
    private Application app;
    
    /**
     * Default constructor
     */
    public OpenLevelController() {
    }

    /**
	 * @param m The Model the current game is running on
	 * @param app The current application being run
	 */
    public OpenLevelController(Model m, Application app) {
        this.model = m;
        this.app = app;
     // TODO might need to pass in the specific level that this controller goes to rather than the full model
    }

    /**
	 * @param ActionEvent ae The mouse is clicked on the button
	 * entry condition: the button this controller is attached to is pressed
	 * exit condition: the View has been set to the proper LevelPlayerView for the selected level
	 */
    @Override
    public void mouseClicked(MouseEvent me) {
    	// TODO pass in the correct level information to set up the LevelPlayerView properly
    	app.setView(app.getLevelPlayer());
    }

}