/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ *
 * ~~~~~ Team Scandium                                                                           *
 * ~~~~~ CS 3733                                                                                 *
 * ~~~~~ Project: Level Builder                                                                  *
 * ~~~~~ Created: November 28th                                                                  *
 * ~~~~~ Class: TileTest                                                                         *
 * ~~~~~        This class tests the source class scandium.common.model.Tile                     *
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
package scandium.common.model;

import junit.framework.TestCase;

/**
 * Test class for {@link scandium.common.model.Tile}.
 */
public class TileTest extends TestCase {

	/**
	 * Test method for {@link scandium.common.model.Tile#Tile(java.lang.String, int)}.
	 */
	public void testConstructorMethod(){
		// test that the constructor saves the given information
		Tile tile = new Tile("A", 1);
		assertEquals("A", tile.getContent());
		assertEquals(1, tile.getScore());
	}

	/**
	 * Test method for {@link scandium.common.model.Tile#getContent()}.
	 */
	public void testGetContent(){
		String value = "A";
		Tile tile = new Tile(value, 10);
		String content = tile.getContent();
		assertEquals(value, content);
	}

	/**
	 * Test method for {@link scandium.common.model.Tile#getScore()}.
	 */
	public void testGetScore(){
		int score_orig = 10;
		Tile tile = new Tile("A", score_orig);
		int score_new = tile.getScore();
		assertEquals(score_orig, score_new);
	}
}
