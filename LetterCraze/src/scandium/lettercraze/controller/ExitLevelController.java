package scandium.lettercraze.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import scandium.lettercraze.model.GameProgress;
import scandium.lettercraze.model.LevelProgress;
import scandium.lettercraze.model.Model;
import scandium.lettercraze.undo.UndoManager;
import scandium.lettercraze.view.Application;

/**
 * This class handles the exiting of a level. It determines if the current progress of the game 
 * is better than the previous progress of the game, and if so, it saves the new progress to the 
 * GameProgress object and to file. 
 * @author Scandium
 * @date 12/10/2016
 */
public class ExitLevelController implements ActionListener{
	/** 
	 * The entire LetterCraze model. With this, the controller has access to all entities
	 * that it may need. 
	 */
	Model model;
	/** 
	 * The entire LetterCraze GUI. With this, the controller has access to all widgets
	 * that it may need. 
	 */
    Application app;

	/**
	 * This constructor instantiates a new instance of the ExitLevelController. It accepts 
	 * the entire model and the entire application(GUI).
	 * @param m The Model the current game is running on
	 * @param app The current application being run
	 */
	public ExitLevelController(Model m, Application app) {
		this.model = m;
		this.app = app;
	}
	
	/**
	 * This function handles the mouse click on the exit level button. It returns the view to the main menu
	 * and updates the progress (if the current progress is better than the old saved progress.
	 * <p>entry condition: the button this controller is attached to is pressed.</p>
	 * <p>exit condition: the View has been set to the Main Menu and progress in the level has been saved if needed.</p>
	 * @param ActionEvent ae The mouse is clicked on the button
	 */
	@Override
	public void actionPerformed(ActionEvent ae) {
		GameProgress gameProgress = model.getProgress();
		LevelProgress currentProgress = gameProgress.getCurrentLevelProgress();
		boolean shouldSave = false; // whether the progress needs to be saved again
		
		// the level isn't being played anymore
		currentProgress.setPlaying(false);
		currentProgress.getLevel().stopTimer();
		
		// replace the high score with the score that was just earned if it is higher
		if (currentProgress.isHigherScore(gameProgress.getProgressForLevel(currentProgress.getLevel()))) {
			gameProgress.replaceLevelProgress(currentProgress);
			shouldSave = true;
		}
		
		// unlock the next level if the player got a star on the level that was just played
		if (currentProgress.getStarCount() > 0)
			// save the progress if the next level wasn't already unlocked
			gameProgress.unlockNextLevel();
		
		// save the progress if it was changed
		if (shouldSave)
			gameProgress.SaveProgress();
		
		// reset the current level progress and open up the main menu
		UndoManager.instance.removeAllActions();
		gameProgress.getCurrentLevelProgress().reset();
		app.getMainMenu().refresh();
		app.setView(app.getMainMenu());
	}

}