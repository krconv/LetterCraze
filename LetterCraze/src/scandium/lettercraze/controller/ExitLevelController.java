package scandium.lettercraze.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import scandium.lettercraze.model.GameProgress;
import scandium.lettercraze.model.LevelProgress;
import scandium.lettercraze.model.Model;
import scandium.lettercraze.view.Application;

/**
 * @author Richard Cole
 */
public class ExitLevelController implements ActionListener{
	private Model model;
	private Application app;

	/**
	 * Default constructor
	 */
	public ExitLevelController() {
	}


	/**
	 * @param m The Model the current game is running on
	 * @param app The current application being run
	 */
	public ExitLevelController(Model m, Application app) {
		this.model = m;
		this.app = app;
	}
	
	/**
	 * @param ActionEvent ae The mouse is clicked on the button
	 * entry condition: the button this controller is attached to is pressed
	 * exit condition: the View has been set to the Main Menu and progress in the level has been saved if needed
	 */
	@Override
	public void actionPerformed(ActionEvent ae) {
		GameProgress gameProgress = model.getProgress();
		LevelProgress currentProgress = gameProgress.getCurrentLevelProgress();
		boolean shouldSave = false; // whether the progress needs to be saved again
		
		// the level isn't being played anymore
		currentProgress.setPlaying(false);
		
		// replace the high score with the score that was just earned if it is higher
		if (currentProgress.isHigherScore(gameProgress.getProgressForLevel(currentProgress.getLevel()))) {
			gameProgress.replaceLevelProgress(currentProgress);
			shouldSave = true;
		}
		
		// unlock the next level if the player got a star on the level that was just played
		if (currentProgress.getStarCount() > 0)
			// save the progress if the next level wasn't already unlocked
			shouldSave = gameProgress.unlockNextLevel();
		
		// save the progress if it was changed
		if (shouldSave)
			gameProgress.SaveProgress();
		
		// reset the current level progress and open up the main menu
		gameProgress.getCurrentLevelProgress().reset();
		app.getMainMenu().refresh();
		app.setView(app.getMainMenu());
	}

}