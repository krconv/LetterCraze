/**
 * Board.java
 * 
 * @author Scandium
 */
package scandium.common.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import scandium.common.tool.LetterDictionary;

/**
 * A play area container for tiles, which is made out of board squares.
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Board {
	@XmlElementWrapper(name = "rows")
	@XmlElement(name = "row")
    private BoardSquare[][] squares;
	@XmlTransient
	private Word selectedWord;
	@XmlElement
	private GravityDirection gravityDirection;
	@XmlElement
	private boolean shouldRegenerate;

	/**
	 * Creates a new Board with the default information.
	 * Precondition: None.
	 * Postcondition: The board is created with default information.
	 */
	public Board() {
		this(true, GravityDirection.Up);
	}

	/**
	 * Creates a new Board with the given information.
	 * Precondition: None.
	 * Postcondition: The board is created with the given information.
	 * 
	 * @param shouldRegenerate Whether new tiles should ever be regenerated.
	 * @param gravityDirection The direction of gravity
	 */
	public Board(boolean shouldRegenerate, GravityDirection gravityDirection) {
		this.shouldRegenerate = shouldRegenerate;
		this.gravityDirection = gravityDirection;
		this.squares = new BoardSquare[6][6];

		// create all of the squares
		for (int row = 0; row < 6; row++) {
			for (int col = 0; col < 6; col++) {
				squares[row][col] = new BoardSquare(row, col, this, true);
			}
		}
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
		return this.selectedWord;
	}

	/**
	 * @return the gravityDirection
	 */
	public GravityDirection getGravityDirection() {
		return this.gravityDirection;
	}
	
	/**
	 * Sets the gravity direction for the board.
	 * @param direction The direction to change it to.
	 */
	public void setGravityDirection(GravityDirection direction) {
		this.gravityDirection = direction;
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
	public boolean insertWord(Word word) {
		// insert the tiles back in to the board by iterating row by row
		if (word == null){ return false; }
		for (int row = 0; row < 6; row++) {
			for (int col = 0; col < 6; col++) {
				if (word.getBoardSquares().contains(getSquare(row, col))) {
					// the current square needs to be inserted into, so we need to shift everything down
					// we will do this by remembering the current tile, removing it, then replacing it on
					// the next valid board square
					Tile tile = getSquare(row, col).getTile();
					getSquare(row, col).removeTile();
					for (int i = 1; i + row < 6 && tile != null; i++) {
						BoardSquare square = getSquare(row + i, col);
						if (square.isEnabled()) {
							Tile temp = square.getTile();
							square.setTile(tile);
							tile = temp;
						}
					}
					// set the square that we emptied to the tile that is being inserted
					getSquare(row, col).setTile(word.getTiles().get(word.getBoardSquares().indexOf(getSquare(row, col))));
				}
			}
		}
		return !word.getTiles().isEmpty();
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
		if (selectedWord != null) {
			// a word was selected so remove it
			for(BoardSquare bs : selectedWord.getBoardSquares()){
				bs.setTile(null);
			}
			selectedWord = null;
			return true;
		} else
			// no word was selected
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
		/* indicator of tile movement */
		boolean moved_tiles = false;
		/* Apply Upwards Gravity */
		if(getGravityDirection() == GravityDirection.Up){
			// go through each column and apply gravity to it
			for (int col = 0; col < 6; col++) {
				for (int row = 0; row < 6; row++) {
					BoardSquare square = getSquare(row, col);
					if (square.isEnabled()) {
						// we should try to fill this square
						for (int i = 1; square.isEmpty() && i + row < 6; i++) {
							// continue to look to the squares below until we find one that has a tile
							BoardSquare filler = getSquare(row + i, col);
							if (!filler.isEmpty()) {
								// found a tile to fill with, so let's move it
								square.setTile(filler.getTile());
								filler.removeTile();
								moved_tiles = true;
							}
						}
					}
				}
			}
		}else System.out.println("Have not yet implemented other gravity directions");
		
		return moved_tiles;
		
		/*
		boolean didItWork = false;
		if(this.getGravityDirection() == GravityDirection.Up){
	        int indicator = 0;
	        for (int i = 0; i < squares.length; i++){
	        	for (int j = 0; j < squares.length; j++){
	        		if ((squares[i-1][j].getTile() == null) && (squares[i-1][j].isEnabled() == true) && (squares[i][j].getTile() == null) && (squares[i][j].isEnabled() == true)){
	        			//^^^^^This logic probably doesn't work
	        			//move shit from one to the next above
	        			squares[i-1][j].setTile(squares[i][j].getTile());
	        			squares[i][j].setTile(null);
	        			indicator = 1;
	        		}
	        	}
	        }
	        if (indicator == 1){
	        	didItWork = true;
	        }else{
	        	didItWork = false;
	        }
		}
		if(this.getGravityDirection() == GravityDirection.Right && didItWork == false){
	        int indicator = 0;
	        for (int i = 0; i < squares.length; i++){
	        	for (int j = 0; j < squares.length; j++){
	        		if ((squares[i][j+1].getTile() == null) && (squares[i][j+1].isEnabled() == true) && (squares[i][j].getTile() == null) && (squares[i][j].isEnabled() == true)){
	        			//^^^^^This logic probably doesn't work
	        			//move shit from one to the next right one
	        			squares[i][j+1].setTile(squares[i][j].getTile());
	        			squares[i][j].setTile(null);
	        			indicator = 1;
	        		}
	        	}
	        }
	        if (indicator == 1){
	        	didItWork = true;
	        }else{
	        	didItWork = false;
	        }
		}
		if(this.getGravityDirection() == GravityDirection.Down && didItWork == false){
	        int indicator = 0;
	        for (int i = 0; i < squares.length; i++){
	        	for (int j = 0; j < squares.length; j++){
	        		if ((squares[i+1][j].getTile() == null) && (squares[i+1][j].isEnabled() == true) && (squares[i][j].getTile() == null) && (squares[i][j].isEnabled() == true)){
	        			//^^^^^This logic probably doesn't work
	        			//move shit from one to the next below
	        			squares[i+1][j].setTile(squares[i][j].getTile());
	        			squares[i][j].setTile(null);
	        			indicator = 1;
	        		}
	        	}
	        }
	        if (indicator == 1){
	        	didItWork = true;
	        }else{
	        	didItWork = false;
	        }
		}
		if(this.getGravityDirection() == GravityDirection.Left && didItWork == false){
	        int indicator = 0;
	        for (int i = 0; i < squares.length; i++){
	        	for (int j = 0; j < squares.length; j++){
	        		if ((squares[i][j-1].getTile() == null) && (squares[i][j-1].isEnabled() == true) && (squares[i][j].getTile() == null) && (squares[i][j].isEnabled() == true)){
	        			//^^^^^This logic probably doesn't work
	        			//move shit from one to the next left one
	        			squares[i][j-1].setTile(squares[i][j].getTile());
	        			squares[i][j].setTile(null);
	        			indicator = 1;
	        		}
	        	}
	        }
	        if (indicator == 1){
	        	didItWork = true;
	        }else{
	        	didItWork = false;
	        }
		}
		
		return didItWork;
		*/
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
	 * Precondition: None.
	 * Postcondition: All tiles on the board have been removed.
	 * 
	 * @return Whether any of the tiles were removed.
	 */
	public boolean clearExistingTiles() {
		int indicator = 0;
        for (int i = 0; i < squares.length; i++){
        	for (int j = 0; j < squares.length; j++){
        		if (squares[i][j].getTile() != null){
        			squares[i][j].removeTile();
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
	 * Selects a new square on the board. 
	 * Precondition: The given position exists on the board.
	 * Postcondition: The indicated square will be added to the selected word if the selection is
	 * valid (e.g. the selection is consecutive, not repeating, and it contains a tile).
	 * 
	 * @param square The square to select.
	 * 
	 * @return Whether the square was selected.
	 */
	public boolean selectSquare(BoardSquare square) {
		if (square.isEmpty() || !square.isEnabled()) return false;
		
		if (selectedWord == null) {
			selectedWord = new Word(square);
			return true;
		} else {
			BoardSquare lastSelected = selectedWord.getLastSelectedSquare();
			if (square.getRow() >= lastSelected.getRow() - 1 && square.getRow() <= lastSelected.getRow() + 1
					&& square.getCol() >= lastSelected.getCol() - 1 && square.getCol() <= lastSelected.getCol() + 1)
				return selectedWord.addSelectedBoardSquare(square);
			else
				return false;
		}
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
		return selectSquare(getSquare(row, col));
	}
	
	/**
	 * Deselects the selected word.
	 * Precondition: None.
	 * Postcondition: Any word that is currently selected will be deselected.
	 * 
	 * @return Whether any word was deselected.
	 */
	public boolean deselectWord() {
		if (selectedWord != null){
			selectedWord = null;
			return true;
		}else{
			return false;
		}
	}

	/**
	 * Determines whether the Board is valid.
	 * 
	 * @return Whether the Board is valid.
	 */
	public boolean isValid() {
		return squares != null && getNumEnabled() >= 9;
	}
	
	/**
	 * Counts how many squares on the board are enabled.
	 * @return The number of squares on the board that are enabled.
	 */
	private int getNumEnabled() {
		int indicator = 0;
        for (int i = 0; i < squares.length; i++){
        	for (int j = 0; j < squares[i].length; j++){
        		if (squares[i][j].isEnabled()){
        			indicator++;
        		}
        	}
        }
        return indicator;
	}
}