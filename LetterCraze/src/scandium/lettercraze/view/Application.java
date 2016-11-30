/**
 * Application.java
 * 
 * @author Scandium
 */
package scandium.lettercraze.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import scandium.lettercraze.controller.*;
import scandium.lettercraze.model.Model;

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
		initializeModel();
		initializeView();
		initializeControllers();
		setView(mainMenu);
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
		setView(mainMenu);
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

	public void setView(JPanel view) {
		getContentPane().removeAll();
		getContentPane().add(view);
		getContentPane().revalidate();
		getContentPane().repaint();
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
		SplashScreen lcSplash = new SplashScreen(5000);
		lcSplash.displaySplash();

		setTitle("LetterCraze");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		this.mainMenu = new MainMenuView();
		this.levelPlayer = new LevelPlayerView(null);
	}

	/**
	 * Initialize the controllers.
	 */
	private void initializeControllers() {
		mainMenu.getLevelIconView(0).addMouseListener(new OpenLevelController(model,this));
		levelPlayer.getLeaveButton().addActionListener(new ExitLevelController(model,this));
	}
}

