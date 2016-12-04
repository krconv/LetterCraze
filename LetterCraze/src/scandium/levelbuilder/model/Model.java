/**
 * Model.java
 * 
 * @author Scandium
 */
package scandium.levelbuilder.model;

import java.util.ArrayList;

import scandium.common.model.*;

/**
 * The top level model container for the LevelBuilder application.
 */
public class Model {
	private Level selectedLevel;
	private ArrayList<Level> levels;
	//do we need this still even though the controllers control the view?
	private LevelBuilderState state;
	private EditProgress editProgress;

    /**
     * Creates a completely new and clean model for the LevelBuilder application.
     */
    public Model() {
        selectedLevel = null;
        levels = new ArrayList<Level>();        
    }
    
    /**
     * This Constructor needs to be created
     * @param LevelFile The File that Levels are loaded from
     */
    public Model(Object LevelFile) {
    	selectedLevel = null;
    	initializeLevelsFromFile(LevelFile);
    }
    
    /**
     * This Method needs to be created
     * @param levelFile The File that Levels are loaded from
     */
    private void initializeLevelsFromFile(Object levelFile) {
		// TODO Auto-generated method stub
		
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
        levels.add(level);
        return true;
    }

    /**
     * Removes a level from the model.
     * @param level The level to remove. 
     * @return Whether the model was changed.
     */
    public boolean removeLevel(Level level) {
        levels.remove(level);
        return true;
    }

    /**
     * Changes the ordering of a level.
     * @param level The level being moved.
     * @param newIndex The new index of the level.
     * @return Whether the model was changed.
     * @throws Exception for Level wanting to be moved not existing
     */
    public boolean moveLevel(Level level, int newIndex) {
        int index = levels.indexOf(level);
        int initialSize = levels.size();
        if(index == -1){
        	RuntimeException LevelDoesNotExist = new RuntimeException();
        	throw LevelDoesNotExist;
        } 
        ArrayList<Level> workingArray =  new ArrayList<Level>();
        for(int i=0; i < initialSize; i++){
        	if(i==newIndex){
        		workingArray.add(level);
        	}else{
        		workingArray.add(levels.get(i));
        	}
        }
        levels.clear();
        levels = workingArray;
        return true;
    }

    /**
     * Replaces a level with another one.
     * @param original The level to replace.
     * @param replacement The level to replace with.
     * @return Whether the model was changed
     */
    public boolean replaceLevel(Level original, Level replacement) {
        levels.set(levels.indexOf(original), replacement);
        return true;
    }

}