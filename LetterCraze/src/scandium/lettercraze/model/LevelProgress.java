/**
 * LevelProgress.java
 * 
 * @author Scandium
 */
package scandium.lettercraze.model;

import java.util.LinkedList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import scandium.common.model.*;

/**
 * An object which contains information about a Player's progress in a Level.
 */
public class LevelProgress {
    private Level level;
    private int score;
    private int starCount;
    private List<String> foundWords;
    private boolean isPlaying = false;
    private Timer timer;

    /**
     * Creates a new LevelProgress with no data.
     */
    public LevelProgress(){
    	this.level = null;
    	this.score = 0;
    	this.starCount = 0;
    	this.foundWords = new LinkedList<String>();
    	this.timer = new Timer();
    	
    }
    /**
     * Creates a new LevelProgress to be associated with the given Level.
     * @param level The Level to be associated with.
     * pre-condition: LevelProgress doesn't exist
     * post-condition: LevelProgress is initialized and constructed
     * @throws Exception 
     */
    public LevelProgress(Level level) throws Exception {
        initialize(level);
    }

    /**
     * @param level The level that is being played right now
     * pre-condition: a level progress has been asked to be initialized
     * post-condition: if isPlaying is true, throws an exception
     * 					otherwise initializes the levelProgress
     * 					if it is a Lightning Level, sets game to stop after the proper amount of time
     * @throws GameProgressAlreadyRunning, timerNotInitializedProperly
     */
    private void initialize(Level level) throws Exception{
		if (isPlaying = true){
			Exception GameProgressAlreadyRunning = new Exception();
			throw GameProgressAlreadyRunning;
		}else{
			this.timer = new Timer();
			this.foundWords = new LinkedList<String>();
			isPlaying = true;
			foundWords.clear();
			starCount = 0;
			score = 0;
			this.level = level;
		}
		if(level.getType().equals("lightning")){
			try{
				timer.schedule(stopPlay(), ((LightningLevel)level).getTimeLimit());
			}
			catch(Exception e){ //timer had a problem initializing
				Exception timerNotInitializedProperly = new Exception();
				throw timerNotInitializedProperly;
			}
		}else{ //timer isn't needed
			timer = null;
		}
	}
    
    /**
     * @param level the level that the LetterCraze is running on
     * @return whether the method ran
     * post-condition: the LevelProgress's level has been set to the correct level, 
     * 					all attributes are at initial values, timer is running if is LightningLevel
     * @throws GameProgressAlreadyRunning, timerNotInitializedProperly
     */
    public boolean setLevel(Level level) throws Exception{
    	try{
    		initialize(level);
    	}catch(Exception e){
    		throw e;
    	}
    	return true;
    }

	/**
	 * @return null
	 * pre-condition: gameProgress is running
	 * post-condition: isPlaying has been set to false
	 * 					nothing should be able to be done to the board or anything in the LevelProgress
	 */
	private TimerTask stopPlay() {
		isPlaying = false;
		return null;
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
		if(isPlaying == true){
			this.score = score;
		}
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
	protected Timer getTimer() {
		return timer;
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
     * @return returns boolean for whether ran or not
     * pre-condition: progress has some value stored for foundWords, score, and starCount
     * post-condition: starCound and score are 0 and foundWords is cleared
     */
    public boolean reset() {
    	if(isPlaying == true){
			this.score = 0;
			this.starCount = 0;
			this.foundWords.clear();
	        return true;
		}
        return false;
    }

    /**
     * Determines whether this progress has a higher score than the stored high score for this level.
     * @param gameProgress The game progress currently running.
     * @return Whether this progress has a higher score.
     * pre-condition: can call whenever, but should be calling upon exit of levelPlayer
     * post-condition: no state has changed
     */
    public boolean isHigherScore(GameProgress gameProgress) {
    	//if high score stored in the gameProgress for this level is lower than the current score
        if(gameProgress.getProgressForLevel(this.level).getScore() < this.score){
        	return true;
        }//else
        return false;
    }

    /**
     * Updates the Player's score for this progress.
     * @param delta The amount to change the score by.
     * @return boolean as to whether the score was updated or not
     * pre-condition: score is a value
     * post-condition: score is now what it was plus delta
     */
    public boolean updateScore(int delta) {
        score = score + delta;
        return true;
    }

}