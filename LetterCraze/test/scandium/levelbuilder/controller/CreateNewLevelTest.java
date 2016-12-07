package scandium.levelbuilder.controller;


import java.awt.Event;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

import javax.swing.JComponent;

import scandium.common.testresources.ScandiumLevelBuilderTestCase;
import scandium.levelbuilder.view.Application;

public class CreateNewLevelTest extends ScandiumLevelBuilderTestCase {
	Application app;
	
	protected void setUp() throws Exception {
		app = new Application();
		try{Thread.sleep(5000);}catch(Exception e){};
		app.setViewMainMenu();
		try{Thread.sleep(1000);}catch(Exception e){};
	}

	protected void tearDown() throws Exception {
		app.dispose();
	}
	
	/**
	 * Checks that clicking on the New Level Button displays the Level Editor View.
	 */
	public void testNewLevelButtonViewChange(){
		assertEquals(true,app.getMainMenu().isVisible());
		assertEquals(false,app.getSplashScreen().isVisible());
		assertEquals(false,app.getLevelEditor().isVisible());
		MouseEvent press = this.createClicked(app, app.getMainMenu().getNewLevelButton(), 0, 0);
		app.getMainMenu().getNewLevelButton().dispatchEvent(press);
		//check that correct panel is visible
		assertEquals(false,app.getMainMenu().isVisible());
		assertEquals(false,app.getSplashScreen().isVisible());
		assertEquals(true,app.getLevelEditor().isVisible());
		//check that default attributes are visible
		assertEquals(true,app.getLevelEditor().getBoardView().isVisible());
		assertEquals(true,app.getLevelEditor().getGenerateButton().isVisible());
		assertEquals(true,app.getLevelEditor().getMainMenuButton().isVisible());
		assertEquals(true,app.getLevelEditor().getSaveButton().isVisible());
		assertEquals(true,app.getLevelEditor().getLightningLevelButton().isVisible());
		assertEquals(true,app.getLevelEditor().getThemeLevelButton().isVisible());
		assertEquals(true,app.getLevelEditor().getPuzzleLevelButton().isVisible());
		assertEquals(true,app.getLevelEditor().getLevelNameTextField().isVisible());
		assertEquals(true,app.getLevelEditor().getLevelNameLabel().isVisible());
		assertEquals(false,app.getLevelEditor().getLevelSpecificLabel().isVisible());
		assertEquals(true,app.getLevelEditor().getOneStarLabel().isVisible());
		assertEquals(true,app.getLevelEditor().getOneStarTextField().isVisible());
		assertEquals(true,app.getLevelEditor().getOneStarUnitLabel().isVisible());
		assertEquals(true,app.getLevelEditor().getThreeStarLabel().isVisible());
		assertEquals(true,app.getLevelEditor().getThreeStarTextField().isVisible());
		assertEquals(true,app.getLevelEditor().getThreeStarUnitLabel().isVisible());
		assertEquals(true,app.getLevelEditor().getTwoStarLabel().isVisible());
		assertEquals(true,app.getLevelEditor().getTwoStarTextField().isVisible());
		assertEquals(true,app.getLevelEditor().getTwoStarUnitLabel().isVisible());
		//check Puzzle Level View attributes are visible (default)
		assertEquals(true,app.getLevelEditor().getPuzzleMaxNumWordsLabel().isVisible());
		assertEquals(true,app.getLevelEditor().getPuzzleMaxNumWordsTextField().isVisible());
		//check Theme Level attributes are not visible
		assertEquals(false,app.getLevelEditor().getThemeNameTextField().isVisible());
		assertEquals(false,app.getLevelEditor().getThemeWordsTextArea().isVisible());
		//check that Lighting Level attributes are not visible
		assertEquals(false,app.getLevelEditor().getLightningTimeLimitLabel().isVisible());
	}
	
	
}
