/**
 * Board.java
 * 
 * @author Scandium
 */
package scandium.common.model;

import scandium.common.tool.LetterDictionary;

/**
 * A play area container for Tiles.
 */
public class Board {
	private BoardSquare[][] squares;
	private Word selectedWord;
	private GravityDirection gravityDirection;
	private boolean shouldRegenerate;

	/**
	 * Creates a new Board. 
	 * Postcondition: All of the squares will be created, and the gravity direction and should 
	 * regenerate will be updated to indicate the given information.
	 * 
	 * @param shouldRegenerate
	 *            Whether new Tiles should be generated.
	 * @param gravityDirection
	 *            The direction of gravity for the board.
	 */
	public Board(boolean shouldRegenerate, GravityDirection gravityDirection) {
		// TODO implement here
	}

	/**
	 * Gets the square at the given position. 
	 * Precondition: The indicated position is a valid one. 
	 * Postcondition: The indicated square on the board is returned.
	 * 
	 * @param row
	 *            The row of the square.
	 * @param col
	 *            The column of the square.
	 * @return The indicated square.
	 * @throws IndexOutOfBoundsException
	 *             Thrown if the given row or column is out of bounds.
	 */
	public BoardSquare getSquare(int row, int col) throws IndexOutOfBoundsException {
		return squares[row][col];
	}

	/**
	 * Precondition: None.
	 * Postcondition: The selected word has been returned without removing it.
	 * @return the selectedWord, or null if no selection has been made.
	 */
	public Word getSelectedWord() {
		return selectedWord;
	}

	/**
	 * @return the gravityDirection
	 */
	public GravityDirection getGravityDirection() {
		return gravityDirection;
	}
	
	/**
	 * Sets the gravity direction for the board.
	 * @param direction The direction to change it to.
	 */
	public void setGravityDirection(GravityDirection direction) {
		gravityDirection = direction;
	}


	/**
	 * @return the whether tiles shouldRegenerate
	 */
	public boolean shouldRegenerate() {
		return shouldRegenerate;
	}

	/**
	 * Insert a Word into the Board, shifting tiles in the direction opposite to
	 * gravity.
	 * Precondition: The word is not null and the word consists of board squares on this board.
	 * Postcondition: Any tiles in the given word are inserted into the board, and any tiles that 
	 * need to be moved for this insert were moved in the direction opposite to gravity.
	 * 
	 * @param word
	 *            The Word to insert.
	 * @return Whether any tiles were inserted.
	 * @exception IllegalArgumentException Thrown if the word consists of boards squares which are
	 * not in this board.
	 */
	public boolean insertWord(Word word) throws IllegalArgumentException {
		// TODO implement here
		return false;
	}

	/**
	 * Removes the selected Word from the Board.
	 * Precondition: None.
	 * Postcondition: The selected word is removed from the board if it exists and the
	 * selected word is deselected.
	 * 
	 * @return Whether a word was removed.
	 */
	public boolean removeSelectedWord() {
		// TODO implement here
		return false;
	}

	/**
	 * Apply gravity to the board, moving Tiles to fill empty squares in the
	 * direction of gravity.
	 * Precondition: None.
	 * Postcondition: All tiles will be moved in the direction of gravity to fill
	 * empty squares if there are any. The board will have the same number of tiles
	 * and the same values after applying gravity.
	 * 
	 * @return Whether any tiles were moved.
	 */
	public boolean applyGravity() {
		// TODO implement here
		return false;
	}

	/**
	 * Fills empty squares on the Board with random tiles from the given
	 * dictionary. 
	 * Precondition: The dictionary is not null. 
	 * Postcondition: All empty squares on the board have been populated with a new tile
	 * while existing squares are not changed.
	 * 
	 * @param dictionary
	 *            The dictionary used to generate tiles.
	 * @return Whether any empty squares were filled.
	 */
	public boolean fillEmptySquares(LetterDictionary dictionary) {
		// TODO implement here
		return false;
	}

	/**
	 * Clears the tiles from the board.
	 * Precondition: None.
	 * Postcondition: All tiles on the board have been removed.
	 * 
	 * @return Whether any of the tiles were removed.
	 */
	public boolean clearExistingTiles() {
		// TODO implement here
		return false;
	}

	/**
	 * Selects a new square on the board.
	 * Precondition: The given board square is on this board.
	 * Postcondition: The indicated square will be added to the selected word if the selection is
	 * valid (e.g. the selection is consecutive, not repeating, and it contains a tile).
	 * 
	 * @param square
	 *            The square to select.
	 * @return Whether the square was selected.
	 * @throws IllegalArgumentException
	 *             Thrown if the given square is not in this board.
	 */
	public boolean selectSquare(BoardSquare square) throws IllegalArgumentException {
		// TODO implement here
		return false;
	}

	/**
	 * Selects a new square on the board. 
	 * Precondition: The given position exists on the board.
	 * Postcondition: The indicated square will be added to the selected word if the selection is
	 * valid (e.g. the selection is consecutive, not repeating, and it contains a tile).
	 * 
	 * @param row
	 *            The row that the square is in.
	 * @param col
	 *            The column that the square is in.
	 * @return Whether the square was selected.
	 * @throws IndexOutOfBoundsException
	 *             Thrown if the given row or column is out of bounds.
	 */
	public boolean selectSquare(int row, int col) throws IndexOutOfBoundsException {
		// TODO implement here
		return false;
	}

	/**
	 * Deselects the selected word.
	 * Precondition: None.
	 * Postcondition: Any word that is currently selected will be deselected.
	 * 
	 * @return Whether any word was deselected.
	 */
	public boolean deselectWord() {
		// TODO implement here
		return false;
	}

	/**
	 * Determines whether the Board is valid.
	 * 
	 * @return Whether the Board is valid.
	 */
	public boolean isValid() {
		// TODO implement here
		return false;
	}

}