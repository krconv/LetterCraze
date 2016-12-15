package scandium.levelbuilder.controller;

import java.awt.event.MouseEvent;
import java.io.File;

import scandium.common.model.Board;
import scandium.common.model.PuzzleLevel;
import scandium.common.testresources.ScandiumLevelBuilderTestCase;
import scandium.common.tool.LetterDictionary;
import scandium.levelbuilder.model.EditProgress;
import scandium.levelbuilder.model.Model;
import scandium.levelbuilder.view.Application;

public class ToggleEnableControllerTest extends ScandiumLevelBuilderTestCase {
	Application app;

	protected void setUp() throws Exception {
		app = new Application(new Model());
		app.setViewMainMenu();
		app.getModel().setEditProgress(new EditProgress(new PuzzleLevel()));
	}

	protected void tearDown() throws Exception {
		app.dispose();
		new File("LetterCrazeProgress.xml").delete();
	}
	
	public void testEnableToggle(){
		/* Create Simulated click */
		MouseEvent click = this.createClicked(app, app.getLevelEditor().getBoardView().getBoardSquareLabel(0, 0), 0, 0);
		/* populate the boardSquares with tiles */
		Board board = app.getModel().getEditProgress().getModified().getBoard();
		board.fillEmptySquares(new LetterDictionary());
		/* Validate that all BoardSquares are enabled and have a tile */
		for(int i = 0; i < 6; i++){
			for(int j = 0; j < 6; j++){
				assertNotNull(board.getSquare(i, j).getTile());
				assertTrue(board.getSquare(i, j).isEnabled());
			}
		}
		/* Simulate click on square */
		app.getLevelEditor().getBoardView().getBoardSquareLabel(0, 0).dispatchEvent(click);
		
		/* Veryify that the board Square is now enabled, and that the square tiles are now null */
		assertFalse(board.getSquare(0, 0).isEnabled());
		for(int i = 0; i < 6; i++){
			for(int j = 0; j < 6; j++){
				assertNull(board.getSquare(i, j).getTile());
			}
		}
		
		/*RePopulate board */
		board.fillEmptySquares(new LetterDictionary());
		
		/* Simulate click on square */
		app.getLevelEditor().getBoardView().getBoardSquareLabel(0, 0).dispatchEvent(click);
		
		/* Validate that the board is empty and that this square is enabled */
		assertTrue(board.getSquare(0, 0).isEnabled());
		for(int i = 0; i < 6; i++){
			for(int j = 0; j < 6; j++){
				assertNull(board.getSquare(i, j).getTile());
			}
		}
		
	}
}
