/**
 * BoardSquare.java
 * 
 * @author Scandium
 */
package scandium.common.model;

/**
 * A square which a Board consists of.
 */
public class BoardSquare {
    private int row;
    private int col;
    private Board board;
    private Tile tile;
    private boolean enabled;

    /**
     * Creates a new square on the given Board.
     * Precondition: The board is not null.
     * Postcondition: The given information has been saved in this square.
     * 
     * @param row The row that the square will be in.
     * @param col The column that the square will be in.
     * @param board The Board that the square will be in.
     * @param enabled Whether the square should initially be enabled.
     * 
     * @exception NullPointerException Thrown if the board is null.
     */
    BoardSquare(int row, int col, Board board, boolean enabled) throws NullPointerException {
    	this.row = row;
    	this.col = col;
    	this.board = board;
    	this.enabled = enabled;
    }
    
    /**
	 * @return the tile
	 */
	public Tile getTile() {
		return tile;
	}

	/**
	 * @param tile the tile to set
	 */
	public void setTile(Tile tile) {
		this.tile = tile;
	}

	/**
	 * @return the enabled
	 */
	public boolean isEnabled() {
		return enabled;
	}

	/**
	 * @param enabled the enabled to set
	 */
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	/**
	 * @return the row
	 */
	public int getRow() {
		return row;
	}

	/**
	 * @return the col
	 */
	public int getCol() {
		return col;
	}

	/**
	 * @return the board
	 */
	public Board getBoard() {
		return board;
	}

	/**
     * @return Whether this square is empty.
     */
    public boolean isEmpty() {
    	if (tile == null){ 
    		return true; 
    	}else{ 
    		return false;
    		}
    }

    /**
     * Removes any Tile from this square, if there is one. 
     * @return Whether any changes were made.
     */
    public boolean removeTile() {
        if (tile != null){
        	tile = null;
        	return true;
        }else{
            return false;
        }
    }

}