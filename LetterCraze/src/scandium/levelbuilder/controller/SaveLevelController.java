package scandium.levelbuilder.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import scandium.levelbuilder.model.EditProgress;
import scandium.levelbuilder.model.Model;
import scandium.levelbuilder.view.Application;

/**
 * @author Scandium
 */
public class SaveLevelController implements ActionListener{

	//attributes
    Model model;
    Application app;

    /**
     * @param model 
     * @param app
     */
    public SaveLevelController(Model m, Application a) {
        this.model = m;
        this.app = a;
    }

    /**
     * @param ActionEvent ae
     */
    public void actionPerformed(ActionEvent ae) {
    	EditProgress progress = model.getEditProgress();
    	//progress.saveProgress();
    }

}