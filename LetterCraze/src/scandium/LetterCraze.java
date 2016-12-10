/**
 * LetterCraze.java
 * 
 * @author Scandium
 */
package scandium;

import java.awt.Dimension;
import java.awt.Toolkit;

import scandium.lettercraze.model.Model;
import scandium.lettercraze.view.Application;

/**
 * The main class for LetterCraze.
 */
public class LetterCraze {
	
	/**
	 * Starts the LetterCraze application.
	 */
	public static void main(String[] args) {
		Application app = new Application(new Model());
		app.setSize(new Dimension(1280, 720));
		app.setMinimumSize(new Dimension(640, 480));
		app.setMaximumSize(Toolkit.getDefaultToolkit().getScreenSize());
		app.showSplashScreen();
		app.setVisible(true);
	}
}
