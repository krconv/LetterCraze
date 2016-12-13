package scandium.levelbuilder.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

import scandium.levelbuilder.model.Model;
import scandium.levelbuilder.view.Application;

/**
 * @author Felix
 */
public class DeleteLevelController implements ActionListener{

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
     * @param ActionEvent ae
     */
	public void actionPerformed(ActionEvent ae) {
		//model.deleteLevel( model.getSelectedLevel() );
		app.getMainMenu().refresh();
	}

}