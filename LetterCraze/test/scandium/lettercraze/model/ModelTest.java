/**
 * 
 */
package scandium.lettercraze.model;

import junit.framework.TestCase;
import scandium.common.model.LightningLevel;

/**
 * @author Connor
 *
 */
public class ModelTest extends TestCase {
	private LightningLevel selectedLevel;
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
	 * Test method for {@link scandium.lettercraze.model.Model#getState()} and {@link scandium.lettercraze.model.Model#setState(scandium.lettercraze.model.LetterCrazeState)}.
	 */
	public void testGetSetState() {
		model.setState(LetterCrazeState.MainMenu);
		assertEquals(LetterCrazeState.MainMenu, model.getState());
		
		model.setState(LetterCrazeState.Player);
		assertEquals(LetterCrazeState.Player, model.getState());
	}

	/**
	 * Test method for {@link scandium.lettercraze.model.Model#getSelectedLevel()} and {@link scandium.lettercraze.model.Model#setSelectedLevel(scandium.common.model.Level)}.
	 */
	public void testGetSetSelectedLevel() {
		assertEquals(null, model.getSelectedLevel());
		model.setSelectedLevel(selectedLevel);
		assertEquals(selectedLevel, model.getSelectedLevel());
		
	}

	/**
	 * Test method for {@link scandium.lettercraze.model.Model#getLevels()}.
	 */
	public void testGetLevels() {
		assertNotNull(model.getLevels());
	}

	/**
	 * Test method for {@link scandium.lettercraze.model.Model#getProgress()}.
	 */
	public void testGetProgress() {
		assertNotNull(model.getProgress());
	}

}
