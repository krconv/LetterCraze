/**
 * GameProgressTest.java
 * 
 * @author Scandium
 */
package scandium.lettercraze.model;

import java.util.List;

import junit.framework.TestCase;
import scandium.common.model.Level;
import scandium.common.tool.GameLoader;

/**
 * Test class for {@link scandium.lettercraze.model.GameProgress}.
 */
public class GameProgressTest extends TestCase {
	private GameProgress progress;
	private List<Level> levels;
	
	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
		levels = new GameLoader().LoadLevels();
		progress = new GameProgress(levels);
		
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	/**
	 * Test method for {@link scandium.lettercraze.model.GameProgress#GameProgress(java.util.List)}.
	 */
	public void testGameProgress() {
		// make sure that there are progresses for every level
		for (Level level : levels) {
			assertNotNull(progress.getProgressForLevel(level));
		}
		
		// make sure the current progress
		assertNotNull(progress.getCurrentLevelProgress());
	}

	/**
	 * Test method for {@link scandium.lettercraze.model.GameProgress#unlockNextLevel()}.
	 */
	public void testUnlockNextLevel() {
		progress.getCurrentLevelProgress().setLevel(levels.get(0));
		progress.getCurrentLevelProgress().setUnlocked(true);
		assertTrue(progress.unlockNextLevel());
		assertTrue(progress.getProgressForLevel(levels.get(1)).isUnlocked());
		
		// test that doing it again won't change anything
		assertFalse(progress.unlockNextLevel());
		assertTrue(progress.getProgressForLevel(levels.get(1)).isUnlocked());
		assertFalse(progress.getProgressForLevel(levels.get(2)).isUnlocked());
	}
}
