/**
 * LevelBuilder.java
 * 
 * @author Scandium
 */
package scandium;

import scandium.levelbuilder.view.Application;
import scandium.levelbuilder.view.SplashScreen;

/**
 * The main class for LevelBuilder.
 */
public class LevelBuilder{
	
	/**
	 * Starts the LevelBuilder application.
	 */
	public static void main(String[] args) {
//		SplashScreen splash = new SplashScreen(5000);
//		splash.displaySplash();
		Application app = new Application();
		try{
			Thread.sleep(500);
			app.setViewLevelEditor();
			Thread.sleep(500);
			app.getLevelEditor().getBoardView().selectBoardSquare(2, 3);
			Thread.sleep(500);
			app.getLevelEditor().getBoardView().deselectBoardSquare(2, 3);
			Thread.sleep(500);
			app.getLevelEditor().getBoardView().setBoardSquareText("A", 2, 3);
			Thread.sleep(500);
			app.getLevelEditor().setPuzzleLevelView();
			Thread.sleep(2000);
			app.getLevelEditor().setLightningLevelView();
			Thread.sleep(2000);
			app.getLevelEditor().setThemeLevelView();
			
		}catch(Exception e){
			
		}
	}
}
