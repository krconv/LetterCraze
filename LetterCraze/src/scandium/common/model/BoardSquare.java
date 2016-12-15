/**
 * BoardSquare.java
 * 
 * @author Scandium
 */
package scandium.common.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * A square which a Board consists of.
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class BoardSquare {
	@XmlElement
    private int row;
	@XmlElement
    private int col;
	@XmlElement
    private Tile tile;
	@XmlElement
    private boolean enabled;
	@XmlTransient
    private Board board;
	
    /**
	 * Creates a board square with uninitialized data. 
	 * Precondition: None.
	 * Postcondition: The tile is created with uninitialized data.
     */
    @SuppressWarnings("unused") // used only for the XML Serializer
	private BoardSquare() {
    	row = -1;
    	col = -1;
    	enabled = true;
    }
    
    /**
     * Creates a new square on the given Board.
     * Precondition: The board is not null.
     * Postcondition: The given information has been saved in this square.
     * 
     * @param row The row that the square will be in.
     * @param col The column that the square will be in.
     * @param board The Board that the square will be in.
     * @param enabled Whether the square should initially be enabled.
     */
    BoardSquare(int row, int col, Board board, boolean enabled) {
    	this.row = row;
    	this.col = col;
    	this.board = board;
    	this.enabled = enabled;
    	this.tile = null;
    }
    
	/**
	 * Whether the square is enabled.
	 * @return the enabled
	 */
	public boolean isEnabled() {
		return enabled;
	}

	/**
	 * Whether this square is empty.
     * @return the is empty.
     */
    public boolean isEmpty() {
        return (this.tile == null);
    }

    /**
     * Sets the tile for this square.
	 * @param tile the tile to set
	 */
	public void setTile(Tile tile) {
		this.tile = tile;
	}

	/**
     * Removes any Tile from this square. 
     * @return Whether any changes were made.
     */
    public boolean removeTile() {
        if (!this.isEmpty()) {
        	this.tile = null;
        	return true;
        }
        return false;
    }

	/**
	 * Gets the row of this square.
	 * @return the row
	 */
	public int getRow() {
		return row;
	}

	/**
	 * Gets the column of this square.
	 * @return the col
	 */
	public int getCol() {
		return col;
	}

	/**
	 * Gets the tile of this square.
	 * @return the tile
	 */
	public Tile getTile() {
		return tile;
	}
	
	/**
	 * Gets the board this square is contained within.
	 * @return the board
	 */
	public Board getBoard(){
		return board;
	}

	/**
	 * Sets whether this square is enabled.
	 * @param enabled the enabled to set
	 */
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
    
    
}