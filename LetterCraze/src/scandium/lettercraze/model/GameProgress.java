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
	//to create a flag so that the GameProgress is a singleton
	private boolean created = false;

	/**
	 * Creates a completely new game progress with nothing stored in it
	 * Creates a currentLevelProgress with a null level and isPlaying equals false
	 * @throws Exception if the current level progress is already running, 
	 * 						or if one of the LevelProgress initializations fail
	 */
	public GameProgress() throws Exception {
		//if current level progress already exists, throw exception
		if (this.created == true){
			this.levelProgresses = new HashMap<Level, LevelProgress>();
			this.currentLevelProgress = new LevelProgress();
			currentLevelProgress.setPlaying(false);
		} else{
			Exception CanOnlyHaveOneGameProgress = new Exception();
			throw CanOnlyHaveOneGameProgress;
		}
	}

	/**
	 * Creates a new game progress from the given HashMap
	 * Creates a currentLevelProgress with a null level and isPlaying equals false
	 * @param storedProgress a HashMap of the current stored progress to be loaded
	 * @throws Exception 
	 */
	public GameProgress(HashMap<Level, LevelProgress> storedProgress) throws Exception{
		this.levelProgresses = storedProgress;
		//TODO Replace this with loading the storedProgress from file
		this.currentLevelProgress = new LevelProgress(null);
		currentLevelProgress.setPlaying(false);
	}

	/**
	 * @return the currentLevelProgress
	 */
	public LevelProgress getCurrentLevelProgress() {
		return currentLevelProgress;
	}

	/**
	 * @param level the level to set the current level playing to 
	 * @throws LevelNotUpdatedProperly
	 */
	public void setCurrentLevelProgress(Level level) throws Exception {
		if(this.currentLevelProgress.setLevel(level)){
			return;
		}else{
			Exception LevelNotUpdatedProperly = new Exception();
			throw LevelNotUpdatedProperly;
		}
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