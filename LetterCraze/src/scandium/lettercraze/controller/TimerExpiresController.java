package scandium.lettercraze.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import scandium.lettercraze.model.LevelProgress;
import scandium.lettercraze.model.Model;
import scandium.lettercraze.view.Application;

/**
 * @author Scandium
 */
public class TimerExpiresController implements ActionListener {
    private Model model;
    private Application app;

    /**
     * Creates a new controller which will stop game play if the expire is called.
     * @param model The model.
     * @param app The application.
     */
    public TimerExpiresController(Model model, Application app) {
    	this.model = model;
    	this.app = app;
    }

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent event) {
		LevelProgress currentProgress = model.getProgress().getCurrentLevelProgress();
		currentProgress.setPlaying(false);
		currentProgress.setTimeLeft(0);
		app.getLevelPlayer().refresh();
	}

}