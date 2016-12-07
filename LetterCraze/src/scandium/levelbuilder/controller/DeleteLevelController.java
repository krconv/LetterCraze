package scandium.levelbuilder.controller;

import java.awt.event.MouseEvent;

import scandium.levelbuilder.model.Model;
import scandium.levelbuilder.view.Application;

/**
 * @author Felix
 */
public class DeleteLevelController {

	//attributes
    Model model;
    Application app;

    
    /**
     * @param model 
     * @param app
     */
    public DeleteLevelController(Model m, Application a) {
        this.model = m;
        this.app = a;
    }

    
    /**
     * @param MouseEvent me
     */
    public void mousePressed(MouseEvent me) {
    	//delete level
    }

}