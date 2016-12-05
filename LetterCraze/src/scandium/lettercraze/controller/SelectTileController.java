package scandium.lettercraze.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;

import scandium.lettercraze.model.Model;
import scandium.lettercraze.view.Application;

/**
 * @author Scandium
 */
public class SelectTileController extends MouseAdapter{

	/* Class Attributes                                                                          */
    Model model;
    Application app;
    
    /**
     * Default constructor
     */
    public SelectTileController() {
    }


    /**
     * Instantiate a new Controller with the model and application.
     * @param model 
     * @param app
     */
    public SelectTileController(Model model, Application app) {
        this.model = model;
        this.app = app;
    }

    /**
     * This function handles a mouse press on one of the JLabel squares in the BoardView
     * (Used to select a tile)
     * @param me The mouse event for this controller
     */
    @Override
    public void mousePressed(MouseEvent me){  	
    	/* AdjustView */
    	JLabel label = (JLabel) me.getComponent();
    	app.getLevelPlayer().getBoardView().highlight(label);
    }
    
}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    