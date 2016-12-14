package scandium.levelbuilder.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import scandium.common.model.Level;
import scandium.common.model.LightningLevel;
import scandium.common.model.PuzzleLevel;
import scandium.common.model.ThemeLevel;
import scandium.levelbuilder.model.EditProgress;
import scandium.levelbuilder.model.LevelBuilderState;
import scandium.levelbuilder.model.Model;
import scandium.levelbuilder.view.Application;

/**
 * This class handles the users mouse click the open level button. It opens the selected
 * level, and in doing so, allows the user to edit an existing level. 
 * @author Scandium
 * @date 13/12/16
 */
public class OpenLevelEditorController extends MouseAdapter{

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
     * This constructor instantiates a new OpenLevelEditorController.
     * @param model The entire LevelBuilder model.
     * @param app The entire LevelBuilder application.
     */
    public OpenLevelEditorController(Model m, Application a) {
        this.model = m;
        this.app = a;
    }

    
    /**
     * This function handles the opening of the selected level.
     * @param MouseEvent me
     */
    public void mousePressed(MouseEvent me) {
    	/* get selected level if it exits */
    	Level level = model.getSelectedLevel();
    	if(level == null) return;
    	/* Make new edit progress */
    	EditProgress progress = new EditProgress(level);
    	model.setEditProgress(progress);
    	/* change state of model */
    	model.setLevelBuilderState(LevelBuilderState.Editor);
    	/* unselect the level */
    	model.setSelectedLevel(null);
    	/* Refresh */
    	app.refresh();
    	
    	/* Preset textfield values */
    	app.getLevelEditor().getLevelNameTextField().setText(level.getName());
    	app.getLevelEditor().getOneStarTextField().setText(level.getStars()[0].getThreshold() + "");
    	app.getLevelEditor().getTwoStarTextField().setText(level.getStars()[1].getThreshold() + "");
    	app.getLevelEditor().getThreeStarTextField().setText(level.getStars()[2].getThreshold() + "");
    	if(level instanceof PuzzleLevel){
    		app.getLevelEditor().getPuzzleMaxNumWordsTextField().setText(((PuzzleLevel) level).getMaxNumWords() + "");
    	}else if(level instanceof LightningLevel){
    		app.getLevelEditor().getLightningTimeLimitTextField().setText(((LightningLevel) level).getTimeLimit() + "");
    	}else{
    		app.getLevelEditor().getThemeNameTextField().setText(((ThemeLevel) level).getTheme());
    		ArrayList<String> theme_words = ((ThemeLevel) level).getThemeWords();
    		String words = "";
    		for(String s : theme_words){
    			words += s + "\n";
    		}
    		app.getLevelEditor().getThemeWordsTextArea().setText(words);
    	}
    }

}