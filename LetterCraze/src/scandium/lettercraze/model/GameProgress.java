/**
 * GameProgress.java
 * 
 * @author Scandium
 */
package scandium.lettercraze.model;

import java.util.HashMap;

import scandium.common.model.Level;

/**
 * A collection of progresses to track the Player's total progress on a set of Levels.
 */
public class GameProgress {
	private HashMap<Level, LevelProgress> levelProgresses;
	private LevelProgress currentLevelProgress;

    /**
     * Creates a new total game progress.
     */
    public GameProgress() {
    	levelProgresses = new HashMap<Level, LevelProgress>();
    }

    /**
	 * @return the currentLevelProgress
	 */
	public LevelProgress getCurrentLevelProgress() {
		return currentLevelProgress;
	}

	/**
	 * @param currentLevelProgress the currentLevelProgress to set
	 */
	public void setCurrentLevelProgress(LevelProgress currentLevelProgress) {
		this.currentLevelProgress = currentLevelProgress;
	}

	/**
	 * @return the levelProgresses
	 */
	public HashMap<Level, LevelProgress> getLevelProgresses() {
		return levelProgresses;
	}

	/**
     * Gets the progress for a specific level.
     * @param level The Level to retrieve the progress for.
     * @return The progress for the given Level.
     */
    public LevelProgress getProgressForLevel(Level level) {
        return levelProgresses.get(level);
    }

}