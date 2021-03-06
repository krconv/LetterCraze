/**
 * GameProgress.java
 * 
 * @author Scandium
 */
package scandium.lettercraze.model;

import java.util.List;

import scandium.common.model.Level;
import scandium.lettercraze.tool.ProgressLoader;

/**
 * A collection of progresses to track the Player's total progress on a set of Levels.
 */
public class GameProgress {
	private List<LevelProgress> levelProgresses;
	private LevelProgress currentLevelProgress;
	private ProgressLoader progressLoader;
	//to create a flag so that the GameProgress is a singleton
	private boolean created = false;

	/**
	 * Creates a new game progress which will be for the given levels.
	 * @param levels The levels in the current game.
	 * @throws IllegalStateException if the current level progress is already running, 
	 * 						or if one of the LevelProgress initializations fails
	 */
	public GameProgress(List<Level> levels) throws IllegalStateException{
		//if current level progress already exists, throw exception
		if (this.created == false){
			this.currentLevelProgress = new LevelProgress();
			this.currentLevelProgress.setPlaying(false);
			this.progressLoader = new ProgressLoader();
			
			// load the levels from the loader
			this.levelProgresses = progressLoader.LoadLevelProgress(levels);
			this.created = true;
		} else{
			throw new IllegalStateException("The Game Progress Already Exists");
		}
	}

	/**
	 * Gets the current level's progress.
	 * @return the currentLevelProgress
	 */
	public LevelProgress getCurrentLevelProgress() {
		return currentLevelProgress;
	}

	/**
	 * Gets all of the level progress.
	 * @return The list of LevelProgresses
	 */
	public List<LevelProgress> getLevelProgresses(){
		return levelProgresses;
	}
	
	/**
	 * Unlocks the level after the currently active level progress.
	 * @return whether a level was unlocked
	 */
	public boolean unlockNextLevel() {
		// go through all of the progresses and find the one whose level matches
		// the current progress
		for (int i = 0; i < levelProgresses.size() - 1; i++) {
			if (getCurrentLevelProgress().getLevel() == levelProgresses.get(i).getLevel()) {
				// unlock the next sequential level
				return levelProgresses.get(i + 1).setUnlocked(true);
			}
		}
		// we didn't find any levels to unlock
		return false;
	}

	/**
	 * Gets the progress for a specific level.
	 * @param level The Level to retrieve the progress for.
	 * @return The progress for the given Level.
	 */
	public LevelProgress getProgressForLevel(Level level) {
		// go through all of the progresses until we find the one with the given level
		for (LevelProgress progress : levelProgresses) {
			if (progress.getLevel() == level) {
				// found it!
				return progress;
			}
		}
		// couldn't find it
		return null;
	}

	/**
	 * Replaces the level progress for the corresponding level with the given one.
	 * @param lp The level progress to add and replace with.
	 * @return true if the LevelProgress was added and if the state of LevelProgresses has changed
	 */
	public boolean replaceLevelProgress(LevelProgress lp){
		LevelProgress toReplace = getProgressForLevel(lp.getLevel());
		
		if (toReplace != null) {
			// the given lp has a level that can be replaced
			toReplace.setScore(lp.getScore());
			return true;
		}
		// didn't find the level to replace
		return false;
	}
	
	
	/**
	 * Saves the level progress.
	 * @return Whether any of the progress was saved.
	 */
	public boolean SaveProgress() {
		return progressLoader.SaveLevelProgress(levelProgresses);
	}
}