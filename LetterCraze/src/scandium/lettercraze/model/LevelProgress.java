/**
 * LevelProgress.java
 * 
 * @author Scandium
 */
package scandium.lettercraze.model;

import java.util.List;
import java.util.Timer;

import scandium.common.model.Level;

/**
 * An object which contains information about a Player's progress in a Level.
 */
public class LevelProgress {
    private Level level;
    private int score;
    private int starCount;
    private List<String> foundWords;
    private boolean isPlaying;
    private Timer timer;

    /**
     * Creates a new LevelProgress to be associated with the given Level.
     * @param level The Level to be associated with.
     */
    public LevelProgress(Level level) {
        // TODO implement here
    }

    /**
	 * @return the score
	 */
	public int getScore() {
		return score;
	}

	/**
	 * @param score the score to set
	 */
	public void setScore(int score) {
		this.score = score;
	}

	/**
	 * @return the isPlaying
	 */
	public boolean isPlaying() {
		return isPlaying;
	}

	/**
	 * @param isPlaying the isPlaying to set
	 */
	public void setPlaying(boolean isPlaying) {
		this.isPlaying = isPlaying;
	}

	/**
	 * @return the timer
	 */
	public Timer getTimer() {
		return timer;
	}

	/**
	 * @param timer the timer to set
	 */
	public void setTimer(Timer timer) {
		this.timer = timer;
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
	 * @return the foundWords
	 */
	public List<String> getFoundWords() {
		return foundWords;
	}

	/**
     * Resets the progress.
     */
    public void reset() {
        // TODO implement here
        return;
    }

    /**
     * Determines whether this progress has a higher score than the given one.
     * @param levelProgress The progress to compare to.
     * @return Whether this progress has a higher score.
     */
    public boolean isHigherScore(LevelProgress levelProgress) {
        // TODO implement here
        return false;
    }

    /**
     * Updates the Player's score for this progress.
     * @param delta The amount to change the score by.
     */
    public void updateScore(int delta) {
        // TODO implement here
        return;
    }

}