package scandium.lettercraze.controller;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import scandium.common.model.Board;
import scandium.common.model.BoardSquare;
import scandium.common.model.GravityDirection;
import scandium.common.model.PuzzleLevel;
import scandium.common.model.Star;
import scandium.common.model.Tile;
import scandium.common.tool.LetterDictionary;
import scandium.lettercraze.model.Model;
import scandium.lettercraze.view.Application;
import scandium.lettercraze.view.LevelPlayerView;

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
	 * @param model The entire LetterCraze Model.
	 * @param app The entire LetterCraze GUI.
	 */
    public OpenLevelController(Model model, Application app) {
        this.model = model;
        this.app = app;
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
    	/* Initialize Fake Level */
    	Board board = new Board(true, GravityDirection.Up);
    	board.getBoardSquare(0,3).setEnabled(false);
    	board.getBoardSquare(1, 2).setEnabled(false);
    	Star[] stars = new Star[3];
    	stars[0] = new Star(1);
    	stars[1] = new Star(10);
    	stars[2] = new Star(100);
    	String name = "Test";
    	int max_num_words = 5;
    	PuzzleLevel level = new PuzzleLevel(name, board, stars, max_num_words);
    	
    	/* Store the selected level as the current level progress */
    	model.getProgress().getCurrentLevelProgress().setLevel(level);
    	
    	/* Load the board squares to the view */
    	for(int i = 0; i < 6; i++){
    		for(int j = 0; j < 6; j++){
    			BoardSquare square = level.getBoard().getBoardSquare(j, i);
    			JLabel label = app.getLevelPlayer().getBoardView().getJLabel(i, j);
    			if (square.isEnabled()){
    				Tile random_tile = dictionary.getRandomTile();
    				square.setTile(random_tile);
    				label.setText(random_tile.getContent());
    				label.setVisible(true);
    			}else
    				label.setBackground(Color.BLACK);
    		}
    	}
    	
    	/* Load the Level Name to the view */
    	app.getLevelPlayer().getLevelNameLabel().setText(level.getName());
    	
    	/* If Puzzle Level, Load the max number of words value to the view */
    	if(level.getType().equals("Puzzle")){
    		app.getLevelPlayer().getMaxNumWordsValueLabel().setText(level.getMaxNumWords()+ "");
    	}
    	
    	/* Set the view to reflect the score of 0 */
    	app.getLevelPlayer().getScoreValueLabel().setText(0 + "");
    	/* Set the view to reflect no stars */
    	for(int i = 0; i < 3; i++){
			app.getLevelPlayer().getStarLabels()[i].setIcon(
					new ImageIcon(LevelPlayerView.class.getResource("/scandium/lettercraze/resources/star-icon-off.png")));
    	}
    	/* Set the view to reflect no words in the found words box */
    	app.getLevelPlayer().getFoundWordsListModel().clear();
    	
    	/* Set the view to the Level Player */
    	app.setView(app.getLevelPlayer());
    }

}