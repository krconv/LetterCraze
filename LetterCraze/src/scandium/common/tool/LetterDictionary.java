/**
 * LetterDictionary.java
 * 
 * @author Scandium
 */
package scandium.common.tool;

import java.util.Random;

import scandium.common.model.Tile;

/**
 * A tool used for generating Tiles.
 */
public class LetterDictionary {
    @SuppressWarnings("unused")
	private String[] letters;
    @SuppressWarnings("unused")
	private double[] frequencies;
    @SuppressWarnings("unused")
	private int[] scores;
    Random random;

    /**
     * Creates a new LetterDictionary.
     * @param letters The letters which will be used to generate Tiles. 
     * @param frequencies A list of frequencies corresponding to the letters.
     * @param scores The list of scores corresponding to the letters.
     */
    public LetterDictionary(String[] letters, double[] frequencies, int[] scores) {
    	this.letters = letters;
    	this.frequencies = frequencies;
    	this.scores = scores;
    	this.random = new Random();
    }

    /**
     * @return a random Tile
     */
    public Tile getRandomTile() {
        // TODO implement here
		return null;
    }

}