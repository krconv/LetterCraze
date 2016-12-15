package scandium.levelbuilder.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import scandium.common.model.Level;
import scandium.common.model.LightningLevel;
import scandium.common.model.PuzzleLevel;
import scandium.common.model.ThemeLevel;
import scandium.levelbuilder.model.Model;
import scandium.levelbuilder.view.Application;

/**
 * This class handles the the user's selection of the level type.
 * @author Scandium 
 */
public class SpecifyLevelTypeController implements ActionListener {
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
     * @param m The entire LevelBuilder Model
     * @param a The entire LevelBuilder application
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
    	Level orig_level = model.getEditProgress().getModified();
    	Level modified_level = null;
    	
    	// create the new level
    	switch (((String) app.getLevelEditor().getLevelTypeComboBox().getSelectedItem()).toLowerCase()) {
    	case "puzzle":
    		modified_level = new PuzzleLevel();
    		break;
    	case "lightning":
    		modified_level = new LightningLevel();
    		break;
    	case "theme":
    		modified_level = new ThemeLevel();
    		break;
    	}
    	
    	// copy over the old attributes
    	modified_level.setName(orig_level.getName());
    	modified_level.setBoard(orig_level.getBoard());
    	for (int i = 0; i < 3; i++)
    		modified_level.getStar(i).setThreshold(orig_level.getStar(i).getThreshold());
    	
    	// update should regenerate
    	if (modified_level instanceof ThemeLevel) 
    		modified_level.getBoard().setShouldRegenerate(false);
    	else
    		modified_level.getBoard().setShouldRegenerate(true);
    		
    	// update the modified copy
    	model.getEditProgress().setModified(modified_level);
    	app.getLevelEditor().clearFields();
        app.getLevelEditor().refresh();
    }

}