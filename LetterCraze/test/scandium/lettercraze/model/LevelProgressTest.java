/**
 * 
 */
package scandium.lettercraze.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

import junit.framework.TestCase;
import scandium.common.model.*;

/**
 * @author Connor
 *
 */
public class LevelProgressTest extends TestCase {
	private LevelProgress lp;
	private LightningLevel level;
	private int score;
	private int starCount;
	private List<String> foundWords;
	private boolean isPlaying;
	private int timeLeft;
	private boolean isUnlocked;
	
	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
		lp = new LevelProgress();
		level = new LightningLevel("level", new Board(true, GravityDirection.Up), new Star[3], 5000);
		score = 0;
		starCount = 0;
		isPlaying = false;
		timeLeft = 5000;
		isUnlocked = true;
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	/**
	 * Test method for {@link scandium.lettercraze.model.LevelProgress#setLevel(scandium.common.model.Level)} and {@link scandium.lettercraze.model.LevelProgress#getLevel()}.
	 */
	public void testGetSetLevel() {
		lp.setLevel(level);
		assertEquals(level, lp.getLevel());
	}

	/**
	 * Test method for {@link scandium.lettercraze.model.LevelProgress#getScore()} and {@link scandium.lettercraze.model.LevelProgress#setScore(int)}.
	 */
	public void testGetSetScore() {
		lp.setLevel(level);
		lp.setScore(score);
		assertEquals(score, lp.getScore());
		
		lp.setScore(-1);
		assertEquals(0, lp.getScore());
	}

	/**
	 * Test method for {@link scandium.lettercraze.model.LevelProgress#isPlaying()} and {@link scandium.lettercraze.model.LevelProgress#setPlaying(boolean)}.
	 */
	public void testIsSetPlaying() {
		assertFalse(lp.isPlaying());
		lp.setPlaying(true);
		assertTrue(lp.isPlaying());
	}

	/**
	 * Test method for {@link scandium.lettercraze.model.LevelProgress#getTimeLeft()} and {@link scandium.lettercraze.model.LevelProgress#setTimeLeft(int)}.
	 */
	public void testGetSetTimeLeft() {
		lp.setTimeLeft(timeLeft);
		assertEquals(timeLeft, lp.getTimeLeft());
	}

	/**
	 * Test method for {@link scandium.lettercraze.model.LevelProgress#getStarCount()}.
	 */
	public void testGetStarCount() {
		lp.setLevel(level);
		lp.setScore(score);
		assertEquals(starCount, lp.getStarCount());
	}

	/**
	 * Test method for {@link scandium.lettercraze.model.LevelProgress#isUnlocked()} and {@link scandium.lettercraze.model.LevelProgress#setUnlocked(boolean)}.
	 */
	public void testIsSetUnlocked() {
		lp.setUnlocked(isUnlocked);
		assertTrue(lp.isUnlocked());
		lp.setUnlocked(false);
		assertFalse(lp.isUnlocked());
	}

	/**
	 * Test method for {@link scandium.lettercraze.model.LevelProgress#getFoundWords()} and {@link scandium.lettercraze.model.LevelProgress#addFoundWord(java.lang.String)}.
	 */
	public void testGetAddFoundWords() {
		assertEquals(new ArrayList<String>(), lp.getFoundWords());
		lp.addFoundWord("hello");
		assertEquals("hello", lp.getFoundWords().get(0));
		lp.addFoundWord("goodbye");
		assertEquals("goodbye", lp.getFoundWords().get(1));
	}

	/**
	 * Test method for {@link scandium.lettercraze.model.LevelProgress#reset()}.
	 */
	public void testReset() {
		lp.setLevel(level);
		lp.addFoundWord("hello");
		assertEquals("hello", lp.getFoundWords().get(0));
		lp.setScore(500);
		assertEquals(500, lp.getScore());
		
		assertTrue(lp.reset());
		assertEquals(new ArrayList<String>(), lp.getFoundWords());
		assertEquals(0, lp.getScore());
		assertEquals(0, lp.getStarCount());
	}

	/**
	 * Test method for {@link scandium.lettercraze.model.LevelProgress#isHigherScore(scandium.lettercraze.model.LevelProgress)}.
	 */
	public void testIsHigherScore() {
		lp.setLevel(level);
		LevelProgress lp2 = new LevelProgress(level);
		lp2.setScore(50);
		assertFalse(lp.isHigherScore(lp2));
		lp.setScore(75);
		assertTrue(lp.isHigherScore(lp2));
		lp.setScore(50);
		assertFalse(lp.isHigherScore(lp2));
	}

	/**
	 * Test method for {@link scandium.lettercraze.model.LevelProgress#updateScore(int)}.
	 */
	public void testUpdateScore() {
		lp.setLevel(level);
		lp.setScore(score);
		lp.updateScore(20);
		assertEquals(20, lp.getScore());
		lp.updateScore(-10);
		assertEquals(10, lp.getScore());
		
		lp.updateScore(-20);
		assertEquals(10, lp.getScore());
	}
}
