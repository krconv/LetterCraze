/**
 * LightningLevel.java
 * 
 * @author Scandium
 */
package scandium.common.model;

/**
 * A type of Level which has a time limit.
 */
public class LightningLevel extends Level {
    private int timeLimit;
    
    /**
     * Creates a new uninitialized Lightning Level.
     */
    public LightningLevel() {
    	super();
    	timeLimit = -1;
    }

    /**
     * Creates a new Lightning Level with the given information.
     * @param name The name of the Level.
     * @param board The Board of the Level. 
     * @param stars The Stars used in the Level.
     * @param timeLimit The time limit for the Level.
     */
    public LightningLevel(String name, Board board, Star[] stars, int timeLimit) {
        super(name, board, stars);
        this.timeLimit = timeLimit;
    }

    /**
	 * @return the timeLimit
	 */
	public int getTimeLimit() {
		return timeLimit;
	}

	/**
	 * @param timeLimit the timeLimit to set
	 */
	public void setTimeLimit(int timeLimit) {
		this.timeLimit = timeLimit;
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
    public LightningLevel copy() {
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