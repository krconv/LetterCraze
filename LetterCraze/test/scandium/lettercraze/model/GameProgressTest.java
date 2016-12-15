/**
 * 
 */
package scandium.lettercraze.model;

import java.io.File;
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
	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
		new File("LetterCrazeProgress.xml").delete();
	}

	/**
	 * Test method for {@link scandium.lettercraze.model.GameProgress#getCurrentLevelProgress()}.
	 */
	public void testGetSetCurrentLevelProgress() {
		// test that the current progress is not null
		assertNotNull(gp.getCurrentLevelProgress());
	}

	/**
	 * Test method for {@link scandium.lettercraze.model.GameProgress#unlockNextLevel()}.
	 */
	public void testUnlockNextLevel() {
		gp.getCurrentLevelProgress().setLevel(ll);
		assertTrue(gp.unlockNextLevel());
	}

	/**
	 * Test method for {@link scandium.lettercraze.model.GameProgress#getProgressForLevel(scandium.common.model.Level)}.
	 */
	public void testGetProgressForLevel() {
		assertNotNull(gp.getProgressForLevel(ll));
		gp.getCurrentLevelProgress().setLevel(ll);
		assertNotNull(gp.getProgressForLevel(ll));
		
	}

	/**
	 * Test method for {@link scandium.lettercraze.model.GameProgress#replaceLevelProgress(scandium.lettercraze.model.LevelProgress)}.
	 */
	public void testReplaceLevelProgress() {
		assertTrue(gp.replaceLevelProgress(lp));
		try {
			assertFalse(gp.replaceLevelProgress(null));
			fail();
		} catch (NullPointerException e) {
			
		} catch (Exception e) {
			fail();
		}
	}

	/**
	 * Test method for {@link scandium.lettercraze.model.GameProgress#SaveProgress()}.
	 */
	public void testSaveLoadProgress() {
		
		assertTrue(gp.SaveProgress());
	}

}
