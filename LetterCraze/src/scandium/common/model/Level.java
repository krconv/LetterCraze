/**
 * Level.java
 * 
 * @author Scandium
 */
package scandium.common.model;

import java.util.Random;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlSeeAlso;

import scandium.common.tool.IWordDictionary;
import scandium.common.tool.LevelRestrictor;
import scandium.common.tool.WordDictionary;

/**
 * A class which holds basic information about a Level.
 */
@XmlSeeAlso({ PuzzleLevel.class, LightningLevel.class, ThemeLevel.class })
@XmlAccessorType(XmlAccessType.FIELD)
public abstract class Level {
	@XmlElement
	private String name;
	@XmlElement
	private Board board;
	@XmlElementWrapper(name = "stars")
	@XmlElement(name = "star")
	private Star[] stars;
	@XmlElement
	private long token;

	/**
	 * Creates a new Level with the default information.
	 */
	public Level() {
		this.name = new String();
		this.board = new Board();
		this.stars = new Star[] { new Star(), new Star(), new Star() };
		this.token = new Random().nextLong();
	}

	/**
	 * Creates a new Level with the given information.
	 * 
	 * @param name
	 *            The name of the Level.
	 * @param board
	 *            The Board that the Level will use.
	 * @param stars
	 *            The Stars that the Level will use.
	 */
	public Level(String name, Board board, Star[] stars) {
		this.name = name;
		this.board = board;
		this.stars = stars;
		// generate a random token that is not zero
		this.token = new Random().nextLong();
	}

	/**
	 * Gets the name of the level.
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name of the level.
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the board for the level.
	 * @return the board
	 */
	public Board getBoard() {
		return board;
	}

	/**
	 * Sets the board for the level.
	 * @param board
	 *            the board to set
	 */
	public void setBoard(Board board) {
		this.board = board;
	}

	/**
	 * Gets the stars for the level.
	 * @return an array of the Stars in the level
	 */
	public Star[] getStars() {
		return stars;
	}

	/**
	 * Gets a star for this level.
	 * @param index
	 *            the zero-based index of the desired star
	 * @return returns the star at the index
	 */
	public Star getStar(int index) {
		return getStars()[index];
	}

	/**
	 * 
	 * @return the token
	 */
	public long getToken() {
		return token;
	}

	/**
	 * Determines how many points should be gained for finding the given word.
	 * 
	 * @param word
	 *            The word that is being scored.
	 * @return The score of the found word.
	 */
	public abstract int determineScore(Word word);

	/**
	 * Determines whether the given word is a word that can be played in this
	 * level.
	 * 
	 * @param word
	 *            The word to check.
	 * @return Whether the word is a valid word.
	 */
	public boolean isValidWord(Word word) {
		return WordDictionary.instance.isWord(word.generateString());
	}

	/**
	 * Retrieves the dictionary that this level uses to validate words.
	 * 
	 * @return The word dictionary used to validate words for this level.
	 */
	public IWordDictionary getWordDictionary() {
		return WordDictionary.instance;
	}

	/**
	 * Gets a new level restrictor for this level.
	 * 
	 * @return A new level restrictor for this level.
	 */
	public abstract LevelRestrictor getRestrictor();

	/**
	 * Gets the units that the scores for this level are in.
	 * 
	 * @param plural
	 *            Whether the unit should be pluralized.
	 * @return The units for the scores in this level.
	 */
	public abstract String getScoreUnits(boolean plural);

	/**
	 * Gets the type of the level.
	 * @return the user friendly type of the Level
	 */
	public abstract String getType();

	/**
	 * Copies the data in this Level into a new Level.
	 * 
	 * @return A copy of this Level.
	 */
	public abstract Level copy();

	/**
	 * Determines whether this Level is valid.
	 * 
	 * @return Whether this Level is valid.
	 */
	public boolean isValid() { // For each of the different isValid methods, it
								// might need to get more specific with how it
								// is implemented in the future.
		return ((name != null) && !name.isEmpty() && (board != null) && (stars != null) && stars.length == 3
				&& 0 < stars[0].getThreshold() && stars[0].getThreshold() < stars[2].getThreshold()
				&& stars[1].getThreshold() < stars[2].getThreshold() && board.isValid());
	}
}