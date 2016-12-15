package scandium.lettercraze.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import scandium.lettercraze.model.LevelProgress;
import scandium.lettercraze.model.Model;
import scandium.lettercraze.view.Application;

/**
 * This class handles the restriction on any level ending the level.
 * @author Scandium
 */
public class EndLevelController implements ActionListener {
    private Model model;
    private Application app;

    /**
     * Creates a new controller which will stop game play when a restriction occurs..
     * @param model The model.
     * @param app The application.
     */
    public EndLevelController(Model model, Application app) {
    	this.model = model;
    	this.app = app;
    }

	/**
	 * Handles the event of the current level expiring.
	 * 
	 * @param event Unused.
	 */
	@Override
	public void actionPerformed(ActionEvent event) {
		LevelProgress currentProgress = model.getProgress().getCurrentLevelProgress();
		currentProgress.getRestrictor().stop();
		currentProgress.setPlaying(false);
		app.getLevelPlayer().refresh();
	}
}