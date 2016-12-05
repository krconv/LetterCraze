package scandium.lettercraze.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;

import scandium.common.tool.LetterDictionary;
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
     * This constructor instantiates a new OpenLevelController. It accepts the LetterCraze model
     * and GUI. 
	 * @param m The entire LetterCraze Model.
	 * @param app The entire LetterCraze GUI.
	 */
    public OpenLevelController(Model m, Application app) {
        this.model = m;
        this.app = app;
        this.dictionary = new LetterDictionary();
    }

    /**
     * This function handles a mouse click on a level in the Main Menu. It transitions the 
     * view from the Main Menu to the Level Player, and loads the selected level. 
     * entry condition: the button this controller is attached to is pressed.
	 * exit condition: the View has been set to the proper LevelPlayerView for the selected level.
	 * @param me The MouseEvent representing the user's mouse click on the level.
	 */
    
    @Override
    public void mouseClicked(MouseEvent me) {   	
    	/* initialize tiles with random letters */
    	for(int i = 0; i < 6; i++){
    		for(int j = 0; j < 6; j++){
    			String random_letter = dictionary.getRandomTile().getContent();
    			JLabel label = app.getLevelPlayer().getBoardView().getJLabel(i, j);
    			label.setText(random_letter);
    		}
    	}
    	
    	/* Set the view to the Level Player */
    	app.setView(app.getLevelPlayer());
    }

}