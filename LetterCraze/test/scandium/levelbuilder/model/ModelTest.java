/**
 * 
 */
package scandium.levelbuilder.model;

import junit.framework.TestCase;
import scandium.common.model.*;

/**
 * @author Connor
 *
 */
public class ModelTest extends TestCase {
	private LightningLevel selectedLevel;
	private EditProgress editProgress;
	private Model model;
	
	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
		selectedLevel = new LightningLevel();
		model = new Model();
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	/**
	 * Test method for {@link scandium.levelbuilder.model.Model#getSelectedLevel()} and {@link scandium.levelbuilder.model.Model#setSelectedLevel(scandium.common.model.Level)}.
	 */
	public void testGetSetSelectedLevel() {
		assertEquals(null, model.getSelectedLevel());
		model.setSelectedLevel(selectedLevel);
		assertEquals(selectedLevel, model.getSelectedLevel());
	}

	/**
	 * Test method for {@link scandium.levelbuilder.model.Model#getEditProgress()} and {@link scandium.levelbuilder.model.Model#setEditProgress(scandium.levelbuilder.model.EditProgress)}.
	 */
	public void testGetSetEditProgress() {
		model.setSelectedLevel(selectedLevel);
		editProgress = new EditProgress(selectedLevel);
		assertEquals(null, model.getEditProgress());
		model.setEditProgress(editProgress);
		assertEquals(editProgress, model.getEditProgress());
	}

	/**
	 * Test method for {@link scandium.levelbuilder.model.Model#getLevels()}.
	 */
	public void testGetLevels() {
		assertNotNull(model.getLevels());
	}

	/**
	 * Test method for {@link scandium.levelbuilder.model.Model#addLevel(scandium.common.model.Level)}.
	 */
	public void testAddLevel() {
		assertTrue(model.addLevel(selectedLevel));
		assertTrue(model.getLevels().contains(selectedLevel));
	}

	/**
	 * Test method for {@link scandium.levelbuilder.model.Model#removeLevel(scandium.common.model.Level)}.
	 */
	public void testRemoveLevel() {
		assertTrue(model.addLevel(selectedLevel));
		assertTrue(model.getLevels().contains(selectedLevel));
		assertTrue(model.removeLevel(selectedLevel));
		assertFalse(model.getLevels().contains(selectedLevel));
	}

	/**
	 * Test method for {@link scandium.levelbuilder.model.Model#moveLevel(scandium.common.model.Level, int)}.
	 */
	public void testMoveLevel() {
		assertTrue(model.addLevel(selectedLevel));
		assertTrue(model.getLevels().contains(selectedLevel));
		assertTrue(model.moveLevel(selectedLevel, 0));
		assertEquals(selectedLevel, model.getLevels().get(0));
	}

	/**
	 * Test method for {@link scandium.levelbuilder.model.Model#replaceLevel(scandium.common.model.Level, scandium.common.model.Level)}.
	 */
	public void testReplaceLevel() {
		assertTrue(model.addLevel(selectedLevel));
		assertTrue(model.getLevels().contains(selectedLevel));
		assertTrue(model.moveLevel(selectedLevel, 0)); //This is done so I know the exact index of selectedLevel
		assertEquals(selectedLevel, model.getLevels().get(0)); 
		ThemeLevel newLevel = new ThemeLevel();
		assertTrue(model.replaceLevel(selectedLevel, newLevel));
		assertEquals(newLevel, model.getLevels().get(0));
	}

}
