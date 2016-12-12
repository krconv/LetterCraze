/**
 * IAction.java
 * 
 * @author Scandium
 */
package scandium.lettercraze.action;

import scandium.common.model.PuzzleLevel;
import scandium.common.model.Word;
import scandium.common.tool.IWordDictionary;
import scandium.common.tool.LetterDictionary;
import scandium.lettercraze.model.LevelProgress;

/**
 * Action where a word is removed from the level board.
 */
public class RemoveWordAction implements IAction {
	private LevelProgress progress;
	private Word word;
	private String generatedString;
	private IWordDictionary dictionary;
	private LetterDictionary letterDictionary;

    /**
     * Creates a new remove word action.
     * @param model The model.
     * @param word The word being removed.
     */
    public RemoveWordAction(LevelProgress progress, Word word, IWordDictionary dictionary, LetterDictionary letterDictionary) {
    	this.progress = progress;
    	this.word = word;
    	this.dictionary = dictionary;
    	this.letterDictionary = letterDictionary;
    	this.generatedString = word.generateString();
    }

    /* (non-Javadoc)
     * @see scandium.lettercraze.action.IAction#execute()
     */
    @Override
    public boolean execute() {
		if (isValid()) {
			// the selected word is a valid one
			// update the score
			progress.updateScore(progress.getLevel().determineScore(word));

			// add to found words
			progress.addFoundWord(generatedString);
			
			// If puzzle level and max num words is reached
			if(progress.getLevel().getType().equals("Puzzle")){
				PuzzleLevel level = (PuzzleLevel) progress.getLevel();
				if(level.getMaxNumWords() <= progress.getFoundWords().size()){
					progress.setPlaying(false);
				}
			}

			// update the board
			progress.getLevel().getBoard().removeSelectedWord();
			progress.getLevel().getBoard().applyGravity();
			if (progress.getLevel().getBoard().shouldRegenerate()) {
				progress.getLevel().getBoard().fillEmptySquares(letterDictionary);
			}
	        return true;
		}
		return false;
    }

    /* (non-Javadoc)
     * @see scandium.lettercraze.action.IAction#undo()
     */
    @Override
    public boolean undo() {
		if (isValid()) {
			// the action was able to be done so let's undo it
			
			// update the score
			progress.updateScore(-1 * progress.getLevel().determineScore(word));

			// remove the word from found words
			progress.getFoundWords().remove(generatedString);
			
			// If puzzle level and max num words is reached
			if(progress.getLevel().getType().equals("Puzzle")){
				PuzzleLevel level = (PuzzleLevel) progress.getLevel();
				if(level.getMaxNumWords() > progress.getFoundWords().size()){
					progress.setPlaying(true);
				}
			}

			// update the board
			progress.getLevel().getBoard().insertWord(word);
	        return true;
		}
		return false;
    }

	/* (non-Javadoc)
	 * @see scandium.lettercraze.action.IAction#isValid()
	 */
	@Override
	public boolean isValid() {
		return dictionary.isWord(word.generateString());
	}

}