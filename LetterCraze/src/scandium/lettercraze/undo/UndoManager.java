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
	public static final UndoManager instance = new UndoManager();
	private Stack<IAction> undoStack;

    /**
     * Creates a new manager.
     */
    private UndoManager() {
    	undoStack = new Stack<IAction>();
    }
    
	/**
     * Records an action that has been done.
     * @param action The action to record.
     */
    public void recordAction(IAction action) {
    	undoStack.push(action);
        return;
    }

    /**
     * Removes the last action that was made and returns it.
     * @return The action that was removed.
     */
    public IAction removeLastAction() {
    	if (!undoStack.isEmpty())
    		return undoStack.pop();
    	else
    		return null;
    }

    /**
     * Removes every action that was made.
     * @return Whether any actions were undone.
     */
    public boolean removeAllActions() {
    	boolean modified = false;
    	while (!undoStack.isEmpty()) {
    		if (undoStack.pop().undo()) 
    			modified = true;
    	}
        return modified;
    }

    /**
     * Forgets all of the actions that were recorded.
     */
    public void forgetActions() {
    	undoStack.removeAllElements();
    }

}