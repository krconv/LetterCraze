package scandium.levelbuilder.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

import scandium.common.model.Level;
import scandium.common.model.LightningLevel;
import scandium.common.model.PuzzleLevel;
import scandium.common.model.ThemeLevel;
import scandium.levelbuilder.model.Model;
import scandium.levelbuilder.view.Application;
import scandium.levelbuilder.view.LevelEditorView;

/**
 * This class handles the user pressing the save level button in the level editor view. 
 * It saves the level if the level is fully complete, otherwise, It Displays an error message.
 * @author Scandium
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
    	LevelEditorView levelEditorView = app.getLevelEditor();
    	// update the modified level
    	StringBuilder errors = new StringBuilder();
    	Level modified = model.getEditProgress().getModified();
    	
    	// set the common attributes
    	modified.setName(levelEditorView.getLevelNameTextField().getText());
		try {
	    	modified.getStar(0).setThreshold(Integer.parseInt(levelEditorView.getStarOneTextField().getText()));
		} catch (NumberFormatException e) {
			errors.append("The threshold for Star One is not a number!");
		}
		try {
	    	modified.getStar(1).setThreshold(Integer.parseInt(levelEditorView.getStarTwoTextField().getText()));
		} catch (NumberFormatException e) {
			errors.append("The threshold for Star Two is not a number!");
		}
		try {
	    	modified.getStar(2).setThreshold(Integer.parseInt(levelEditorView.getStarThreeTextField().getText()));
		} catch (NumberFormatException e) {
			errors.append("The threshold for Star Three is not a number!");
		}
		
		// set the level specific settings
    	if (modified instanceof PuzzleLevel)
    		try {
    			((PuzzleLevel) modified).setMaxNumWords(Integer.parseInt(levelEditorView.getMaxNumWordsTextField().getText()));
    		} catch (NumberFormatException e) {
    			errors.append("The Word Limit is not a number!");
    		}
    	if (modified instanceof LightningLevel)
    		try {
    			((LightningLevel) modified).setTimeLimit(Integer.parseInt(levelEditorView.getTimeLimitTextField().getText()));
    		} catch (NumberFormatException e) {
    			errors.append("The Time Limit is not a number!");
    		}
    	if (modified instanceof ThemeLevel) {
			((ThemeLevel) modified).setTheme(levelEditorView.getThemeNameTextField().getText());
			((ThemeLevel) modified).setThemeWords(levelEditorView.getThemeWords());
    	}
    	    	
    	// make sure the level is valid
    	if (!modified.isValid())
    		errors.append("The level is not valid!");
    	
    	// don't save if there were any errors
    	if (!errors.toString().isEmpty()) {
    		JOptionPane.showMessageDialog(levelEditorView, errors.toString(), "Error", JOptionPane.WARNING_MESSAGE);
    		return;
    	}

    	// replace the level
    	model.replaceLevel(model.getEditProgress().getOriginal(), modified);
    	    	
    	/* Save levels to File */
    	model.SaveLevels();
    	
    	app.getLevelEditor().refresh();
    }
}