package scandium.levelbuilder.controller;

import java.awt.event.MouseEvent;

import scandium.common.model.Level;
import scandium.levelbuilder.model.EditProgress;
import scandium.levelbuilder.model.Model;
import scandium.levelbuilder.view.Application;

/**
 * @author Scandium WORK ON THIS
 */
public class OpenLevelEditorController {

	//attributes
    Model model;
    Application app;
    Level l;
    EditProgress progress;

    
    /**
     * @param model 
     * @param app
     */
    public OpenLevelEditorController(Model m, Application a) {
        this.model = m;
        this.app = a;
        this.l = model.getSelectedLevel();
        this.progress = new EditProgress(l);
    }

    
    /**
     * @param MouseEvent me
     */
    public void mousePressed(MouseEvent me) {
    	//load selected level
    	model.setSelectedLevel(l);
    	model.setEditProgress(progress);
    	app.getLevelEditor().setEditProgress(progress);
    	
    	//change view
    	app.setViewLevelEditor();
    }

}