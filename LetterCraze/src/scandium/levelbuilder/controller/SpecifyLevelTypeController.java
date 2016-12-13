package scandium.levelbuilder.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JRadioButton;

import scandium.common.model.LightningLevel;
import scandium.common.model.PuzzleLevel;
import scandium.common.model.ThemeLevel;
import scandium.levelbuilder.model.EditProgress;
import scandium.levelbuilder.model.Model;
import scandium.levelbuilder.view.Application;

/**
 * This class handles the the user's selection of the level type.
 * @author Scandium 
 * @date 13/12/16
 */
public class SpecifyLevelTypeController implements ActionListener{
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
     * This constructor creates a new SpecifyLevelTypeController.
     * @param model The entire LevelBuilder Model
     * @param app The entire LevelBuilder application
     */
    public SpecifyLevelTypeController(Model m, Application a) {
        this.model = m;
        this.app = a;
    }

    /**
     * This function handles the user's selection of the level type
     * @param ae The ActionEvent representing the user's selection of the level type.
     */
    public void actionPerformed(ActionEvent ae) {
    	/* Get Buttons from View */
    	JRadioButton puzzle = app.getLevelEditor().getPuzzleLevelButton();
    	JRadioButton lightning = app.getLevelEditor().getLightningLevelButton();
    	JRadioButton theme = app.getLevelEditor().getThemeLevelButton();
    	
    	/* Determine Which Button was pressed */
        if(puzzle.isSelected()){
        	PuzzleLevel level = new PuzzleLevel();
        	model.setEditProgress(new EditProgress(level));
        }else if(lightning.isSelected()){
        	LightningLevel level = new LightningLevel();
        	model.setEditProgress(new EditProgress(level));
        }else if(theme.isSelected()){
        	ThemeLevel level = new ThemeLevel();
        	model.setEditProgress(new EditProgress(level));
        }
        
        app.refresh();
    }

}