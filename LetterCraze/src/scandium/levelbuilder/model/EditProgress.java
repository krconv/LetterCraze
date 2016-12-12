/**
 * EditProgress.java
 * 
 * @author Scandium
 */
package scandium.levelbuilder.model;

import scandium.common.model.Level;
import scandium.common.model.ThemeLevel;
import scandium.common.tool.ThemeLevelTileGenerationAlgorithm;
import scandium.levelbuilder.view.Application;

/**
 * An object to track the changes to a level being edited.
 */
public class EditProgress {
	private Level original;
	private Level modified;

	/**
	 * Creates a new level to track the edits to the given existing Level.
	 * @param l
	 *            The Level to modify.
	 */
	public EditProgress(Level l) {
		this.original = l;
		this.modified = l.copy();
	}

	/**
	 * @return the original level
	 */
	public Level getOriginal() {
		return original;
	}

	/**
	 * @return the modified level
	 */
	public Level getModified() {
		return modified;
	}
	
	/**
	 * This generates the tiles on the board for a theme level. It uses the Theme words to 
	 * generate the tiles. 
	 */
	public void generateThemeTiles(Application app){
		if(!modified.getType().equals("Theme"))return;
		ThemeLevel level = (ThemeLevel) modified;
		/* Fill Board */
		ThemeLevelTileGenerationAlgorithm.populateThemeLevelWithTiles(level);
	}
}