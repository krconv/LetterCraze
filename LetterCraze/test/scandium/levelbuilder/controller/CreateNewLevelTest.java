package scandium.levelbuilder.controller;

import java.awt.event.MouseEvent;

import scandium.common.testresources.ScandiumLevelBuilderTestCase;
import scandium.levelbuilder.model.Model;
import scandium.levelbuilder.view.Application;

public class CreateNewLevelTest extends ScandiumLevelBuilderTestCase {
	Application app;

	protected void setUp() throws Exception {
		app = new Application(new Model());
		app.setVisible(true);
		app.setViewMainMenu();
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
		MouseEvent click = this.createClicked(app, app.getMainMenu().getNewLevelButton(), 42, 36);
		app.getMainMenu().getNewLevelButton().dispatchEvent(click);
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
		}
		//check that correct panel is visible
		assertEquals(false,app.getMainMenu().isVisible());
		assertEquals(false,app.getSplashScreen().isVisible());
		assertEquals(true,app.getLevelEditor().isVisible());
		//check that default attributes are visible
		assertEquals(true,app.getLevelEditor().getBoardView().isVisible());
		assertEquals(true,app.getLevelEditor().getGenerateButton().isVisible());
		assertEquals(true,app.getLevelEditor().getMainMenuButton().isVisible());
		assertEquals(true,app.getLevelEditor().getSaveButton().isVisible());
		assertEquals(true,app.getLevelEditor().getLevelTypeComboBox().isVisible());
		assertEquals(true,app.getLevelEditor().getLevelNameTextField().isVisible());
		assertEquals(true,app.getLevelEditor().getStarOneTextField().isVisible());
		assertEquals(true,app.getLevelEditor().getStarTwoTextField().isVisible());
		assertEquals(true,app.getLevelEditor().getStarThreeTextField().isVisible());
		//check Puzzle Level View attributes are visible (default)
		assertEquals(true,app.getLevelEditor().getMaxNumWordsBox().isVisible());
		// 
		//check Theme Level attributes are not visible
		assertEquals(false,app.getLevelEditor().getThemeNameBox().isVisible());
		assertEquals(false,app.getLevelEditor().getThemeWordsBox().isVisible());
		//check that Lighting Level attributes are not visible
		assertEquals(false,app.getLevelEditor().getTimeLimitBox().isVisible());
	}

	public void testEditPuzzleLevelButtonViewChange(){
		//TODO create tests for if the items inside of the text fields are correct
		//can use .getSelectedText() on TextFields to get text inside of them
		assertEquals(true,app.getMainMenu().isVisible());
		assertEquals(false,app.getSplashScreen().isVisible());
		assertEquals(false,app.getLevelEditor().isVisible());
		MouseEvent clickEditButton = this.createClicked(app, app.getMainMenu().getNewLevelButton(), 0, 0);
		MouseEvent clickLevel = this.createClicked(app, app.getMainMenu().getLevelIcons().get(0), 0, 0);
		app.getMainMenu().getLevelIcons().get(0).dispatchEvent(clickLevel);
		app.getMainMenu().getEditLevelButton().dispatchEvent(clickEditButton);
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
		}
		//check that correct panel is visible
		assertEquals(false,app.getMainMenu().isVisible());
		assertEquals(false,app.getSplashScreen().isVisible());
		assertEquals(true,app.getLevelEditor().isVisible());
		//check that default attributes are visible
		assertEquals(true,app.getLevelEditor().getBoardView().isVisible());
		assertEquals(true,app.getLevelEditor().getGenerateButton().isVisible());
		assertEquals(true,app.getLevelEditor().getMainMenuButton().isVisible());
		assertEquals(true,app.getLevelEditor().getSaveButton().isVisible());
		assertEquals(true,app.getLevelEditor().getLevelNameTextField().isVisible());
		assertEquals(true,app.getLevelEditor().getLevelNameTextField().isVisible());
		assertEquals(true,app.getLevelEditor().getStarOneTextField().isVisible());
		assertEquals(true,app.getLevelEditor().getStarTwoTextField().isVisible());
		assertEquals(true,app.getLevelEditor().getStarThreeTextField().isVisible());
		//check Puzzle Level View attributes are visible (default)
		assertEquals(true,app.getLevelEditor().getMaxNumWordsBox().isVisible());
		//check Theme Level attributes are not visible
		assertEquals(false,app.getLevelEditor().getThemeNameBox().isVisible());
		assertEquals(false,app.getLevelEditor().getThemeWordsBox().isVisible());
		//check that Lighting Level attributes are not visible
		assertEquals(false,app.getLevelEditor().getTimeLimitBox().isVisible());
	}

	public void testEditLightingLevelButtonViewChange(){
		//TODO create tests for if the items inside of the text fields are correct
		//can use .getSelectedText() on TextFields to get text inside of them
		assertEquals(true,app.getMainMenu().isVisible());
		assertEquals(false,app.getSplashScreen().isVisible());
		assertEquals(false,app.getLevelEditor().isVisible());
		MouseEvent clickEditButton = this.createClicked(app, app.getMainMenu().getNewLevelButton(), 0, 0);
		MouseEvent clickLevel = this.createClicked(app, app.getMainMenu().getLevelIcon(1), 0, 0);
		app.getMainMenu().getLevelIcon(1).dispatchEvent(clickLevel);
		app.getMainMenu().getEditLevelButton().dispatchEvent(clickEditButton);
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
		}
		//check that correct panel is visible
		assertEquals(false,app.getMainMenu().isVisible());
		assertEquals(false,app.getSplashScreen().isVisible());
		assertEquals(true,app.getLevelEditor().isVisible());
		//check that default attributes are visible
		assertEquals(true,app.getLevelEditor().getBoardView().isVisible());
		assertEquals(true,app.getLevelEditor().getGenerateButton().isVisible());
		assertEquals(true,app.getLevelEditor().getMainMenuButton().isVisible());
		assertEquals(true,app.getLevelEditor().getSaveButton().isVisible());
		assertEquals(true,app.getLevelEditor().getLevelNameTextField().isVisible());
		assertEquals(true,app.getLevelEditor().getStarOneTextField().isVisible());
		assertEquals(true,app.getLevelEditor().getStarTwoTextField().isVisible());
		assertEquals(true,app.getLevelEditor().getStarThreeTextField().isVisible());
		//check Puzzle Level View attributes are visible (default)
		assertEquals(false,app.getLevelEditor().getMaxNumWordsBox().isVisible());
		//check Theme Level attributes are not visible
		assertEquals(false,app.getLevelEditor().getThemeNameBox().isVisible());
		assertEquals(false,app.getLevelEditor().getThemeWordsBox().isVisible());
		//check that Lighting Level attributes are not visible
		assertEquals(true,app.getLevelEditor().getTimeLimitBox().isVisible());
	}

	public void testEditThemeLevelButtonViewChange(){
		//TODO create tests for if the items inside of the text fields are correct
		//can use .getSelectedText() on TextFields to get text inside of them
		assertEquals(true,app.getMainMenu().isVisible());
		assertEquals(false,app.getSplashScreen().isVisible());
		assertEquals(false,app.getLevelEditor().isVisible());
		MouseEvent clickEditButton = this.createClicked(app, app.getMainMenu().getNewLevelButton(), 0, 0);
		MouseEvent clickLevel = this.createClicked(app, app.getMainMenu().getLevelIcon(2), 0, 0);
		app.getMainMenu().getLevelIcon(2).dispatchEvent(clickLevel);
		app.getMainMenu().getEditLevelButton().dispatchEvent(clickEditButton);
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
		}
		//check that correct panel is visible
		assertEquals(false,app.getMainMenu().isVisible());
		assertEquals(false,app.getSplashScreen().isVisible());
		assertEquals(true,app.getLevelEditor().isVisible());
		//check that default attributes are visible
		assertEquals(true,app.getLevelEditor().getBoardView().isVisible());
		assertEquals(true,app.getLevelEditor().getGenerateButton().isVisible());
		assertEquals(true,app.getLevelEditor().getMainMenuButton().isVisible());
		assertEquals(true,app.getLevelEditor().getSaveButton().isVisible());
		assertEquals(true,app.getLevelEditor().getLevelNameTextField().isVisible());
		assertEquals(true,app.getLevelEditor().getStarOneTextField().isVisible());
		assertEquals(true,app.getLevelEditor().getStarTwoTextField().isVisible());
		assertEquals(true,app.getLevelEditor().getStarThreeTextField().isVisible());
		//check Puzzle Level View attributes are visible (default)
		assertEquals(false,app.getLevelEditor().getMaxNumWordsBox().isVisible());
		//check Theme Level attributes are not visible
		assertEquals(true,app.getLevelEditor().getThemeNameBox().isVisible());
		assertEquals(true,app.getLevelEditor().getThemeWordsBox().isVisible());
		//check that Lighting Level attributes are not visible
		assertEquals(false,app.getLevelEditor().getTimeLimitBox().isVisible());
	}

	public void testLeaveLevelEditorViewChange(){
		assertEquals(true,app.getMainMenu().isVisible());
		assertEquals(false,app.getSplashScreen().isVisible());
		assertEquals(false,app.getLevelEditor().isVisible());
		MouseEvent clickEditButton = this.createClicked(app, app.getMainMenu().getNewLevelButton(), 0, 0);
		MouseEvent clickLevel = this.createClicked(app, app.getMainMenu().getLevelIcon(0), 0, 0);
		app.getMainMenu().getLevelIcon(0).dispatchEvent(clickLevel);
		app.getMainMenu().getEditLevelButton().dispatchEvent(clickEditButton);
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
		}
		//check that correct panel is visible
		assertEquals(false,app.getMainMenu().isVisible());
		assertEquals(false,app.getSplashScreen().isVisible());
		assertEquals(true,app.getLevelEditor().isVisible());
		//click on the Main Menu Button to return to Main Menu
		MouseEvent clickExit = this.createClicked(app, app.getLevelEditor().getMainMenuButton(), 0, 0);
		app.getLevelEditor().getMainMenuButton().dispatchEvent(clickExit);
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
		}
		//check that correct panel is visible
		assertEquals(true,app.getMainMenu().isVisible());
		assertEquals(false,app.getSplashScreen().isVisible());
		assertEquals(false,app.getLevelEditor().isVisible());
	}

	public void testEnableDisableBoardSquare(){
		assertEquals(true,app.getMainMenu().isVisible());
		assertEquals(false,app.getSplashScreen().isVisible());
		assertEquals(false,app.getLevelEditor().isVisible());
		//click on the New Level Button
		MouseEvent press = this.createClicked(app, app.getMainMenu().getNewLevelButton(), 0, 0);
		app.getMainMenu().getNewLevelButton().dispatchEvent(press);
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
		}
		//check that correct panel is visible
		assertEquals(false,app.getMainMenu().isVisible());
		assertEquals(false,app.getSplashScreen().isVisible());
		assertEquals(true,app.getLevelEditor().isVisible());
		//assert top left BoardSquare in enabled
		assertEquals(true,app.getModel().getEditProgress().getModified().getBoard().getSquare(0, 0).isEnabled());
		//click on the top left Board Square
		MouseEvent clickSquare = this.createClicked(app, app.getLevelEditor().getBoardView(), 21, 21);
		app.getLevelEditor().getBoardView().dispatchEvent(clickSquare);
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
		}
		//assert top left Board Square is disabled
		assertEquals(false,app.getModel().getEditProgress().getModified().getBoard().getSquare(0, 0).isEnabled());
		//repeat click on top left BoardSquare
		app.getLevelEditor().getBoardView().dispatchEvent(clickSquare);
		//assert top left Board Square is enabled
		assertEquals(true,app.getModel().getEditProgress().getModified().getBoard().getSquare(0, 0).isEnabled());
	}

}
