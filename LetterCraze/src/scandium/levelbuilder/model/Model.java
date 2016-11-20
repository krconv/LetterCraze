/**
 * Model.java
 * 
 * @author Scandium
 */
package scandium.levelbuilder.model;

import java.util.ArrayList;

import scandium.common.model.Level;

/**
 * The top level model container for the LevelBuilder application.
 */
public class Model {
	private Level selectedLevel;
	private ArrayList<Level> levels;
	private LevelBuilderState state;
	private EditProgress editProgress;

    /**
     * Creates a new model for the LevelBuilder application.
     */
    public Model() {
        // TODO implement here
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
	 * @return the state
	 */
	public LevelBuilderState getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(LevelBuilderState state) {
		this.state = state;
	}
	/**
	 * @return the editProgress
	 */
	public EditProgress getEditProgress() {
		return editProgress;
	}

	/**
	 * @param editProgress the editProgress to set
	 */
	public void setEditProgress(EditProgress editProgress) {
		this.editProgress = editProgress;
	}

	/**
	 * @return the levels
	 */
	public ArrayList<Level> getLevels() {
		return levels;
	}

	/**
     * Adds a level to the model.
     * @param level The level to add.
     * @return Whether the model was changed.
     */
    public boolean addLevel(Level level) {
        // TODO implement here
        return false;
    }

    /**
     * Removes a level from the model.
     * @param level The level to remove. 
     * @return Whether the model was changed.
     */
    public boolean removeLevel(Level level) {
        // TODO implement here
        return false;
    }

    /**
     * Changes the ordering of a level.
     * @param level The level being moved.
     * @param newIndex The new index of the level.
     * @return Whether the model was changed.
     */
    public boolean moveLevel(Level level, int newIndex) {
        // TODO implement here
        return false;
    }

    /**
     * Replaces a level with another one.
     * @param original The level to replace.
     * @param replacement The level to replace with.
     * @return Whether the model was changed
     */
    public boolean replaceLevel(Level original, Level replacement) {
        // TODO implement here
        return false;
    }

}