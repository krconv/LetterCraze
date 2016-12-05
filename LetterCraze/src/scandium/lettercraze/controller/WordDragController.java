package scandium.lettercraze.controller;

import java.awt.Component;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JLabel;

import scandium.lettercraze.model.Model;
import scandium.lettercraze.view.Application;

/**
 * @author Scandium
 */
public class WordDragController extends MouseMotionAdapter{

	/* Class Attributes                                                                          */
    Model model;
    Application app;
    
    /**
     * Instantiate a new Controller with the model and application.
     * @param model 
     * @param app
     */
    public WordDragController(Model model, Application app) {
        this.model = model;
        this.app = app;
    }

   
    /** This function handles a mouse Drag on one of the JLabel squares in the BoardView
     * (used to select a tile)
     * @param me The Mouse event for this controller
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
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    