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
     * @param first The first square selected.
     */
    public Word(BoardSquare first) {
    	this.tiles = new LinkedList<Tile>();
    	this.selection = new LinkedList<BoardSquare>();

    	tiles.add(first.getTile());
    	selection.add(first);
    }

    /**
     * This function returns the string representation of the selected tiles.
     * @return String
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
     * This function returns the total score of the currently selected word
     * @return int
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
     * This function adds another square to the selection
     * @param square The Selected BoardSquare
     * @return boolean Was the addition of the board square successful?
     */
    public boolean addSelectedBoardSquare(BoardSquare square) {
        boolean result = tiles.add(square.getTile());
        if(result) result = selection.add(square);
        return result;
    }
    
    /**
     * This function returns the selected tiles
     */
    public List<Tile> getTiles(){
    	return tiles;
    }
    
    /**
     * This function returns the selected boardSquares
     */
    public List<BoardSquare> getBoardSquares(){
    	return selection;
    }
}