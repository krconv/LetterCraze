package scandium.levelbuilder.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import scandium.levelbuilder.model.Model;
import scandium.levelbuilder.view.Application;

public class LeaveLevelEditorController extends MouseAdapter{

	//attributes
    Model model;
    Application app;

    
    /**
     * @param model 
     * @param app
     */
    public LeaveLevelEditorController(Model m, Application a) {
        this.model = m;
        this.app = a;
    }

    
    /**
     * @param MouseEvent me
     */
    public void mouseClicked(MouseEvent me) {
    	app.setViewMainMenu();
    	app.getLevelEditor().refresh();
    }
}