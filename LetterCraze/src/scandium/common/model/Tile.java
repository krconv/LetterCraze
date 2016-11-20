/**
 * Tile.java
 * 
 * @author Scandium
 */
package scandium.common.model;

/**
 * A item which can be moved around.
 */
public class Tile {
    private String content;
    private int score;

    /**
     * Creates a new Tile.
     * @param content The content of the new tile.
     * @param score The score of the new tile.
     */
    public Tile(String content, int score) {
    	this.content = content;
    	this.score = score;
    }

	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @return the score
	 */
	public int getScore() {
		return score;
	}
}