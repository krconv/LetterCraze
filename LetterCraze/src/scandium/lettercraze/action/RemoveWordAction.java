/**
 * IAction.java
 * 
 * @author Scandium
 */
package scandium.lettercraze.action;

import scandium.lettercraze.model.Model;
import scandium.common.model.Word;

/**
 * Action where a word is removed from the level board.
 */
public class RemoveWordAction implements IAction {
	private Model model;
	private Word word;

    /**
     * Creates a new remove word action.
     * @param model The model.
     * @param word The word being removed.
     */
    public RemoveWordAction(Model model, Word word) {
    	this.model = model;
    	this.word = word;
    }

    /* (non-Javadoc)
     * @see scandium.lettercraze.action.IAction#execute()
     */
    @Override
    public boolean execute() {
        // TODO implement here
        return false;
    }

    /* (non-Javadoc)
     * @see scandium.lettercraze.action.IAction#undo()
     */
    @Override
    public boolean undo() {
        // TODO implement here
        return false;
    }

	/* (non-Javadoc)
	 * @see scandium.lettercraze.action.IAction#isValid()
	 */
	@Override
	public boolean isValid() {
		// TODO Auto-generated method stub
		return false;
	}

}