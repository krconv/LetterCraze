/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ *
 * ~~~~~ Team Scandium                                                                           *
 * ~~~~~ CS 3733                                                                                 *
 * ~~~~~ Project: Level Builder                                                                  *
 * ~~~~~ Created: November 28th                                                                  *
 * ~~~~~ Class: Tile                                                                             *
 * ~~~~~        This class tests the source class scandium.common.model.Tile                     *
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
package scandium.common.model;

import junit.framework.TestCase;

public class TileTest extends TestCase {
	
	/**~~~~~                                                                               ~~~~~ *
	 * TestGetContent()                                                                          *
	 * This function tests the function Tile.getContent()                                        *
	 * ~~~~~                                                                               ~~~~~ */
	public void testGetContent(){
		String value = "A";
		Tile tile = new Tile(value, 10);
		String content = tile.getContent();
		assertEquals(value, content);
	}
	
	/**~~~~~                                                                               ~~~~~ *
	 * TestGetScore()                                                                            *
	 * This function tests the function Tile.getScore()                                          *
	 * ~~~~~                                                                               ~~~~~ */
	public void testGetScore(){
		int score_orig = 10;
		Tile tile = new Tile("A", score_orig);
		int score_new = tile.getScore();
		assertEquals(score_orig, score_new);
	}
}
