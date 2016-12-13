/**
 * WordLevelRestrictor.java
 * 
 * @author Kodey Converse (kodey@krconv.com)
 */
package scandium.common.tool;

import scandium.lettercraze.action.IAction;

/**
 * A level restrictor that is based on a word limit.
 */
public class WordLevelRestrictor extends LevelRestrictor {
	private int wordLimit;
	private int wordsLeft;
	
	/**
	 * Creates a new restrictor that is based on a word limit.
	 * @param wordLimit The word limit for the level in number of words.
	 */
	public WordLevelRestrictor(int wordLimit) {
		this.wordLimit = wordLimit;
		this.wordsLeft = 0;
	}

	/* (non-Javadoc)
	 * @see scandium.common.tool.LevelRestrictor#recordAction(scandium.lettercraze.action.IAction)
	 */
	@Override
	public void recordAction(IAction action) {
		if (isRestricting()) {
			if (action.isValid())
				wordsLeft--;
			if (wordsLeft <= 0)
				restrict();
		}
	}

	/* (non-Javadoc)
	 * @see scandium.common.tool.LevelRestrictor#removeAction(scandium.lettercraze.action.IAction)
	 */
	@Override
	public void removeAction(IAction action) {
		if (isRestricting()) {
			if (action.isValid())
				wordsLeft++;
		}
	}
	
	/* (non-Javadoc)
	 * @see scandium.common.tool.LevelRestrictor#start()
	 */
	@Override
	public void start() {
		super.start();
		wordsLeft = wordLimit;
	}

	/* (non-Javadoc)
	 * @see scandium.common.tool.LevelRestrictor#getLabel()
	 */
	@Override
	public String getLabel() {
		return "Words Left";
	}

	/* (non-Javadoc)
	 * @see scandium.common.tool.LevelRestrictor#getValue()
	 */
	@Override
	public String getValue() {
		return "" + wordsLeft;
	}

	/* (non-Javadoc)
	 * @see scandium.common.tool.LevelRestrictor#getValueUnit()
	 */
	@Override
	public String getValueUnit() {
		return "word" + (wordsLeft == 1 ? "" : "s");
	}

}
