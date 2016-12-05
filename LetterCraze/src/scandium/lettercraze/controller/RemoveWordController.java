package scandium.lettercraze.controller;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import scandium.common.tool.WordDictionary;
import scandium.lettercraze.model.Model;
import scandium.lettercraze.view.Application;

/**
 * @author Scandium
 */
public class RemoveWordController extends MouseAdapter{

    /**
     * Default constructor
     */
    public RemoveWordController(){
    }

    Model model;
    Application app;
    WordDictionary dictionary;



    /**
     * @param model 
     * @param app 
     * @param dictionary
     */
    public RemoveWordController(Model model, Application app, WordDictionary dictionary) {
        this.model = model;
        this.app = app;
        this.dictionary = dictionary;
    }

    /**
     * This function handles a mouse release on one of the JLabel squares in the Board View
     * (used to form and remove a word)
     * @param me The mouse event for this controller
     */
    @Override
    public void mouseReleased(MouseEvent me){
    	
    	/* Adjust View */
    	for(int i = 0; i < 6; i++){
    		for(int j = 0; j < 6; j++){
    			app.getLevelPlayer().getBoardView().getJLabel(i, j).setBackground(Color.WHITE);
    		}
    	}
    }

}