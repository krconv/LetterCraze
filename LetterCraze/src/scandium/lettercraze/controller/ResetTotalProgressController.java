package scandium.lettercraze.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import scandium.lettercraze.model.GameProgress;
import scandium.lettercraze.model.LevelProgress;
import scandium.lettercraze.model.Model;
import scandium.lettercraze.view.Application;

/**
 * This class handles the reseting of the entire game progress. It clears
 * the players progress for all levels. Used to replay the game. 
 * @author Scandium
 */
public class ResetTotalProgressController extends MouseAdapter{
	
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
     * The entire saved progress for LetterCraze. With this the controller can reset all progress.
     */
    GameProgress total_progress;
    
    /**
     * This constructor method creates a new instance of the ResetTotalProgressControllrer. It accepts
     * the entire LetterCraze model and GUI. 
     * @param model The entire LetterCraze Model
     * @param app The entire LetterCraze Application(GUI)
     * @param total_progress The game progress which would be reset.
     */
    public ResetTotalProgressController(Model model, Application app, GameProgress total_progress){
    	this.model = model;
    	this.app = app;
    	this.total_progress = total_progress;
    }

    /**
     * This function handles the mouse click on the reset total progress. It removes 
     * all level specific progress from the game progress, saves this change to file, 
     * and updates the view to reflect this change. 
     * 
     * <p>Entry Condition: The player clicks the resetTotalProgress Button in the Main Menu </p>
     * <p>Exit Condition: The model, saved files, and view have been updated to reflect the removal
     *    of all progress.</p>
     *    
     * @param me The MouseEvent representing the user's mouse click on the ResetTotalProgress Button.
     */
    @Override
    public void mouseClicked(MouseEvent me) {
    	for(LevelProgress level_progress : total_progress.getLevelProgresses()){
    		/* Reset and lock all levels */
    		level_progress.reset();
    		level_progress.setUnlocked(false);
    	}
    	/* unlock first level */
    	total_progress.getLevelProgresses().get(0).setUnlocked(true);
    	
    	/* commit changes to file */
    	total_progress.SaveProgress();
    	/* update view */
    	app.getMainMenu().refresh();
    }

}