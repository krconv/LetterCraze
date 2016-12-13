/**
 * LevelProgress.java
 * 
 * @author Scandium
 */
package scandium.lettercraze.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import scandium.common.model.Level;
import scandium.common.model.Star;
import scandium.common.tool.LevelRestrictor;

/**
 * An object which contains information about a Player's progress in a Level.
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class LevelProgress {
	@XmlTransient
	private Level level;
	@XmlElement
	private int score;
	@XmlElement
	private int starCount;
	@XmlTransient
	private List<String> foundWords;
	@XmlTransient
	private boolean isPlaying;
	@XmlElement
	private boolean isUnlocked;
	@XmlTransient
	private LevelRestrictor restrictor;

	/**
	 * Creates a new Level progress with uninitialized information.
	 */
	public LevelProgress() {
		isPlaying = false;
		foundWords = new ArrayList<String>();
		isUnlocked = false;
	}
	
	/**
	 * Creates a new Level progress with the given information.
	 * 
	 * @param level
	 *            The level that this progress will be tied to.
	 */
	public LevelProgress(Level level) {
		this.level = level;
		isPlaying = false;
		foundWords = new ArrayList<String>();
		isUnlocked = false;
	}

	/**
	 * Updates the level which this progress is based on.
	 * Precondition: The given level is not null.
	 * Postcondition: This progress represents the given level.
	 * 
	 * @param level
	 *            The level to update using.
	 */
	public void setLevel(Level level) {
		this.level = level;
		restrictor = level.getRestrictor();
	}

	/**
	 * @return the score
	 */
	public int getScore() {
		return score;
	}

	/**
	 * Sets the score and updates the star count accordingly
	 * @param score
	 *            the score to set
	 */
	public void setScore(int score) {
		if (score >= 0){ //Checks to make sure a negative score is not being set
			this.score = score;
		
			// determine how many stars have been obtained
			starCount = 0;
			for (Star star : getLevel().getStars()) {
				if (star != null){
					if (star.isObtained(score))
						starCount++;
				}
			}
		}
	}

	/**
	 * @return the isPlaying
	 */
	public boolean isPlaying() {
		return isPlaying;
	}

	/**
	 * @param isPlaying
	 *            the isPlaying to set
	 */
	public void setPlaying(boolean isPlaying) {
		this.isPlaying = isPlaying;		
	}

	/**
	 * @return the level
	 */
	public Level getLevel() {
		return level;
	}

	/**
	 * @return the restrictor
	 */
	public LevelRestrictor getRestrictor() {
		return restrictor;
	}

	/**
	 * @return the starCount
	 */
	public int getStarCount() {
		return starCount;
	}

	/**
	 * @return the isUnlocked
	 */
	public boolean isUnlocked() {
		return isUnlocked;
	}

	/**
	 * @return the foundWords
	 */
	public List<String> getFoundWords() {
		return foundWords;
	}

	/**
	 * Resets the progress.
	 */
	public void reset() {
		this.score = 0;
		this.starCount = 0;
		this.foundWords.clear();
	}

	/**
	 * Determines whether this progress has a higher score than the stored high
	 * score for this level.
	 * Precondition: None.
	 * Postcondition: Determines whether this progress is a higher score.
	 * 
	 * @param lp The level progress to compare to.
	 *           
	 * @return Whether this progress has a higher score. 
	 */
	public boolean isHigherScore(LevelProgress lp) {
		return lp.getScore() < this.score;
	}

	/**
	 * Updates the score and the star count for this progress.
	 * 
	 * @param delta
	 *            The amount to change the score by.
	 */
	public void updateScore(int delta) {
		setScore(score + delta);
	}

	/**
	 * Adds a word to the list of found words
	 * 
	 * @param word
	 *            The found word
	 */
	public void addFoundWord(String word) {
		this.foundWords.add(word);
	}
	
	/**
	 * Updates this progress's unlocked status.
	 * @param isUnlocked The new value of whether this progress is unlocked.
	 * @return Whether the value was changed.
	 */
	public boolean setUnlocked(boolean isUnlocked) {
		if (this.isUnlocked != isUnlocked) {
			this.isUnlocked = isUnlocked;
			return true;
		} else
			return false;
	}
}