/**
 * Application.java
 * 
 * @author Scandium
 * Date: 11/22/2016
 * Description: This class represents the level builder Application (View/GUI) It stores the
 * Main Menu and Level Editor views.
 */
package scandium.levelbuilder.view;

import java.awt.Dimension;

import javax.swing.JFrame;

import scandium.levelbuilder.controller.CreateNewLevelController;
import scandium.levelbuilder.controller.GenerateBoardArrangementController;
import scandium.levelbuilder.controller.LeaveLevelEditorController;
import scandium.levelbuilder.controller.OpenLevelEditorController;
import scandium.levelbuilder.controller.SelectLevelController;
import scandium.levelbuilder.controller.SpecifyLevelTypeController;
import scandium.levelbuilder.controller.ToggleEnableController;
import scandium.levelbuilder.model.LevelBuilderState;
import scandium.levelbuilder.model.Model;

public class Application extends JFrame{

	/* Serial ID                                                                                 */
	private static final long serialVersionUID = -7300085623783459664L;

	/* Game Window Width and Height                                                              */
	private static final int WIDTH = 1280;
	private static final int HEIGHT = 720;

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
	 * Creates a new LevelBuilder application window without a model.
	 */
	public Application(){
		initializeView();
		initializeControllers();
	}

	/**
	 * Creates a new LetterCraze application window with a model.
	 * @param model The LevelBuilder Model
	 */
	public Application(Model model){
		this.model = model;
		initializeView();
		initializeControllers();
	}

	/**
	 * Initializes the LevelBuilder View
	 */
	void initializeView(){
		this.main_menu = new MainMenuView(model);
		this.level_editor = new LevelEditorView(model);
		this.splash_screen = new SplashScreenView();
		/* Add both panels to the view                                                           */ 
		getContentPane().add(main_menu);
		getContentPane().add(level_editor);
		getContentPane().add(splash_screen);
		/* Set both to invisible                                                                 */
		main_menu.setVisible(false);
		level_editor.setVisible(false);
		splash_screen.setVisible(true);
		/* Maintenance of JFrame                                                                 */
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setVisible(true);
		setSize(WIDTH, HEIGHT);
		pack();
	}

	/**
	 * Initializes the LevelBuilder Controllers
	 */
	private void initializeControllers() {
		/* Initialize controllers for entering and leaving level editor*/
		main_menu.getNewLevelButton().addMouseListener(new CreateNewLevelController(model,this));
//		main_menu.getDeleteLevelButton().addMouseListener(new DeleteLevelController(model,this));
		main_menu.getEditLevelButton().addMouseListener(new OpenLevelEditorController(model,this));
			
		/* Initialize controllers for SpecifyLevelType*/
		level_editor.getPuzzleLevelButton().addActionListener(new SpecifyLevelTypeController(model,this));
		level_editor.getLightningLevelButton().addActionListener(new SpecifyLevelTypeController(model,this));
		level_editor.getThemeLevelButton().addActionListener(new SpecifyLevelTypeController(model, this));
//		
//		/* Initialize controllers for level editor buttons*/
//		level_editor.getSaveButton().addActionListener(new SaveLevelController(model,this));
		level_editor.getMainMenuButton().addMouseListener(new LeaveLevelEditorController(model,this));
		level_editor.getGenerateButton().addMouseListener(new GenerateBoardArrangementController(model,this));
		
		/* Initialize controllers for the 'board squares' */
		for(int i = 0; i < 6; i++){
			for(int j = 0; j < 6; j++){
				level_editor.getBoardView().getJLabel(i, j).addMouseListener(new ToggleEnableController(model, this, i, j));
			}
		}
		
		/* Initialize Controllers for Main Menu Level Icons */
		for(LevelIconView liv : main_menu.getLevelIcons()){
			liv.addMouseListener(new SelectLevelController(model, this, liv.getLevel()));
		}
	}

	/* ~~~~~                                                                               ~~~~~ *
	 * Getter Methods                                                                            *
	 * ~~~~~                                                                               ~~~~~ */

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

	public Model getModel(){
		return this.model;
	}

	/* ~~~~~                                                                               ~~~~~ *
	 * GUI Logic for Controllers                                                                 *
	 * ~~~~~                                                                               ~~~~~ */

	/**
	 * This function sets the application view to display the Main Menu View
	 */
	public void setViewMainMenu(){
		level_editor.setVisible(false);
		splash_screen.setVisible(false);
		main_menu.setVisible(true);
	}

	/** 
	 * This function set the application view to display the Level Editor
	 */
	public void setViewLevelEditor(){
		main_menu.setVisible(false);
		splash_screen.setVisible(false);
		level_editor.setVisible(true);
	}

	/** 
	 * This function refreshes the entire levelBuilder application.
	 */
	public void refresh() {
		if(model.getLevelBuilderState().equals(LevelBuilderState.MainMenu)){ //MainMenu
			level_editor.setVisible(false);
			main_menu.setVisible(true);
			main_menu.refresh();
		}else{ //LevelEditor
			level_editor.setVisible(true);
			main_menu.setVisible(false);
			level_editor.refresh();
		}
		
	}

}