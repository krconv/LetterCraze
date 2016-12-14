package scandium.lettercraze.controller;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import scandium.common.model.BoardSquare;
import scandium.lettercraze.model.Model;
import scandium.lettercraze.view.Application;
import scandium.lettercraze.view.BoardView;

/**
 * This class handles the selection of a word through the dragging of the mouse across the 
 * board squares. It shows updates the view and the model to reflect the selection of letters. 
 * @author Scandium
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
    int row;
    int col;
    
    /**
     * This constructor instantiates a new WordDragController. It accepts the entire LetterCraze
     * model and the entire LetterCraze GUI.
     * @param model The entire LetterCraze model.
     * @param app The entire LetterCraze GUI.
     * @param row The row of the square which this controller is for.
     * @param col The column of the square which this controller is for.
     */
    public WordDragController(Model model, Application app, int row, int col) {
        this.model = model;
        this.app = app;
        this.row = row;
        this.col = col;
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
    	// check that the game is being played
    	if (!model.getProgress().getCurrentLevelProgress().isPlaying()) return;

    	BoardView boardView = app.getLevelPlayer().getBoardView();
    	
    	// capture where the mouse was dragged on the board
    	Point pos = getRelativePoint(me);
    	// capture what board square was dragged over
    	BoardSquare square = boardView.getBoardSquareAt(pos);
    	if (square != null) {
    		// the player dragged over a 
    		
        	if (model.getProgress().getCurrentLevelProgress().getLevel().getBoard().selectSquare(square)) {
        		// the player successfully selected a new square
            	boardView.refresh();
        	}
    	}
    }
    
    /**
     * This function returns a point that is the location of the JLabel being dragged over. 
     * Relative to Proper JPanels.
     * @param me The MouseEvent of the drag
     * @return Point the point of the JPanel
     */
    private Point getRelativePoint(MouseEvent me){
    	Point relative_point = me.getPoint();
    	Point starting_point = me.getComponent().getLocation();
    	return new Point((int)(starting_point.getX() + relative_point.getX()), (int)(starting_point.getY() + relative_point.getY()));
    }

}