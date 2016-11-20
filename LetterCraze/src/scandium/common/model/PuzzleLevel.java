/**
 * PuzzleLevel.java
 * 
 * @author Scandium
 */
package scandium.common.model;

/**
 * A type of level which has a maximum number of words.
 */
public class PuzzleLevel extends Level {
    private int maxNumWords;

    /**
     * Creates a new uninitiated PuzzleLevel.
     */
    public PuzzleLevel() {
    	super();
    	this.maxNumWords = -1;
    }

    /**
     * Creates a new PuzzleLevel with the given information.
     * @param name The name of the Level.
     * @param board The Board of the Level.
     * @param stars The Stars in the Level.
     * @param maxNumWords The maximum number of words that the user can make.
     */
    public PuzzleLevel(String name, Board board, Star[] stars, int maxNumWords) {
    	super(name, board, stars);
    	this.maxNumWords = maxNumWords;
    }

    /**
	 * @return the maxNumWords
	 */
	public int getMaxNumWords() {
		return maxNumWords;
	}

	/**
	 * @param maxNumWords the maxNumWords to set
	 */
	public void setMaxNumWords(int maxNumWords) {
		this.maxNumWords = maxNumWords;
	}

	/* (non-Javadoc)
     * @see scandium.common.model.Level#getType()
     */
    @Override
    public String getType() {
        // TODO implement here
        return "";
    }

    /* (non-Javadoc)
     * @see scandium.common.model.Level#copy()
     */
    @Override
    public PuzzleLevel copy() {
        // TODO implement here
        return null;
    }

    /* (non-Javadoc)
     * @see scandium.common.model.Level#isValid()
     */
    @Override 
    public boolean isValid() {
        // TODO implement here
        return false;
    }
}