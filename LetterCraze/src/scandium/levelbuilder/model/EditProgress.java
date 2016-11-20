/**
 * EditProgress.java
 * 
 * @author Scandium
 */
package scandium.levelbuilder.model;

import scandium.common.model.Level;

/**
 * An object to track the changes to a level being edited.
 */
public class EditProgress {
	private Level original;
	private Level modified;

	/**
	 * Track the edits to a new Level.
	 */
	public EditProgress() {
		// TODO implement here
	}

	/**
	 * Track the edits to the given existing Level.
	 * 
	 * @param level
	 *            The Level to modify.
	 */
	public EditProgress(Level level) {
		// TODO implement here
	}

	/**
	 * @return the original
	 */
	public Level getOriginal() {
		return original;
	}

	/**
	 * @return the modified
	 */
	public Level getModified() {
		return modified;
	}
}