package scandium.lettercraze.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;

import scandium.common.tool.LetterDictionary;
import scandium.lettercraze.model.Model;
import scandium.lettercraze.view.Application;

/**
 * @author Scandium
 */
public class OpenLevelController extends MouseAdapter{
	
	/* Class attributes                                                                          */
	Model model;
    Application app;
    LetterDictionary dictionary;
    
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
        this.dictionary = new LetterDictionary();
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
    	
    	/* must initializes one letter dictionary for all tiles, not one per tile.
    	 * Otherwise the seeds will be too close together and all tiles will be the same. 
    	 */
    	LetterDictionary letters = dictionary;
    	/* initialize tiles with random letters */
    	for(int i = 0; i < 6; i++){
    		for(int j = 0; j < 6; j++){
    			String random_letter = letters.getRandomTile().getContent();
    			JLabel label = app.getLevelPlayer().getBoardView().getJLabel(i, j);
    			label.setText(random_letter);
    		}
    	}
    	
    	app.setView(app.getLevelPlayer());
    }

}