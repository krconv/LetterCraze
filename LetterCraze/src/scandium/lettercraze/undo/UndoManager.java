/**
 * UndoManager.java
 * 
 * @author Scandium
 */
package scandium.lettercraze.undo;

import java.util.Stack;

import scandium.lettercraze.action.IAction;

/**
 * A tool for keeping track of actions that can be undone.
 */
public class UndoManager {
	private static UndoManager instance;
	@SuppressWarnings("unused")
	private Stack<IAction> undoStack;

    /**
     * Creates a new manager.
     */
    private UndoManager() {
        // TODO implement here
    }

    /**
	 * @return the instance
	 */
	public static UndoManager getInstance() {
		return instance;
	}

	/**
     * Records an action that has been done.
     * @param action The action to record.
     */
    public void recordAction(IAction action) {
        // TODO implement here
        return;
    }

    /**
     * Removes the last action that was made and returns it.
     * @return The action that was removed.
     */
    public IAction removeLastAction() {
        // TODO implement here
        return null;
    }

    /**
     * Forgets all of the actions that were recorded.
     */
    public void forgetActions() {
        // TODO implement here
        return;
    }

}