/**
 * Model.java
 * 
 * @author Scandium
 */
package scandium.lettercraze.model;

import java.util.ArrayList;
import java.util.List;

import scandium.common.model.*;
import scandium.common.tool.GameLoader;


/**
 * The top level model container for LetterCraze.
 */
public class Model {
	//do we still need this enum if the view is controlled by the controllers???
	private LetterCrazeState state;
	private List<Level> levels;
	private Level selectedLevel;
	private GameProgress progress;
	private GameLoader gameLoader;

    /**
     * Creates a new Model.
     */
    public Model() {
        initialize();
    }

	/**
	 * Creates a new Model from file using the GameLoader.
	 */
	private void initialize() {
		// load the levels
		this.gameLoader = new GameLoader();
		this.levels = gameLoader.LoadLevels(new ArrayList<Level>());
		this.progress = new GameProgress(levels);
	}

	/**
	 * Gets the state of the game.
	 * @return the state
	 */
	public LetterCrazeState getState() {
		return state;
	}

	/**
	 * Sets the state of the game.
	 * @param state the state to set
	 */
	public void setState(LetterCrazeState state) {
		this.state = state;
	}

	/**
	 * Gets the currently selected level.
	 * @return the selectedLevel
	 */
	public Level getSelectedLevel() {
		return selectedLevel;
	}

	/**
	 * Sets the currently selected level.
	 * @param selectedLevel the selectedLevel to set
	 */
	public void setSelectedLevel(Level selectedLevel) {
		this.selectedLevel = selectedLevel;
	}

	/**
	 * Gets the list of levels for this game.
	 * @return the levels
	 */
	public List<Level> getLevels() {
		return levels;
	}

	/**
	 * Gets the progress for this game.
	 * @return the progress
	 */
	public GameProgress getProgress() {
		return progress;
	}

    
}