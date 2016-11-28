/**
 * Application.java
 * 
 * @author Scandium
 */
package scandium.lettercraze.view;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import scandium.lettercraze.model.Model;
import java.awt.Font;
import java.awt.Color;

/**
 * The LetterCraze application window.
 */
public class Application extends JFrame {
	static final long serialVersionUID = -7053432922965446279L;
	private Model model;
	private MainMenuView mainMenu;
	private LevelPlayerView levelPlayer;

	/**
	 * Creates a new LetterCraze application window without a model.
	 */
	public Application() {
		initializeView();
	}

	/**
	 * Creates a new LetterCraze application window.
	 * 
	 * @param model
	 *            The model of the application.
	 */
	public Application(Model model) {
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
	private void initializeView() {
		setTitle("LetterCraze");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		UIManager.getLookAndFeelDefaults().put("defaultFont", new Font("Segoe WP Light", Font.PLAIN, 12));
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		getContentPane().setFont(null);
		this.mainMenu = new MainMenuView();
		mainMenu.setForeground(new Color(0, 0, 0));
		getContentPane().add(mainMenu);
		
		this.levelPlayer = new LevelPlayerView(null);
	}

	/**
	 * Initialize the controllers.
	 */
	private void initializeControllers() {
		// TODO implement here
	}

}