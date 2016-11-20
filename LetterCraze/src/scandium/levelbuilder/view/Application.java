/**
 * Application.java
 * 
 * @author Scandium
 */
package scandium.levelbuilder.view;

import javax.swing.JPanel;

import scandium.levelbuilder.model.Model;

/**
 * The LevelBuilder application window.
 */
public class Application extends JPanel {
	private static final long serialVersionUID = 1110806632457203710L;
	private Model model;
	private MainMenuView mainMenu;
	private LevelEditorView levelEditor;
	
    /**
     * Creates a new LevelBuilder application window.
     * @param model The model of the application.
     */
    public void LevelBuilder(Model model) {
    	this.model = model;
    	
    	initializeModel();
    	initializeView();
    	initializeControllers();
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
	 * @return the levelEditor
	 */
	public LevelEditorView getLevelEditor() {
		return levelEditor;
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
    private void initializeView() {
        // TODO implement here
    }

    /**
     * Initialize the controllers.
     */
    private void initializeControllers() {
        // TODO implement here
    }
}