/**
 * BoardView.java
 * 
 * @author Scandium
 */
package scandium.common.view;

import javax.swing.JPanel;

import scandium.common.model.Board;

/**
 * A panel which shows all of the elements of a Board.
 */
public class BoardView extends JPanel {
	private static final long serialVersionUID = -314107537905075453L;
	private Board model;
	private BoardSquareView[] boardSquareViews;
	
    /**
     * Creates a new Board View with the given board.
     * @param board The board that this view will represent.
     */
    public BoardView(Board model) {
        // TODO implement here
    }

	/**
	 * @return the model
	 */
	public Board getModel() {
		return model;
	}

	/**
	 * @return the boardSquareViews
	 */
	public BoardSquareView[] getBoardSquareViews() {
		return boardSquareViews;
	}
}