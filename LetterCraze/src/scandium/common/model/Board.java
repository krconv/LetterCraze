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
        this.shouldRegenerate = shouldRegenerate;
        this.gravityDirection = gravityDirection;
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
	 * Returns a BoardSquare that corresponds to a position given
	 * @param row The row the BoardSquare is in
	 * @param col The column the BoardSquare is in
	 * @return The BoardSquare at the given position
	 */
	public BoardSquare getBoardSquare(int row, int col){
		BoardSquare bs = squares[row][col];
		return bs;
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
     * Removes the selected Word from the Board.
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
        int indicator = 0;
        for (int i = 0; i < squares.length; i++){
        	for (int j = 0; j < squares.length; j++){
        		if ((squares[i][j].getTile() == null) && (squares[i][j].isEnabled() == true)){
        			squares[i][j].setTile(dictionary.getRandomTile());
        			indicator = 1;
        		}
        	}
        }
        if (indicator == 1){
        	return true;
        }else{
        	return false;
        }
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
    	if (selectedWord.addSelectedBoardSquare(square)){
    		return true;
    	}else{
    		return false;
    	}
    }

    /**
     * Selects a new square on the board.
     * @param row The row that the square is in.
     * @param col The column that the square is in.
     * @return Whether the square was selected.
     */
    public boolean selectSquare(int row, int col) {
        BoardSquare bs = getBoardSquare(row, col);
        if (selectedWord.addSelectedBoardSquare(bs)){
        	return true;
        }else{
        	return false;
        }
    }

    /**
     * Deselects the selected word.
     * @return Whether any word was deselected.
     */
    public boolean deselectWord() { //I started to write this method, but I think we need a removeSelectedBoardSquare in the Word class
        // TODO implement here
    	//for (int i = selectedWord.getTiles().size(); i == 0; i--){
    		
    	//}
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