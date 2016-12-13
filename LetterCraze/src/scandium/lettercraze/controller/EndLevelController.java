package scandium.lettercraze.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import scandium.lettercraze.model.LevelProgress;
import scandium.lettercraze.model.Model;
import scandium.lettercraze.view.Application;

/**
 * This class handles the timer expiring during a lighting level. It makes the level not playable
 * until the player exits to the main menu and returns.
 * @author Scandium
 */
public class EndLevelController implements ActionListener {
    private Model model;
    private Application app;

    /**
     * Creates a new controller which will stop game play if the expire is called.
     * @param model The model.
     * @param app The application.
     */
    public EndLevelController(Model model, Application app) {
    	this.model = model;
    	this.app = app;
    }

	/**
	 * This function handles the timer expiring during a lightning level. 
	 * It makes the level not playable and refreshes the display.
	 * 
	 * <p>Entry Condition: The current level is a lightning level. The timer has expired</p>
	 * <p>Exit Condition: The level is no longer playable. The view is updated to reflect this change.</p>
	 * @param event The ActionEvent representing the timer expiring.
	 */
	@Override
	public void actionPerformed(ActionEvent event) {
		LevelProgress currentProgress = model.getProgress().getCurrentLevelProgress();
		currentProgress.getRestrictor().stop();
		currentProgress.setPlaying(false);
		app.getLevelPlayer().refresh();
	}

}