/**
 * LetterCraze.java
 * 
 * @author Scandium
 */
package scandium;

import scandium.lettercraze.view.Application;

/**
 * The main class for LetterCraze.
 */
public class LetterCraze {
	
	/**
	 * Starts the LetterCraze application.
	 */
	public static void main(String[] args) {
		Application app = new Application();
		app.setSize(1280, 720);
		app.setVisible(true);
	}
}
