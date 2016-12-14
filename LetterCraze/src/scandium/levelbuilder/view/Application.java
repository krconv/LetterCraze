/**
 * Application.java
 * 
 * @author Scandium
 * Date: 11/22/2016
 * Description: This class represents the level builder Application (View/GUI) It stores the
 * Main Menu and Level Editor views.
 */
package scandium.levelbuilder.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import scandium.levelbuilder.controller.CreateNewLevelController;
import scandium.levelbuilder.controller.DeleteLevelController;
import scandium.levelbuilder.controller.GenerateBoardArrangementController;
import scandium.levelbuilder.controller.LeaveLevelEditorController;
import scandium.levelbuilder.controller.SaveLevelController;
import scandium.levelbuilder.controller.SpecifyLevelTypeController;
import scandium.levelbuilder.controller.ToggleEnableController;
import scandium.levelbuilder.model.LevelBuilderState;
import scandium.levelbuilder.model.Model;

public class Application extends JFrame{

	/* Serial ID                                                                                 */
	private static final long serialVersionUID = -7300085623783459664L;

	/* ~~~~~                                                                               ~~~~~ *
	 * Class Attributes                                                                          *
	 * ~~~~~                                                                               ~~~~~ */
	Model model = null;
	MainMenuView main_menu;
	LevelEditorView level_editor;
	SplashScreenView splash_screen;

	/* ~~~~~                                                                               ~~~~~ *
	 * Constructors and Initialization                                                           *
	 * ~~~~~                                                                               ~~~~~ */

	/**
	 * Creates a new LetterCraze application window with a model.
	 * @param model The LevelBuilder Model
	 */
	public Application(Model model){
		this.model = model;
		
		initializeView();
		initializeControllers();
		setSplashScreenView();
	}

	/* ~~~~~                                                                               ~~~~~ *
	 * Getter Methods                                                                            *
	 * ~~~~~                                                                               ~~~~~ */
	/**
	 * @return the model
	 */
	public Model getModel(){
		return this.model;
	}
	
	/**
	 * This function returns the MainMenuView for LevelBuilder
	 * @return MainMenuView
	 */
	public MainMenuView getMainMenu(){
		return main_menu;
	}

	/**
	 * This function returns the LevelEditorView for LevelBuilder
	 * @return LevelEditorView
	 */
	public LevelEditorView getLevelEditor(){
		return level_editor;
	}

	/**
	 * This function returns the SplashScreenView for LevelBuilder
	 * @return SplashScreenView
	 */
	public SplashScreenView getSplashScreen(){
		return splash_screen;
	}

	/**
	 * Sets the main view of the application.
	 * @param view The view to change the application to.
	 */
	public void setView(JPanel view) {
		getContentPane().removeAll();
		getContentPane().add(view);
		getContentPane().revalidate();
		getContentPane().repaint();
	}
	
	/**
	 * This function sets the application view to display the Main Menu View
	 */
	public void setViewMainMenu(){
		setView(main_menu);
	}

	/** 
	 * This function set the application view to display the Level Editor
	 */
	public void setViewLevelEditor(){
		setView(level_editor);
	}
	
	/** 
	 * This function set the application view to display the Splash Screen.
	 */
	public void setSplashScreenView(){
		setView(splash_screen);
	}
	
	/**
	 * Initializes the LevelBuilder View
	 */
	void initializeView(){
		setTitle("LetterCraze Level Builder");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			// if we can't change to look, who cares
		}
		this.main_menu = new MainMenuView(model, this);
		this.level_editor = new LevelEditorView(model, this);
		this.splash_screen = new SplashScreenView();
	}

	/**
	 * Initializes the LevelBuilder Controllers
	 */
	private void initializeControllers() {
		/* Initialize controllers for entering and leaving level editor*/
		main_menu.getNewLevelButton().addMouseListener(new CreateNewLevelController(model,this));
		main_menu.getDeleteLevelButton().addMouseListener(new DeleteLevelController(model,this));
		//main_menu.getEditLevelButton().addMouseListener(new OpenLevelEditorController(model,this));
			
		/* Initialize controllers for SpecifyLevelType*/
		level_editor.getPuzzleLevelButton().addActionListener(new SpecifyLevelTypeController(model,this));
		level_editor.getLightningLevelButton().addActionListener(new SpecifyLevelTypeController(model,this));
		level_editor.getThemeLevelButton().addActionListener(new SpecifyLevelTypeController(model, this));
		
		/* Initialize controllers for level editor buttons*/
		level_editor.getSaveButton().addActionListener(new SaveLevelController(model,this));
		level_editor.getMainMenuButton().addMouseListener(new LeaveLevelEditorController(model,this));
		level_editor.getGenerateButton().addMouseListener(new GenerateBoardArrangementController(model,this));
		
		/* Initialize controllers for the 'board squares' */
		for(int i = 0; i < 6; i++){
			for(int j = 0; j < 6; j++){
				level_editor.getBoardView().get(i, j).addMouseListener(new ToggleEnableController(model, this, i, j));
			}
		}
	}
}