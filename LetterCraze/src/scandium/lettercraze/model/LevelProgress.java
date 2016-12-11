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
	@XmlTransient
	private int timeLeft;
	@XmlElement
	private boolean isUnlocked;

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
		timeLeft = -1;
	}

	/**
	 * @param level
	 *            The level that is being played right now pre-condition: a
	 *            level progress has been asked to be initialized
	 *            post-condition: if isPlaying is true, throws an exception
	 *            otherwise initializes the levelProgress if it is a Lightning
	 *            Level, sets game to stop after the proper amount of time
	 * @throws IllegalStateException
	 */
//	private void initialize(Level level) {
//		this.timer = new Timer();
//		this.foundWords = new LinkedList<String>();
//		isPlaying = true;
//		foundWords.clear();
//		starCount = 0;
//		score = 0;
//		this.level = level;
//		this.isUnlocked = false;
//		if (level == null) {
//			throw new IllegalStateException("Null Level");
//		}
//		if (level.getType().equals("lightning")) {
//			try {
//				timer.schedule(new TimerTask() {
//					@Override
//					public void run() {
//						setPlaying(false);;
//					}
//				}, ((LightningLevel) level).getTimeLimit());
//			} catch (Exception e) { // timer had a problem initializing
//				throw new IllegalStateException("Timer not initialized properly");
//			}
//		} else { // timer isn't needed
//			timer = null;
//		}
//	}

	/**
	 * @param level
	 *            the level that the LetterCraze is running on
	 * @return whether the method ran post-condition: the LevelProgress's level
	 *         has been set to the correct level, all attributes are at initial
	 *         values, timer is running if is LightningLevel
	 * @throws GameProgressAlreadyRunning,
	 *             timerNotInitializedProperly
	 */
	public void setLevel(Level level) {
		this.level = level;
	}

	/**
	 * @return the score
	 */
	public int getScore() {
		return score;
	}

	/**
	 * Sets the score and updates the star count.
	 * @param score
	 *            the score to set
	 */
	public void setScore(int score) {
		this.score = score;
		
		// determine how many stars have been obtained
		starCount = 0;
		for (Star star : getLevel().getStars()) {
			if (star.isObtained(score))
				starCount++;
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
	 * @return the time left in seconds
	 */
	public int getTimeLeft() {
		return timeLeft;
	}

	/**
	 * @param timer
	 *            the timer to set
	 */
	public void setTimeLeft(int timeLeft) {
		this.timeLeft = timeLeft;
	}

	/**
	 * @return the level
	 */
	public Level getLevel() {
		return level;
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
	 * 
	 * @return returns boolean for whether ran or not pre-condition: progress
	 *         has some value stored for foundWords, score, and starCount
	 *         post-condition: starCound and score are 0 and foundWords is
	 *         cleared
	 */
	public boolean reset() {
		this.score = 0;
		this.starCount = 0;
		this.foundWords.clear();
		return true;
	}

	/**
	 * Determines whether this progress has a higher score than the stored high
	 * score for this level.
	 * 
	 * @param gameProgress
	 *            The game progress currently running.
	 * @return Whether this progress has a higher score. pre-condition: can call
	 *         whenever, but should be calling upon exit of levelPlayer
	 *         post-condition: no state has changed
	 */
	public boolean isHigherScore(LevelProgress lp) {
		if (lp.getScore() < this.score) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Updates the Player's score for this progress and updates the star count.
	 * 
	 * @param delta
	 *            The amount to change the score by.
	 * @return boolean as to whether the score was updated or not pre-condition:
	 *         score is a value post-condition: score is now what it was plus
	 *         delta
	 */
	public void updateScore(int delta) {
		setScore(score + delta);
	}

	/**
	 * This function adds a word to the list of found words
	 * 
	 * @param word
	 *            The found word
	 */
	public void addFoundWord(String word) {
		this.foundWords.add(word);
	}
	
	/**
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