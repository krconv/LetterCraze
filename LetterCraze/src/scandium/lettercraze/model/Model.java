/**
 * Model.java
 * 
 * @author Scandium
 */
package scandium.lettercraze.model;

import java.util.ArrayList;

import scandium.common.model.Level;

/**
 * The top level model container for LetterCraze.
 */
public class Model {
	private LetterCrazeState state;
	private ArrayList<Level> levels;
	private Level selectedLevel;
	private GameProgress progress;

    /**
     * Creates a new Model.
     */
    public Model() {
        // TODO implement here
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