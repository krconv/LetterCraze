package scandium.lettercraze.controller;

import java.awt.Color;
import java.awt.Component;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JLabel;

import scandium.common.model.BoardSquare;
import scandium.common.model.Word;
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
     * @param model The entire LetterCraze model.
     * @param app The entire LetterCraze GUI.
     */
    public WordDragController(Model model, Application app) {
        this.model = model;
        this.app = app;
    }

   
    /** 
     * This function handles a mouse drag across one of the board squares in the Level Player. 
     * It updates the view and the model to reflect the addition of tile on this board square
     * to the entire selected word. 
     * 
     * <p>Entry Condition: The mouse is pressed and being dragged across the current board square. (JLabel).</p>
     * <p>Exit Condition: The current JLabel has been highlighted in the GUI and the model has been updated
     * to reflect the addition of this letter to the currently selected word. </p>
     * 
     * @param me The MouseEvent representing the user's drag across the current board square. 
     */
    @Override 
    public void mouseDragged(MouseEvent me){
    	/* Check that the game is being played */
    	if(!model.getProgress().getCurrentLevelProgress().isPlaying()) return;
    	/* Get the location of the mouse */
    	Point relative_point = me.getPoint();
    	Point starting_point = me.getComponent().getLocation();
    	Point point = new Point((int)(starting_point.getX() + relative_point.getX()), (int)(starting_point.getY() + relative_point.getY()));
    	Component c = app.getLevelPlayer().getBoardView().findComponentAt(point);
    	JLabel selected_label = null;
    	/* If the drag left the board view */
    	if(c == null){
    		abortSelection();
    		return;
    	}
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
    	if(!(xp >= x + 20 && yp >= y + 20 && xp <= x + (width - 20) && yp <= y + (height - 20))) return;
    	
    	/* Determine the coordinates of the label */
    	int row = -1;
    	int col = -1;
    	for(int i = 0; i < 6; i++){
    		for(int j = 0; j < 6; j++){
    			if(app.getLevelPlayer().getBoardView().getJLabel(i, j).equals(selected_label)){
    				row = i;
    				col = j;
    			}
    		}
    	}
    	
    	/* Determine if the Drag is a Drag to an enabled Square */
    	BoardSquare square = model.getProgress().getCurrentLevelProgress().getLevel().getBoard().getBoardSquare(col, row);
    	if(!square.isEnabled()){
    		abortSelection();
    		return;
    	}
    	/* Determine if the Drag is to a already selected Square */
    	Word word = model.getProgress().getCurrentLevelProgress().getLevel().getBoard().getSelectedWord();
    	if(word == null) return;
    	if(word.getBoardSquares().contains(square)){
    		/* If its not the drag on the same tile. */
    		if(!square.equals(word.getBoardSquares().get(word.getBoardSquares().size() - 1))){
    			abortSelection();
    		}
    		return;
    	}
    	/* Determine if the Drag is to an adjacent square */
    	BoardSquare last_square = word.getBoardSquares().get(word.getBoardSquares().size() - 1);
    	x = (int)last_square.getRow();
    	y = (int)last_square.getCol();
    	if(!(x==row || x==row-1 || x==row+1)&&(y==col || y==col-1 || y==col+1)){
    		abortSelection();
    		return;
    	}
    	
    	/* Add selected Square to the model */
    	//Word word = model.getProgress().getCurrentLevelProgress().getLevel().getBoard().getSelectedWord();
    	//already Selected = word.getBoardSquares().contains(square);
    	
    	model.getProgress().getCurrentLevelProgress().getLevel().getBoard().selectSquare(square);
    	
    	/* Adjust View */
    	app.getLevelPlayer().getBoardView().highlight(selected_label);
    }
    
    
    void abortSelection(){
    	/* Un-highlight the word on the board view */
    	Word word = model.getProgress().getCurrentLevelProgress().getLevel().getBoard().getSelectedWord();
    	/* If no selection */
    	if(word == null) return;
    	for(BoardSquare bs : word.getBoardSquares()){
    		int row = bs.getRow();
    		int col = bs.getCol();
    		app.getLevelPlayer().getBoardView().getJLabel(row, col).setBackground(Color.WHITE);
    	}
    	/* Un-select the word in the model */
		model.getProgress().getCurrentLevelProgress().getLevel().getBoard().removeSelectedWord();
    }
    
}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    