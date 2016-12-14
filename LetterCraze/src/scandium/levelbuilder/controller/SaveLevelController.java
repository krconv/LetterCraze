package scandium.levelbuilder.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import scandium.common.model.Level;
import scandium.common.model.LightningLevel;
import scandium.common.model.PuzzleLevel;
import scandium.common.model.ThemeLevel;
import scandium.lettercraze.model.LevelProgress;
import scandium.levelbuilder.model.EditProgress;
import scandium.levelbuilder.model.Model;
import scandium.levelbuilder.view.Application;
import scandium.levelbuilder.view.LevelEditorView;

/**
 * This class handles the user pressing the save level button in the level editor view. 
 * It saves the level if the level is fully complete, otherwise, It Displays an error message.
 * @author Scandium
 * @date 12/13/16
 */
public class SaveLevelController implements ActionListener{
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
     * This constructor instantiates a new SaveLevelController.
     * @param model The entire LevelBuilder Model.
     * @param app The entire LevelBuilder application.
     */
    public SaveLevelController(Model model, Application app) {
        this.model = model;
        this.app = app;
    }

    /**
     * This function handles the user's mouse Click on the save level button.
     * @param ae The ActionEvent representing the user's mouse click.
     */
    public void actionPerformed(ActionEvent ae) {
    	LevelEditorView LEV = app.getLevelEditor();
    	boolean is_saveable = true;
    	String error = "";
    	/* Get all level attributes from the level editor window */
    	int max_num_words = 0;
    	int time_limit = 0;
    	String theme_name = "";
    	ArrayList<String> theme_words = new ArrayList<String>();
    	String level_name = LEV.getLevelNameTextField().getText();
    	int star1 = 0;
    	int star2 = 0;
    	int star3 = 0;
    	try{
	    	star1 = Integer.parseInt(LEV.getOneStarTextField().getText());
	    	star2 = Integer.parseInt(LEV.getTwoStarTextField().getText());
	    	star3 = Integer.parseInt(LEV.getThreeStarTextField().getText());
    	}catch(Exception e){}
    	
    	int board_squares = 0;
    	/* Count the number of board squares */
    	for(int i = 0; i < 6; i++){
    		for(int j = 0; j < 6; j++){
    			if(model.getEditProgress().getModified().getBoard().getSquare(i, j).isEnabled()) board_squares++;
    		}
    	}
    	if(level_name.equals("")){
    		is_saveable = false;
    		error += "Invalid Level Name.\n";
    	}
    	if(star1 <= 0){
    		is_saveable = false;
    		error += "Invalid Star1 Threshold.\n";
    	}
    	if(star2 <= 0 || star2 <= star1){
    		is_saveable = false;
    		error += "Invalid Star2 Threshold.\n";
    	}
    	if(star3 <= 0 || star3 <= star2){
    		is_saveable = false;
    		error += "Invalid Star2 Threshold.\n";
    	}
    	if(board_squares < 9){
    		is_saveable = false;
    		error += "Need At Least 9 Enabled BoardSquares.\n";
    	}
    	/* Puzzle Level Specifics */
    	if(model.getEditProgress().getModified() instanceof PuzzleLevel){
    		try{
    			max_num_words = Integer.parseInt(LEV.getPuzzleMaxNumWordsTextField().getText());
    		}catch(Exception e){}
    		if(max_num_words <= 0){
    			is_saveable = false;
    			error += "Maximum Number of Words for Puzzle Level must be Greater than 0.\n";
    		}
    	}else if(model.getEditProgress().getModified() instanceof LightningLevel){
    		try{
        		time_limit = Integer.parseInt(LEV.getLightningTimeLimitTextField().getText());
    		}catch(Exception e){}
    		if(time_limit <= 0){
    			is_saveable = false;
    			error += "Time Limit for Lightning Level must be Greater than 0.\n";
    		}
    	}else {
    		theme_name = LEV.getThemeNameTextField().getText();
    		theme_words = parseThemeWords(LEV.getThemeWordsTextArea().getText());
    		if(theme_name.equals("")){
    			is_saveable = false;
    			error += "Invalid Theme Name for Theme Level.\n";
    		}
    		if(theme_words.isEmpty()){
    			is_saveable = false;
    			error += "Number of Theme Words for Theme Level must be Greater than 0.\n";
    		}
    		boolean has_generated = true;
    		for(int i = 0; i < 6; i++){
    			for(int j = 0; j < 6; j++){
    				if(model.getEditProgress().getModified().getBoard().getSquare(i, j).getTile() == null &&
    						model.getEditProgress().getModified().getBoard().getSquare(i, j).isEnabled()){
    					has_generated = false;
    				}
    			}
    		}
    		if(!has_generated){
				is_saveable = false;
				error += "Tiles need to be Generated for a ThemeLevel Before Save.\n";
    		}
    	}
    	
    	if(!is_saveable){
    		JOptionPane.showMessageDialog(null, error, "Errors Occured While Saving the Level", JOptionPane.INFORMATION_MESSAGE);
    		return;
    	}
    	
    	/* Prepare level */
    	Level level = model.getEditProgress().getModified();
    	level.setName(level_name);
    	level.getStars()[0].setThreshold(star1);
    	level.getStars()[1].setThreshold(star2);
    	level.getStars()[2].setThreshold(star3);
    	if(level instanceof PuzzleLevel){
    		((PuzzleLevel) level).setMaxNumWords(max_num_words);
    	}else if(level instanceof LightningLevel){
    		((LightningLevel) level).setTimeLimit(time_limit);
    	}else{
    		((ThemeLevel) level).setTheme(theme_name);
    		((ThemeLevel) level).setThemeWords(theme_words);
    	}
    	/* Prepare Levels and level progresses */
    	int index = model.getLevels().indexOf(model.getEditProgress().getOriginal());
    	model.getLevels().remove(model.getEditProgress().getOriginal());
    	if(index == -1){
    		model.addLevel(level);
    		model.getLevelProgresses().add(new LevelProgress(level));
    	}else{
    		model.getLevelProgresses().remove(index);
    		model.getLevels().add(index, level);
    		model.getLevelProgresses().add(index, new LevelProgress(level));
    		model.setEditProgress(new EditProgress(level));
    	}
    	
    	/* Save levels to File */
    	model.SaveLevels();
    	
    	app.refresh();
    	

    }
    
    /**
     * This function consumes one long string representing the theme words in the text area, 
     * and parses them into an array list of separate words. It allows the words to be 
     * Separated by spaces, new lines, or commas.
     * @param theme_words The String of theme words separated by commas, spaces, or new lines.
     */
    ArrayList<String> parseThemeWords(String theme_words){
    	ArrayList<String> words = new ArrayList<String>();
    	int old_index = 0;
    	boolean on_word = false;
    	char[] chars = theme_words.toCharArray();
    	/* Parse the String */
    	for(int i = 0; i <= theme_words.length(); i++){
    		char this_char = ' ';
    		if(i != theme_words.length()) this_char = chars[i];
    		
    		if(this_char == ' ' || this_char == ',' || this_char =='\n'){
    			if(on_word){
    				words.add(theme_words.substring(old_index, i));
    			}
    			old_index = i+1;
    			on_word = false;
    		}else on_word = true;
    	}
    	
    	return words;
    }
    
    

}