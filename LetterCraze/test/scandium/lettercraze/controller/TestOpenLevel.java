package scandium.lettercraze.controller;

import java.awt.event.MouseEvent;

import scandium.common.testresources.ScandiumLetterCrazeTestCase;
import scandium.lettercraze.model.Model;
import scandium.lettercraze.view.Application;

public class TestOpenLevel extends ScandiumLetterCrazeTestCase {

	Application app;
	
	protected void setUp() throws Exception {
		app = new Application(new Model());
		app.setView(app.getMainMenu());
	}

	protected void tearDown() throws Exception {
		app.dispose();
	}
	
	/**
	 * Tests that the MainMenuView initializes properly.
	 */
	public void testInitializeMainMenuView(){
		//check correct view is open
		assertEquals(true,app.getMainMenu().isVisible());
		assertEquals(false,app.getLevelPlayer().isVisible());
		//check that the proper attributes are visible and have the correct data
		assertEquals(true,app.getMainMenu().getResetButton().isVisible());
		//TODO This following line needs to be changed to be what the correct number of levels is
		assertEquals(3,app.getMainMenu().getLevelIcons().size());
		assertEquals(true,app.getMainMenu().getTitleLabel().isVisible());
		assertEquals("LetterCraze",app.getMainMenu().getTitleLabel().getText());
	}
	
	/**
	 * Tests that a Puzzle Level opens properly after a click on the right Level Icon in the Main Menu.
	 */
	public void testOpenPuzzleLevel(){
		//check correct View is open
		assertEquals(true,app.getMainMenu().isVisible());
		assertEquals(false,app.getLevelPlayer().isVisible());
		//create click event
		MouseEvent click = this.createClicked(app, app.getMainMenu().getLevelIcons().get(0), 0, 0);
		app.getMainMenu().getLevelIcons().get(0).dispatchEvent(click);
		//check proper things are visible with the correct data
		assertEquals(false,app.getMainMenu().isVisible());
		assertEquals(true,app.getLevelPlayer().isVisible());
		//check attributes are visible and have correct data	
		assertEquals(true,app.getLevelPlayer().getFoundWordsLabel().isVisible());
		assertEquals("Found Words",app.getLevelPlayer().getFoundWordsLabel().getText());
		
		assertEquals(true,app.getLevelPlayer().getFoundWordsScrollPane().isVisible());
		assertEquals(0,app.getLevelPlayer().getFoundWordsListModel().size());
		
		assertEquals(true,app.getLevelPlayer().getLeaveButton().isVisible());
		assertEquals(true,app.getLevelPlayer().getUndoButton().isVisible());
		assertEquals(true,app.getLevelPlayer().getResetButton().isVisible());
		
		assertEquals(true,app.getLevelPlayer().getStarBox().isVisible());
		assertEquals(0,app.getLevelPlayer().getLevelProgress().getStarCount());
		assertEquals(false,app.getLevelPlayer().getStarLabel(0).isVisible());
		assertEquals(false,app.getLevelPlayer().getStarLabel(1).isVisible());
		assertEquals(false,app.getLevelPlayer().getStarLabel(2).isVisible());
		
		assertEquals(true,app.getLevelPlayer().getNextStarBox().isVisible());
		assertEquals(Integer.toString(app.getLevelPlayer().getLevelProgress().getLevel().getStar(0).getThreshold()),app.getLevelPlayer().getNextStarValueLabel().getText());
		
		assertEquals(true,app.getLevelPlayer().getScoreBox().isVisible());
		assertEquals(Integer.toString(app.getLevelPlayer().getLevelProgress().getScore()) + " words",app.getLevelPlayer().getScoreValueLabel());
		
		assertEquals(true,app.getLevelPlayer().getNextStarValueLabel().isVisible());
	}

}
