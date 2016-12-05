/**
 * Model.java
 * 
 * @author Scandium
 */
package scandium.lettercraze.model;

import java.util.ArrayList;

import scandium.common.model.*;


/**
 * The top level model container for LetterCraze.
 */
public class Model {
	//do we still need this enum if the view is controlled by the controllers???
	private LetterCrazeState state;
	
	private ArrayList<Level> levels;
	private Level selectedLevel;
	private GameProgress progress;

    /**
     * Creates a completely new Model.
     * @throws Exception 
     */
    public Model() throws IllegalArgumentException {
        initialize();
    }
   
    /**
     * Creates the Model from file.
     * @param ProgressFile file containing the GameProgress
     * @param LevelFile file containing the Levels
     */
    public Model(Object ProgressFile, Object LevelFile){
        initializeLevelsFromFile(LevelFile);
        initializeProgressFromFile(ProgressFile);
    }
    
	/**
	 * initializes the levels from the level file
	 * @param file file containing the Levels
	 */
	private void initializeProgressFromFile(Object file) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * initializes the GameProgress from the GameProgress file
	 * @param file file containing the GameProgress
	 */
	private void initializeLevelsFromFile(Object file) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Creates a completely new and clean Model
	 * @throws Exception
	 */
	private void initialize() throws IllegalArgumentException {
		this.levels = new ArrayList<Level>();
		this.progress = new GameProgress();
	}

	/**
	 * @return the state
	 */
	public LetterCrazeState getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(LetterCrazeState state) {
		this.state = state;
	}

	/**
	 * @return the selectedLevel
	 */
	public Level getSelectedLevel() {
		return selectedLevel;
	}

	/**
	 * @param selectedLevel the selectedLevel to set
	 */
	public void setSelectedLevel(Level selectedLevel) {
		this.selectedLevel = selectedLevel;
	}

	/**
	 * @return the levels
	 */
	public ArrayList<Level> getLevels() {
		return levels;
	}

	/**
	 * @return the progress
	 */
	public GameProgress getProgress() {
		return progress;
	}

    
}