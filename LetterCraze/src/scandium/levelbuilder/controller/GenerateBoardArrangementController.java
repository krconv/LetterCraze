package scandium.levelbuilder.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Random;

import scandium.common.model.Level;
import scandium.common.model.ThemeLevel;
import scandium.common.tool.LetterDictionary;
import scandium.common.tool.ThemeLevelTileGenerationAlgorithm;
import scandium.levelbuilder.model.Model;
import scandium.levelbuilder.view.Application;

/**
 * This class Places tiles on the enabled boardsquares to allow the user to view 
 * a possible distribution of tiles. For the theme level it uses an algorithm to 
 * place the theme words into the board. 
 * @author Scandium
 */
public class GenerateBoardArrangementController extends MouseAdapter{

	/** 
	 * The entire LevelBuilder model. With this, the controller has access to all entities
	 * that it may need. 
	 */
	Model model;
	/** 
	 * The entire LevelBuilder GUI. With this, the controller has access to all widgets
	 * that it may need. 
	 */
    Application app;
    /**
     * A letterDictionary used to re populate the board squares.
     */
    LetterDictionary dictionary;

    /**
     * This constructor instantiates a new GenerateBoardArrangementController.
     * @param m The model.
     * @param a The application.
     */
    public GenerateBoardArrangementController(Model m, Application a) {
        this.model = m;
        this.app = a;
        this.dictionary = new LetterDictionary();
    }

    /**
     * This function fills the enabled board squares with random tiles. For the theme level 
     * it hides the theme words within the board. 
     * @param me The mouse event representing the user's mouse click on the generate button.
     */
    public void mouseClicked(MouseEvent me) {
    	Level level = model.getEditProgress().getModified();
    	model.getEditProgress().getModified().getBoard().clearExistingTiles();
    	if(level instanceof ThemeLevel){ //if theme level);
    		List<String> theme_words = app.getLevelEditor().getThemeWords();
    		ThemeLevel level2 = (ThemeLevel) level;
    		level2.setThemeWords(theme_words);
    		ThemeLevelTileGenerationAlgorithm.populateThemeLevelWithTiles(level2, new Random().nextLong());
    	}else{
    		model.getEditProgress().getModified().getBoard().fillEmptySquares(dictionary);
    	}
    	
    	app.getLevelEditor().refresh();
    }
}