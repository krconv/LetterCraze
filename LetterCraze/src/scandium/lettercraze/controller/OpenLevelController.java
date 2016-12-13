package scandium.lettercraze.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.concurrent.Callable;

import scandium.common.model.Level;
import scandium.common.tool.LetterDictionary;
import scandium.lettercraze.model.LevelProgress;
import scandium.lettercraze.model.Model;
import scandium.lettercraze.view.Application;

/**
 * This class handles the opening of a level in LetterCraze. It Transitions the view from the Main 
 * Menu to the Level Player for the specific level.
 * @author Scandium
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
     * The current progress of this level.
     */
    LevelProgress progress;

    /**
     * This constructor instantiates a new OpenLevelController. It accepts the LetterCraze model
     * and GUI. 
	 * @param model The entire LetterCraze Model.
	 * @param app The entire LetterCraze GUI.
     * @param progress The level progress which will be opened.
     */
    public OpenLevelController(Model model, Application app, LevelProgress progress) {
        this.model = model;
        this.app = app;
        this.progress = progress;
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
    		currentProgress.setPlaying(true);
    		
    		// generate the board if it should be regenerated
    		if (level.getBoard().shouldRegenerate()){
    			level.getBoard().clearExistingTiles();
    			level.getBoard().fillEmptySquares(new LetterDictionary());
			}

			// start the level restrictor
			currentProgress.getRestrictor().addActionListener(new EndLevelController(model, app));
			currentProgress.getRestrictor().setOnValueChanged(new Callable<Void>() {
				@Override
				public Void call() {
					app.getLevelPlayer().refresh();
					return null;
				}
			});
			currentProgress.getRestrictor().start();

    		// update the level to being played
    		currentProgress.setPlaying(true);

    		// set the view to the level player
        	app.getLevelPlayer().refresh();
        	app.setView(app.getLevelPlayer());
    	}
    }
}