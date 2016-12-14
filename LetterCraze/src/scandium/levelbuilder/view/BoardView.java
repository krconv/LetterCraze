/**
 * BoardView.java
 * 
 * @author Scandium
 */
package scandium.levelbuilder.view;

import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Point;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import scandium.common.model.Board;
import scandium.common.model.BoardSquare;

/**
 * 
 */
public class BoardView extends JPanel {
	private static final long serialVersionUID = 8871823801671988312L;
	private Board board;
	
	/**
	 * Creates a new board view.
	 */
	public BoardView() {
		setLayout(new GridLayout(6, 6, 0, 0));
		setOpaque(false);
		
		/* Intialize each View */
		for(int i = 0; i < 36; i++){
			JLabel label = new JLabel();
			label.setOpaque(true);
			label.setHorizontalAlignment(SwingConstants.CENTER);
			label.setFont(label.getFont().deriveFont(label.getFont().getSize() + 20f));
			label.setBorder(new LineBorder(new Color(0, 0, 0), 1));
			label.setBackground(Color.WHITE);
			add(label);
		}
		refresh();
	}
	
	/**
	 * Gets the board square label at the given row and column.
	 * 
	 * @param row The row of the square.
	 * @param col The column of the square.
	 * @return The label at the given row and col, or null if the index
	 * is out of bounds.
	 */
	public JLabel getBoardSquareLabel(int row, int col){
		if (row >= 6 || col >= 6 || row < 0 || col < 0) return null;
		return (JLabel) getComponent(row * 6 + col);
	}
	
	/**
	 * Retrieves the board square at the given position on the board view.
	 * 
	 * @param position
	 *            The position on the board view.
	 * @return The board square which is represented at the given position, or
	 *         null if there is none.
	 */
	public BoardSquare getBoardSquareAt(Point position) {
		// make sure the point is within the board (taking into account the borders)
		Insets borderInsets = ((EmptyBorder) getBorder()).getBorderInsets();
		if (position.x < borderInsets.left || position.y < borderInsets.top
				|| position.x > getWidth() - borderInsets.right || position.y > getHeight() - borderInsets.bottom)
			// the point is outside of the board
			return null;
		
		// see if the point is in between two squares (considering 20% margins around the squares
		Point squareSize = new Point(getBoardSquareLabel(0, 0).getWidth(), getBoardSquareLabel(0, 0).getHeight());
		if (position.x % squareSize.x < squareSize.x * 0.2 // near the left border of a square
				|| position.x % squareSize.x > squareSize.x - squareSize.x * 0.2 // near the right border of a square
				|| position.y % squareSize.y < squareSize.y * 0.2 // near the top of a square
				|| position.y % squareSize.y > squareSize.y - squareSize.y * 0.2) // near bottom of a square
			// the point is too close to the borders
			return null;
		
		// return the square at the given position
		return board.getSquare((position.y - borderInsets.top) / squareSize.y,
				(position.x - borderInsets.left) / squareSize.x);
	}
	
	/**
	 * Sets the board for the board view.
	 * @param board The board.
	 */
	public void setBoard(Board board) {
		this.board = board;
	}
	
	/**
	 * Refreshes the data of the board from the model.
	 */
	public void refresh() {		
		if (board != null) {
			// go through every square and update it according to the model
			for (int row = 0; row < 6; row++) {
				for (int col = 0; col < 6; col++) {
					BoardSquare square = board.getSquare(row, col);
					JLabel label = getBoardSquareLabel(row, col);
					// update the square to reflect the tile in it
					if (square.isEmpty()) 
						label.setText(null);
					else 
						label.setText(square.getTile().getContent());
					
					// highlight the square if it's highlighted
					if (board.getSelectedWord() != null && board.getSelectedWord().getBoardSquares().contains(square)) {
						label.setBackground(Color.GRAY);
					} else {
						label.setBackground(Color.WHITE);
					}
						
					// make disabled squares black
					if (!square.isEnabled())
						label.setBackground(Color.BLACK);
				}
			}
		}
		repaint();
	}
}
