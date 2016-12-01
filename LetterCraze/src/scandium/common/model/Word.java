/**
 * Word.java
 * 
 * @author Scandium
 */
package scandium.common.model;

import java.util.LinkedList;
import java.util.List;

/**
 * An object for holding a list of tiles and board square.
 */
public class Word {
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
     * @return the total score of the contained tiles
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
     * Add another square to the selection.
     * @param square The square to select.
     * @return Whether the given square was selected.
     */
    public boolean addSelectedBoardSquare(BoardSquare square) {
        // TODO implement here
        return false;
    }
}