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
    	this.tile = null;
    }
    
	/**
	 * @return the enabled
	 */
	public boolean isEnabled() {
		return enabled;
	}

	/**
     * @return Whether this square is empty.
     */
    public boolean isEmpty() {
        return (this.tile == null);
    }

    /**
     * Removes any Tile from this square, if there is one. 
     * @return Whether any changes were made.
     */
    public boolean removeTile() {
        if (!this.isEmpty()) {
        	this.tile = null;
        	return true;
        }
        return false;
    }

    /*-----Get Methods-----*/
    public int getRow(){
    	return this.row;
    }
    
    public int getCol(){
    	return this.col;
    }
    
    public Board getBoard(){
    	return this.board;
    }
    
    public Tile getTile(){
    	return this.tile;
    }
    
    //getEnabled() is redundant by isEnabled()
    
    
    /*-----Set Methods-----*/
    public void setRow(int row){
    	this.row = row;
    }
    
    public void setCol(int col){
    	this.col = col;
    }
    public void setBoard(Board board){
    	this.board = board;
    }
    
    public void setTile(Tile tile){
    	this.tile = tile;
    }
    
    public void setEnabled(boolean enabled){
    	this.enabled = enabled;
    }
}