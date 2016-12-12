/**
 * LevelBuilder.java
 * 
 * @author Scandium
 */
package scandium;

import scandium.levelbuilder.model.Model;
import scandium.levelbuilder.view.Application;

/**
 * The main class for LevelBuilder.
 */
public class LevelBuilder{
	
	/**
	 * Starts the LevelBuilder application.
	 */
	public static void main(String[] args) {
		Application app = new Application(new Model());
		try{Thread.sleep(5000);}catch(Exception e){};
		app.setViewMainMenu();
		app.getLevelEditor().setPuzzleLevelView();
	}
}
