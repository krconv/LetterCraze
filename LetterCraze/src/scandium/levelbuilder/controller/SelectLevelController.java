/**
 * SelectLevelController.java
 * 
 * @author Kodey Converse (kodey@krconv.com)
 */
package scandium.levelbuilder.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import scandium.common.model.Level;
import scandium.levelbuilder.model.Model;
import scandium.levelbuilder.view.Application;

/**
 * A controller that handles the event of a builder selecting a level in the main menu.
 */
public class SelectLevelController extends MouseAdapter {
	//attributes
    private Model model;
    private Application app;
    private Level level;
    
    /**
     * Creates a new controller which will select a level in the main menu.
     * @param model The model.
     * @param app The application.
     * @param level The level this controller is for.
     */
    public SelectLevelController(Model model, Application app, Level level) {
        this.model = model;
        this.app = app;
        this.level = level;
    }

	/* (non-Javadoc)
	 * @see java.awt.event.MouseAdapter#mouseClicked(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// select the level and refresh the display
		if (model.getSelectedLevel() == level)
			// deselect it
			model.setSelectedLevel(null);
		else
			model.setSelectedLevel(level);
		app.getMainMenu().refresh();
	}

    
}
