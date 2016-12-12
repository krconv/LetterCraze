package scandium.lettercraze.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Timer;

import scandium.common.model.Level;
import scandium.common.tool.LetterDictionary;
import scandium.lettercraze.model.LevelProgress;
import scandium.lettercraze.model.Model;
import scandium.lettercraze.view.Application;

/**
 * This class handles the opening of a level in LetterCraze. It Transitions the view from the Main 
 * Menu to the Level Player for the specific level.
 * @author Scandium
 * @date 12/5/16
 */
public class OpenLevelController extends MouseAdapter{
	
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
     * A instance of a LetterDictionary. With this, the controller can populate the board's tiles.
     */
    LetterDictionary dictionary;
    /**
     * The current progress of this level.
     */
    LevelProgress progress;

    /**
     * This constructor instantiates a new OpenLevelController. It accepts the LetterCraze model
     * and GUI. 
	 * @param model The entire LetterCraze Model.
	 * @param app The entire LetterCraze GUI.
	 */
    public OpenLevelController(Model model, Application app, LevelProgress progress) {
        this.model = model;
        this.app = app;
        this.progress = progress;
        this.dictionary = new LetterDictionary();
    }

    /**
     * This function handles a mouse click on a level in the Main Menu. It transitions the 
     * view from the Main Menu to the Level Player, and loads the selected level. 
     * 
     * <p>Entry Condition: the button this controller is attached to is pressed.</p>
	 * <p>Exit Condition: the View has been set to the proper LevelPlayerView for the selected level.</p>
	 * 
	 * @param me The MouseEvent representing the user's mouse click on the level.
	 */
    
    @Override
    public void mouseClicked(MouseEvent me) {
    	// only proceed if the player trying to open an unlocked level
    	if (progress.isUnlocked()) {
    		Level level = progress.getLevel();
    		
    		// update the current level progress
    		LevelProgress currentProgress = model.getProgress().getCurrentLevelProgress();
    		currentProgress.setLevel(level);
    		
    		// generate the board if it should be regenerated
    		if (level.getBoard().shouldRegenerate())
    			level.getBoard().fillEmptySquares(dictionary);
    		
    		// start a timer if the level has one
    		Timer levelTimer = level.createTimer(new TimerExpiresController(model, app));
    		
    		if (levelTimer != null) {
    			// update the time left for the level 
    			currentProgress.setTimeLeft(levelTimer.getInitialDelay() / 1000);
        		
    			// create a second timer that will update the level progress every second
    			Timer updateTimer = new Timer(1000, null);
    			updateTimer.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						if (!levelTimer.isRunning()) { // stop updating if the original timer stopped
							updateTimer.stop();
							return;
						}
						currentProgress.setTimeLeft(currentProgress.getTimeLeft() - 1);
						app.getLevelPlayer().refresh();
					}
    				
    			});
    			
    			// start the timers
    			levelTimer.start();
    			updateTimer.start();
    		}
    		
    		// update the level to being played
    		currentProgress.setPlaying(true);

    		// set the view to the level player
        	app.getLevelPlayer().refresh();
        	app.setView(app.getLevelPlayer());
    	}
    }
}