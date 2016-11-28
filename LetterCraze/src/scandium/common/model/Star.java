/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ *
 * ~~~~~ Team Scandium                                                                           *
 * ~~~~~ CS 3733                                                                                 *
 * ~~~~~ Project: Level Builder                                                                  *
 * ~~~~~ Created: November 28th                                                                  *
 * ~~~~~ Class: Star                                                                             *
 * ~~~~~        This class represents a star for a level. A star has a threshold that when       *
 * ~~~~~        surpassed, indicates that this star has been achieved.                           *
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
package scandium.common.model;

public class Star {
	
	/* ~~~~~                                                                               ~~~~~ *
	 * Class Attributes                                                                          *
	 * ~~~~~                                                                               ~~~~~ */
    private int threshold;

	/**~~~~~                                                                               ~~~~~ *
	 * Constructor Method                                                                        *
	 * Create an uninitialized Star                                                              *
	 * ~~~~~                                                                               ~~~~~ */
    public Star() {
    	this.threshold = -1;
    }

	/**~~~~~                                                                               ~~~~~ *
	 * Constructor Method                                                                        *
	 * @param threshold: The stars threshold                                                     *
	 * ~~~~~                                                                               ~~~~~ */
    public Star(int threshold) {
    	this.threshold = threshold;
    }

	/**~~~~~                                                                               ~~~~~ *
	 * getThreshold()                                                                            *
	 * @return int                                                                               *
	 * This function returns the integer Star threshold. If the star has not been initialized    *
	 * it will return -1                                                                         *
	 * ~~~~~                                                                               ~~~~~ */
	public int getThreshold() {
		return threshold;
	}

	/**~~~~~                                                                               ~~~~~ *
	 * setThreshold()                                                                            *
	 * @return int                                                                               *
	 * This function sets the integer Star threshold.                                            *
	 * ~~~~~                                                                               ~~~~~ */
	public void setThreshold(int threshold) {
		this.threshold = threshold;
	}

	/**~~~~~                                                                               ~~~~~ *
	 * isObtained()                                                                              *
	 * @param score: The integer representing the current score.                                 *
	 * @return boolean                                                                           *
	 * This function determines if this star has been obtained, given the current score.         *
	 * ~~~~~                                                                               ~~~~~ */
    public boolean isObtained(int score) {
        return score >= threshold;
    }

	/**~~~~~                                                                               ~~~~~ *
	 * isValid()                                                                                 *
	 * @return boolean                                                                           *
	 * This function returns a boolean indicating if the star is valid. A Star is valid if the   *
	 * threshold is non-negative.
	 * ~~~~~                                                                               ~~~~~ */
    public boolean isValid() {
        return threshold >= 0;
    }

}