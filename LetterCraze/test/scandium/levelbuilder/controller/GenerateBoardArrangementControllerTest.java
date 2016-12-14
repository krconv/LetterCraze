package scandium.levelbuilder.controller;

import java.awt.event.MouseEvent;

import scandium.common.model.Board;
import scandium.common.model.PuzzleLevel;
import scandium.common.model.ThemeLevel;
import scandium.common.testresources.ScandiumLevelBuilderTestCase;
import scandium.levelbuilder.model.EditProgress;
import scandium.levelbuilder.model.Model;
import scandium.levelbuilder.view.Application;

public class GenerateBoardArrangementControllerTest extends ScandiumLevelBuilderTestCase {
	Application app;

	protected void setUp() throws Exception {
		app = new Application(new Model());
		app.setViewMainMenu();
	}

	protected void tearDown() throws Exception {
		app.dispose();
	}
	
	/**
	 * This method ensures that the generateBoardArrangementController populates the board with tiles. 
	 * Testing for puzzle level.
	 */
	public void testTileGenerationController(){
		app.getModel().setEditProgress(new EditProgress(new PuzzleLevel()));
		
		/* Create Simulated click */
		MouseEvent click = this.createClicked(app, app.getLevelEditor().getGenerateButton(), 0, 0);
		/* populate the boardSquares with tiles */
		Board board = app.getModel().getEditProgress().getModified().getBoard();
		
		/* Validate that all BoardSquares do not have a tile */
		for(int i = 0; i < 6; i++){
			for(int j = 0; j < 6; j++){
				assertNull(board.getSquare(i, j).getTile());
			}
		}
		
		/* Dispatch simulated click */
		app.getLevelEditor().getGenerateButton().dispatchEvent(click);
		
		/* Validate that all BoardSquares have a tile */
		for(int i = 0; i < 6; i++){
			for(int j = 0; j < 6; j++){
				assertNotNull(board.getSquare(i, j).getTile());
			}
		}
		
	}
	
	/**
	 * This method ensures that the generateBoardArrangementController populates the board with tiles. 
	 * Testing for Theme level.
	 */
	public void testTileGenerationControllerTheme(){
		app.getModel().setEditProgress(new EditProgress(new ThemeLevel()));
		
		/* Create Simulated click */
		MouseEvent click = this.createClicked(app, app.getLevelEditor().getGenerateButton(), 0, 0);
		/* populate the boardSquares with tiles */
		Board board = app.getModel().getEditProgress().getModified().getBoard();
		
		/* Validate that all BoardSquares do not have a tile */
		for(int i = 0; i < 6; i++){
			for(int j = 0; j < 6; j++){
				assertNull(board.getSquare(i, j).getTile());
			}
		}
		
		/* Dispatch simulated click */
		app.getLevelEditor().getGenerateButton().dispatchEvent(click);
		
		/* Validate that all BoardSquares have a tile */
		for(int i = 0; i < 6; i++){
			for(int j = 0; j < 6; j++){
				assertNotNull(board.getSquare(i, j).getTile());
			}
		}
		
	}
}
