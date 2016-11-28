/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ *
 * ~~~~~ Team Scandium                                                                           *
 * ~~~~~ CS 3733                                                                                 *
 * ~~~~~ Project: Level Builder                                                                  *
 * ~~~~~ Created: November 28th                                                                  *
 * ~~~~~ Class: Tile                                                                             *
 * ~~~~~        This class represents the tiles to be placed on the board Square. Each tile      *
 * ~~~~~        has a content (qu, or any letter other than q), and a score dependent on the     *
 * ~~~~~        content. This class is used to store information and has no real functionality.  *
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
package scandium.common.model;

public class Tile {
	
	/* ~~~~~                                                                               ~~~~~ *
	 * Class Attributes                                                                          *
	 * ~~~~~                                                                               ~~~~~ */
    String content;
    int score;

    /**
     * Creates a new Tile.
     * @param content The content of the new tile.
     * @param score The score of the new tile.
     */
    
	/**~~~~~                                                                               ~~~~~ *
	 * Constructor Method                                                                        *
	 * @param content: The content of the new tile.                                              *
	 * @param score: The score of the new tile.                                                  *
	 * ~~~~~                                                                               ~~~~~ */
    public Tile(String content, int score) {
    	this.content = content;
    	this.score = score;
    }

	/**~~~~~                                                                               ~~~~~ *
	 * getContent()                                                                              *
	 * @return String                                                                            *
	 * This function returns the string representing the tiles content.                          *
	 * ~~~~~                                                                               ~~~~~ */
	public String getContent() {
		return content;
	}

	/**~~~~~                                                                               ~~~~~ *
	 * getScore()                                                                                *
	 * @return int                                                                               *
	 * This function returns an integer representing this tiles score                            *
	 * ~~~~~                                                                               ~~~~~ */
	public int getScore() {
		return score;
	}
}