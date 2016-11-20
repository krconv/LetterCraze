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
     * @return the string generated by the selected squares
     */
    public final String generateString() {
        // TODO implement here
        return "";
    }

    /**
     * @return the total score of the contained tiles
     */
    public int calculateScore() {
        // TODO implement here
        return 0;
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