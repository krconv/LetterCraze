package scandium.levelbuilder.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import scandium.common.model.Level;
import scandium.common.model.PuzzleLevel;
import scandium.levelbuilder.model.EditProgress;
import scandium.levelbuilder.model.Model;
import scandium.levelbuilder.view.Application;

/**
 * @author Felix
 */
public class CreateNewLevelController extends MouseAdapter{

	//attributes
    Model model;
    Application app;
    Level l;
    EditProgress progress;

    
    /**
     * @param model 
     * @param app
     */
    public CreateNewLevelController(Model m, Application a) {
        this.model = m;
        this.app = a;
        this.l = new PuzzleLevel();
        this.progress = new EditProgress(l);
    }

    
    /**
     * @param MouseEvent me
     */
    public void mousePressed(MouseEvent me) {
    	app.setViewLevelEditor();
    	model.setSelectedLevel(l);
    	model.setEditProgress(progress);
    	app.getLevelEditor().setEditProgress(progress);
    	app.getLevelEditor().getPuzzleLevelButton().setSelected(true);
    	app.getLevelEditor().refresh();
    }

}