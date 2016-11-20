/**
 * Star.java
 * 
 * @author Scandium
 */
package scandium.common.model;

/**
 * A rank for how well a Player has done in a Level.
 */
public class Star {
    private int threshold;

    /**
     * Creates a new uninitialized Star.
     */
    public Star() {
    	this.threshold = -1;
    }

    /**
     * Creates a new star with the given information.
     * @param threshold The threshold required to obtain the star.
     */
    public Star(int threshold) {
    	this.threshold = threshold;
    }

    /**
	 * @return the threshold
	 */
	public int getThreshold() {
		return threshold;
	}

	/**
	 * @param threshold the threshold to set
	 */
	public void setThreshold(int threshold) {
		this.threshold = threshold;
	}

	/**
     * Determines whether this star has been obtained.
     * @param score The obtained score.
     * @return Whether this star is obtained.
     */
    public boolean isObtained(int score) {
        // TODO implement here
        return false;
    }

    /**
     * Determines whether this star is valid.
     * @return Whether this star is valid.
     */
    public boolean isValid() {
        // TODO implement here
        return false;
    }

}