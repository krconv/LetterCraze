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
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
		}
		//check proper things are visible with the correct data
		assertEquals(false,app.getMainMenu().isVisible());
		assertEquals(true,app.getLevelPlayer().isVisible());
		//check attributes are visible and have correct data	
		assertEquals(true,app.getLevelPlayer().getLevelNameLabel().isVisible());
		assertEquals("Puzzled",app.getLevelPlayer().getLevelNameLabel().getText());

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
		assertEquals(true,app.getLevelPlayer().getNextStarValueLabel().isVisible());
		assertEquals(Integer.toString(app.getLevelPlayer().getLevelProgress().getLevel().getStar(0).getThreshold()) + " point",app.getLevelPlayer().getNextStarValueLabel().getText());

		assertEquals(true,app.getLevelPlayer().getScoreBox().isVisible());		
		assertEquals(Integer.toString(app.getLevelPlayer().getLevelProgress().getScore()) + " points",app.getLevelPlayer().getScoreValueLabel());

		assertEquals(true,app.getLevelPlayer().getRestrictorBox().isVisible());
		assertEquals("Words Left:",app.getLevelPlayer().getRestrictorLabel().getText());
		assertEquals("5 words",app.getLevelPlayer().getRestrictorValueLabel().getText());

		assertEquals(true,app.getLevelPlayer().getBoardView().isVisible());	
		for(int row = 0; row < 6; row++){
			for(int col = 0; col < 6; col++){
				if((row==2 && (col == 3 || col == 4)) || (row == 3 && (col == 3 || col == 4)) 
						|| (row == 5 && (col == 3 || col == 4 || col == 5 || col == 6)) 
						|| (row == 6 && (col == 3 || col == 4 || col == 5 || col == 6))) {
					assertEquals(false, app.getLevelPlayer().getBoardView().getBoardSquareLabel(row, col).isEnabled());
				} else {
					assertEquals(true, app.getLevelPlayer().getBoardView().getBoardSquareLabel(row, col).isEnabled());
				}
			}
		}
	}

	/**
	 * Tests that a Lighting Level opens properly after a click on the right Level Icon in the Main Menu.
	 */
	public void testOpenLightingLevel(){
		//check correct View is open
		assertEquals(true,app.getMainMenu().isVisible());
		assertEquals(false,app.getLevelPlayer().isVisible());
		//create click event
		MouseEvent click = this.createClicked(app, app.getMainMenu().getLevelIcons().get(1), 0, 0);
		app.getMainMenu().getLevelIcons().get(1).dispatchEvent(click);
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
		}
		//check proper things are visible with the correct data
		assertEquals(false,app.getMainMenu().isVisible());
		assertEquals(true,app.getLevelPlayer().isVisible());
		//check attributes are visible and have correct data	
		assertEquals(true,app.getLevelPlayer().getLevelNameLabel().isVisible());
		assertEquals("Fast!",app.getLevelPlayer().getLevelNameLabel().getText());

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
		assertEquals(true,app.getLevelPlayer().getNextStarValueLabel().isVisible());
		assertEquals(Integer.toString(app.getLevelPlayer().getLevelProgress().getLevel().getStar(0).getThreshold()) + " word",app.getLevelPlayer().getNextStarValueLabel().getText());

		assertEquals(true,app.getLevelPlayer().getScoreBox().isVisible());		
		assertEquals(Integer.toString(app.getLevelPlayer().getLevelProgress().getScore()) + " words",app.getLevelPlayer().getScoreValueLabel());

		assertEquals(true,app.getLevelPlayer().getRestrictorBox().isVisible());
		assertEquals("Time Left:",app.getLevelPlayer().getRestrictorLabel().getText());
		//have no way to check what the timer label has because we don't know how long it took to get here

		assertEquals(true,app.getLevelPlayer().getBoardView().isVisible());	
		for(int row = 0; row < 6; row++){
			for(int col = 0; col < 6; col++){
				if((row == 1 && (col == 1 || col == 2)) 
						|| (row == 2 && (col == 5 || col == 6))
						|| (row == 3 && (col == 1 || col == 2)) 
						|| (row == 4 && (col == 5 || col == 6))
						|| (row == 5 && (col == 1 || col == 2))
						|| (row == 6 && (col == 5 || col == 6))) {
					assertEquals(false, app.getLevelPlayer().getBoardView().getBoardSquareLabel(row, col).isEnabled());
				} else {
					assertEquals(true, app.getLevelPlayer().getBoardView().getBoardSquareLabel(row, col).isEnabled());
				}
			}
		}
	}

	/**
	 * Tests that a Theme Level opens properly after a click on the right Level Icon in the Main Menu.
	 */
	public void testOpenThemeLevel(){
		//check correct View is open
		assertEquals(true,app.getMainMenu().isVisible());
		assertEquals(false,app.getLevelPlayer().isVisible());
		//create click event
		MouseEvent click = this.createClicked(app, app.getMainMenu().getLevelIcons().get(2), 0, 0);
		app.getMainMenu().getLevelIcons().get(2).dispatchEvent(click);
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
		}
		//check proper things are visible with the correct data
		assertEquals(false,app.getMainMenu().isVisible());
		assertEquals(true,app.getLevelPlayer().isVisible());
		//check attributes are visible and have correct data	
		assertEquals(true,app.getLevelPlayer().getLevelNameLabel().isVisible());
		assertEquals("Colors...",app.getLevelPlayer().getLevelNameLabel().getText());

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
		assertEquals(true,app.getLevelPlayer().getNextStarValueLabel().isVisible());
		assertEquals(Integer.toString(app.getLevelPlayer().getLevelProgress().getLevel().getStar(0).getThreshold()) + " word",app.getLevelPlayer().getNextStarValueLabel().getText());

		assertEquals(true,app.getLevelPlayer().getScoreBox().isVisible());		
		assertEquals(Integer.toString(app.getLevelPlayer().getLevelProgress().getScore()) + " words",app.getLevelPlayer().getScoreValueLabel());

		assertEquals(true,app.getLevelPlayer().getRestrictorBox().isVisible());
		assertEquals("Words Left:",app.getLevelPlayer().getRestrictorLabel().getText());
		assertEquals("3 words",app.getLevelPlayer().getRestrictorValueLabel().getText());

		assertEquals(true,app.getLevelPlayer().getBoardView().isVisible());	
		for(int row = 0; row < 6; row++){
			for(int col = 0; col < 6; col++){
				if((row == 1 && (col == 1 || col == 5 || col == 6)) 
						|| (row == 2 && (col == 1 || col == 5 || col == 6))
						|| (row == 3 && (col == 1 || col == 5 || col == 6)) 
						|| (row == 4 && (col == 1 || col == 6))
						|| (row == 5 && (col == 1 || col == 6))
						|| (row == 6)) {
					assertEquals(false, app.getLevelPlayer().getBoardView().getBoardSquareLabel(row, col).isEnabled());
				} else {
					assertEquals(true, app.getLevelPlayer().getBoardView().getBoardSquareLabel(row, col).isEnabled());
				}
			}
		}
	}

	/**
	 * Tests that a locked level does not open Level Player upon being clicked
	 */
	public void testClickLockedLevel(){
		//check correct View is open
		assertEquals(true,app.getMainMenu().isVisible());
		assertEquals(false,app.getLevelPlayer().isVisible());
		//create click event
		MouseEvent click = this.createClicked(app, app.getMainMenu().getLevelIcons().get(10), 0, 0);
		app.getMainMenu().getLevelIcons().get(10).dispatchEvent(click);
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
		}
		//check correct View is open
		assertEquals(true,app.getMainMenu().isVisible());
		assertEquals(false,app.getLevelPlayer().isVisible());
	}
	
}
