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
    private boolean shouldRegenerate = true;

    /**
     * Creates a new Board.
     * @param shouldRegenerate Whether new Tiles should be generated.
     * @param gravityDirection The direction of gravity for the board.
     */
    public Board(boolean shouldRegenerate, GravityDirection gravityDirection) {
        // TODO implement here
    }

    /**
	 * @return the squares
	 */
	public BoardSquare[][] getSquares() {
		return squares;
	}

	/**
	 * @return the selectedWord
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
	 * @return the whether tiles shouldRegenerate
	 */
	public boolean shouldRegenerate() {
		return shouldRegenerate;
	}



	/**
     * Insert a Word into the Board, shifting Tiles in the direction opposite to gravity.
     * @param word The Word to insert.
     * @return Whether the Word was inserted.
     */
    public boolean insertWord(Word word) {
        // TODO implement here
        return false;
    }

    /**
     * Removes the elected Word from the Board.
     * @return Whether the selected Word was removed.
     */
    public boolean removeSelectedWord() {
        // TODO implement here
        return false;
    }

    /**
     * Apply gravity to the board, moving Tiles to fill empty squares in the direction of gravity.
     * @return Whether gravity was successfully applied.
     */
    public boolean applyGravity() {
        // TODO implement here
        return false;
    }

    /**
     * Fills empty squares on the Board with random tiles from the given dictionary.
     * @param dictionary The dictionary used to generate tiles.
     * @return Whether any empty squares were filled.
     */
    public boolean fillEmptySquares(LetterDictionary dictionary) {
        // TODO implement here
        return false;
    }

    /**
     * Clears the tiles from the board.
     * @return Whether all of the Tiles were removed.
     */
    public boolean clearExistingTiles() {
        // TODO implement here
        return false;
    }

    /**
     * Selects a new square on the board.
     * @param square The square to select.
     * @return Whether the square was selected.
     */
    public boolean selectSquare(BoardSquare square) {
        // TODO implement here
        return false;
    }

    /**
     * Selects a new square on the board.
     * @param row The row that the square is in.
     * @param col The column that the square is in.
     * @return Whether the square was selected.
     */
    public boolean selectSquare(int row, int col) {
        // TODO implement here
        return false;
    }

    /**
     * Deselects the selected word.
     * @return Whether any word was deselected.
     */
    public boolean deselectWord() {
        // TODO implement here
        return false;
    }

    /**
     * Determines whether the Board is valid.
     * @return Whether the Board is valid.
     */
    public boolean isValid() {
        // TODO implement here
        return false;
    }

}