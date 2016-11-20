/**
 * Application.java
 * 
 * @author Scandium
 */
package scandium.lettercraze.view;

import javax.swing.JFrame;

import scandium.lettercraze.model.Model;


/**
 * The LetterCraze application window. 
 */
public class Application extends JFrame {
	private static final long serialVersionUID = -7053432922965446279L;
    private Model model;
    private MainMenuView mainMenu;
    private LevelPlayerView levelPlayer;

    /**
     * Creates a new LetterCraze application window.
     * @param model The model of the application.
     */
    public void LetterCraze(Model model) {
        // TODO implement here
    }

    /**
	 * @return the model
	 */
	public Model getModel() {
		return model;
	}

	/**
	 * @return the mainMenu
	 */
	public MainMenuView getMainMenu() {
		return mainMenu;
	}
	
	/**
	 * @return the levelPlayer
	 */
	public LevelPlayerView getLevelPlayer() {
		return levelPlayer;
	}

	/**
     * Initialize the model.
     */
    private void initializeModel() {
        // TODO implement here
    }

    /**
     * Initialize the view.
     */
    private  void initializeView() {
        // TODO implement here
    }

    /**
     * Initialize the controllers.
     */
    private void initializeControllers() {
        // TODO implement here
    }

}