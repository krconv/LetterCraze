/**
 * Star.java
 * 
 * @author Scandium
 * Date: 11/28/2016
 * Description: This class represents a star for a level. A star has a threshold that when
 * surpassed, indicates that this star has been achieved. 
 */
package scandium.common.model;

public class Star {
	
	/* ~~~~~                                                                               ~~~~~ *
	 * Class Attributes                                                                          *
	 * ~~~~~                                                                               ~~~~~ */
	int threshold;

	/**
	 * This function creates a new instance of the Star class (uninitialized threshold)
	 */
    public Star() {
    	this.threshold = -1;
    }

    /**
     * This function creates a new instance of the Star class with an initialized threshold 
     * @param threshold The integer threshold for the star
     */
    public Star(int threshold) {
    	this.threshold = threshold;
    }
    
    /**
     * This function returns this star's threshold value
     * @return int The star's threshold
     */
	public int getThreshold() {
		return threshold;
	}

	/**
	 * This function sets this star's threshold value
	 * @param threshold The integer threshold value
	 */
	public void setThreshold(int threshold) {
		this.threshold = threshold;
	}
	
	/**
	 * This function determines if this star is obtained based on its threshold and the given score.
	 * @param score The integer representing the game's current score
	 * @return boolean Has the star been obtained?
	 */
    public boolean isObtained(int score) {
        return score >= threshold;
    }
    
    /**
     * This function returns a boolean indicating if the star is valid. A star is valid
     * if the threshold is non-negative.
     * @return boolean Is the star valid?
     */
    public boolean isValid() {
        return threshold >= 0;
    }

}