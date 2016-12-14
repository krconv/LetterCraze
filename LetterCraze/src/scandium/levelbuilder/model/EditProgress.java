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
	 * @return the modified level
	 */
	public void setOrignial(Level o) {
		this.original = o;
	}
	
	/**
	 * @return the modified level
	 */
	public void setModified(Level m) {
		this.modified = m;
	}
}