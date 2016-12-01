/**
 * Tile.java
 * 
 * @author Scandium
 * Date: 11/28/2016
 * Description: This class represents the tiles to be placed on the board Square. Each tile 
 * has a content (qu, or any letter other than q), and a score dependent on the content. This
 * Class is used to store information and has no real functionality.
 */
package scandium.common.model;

public class Tile {
	
	/* ~~~~~                                                                               ~~~~~ *
	 * Class Attributes                                                                          *
	 * ~~~~~                                                                               ~~~~~ */
    String content;
    int score;

    /**
     * This function creates a new tile
     * @param content The String letter
     * @param score The integer score for the tile
     */
    public Tile(String content, int score) {
    	this.content = content;
    	this.score = score;
    }
    
    /**
     * This function returns the string representing the tiles content
     * @return String The tile's content
     */
	public String getContent() {
		return content;
	}

	/**
	 * This function returns an integer representing this tile's score
	 * @return int The tile's score 
	 */
	public int getScore() {
		return score;
	}
}