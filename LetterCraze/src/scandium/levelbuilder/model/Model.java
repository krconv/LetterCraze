/**
 * Model.java
 * 
 * @author Scandium
 */
package scandium.levelbuilder.model;

import java.util.ArrayList;
import java.util.List;

import scandium.common.model.Level;
import scandium.common.tool.GameLoader;

/**
 * The top level model container for the LevelBuilder application.
 */
public class Model {
	private Level selectedLevel;
	private List<Level> levels;
	private EditProgress editProgress;
	private GameLoader gameLoader;
	private LevelBuilderState state;

	/**
	 * Creates a new model for the LevelBuilder application from file using the GameLoader.
	 */
	public Model() {
		this.selectedLevel = null;
		// load the levels
		this.gameLoader = new GameLoader();
		this.levels = gameLoader.LoadLevels(new ArrayList<Level>());
		state = LevelBuilderState.MainMenu;
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
	public List<Level> getLevels() {
		return levels;
	}
	
	/**
	 * @return state
	 */
	public LevelBuilderState getLevelBuilderState(){
		return state;
	}
	
	/** 
	 * This function sets the levelBuilderState.
	 * @param state The new LevelBuilderState.
	 */
	public void setLevelBuilderState(LevelBuilderState state){
		this.state = state;
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
	 * @throws IllegalArgumentException for Level wanting to be moved not existing
	 */
	public boolean moveLevel(Level level, int newIndex) throws IllegalArgumentException{
		int index = levels.indexOf(level);
		int initialSize = levels.size();
		if(index == -1){
			throw new IllegalArgumentException("Level does not exist");
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
		if (!levels.contains(original))
			levels.add(replacement);
		else
			levels.set(levels.indexOf(original), replacement);
		return true;
	}
	
	/**
	 * Saves the levels.
	 * @return Whether any of the progress was saved.
	 */
	public boolean SaveLevels() {
		return gameLoader.SaveLevels(levels);
	}

}