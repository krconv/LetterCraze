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

import scandium.common.tool.LetterDictionary;
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
	private SplashScreenView splashScreen;

	/**
	 * Creates a new LetterCraze application window.
	 * 
	 * @param model
	 *            The model of the application.
	 */
	public Application(Model model) {
		this.model = model;

		initializeView();
		initializeControllers();
		setSplashScreenView();
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
	 * This function returns the SplashScreenView for LetterCraze.
	 * @return The splash screen.
	 */
	public SplashScreenView getSplashScreen(){
		return splashScreen;
	}

	/**
	 * Sets the main view of the application.
	 * @param view The view to change the application to.
	 */
	public void setView(JPanel view) {
		getContentPane().removeAll();
		getContentPane().add(view);
		getContentPane().revalidate();
		if(view.equals(levelPlayer)) {
			mainMenu.setVisible(false);
			levelPlayer.setVisible(true);
		} else if (view.equals(mainMenu)) {
			mainMenu.setVisible(true);
			levelPlayer.setVisible(false);
		}
		getContentPane().repaint();
	}

	/**
	 * This function sets the application view to display the Main Menu View
	 */
	public void setViewMainMenu(){
		setView(mainMenu);
	}

	/** 
	 * This function set the application view to display the Level Editor
	 */
	public void setViewLevelEditor(){
		setView(levelPlayer);
	}
	
	/** 
	 * This function set the application view to display the Splash Screen.
	 */
	public void setSplashScreenView(){
		setView(splashScreen);
	}
	
	/**
	 * Initialize the view.
	 */
	private void initializeView() {
		setTitle("LetterCraze");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			// if we can't change to look, who cares
		}
		this.mainMenu = new MainMenuView(model);
		this.levelPlayer = new LevelPlayerView(model.getProgress().getCurrentLevelProgress());
		this.splashScreen = new SplashScreenView();
	}

	/**
	 * Initialize the controllers.
	 */
	private void initializeControllers() {
		for (LevelIconView view : mainMenu.getLevelIcons()) {
			view.addMouseListener(new OpenLevelController(model, this, view.getModel()));
		}
		
		LetterDictionary letterDictionary = new LetterDictionary();
		levelPlayer.getLeaveButton().addActionListener(new ExitLevelController(model,this));
		levelPlayer.getUndoButton().addActionListener(new UndoController(model, this));
		
		/* Initialize controllers for the 'board squares' */
		for(int i = 0; i < 6; i++){
			for(int j = 0; j < 6; j++){
				
				levelPlayer.getBoardView().getBoardSquareLabel(i, j).addMouseListener(new SelectTileController(model, this, i, j));
				levelPlayer.getBoardView().getBoardSquareLabel(i, j).addMouseListener(new RemoveWordController(model, this, letterDictionary));
				levelPlayer.getBoardView().getBoardSquareLabel(i, j).addMouseMotionListener(new WordDragController(model, this, i, j));
				
			}
		}
		levelPlayer.getResetButton().addMouseListener(new ResetLevelController(model, this));
		mainMenu.getResetButton().addMouseListener(new ResetTotalProgressController(model, this, model.getProgress()));
	}
}

