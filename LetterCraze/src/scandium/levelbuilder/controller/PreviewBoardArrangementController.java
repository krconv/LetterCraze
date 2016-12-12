package scandium.levelbuilder.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import scandium.common.model.Board;
import scandium.common.tool.LetterDictionary;
import scandium.levelbuilder.model.Model;
import scandium.levelbuilder.view.Application;

/**
 * This class handles the generation of tiles for the board preview in the level builder.
 * For Puzzle and lightning levels, Tiles are placed randomly based on the letter dictionary.
 * For Theme levels, the theme words are generated to show what the board will always look like. 
 * @author Scandium
 * @date 12/10/2016
 */
public class PreviewBoardArrangementController extends MouseAdapter{

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
     * The Letter Dictionary of all letters and their respective frequencies and score. 
     * With this the controller has the ability to refill non-populated tiles.
     */
    LetterDictionary letter_dictionary;

    /**
     * This constructor instantiates a new RemoveWordController. It accepts the LetterCraze 
     * model, the LetterCraze GUI, and a word dictionary.
     * @param model The Entire LetterCraze model.
     * @param app The Entire LetterCraze GUI
     * @param dictionary The LetterDictionary to use when repopulating tiles. 
     */
    public PreviewBoardArrangementController(Model model, Application app, LetterDictionary dictionary) {
        this.model = model;
        this.app = app;
        this.letter_dictionary = dictionary;
    }


    /**
     * This function handles the user's mouse click on the preview board arrangement button.
     * It populates the board with tiles and updates the view to reflect the changes.
     * @param me The MouseEvent representing the user's clicks.
     */
    @Override
    public void mouseClicked(MouseEvent me) {
    	Board board = model.getEditProgress().getModified().getBoard();
        if(board.shouldRegenerate()){
        	board.clearExistingTiles();
        	board.fillEmptySquares(letter_dictionary);
        }else
        	model.getEditProgress().generateThemeTiles(app);
        app.getLevelEditor().refresh();
    }

}