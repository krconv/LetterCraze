package scandium.levelbuilder.controller;

import java.awt.event.MouseEvent;

import scandium.levelbuilder.model.Model;
import scandium.levelbuilder.view.Application;

/**
 * @author Scandium WORK ON THIS
 */
public class OpenLevelEditorController {

	//attributes
    Model model;
    Application app;

    
    /**
     * @param model 
     * @param app
     */
    public OpenLevelEditorController(Model m, Application a) {
        this.model = m;
        this.app = a;
    }

    
    /**
     * @param MouseEvent me
     */
    public void mousePressed(MouseEvent me) {
    	app.setViewLevelEditor();
    	//load up selected level
    }

}