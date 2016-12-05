package scandium.lettercraze.controller;

import java.awt.Component;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JLabel;

import scandium.lettercraze.model.Model;
import scandium.lettercraze.view.Application;

/**
 * This class handles the selection of a word through the dragging of the mouse across the 
 * board squares. It shows updates the view and the model to reflect the selection of letters. 
 * @author Scandium
 * @date 12/5/2016
 */
public class WordDragController extends MouseMotionAdapter{

	/** 
	 * The entire LetterCraze model. With this, the controller has access to all entities
	 * that it may need. 
	 */
	Model model;
	/** 
	 * The entire LetterCraze GUI. With this, the controller has access to all widgets
	 * that it may need. 
	 */
    Application app;
    
    /**
     * This constructor instantiates a new WordDragController. It accepts the entire LetterCraze
     * model and the entire LetterCraze GUI.
     * @param model 
     * @param app
     */
    public WordDragController(Model model, Application app) {
        this.model = model;
        this.app = app;
    }

   
    /** 
     * This function handles a mouse drag across one of the board squares in the Level Player. 
     * It updates the view and the model to reflect the addition of tile on this board square
     * to the entire selected word. 
     * Entry: The mouse is pressed and being dragged across the current board square. (JLabel)
     * Exit: The current JLabel has been highlighted in the GUI and the model has been updated 
     * to reflect the addition of this letter to the currently selected word. 
     * @param me The MouseEvent representing the user's drag across the current board square. 
     */
    @Override 
    public void mouseDragged(MouseEvent me){
    	/* Get the location of the mouse */
    	Point relative_point = me.getPoint();
    	Point starting_point = me.getComponent().getLocation();
    	Point point = new Point((int)(starting_point.getX() + relative_point.getX()), (int)(starting_point.getY() + relative_point.getY()));
    	Component c = app.getLevelPlayer().getBoardView().findComponentAt(point);
    	JLabel selected_label = null;
    	if(c == null) return;
    	if(c.getClass().toString().equals("class javax.swing.JLabel")){
    		selected_label = (JLabel) c;
    	}else return;
    	
    	/* Determine if in 'hitbox' */
    	int width = selected_label.getWidth();
    	int height = selected_label.getHeight();
    	int x = (int)selected_label.getLocation().getX();
    	int y = (int)selected_label.getLocation().getY();
    	int xp = (int)point.getX();
    	int yp = (int)point.getY();
    	if(!(xp >= x + 10 && yp >= y + 10 && xp <= x + (width - 10) && yp <= y + (height - 10))) return;
    	
    	/* Adjust View */
    	app.getLevelPlayer().getBoardView().highlight(selected_label);
    }
}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    