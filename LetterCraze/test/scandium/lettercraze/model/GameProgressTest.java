/**
 * 
 */
package scandium.lettercraze.model;

import java.util.*;
import scandium.common.model.*;
import junit.framework.TestCase;

/**
 * @author Connor
 *
 */
public class GameProgressTest extends TestCase {
	private LevelProgress lp;
	private GameProgress gp;
	private List<Level> levels;
	private LightningLevel ll;
	

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
		levels = new ArrayList<Level>();
		ll = new LightningLevel();
		lp = new LevelProgress();
		levels.add(ll);
		lp.setLevel(ll);
		gp = new GameProgress(levels);
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	/**
	 * Test method for {@link scandium.lettercraze.model.GameProgress#getCurrentLevelProgress()}.
	 */
	public void testGetCurrentLevelProgress() {
		assertNotSame(new LevelProgress(), gp.getCurrentLevelProgress());
	}

	/**
	 * Test method for {@link scandium.lettercraze.model.GameProgress#unlockNextLevel()}.
	 */
	public void testUnlockNextLevel() {
		gp.getCurrentLevelProgress().setLevel(ll);
		assertFalse(gp.unlockNextLevel());
	}

	/**
	 * Test method for {@link scandium.lettercraze.model.GameProgress#getProgressForLevel(scandium.common.model.Level)}.
	 */
	public void testGetProgressForLevel() {
		gp.getCurrentLevelProgress().setLevel(ll);
		assertNotNull(gp.getProgressForLevel(ll));
		
	}

	/**
	 * Test method for {@link scandium.lettercraze.model.GameProgress#replaceLevelProgress(scandium.lettercraze.model.LevelProgress)}.
	 */
	public void testReplaceLevelProgress() {
		assertTrue(gp.replaceLevelProgress(lp));
	}

	/**
	 * Test method for {@link scandium.lettercraze.model.GameProgress#SaveProgress()}.
	 */
	public void testSaveProgress() {
		assertTrue(gp.SaveProgress());
	}

}
