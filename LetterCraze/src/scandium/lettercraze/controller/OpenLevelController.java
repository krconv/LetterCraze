package scandium.lettercraze.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
    		model.getProgress().getCurrentLevelProgress().setLevel(level);
    		
    		// generate the board if it should be regenerated
    		if (level.getBoard().shouldRegenerate())
    			level.getBoard().fillEmptySquares(dictionary);
    		
    		// update the level to being played
    		model.getProgress().getCurrentLevelProgress().setPlaying(true);

    		// set the view to the level player
        	app.getLevelPlayer().refresh();
        	app.setView(app.getLevelPlayer());
    	}
    }

//    /** 
//     * This function refreshes the view from the current state of the model
//     */
//    void refreshView(){
//    	LevelProgress CLP = model.getProgress().getCurrentLevelProgress();
//    	LevelPlayerView  level_player = app.getLevelPlayer();
//    	/* Remove all found words */
//    	level_player.getFoundWordsListModel().clear();
//    	/* Load found words from model */
//    	for(String word : CLP.getFoundWords()){
//    		level_player.getFoundWordsListModel().addElement(word);
//    	}
//    	/* Refresh Score */
//    	level_player.getScoreValueLabel().setText(CLP.getScore() + "");
//    	/* Refresh Stars */
//    	for(JLabel star : level_player.getStarLabels()){
//    		star.setIcon(new ImageIcon(LevelPlayerView.class.getResource(
//    				"/scandium/lettercraze/resources/star-icon-off.png")));
//    	}
//    	for(int i = 0; i < 3 && i < CLP.getStarCount(); i++){
//    		level_player.getStarLabels()[i].setIcon(new ImageIcon(LevelPlayerView.class.getResource(
//    				"/scandium/lettercraze/resources/star-icon-on.png")));
//    	}
//    	/* Refresh Board View */
//    	Board board = model.getProgress().getCurrentLevelProgress().getLevel().getBoard();
//    	for(int i = 0; i < 6; i++){
//    		for(int j = 0; j < 6; j++){
//    			if(board.getBoardSquare(j, i).isEnabled())
//    				app.getLevelPlayer().getBoardView().getJLabel(i, j).setText(board.getBoardSquare(j, i).getTile().getContent());
//    			else 
//    				app.getLevelPlayer().getBoardView().getJLabel(i, j).setBackground(Color.BLACK);
//    		}
//    	}
//    }
    
//    /**
//     * This function regenerates the tiles on the board
//     */
//    void regenerateBoardTiles(){
//    	Board board = model.getProgress().getCurrentLevelProgress().getLevel().getBoard();
//    	for(int i = 0; i < 6; i++){
//    		for(int j = 0; j < 6; j++){
//    			if(board.getSquare(i, j).isEnabled())
//    				board.getSquare(i, j).setTile(dictionary.getRandomTile());
//    		}
//    	}
//    }
}