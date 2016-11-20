/**
 * IAction.java
 * 
 * @author Scandium
 */
package scandium.lettercraze.action;

/**
 * Has the ability to be executed and then undone.
 */
public interface IAction {

    /**
     * Execute the action.
     * @return Whether the execution of the action changed anything.
     */
    public boolean execute();

    /**
     * Undo the action.
     * @return Whether the undo of the action changed anything.
     */
    public boolean undo();
    
    /**
	 * Determines whether the action is valid.
     * @return Whether the action is valid.
     */
    public boolean isValid();

}