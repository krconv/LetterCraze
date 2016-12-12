/**
 * 
 */
package scandium.levelbuilder.model;

import java.util.List;

import junit.framework.TestCase;
import scandium.common.model.*;
import scandium.common.tool.GameLoader;

/**
 * @author Connor
 *
 */
public class ModelTest extends TestCase {
	private LightningLevel selectedLevel;
	private List<Level> levels;
	private EditProgress editProgress;
	private GameLoader gameLoader;
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
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link scandium.levelbuilder.model.Model#addLevel(scandium.common.model.Level)}.
	 */
	public void testAddLevel() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link scandium.levelbuilder.model.Model#removeLevel(scandium.common.model.Level)}.
	 */
	public void testRemoveLevel() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link scandium.levelbuilder.model.Model#moveLevel(scandium.common.model.Level, int)}.
	 */
	public void testMoveLevel() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link scandium.levelbuilder.model.Model#replaceLevel(scandium.common.model.Level, scandium.common.model.Level)}.
	 */
	public void testReplaceLevel() {
		fail("Not yet implemented");
	}

}
