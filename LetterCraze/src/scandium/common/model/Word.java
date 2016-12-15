/**
 * Word.java
 * 
 * @author Scandium
 * Date 12/1/2016
 * Description: This class represents the user's selected word. It stores information about the 
 * the various tiles and board squares. 
 */
package scandium.common.model;

import java.util.LinkedList;
import java.util.List;

/**
 * An object for holding a list of tiles and board square.
 */
public class Word {
	
	/* Class attributes                                                                          */
    private List<Tile> tiles;
    private List<BoardSquare> selection;
    
    /**
	 * Creates a new word with the given first selected board square.
	 * Precondition: The given square is not null, it is enabled and it has a
	 * tile. 
	 * Postcondition: The given square is selected and it's tile is recorded.
	 * 
	 * @param first
	 *            The first square selected.
	 * @exception NullPointerException
	 *                Thrown if the given square is null.
	 * @exception IllegalArgumentException
	 *                Thrown if the given square is disabled or is empty.
	 */
    public Word(BoardSquare first) throws NullPointerException, IllegalArgumentException {
    	this.tiles = new LinkedList<Tile>();
    	this.selection = new LinkedList<BoardSquare>();

    	tiles.add(first.getTile());
    	selection.add(first);
    }

    /**
     * Generates the string representation of the selected tiles.
     * Precondition: None.
     * Postcondition: The value of the tiles that were selected are combined (in their
     * selection order) into a string and returned.
     * 
     * @return A string consisting of all of the tiles that have been selected.
     */
    public final String generateString() {
    	/* Create Empty Word */
        String word = "";
        /* For every Selected Tile */
        for(Tile tile : tiles){
        	/* Concatenate Tile */ 
        	word += tile.getContent();
        }
        return word;
    }

    /**
     * Calculates the total score of the currently selected word.
     * Precondition: None.
     * Postcondition: The cumulative score of the selected tiles is calculated, which
     * is composed of the total score of the selected tiles, times an optional modifier
     * of the number of selected squares minus 2 if there are more than 3 selected squares.
     * 
     * @return The cumulative score of all of the selected tiles.
     */
    public int calculateScore() {
    	int score = 0;
    	/* For every selected tile */
    	for(Tile tile : tiles){
    		score += tile.getScore();
    	}
    	/* Adjust the score based on the length (See lettercraze powerpoint for more info) */
    	if(tiles.size() >= 3) score *= (tiles.size() - 2);
  
        return score;
    }

    /**
	 * Adds another square to the selection. 
	 * Precondition: The given square is not null, it is enabled and it has a tile. 
	 * Postcondition: The given square is selected (if it isn't already) and it's tile is recorded.
	 * 
	 * @param square
	 *            The selected BoardSquare.
	 * @return Whether the board square was selected (false if this board square
	 *         is already selected).
	 * 
	 * @exception NullPointerException
	 *                Thrown if the given square is null.
	 */
    public boolean addSelectedBoardSquare(BoardSquare square) throws NullPointerException {
    	if (square == null) throw new NullPointerException();
    	if (!selection.contains(square)) {
    		selection.add(square);
    		if (!square.isEmpty()) {
        		tiles.add(square.getTile());
    		}
    		return true;
    	} else {
    		return false;
    	}
    }
    
    /**
     * Gets the tiles in this word.
     * @return the tiles that have been selected.
     */
    public List<Tile> getTiles(){
    	return tiles;
    }
    
    /**
     * Gets the board squares in this word.
     * @return the board squares that have been selected.
     */
    public List<BoardSquare> getBoardSquares(){
    	return selection;
    }
    
    /**
     * Gets the last selected square in this word.
     * @return the most recently selected board square
     */
    public BoardSquare getLastSelectedSquare() {
    	return selection.get(selection.size() - 1);
    }
}