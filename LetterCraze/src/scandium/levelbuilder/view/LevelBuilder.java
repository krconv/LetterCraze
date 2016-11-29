/* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ *
 * ~~~~~ Team Scandium                                                                           *
 * ~~~~~ CS 3733                                                                                 *
 * ~~~~~ Project: Level Builder                                                                  *
 * ~~~~~ Created: November 22nd - Jeff Martin                                                    *
 * ~~~~~ Class: LevelBuilder                                                                     *
 * ~~~~~        This class represents the Level Builder applications. It stores the Main Menu    *
 * ~~~~~        and Level editor panels. It contains an initialize methods for the views,        *
 * ~~~~~        model, and controllers. It contains a main function to run the Level Builder     *
 * ~~~~~        application.                                                                     *
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
package scandium.levelbuilder.view;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class LevelBuilder extends JFrame{

	/* Serial ID                                                                                 */
	private static final long serialVersionUID = -7300085623783459664L;
	
	/* Game Window Width and Height                                                              */
	private static final int WIDTH = 1280;
	private static final int HEIGHT = 720;

	/* ~~~~~                                                                               ~~~~~ *
	 * Class Attributes                                                                          *
	 * ~~~~~                                                                               ~~~~~ */
	MainMenuView main_menu;
	LevelEditorView level_editor;
	JPanel active_panel;
	
	/**~~~~~                                                                               ~~~~~ *
	 * Constructor Method                                                                        *
	 * ~~~~~                                                                               ~~~~~ */
	public LevelBuilder(){
		this.main_menu = new MainMenuView();
		this.level_editor = new LevelEditorView();
		this.active_panel = main_menu;
	}
	
	/**~~~~~                                                                               ~~~~~ *
	 * initialize()                                                                              *
	 * ~~~~~                                                                               ~~~~~ */
	public void initialize(){
		/* Initialize the Main Menu and Level Editor                                             */
		main_menu.initialize();
		level_editor.initialize();
		/* Add both panels to the view                                                           */ 
		getContentPane().add(main_menu);
		getContentPane().add(level_editor);
		/* Specify the size of each of the panels                                                */
		main_menu.setBounds(0,0,WIDTH,HEIGHT);
		level_editor.setBounds(0,0,WIDTH,HEIGHT);
		/* Set both to invisible                                                                 */
		main_menu.setVisible(false);
		level_editor.setVisible(false);
		/* Set the active panel to visible                                                       */
		active_panel.setVisible(true);
		
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setVisible(true);
		pack();
	}

	
	/**~~~~~                                                                               ~~~~~ *
	 * getMainMenu()                                                                             *
	 * @return MainMenu                                                                          *
	 * This function returns the Main Menu for levelBuilder                                      *
	 * ~~~~~                                                                               ~~~~~ */
	public MainMenuView getMainMenu(){
		return main_menu;
	}
	
	/**~~~~~                                                                               ~~~~~ *
	 * getLevelEditor()                                                                          *
	 * @return MainMenu                                                                          *
	 * This function returns the levelEditor for levelBuilder                                    *
	 * ~~~~~                                                                               ~~~~~ */
	public LevelEditorView getLevelEditor(){
		return level_editor;
	}
	
	/**~~~~~                                                                               ~~~~~ *
	 * getActivePanel()                                                                          *
	 * @return JPanel                                                                            *
	 * This function returns the active panel (either main_menu or level_editor) for levelBuilder*
	 * ~~~~~                                                                               ~~~~~ */
	public JPanel getActivePanel(){
		return active_panel;
	}
	
	/**~~~~~                                                                               ~~~~~ *
	 * setViewMainMenu()                                                                         *
	 * ~~~~~                                                                               ~~~~~ */
	public void setViewMainMenu(){
		active_panel.setVisible(false);
		active_panel = main_menu;
		active_panel.setVisible(true);
	}
	
	/**~~~~~                                                                               ~~~~~ *
	 * setViewLevelEditor()                                                                      *
	 * ~~~~~                                                                               ~~~~~ */
	public void setViewLevelEditor(){
		active_panel.setVisible(false);
		active_panel = level_editor;
		active_panel.setVisible(true);
	}
	
	
	/**~~~~~                                                                               ~~~~~ *
	 * Main Method                                                                               *
	 * ~~~~~                                                                               ~~~~~ */
	public static void main(String[] args){
		/* Create LevelBuilder */
		LevelBuilder level_builder = new LevelBuilder();
		/* Initialize LevelBuilder */
		level_builder.initialize();
		
		/* Simple Script to show both Windows and some 'functionality' */
		try{
			Thread.sleep(5000);
			/* Switch to level Editor */
			level_builder.active_panel.setVisible(false);
			level_builder.active_panel = level_builder.level_editor;
			level_builder.active_panel.setVisible(true);
			Thread.sleep(2000);
			/* Disable Some random Squares */
			level_builder.level_editor.board_view.getBoardSquares()[1][1].setVisible(false);
			Thread.sleep(500);
			level_builder.level_editor.board_view.getBoardSquares()[2][2].setVisible(false);
			Thread.sleep(500);
			level_builder.level_editor.board_view.getBoardSquares()[3][3].setVisible(false);
			Thread.sleep(500);
			level_builder.level_editor.board_view.getBoardSquares()[4][4].setVisible(false);
			Thread.sleep(500);
			/* Fill some random letters */
			level_builder.level_editor.board_view.getBoardSquares()[1][2].setText("J");
			Thread.sleep(500);
			level_builder.level_editor.board_view.getBoardSquares()[1][3].setText("E");
			Thread.sleep(500);
			level_builder.level_editor.board_view.getBoardSquares()[1][4].setText("F");
			Thread.sleep(500);
			level_builder.level_editor.board_view.getBoardSquares()[1][5].setText("F");
			Thread.sleep(500);
			/* Re-enable the 2 of the squares */ 
			level_builder.level_editor.board_view.getBoardSquares()[1][1].setVisible(true);
			Thread.sleep(500);
			level_builder.level_editor.board_view.getBoardSquares()[2][2].setVisible(true);
			Thread.sleep(500);
			/* Show Puzzle Level Attributes */
			level_builder.level_editor.level_specific_label.setVisible(true);
			level_builder.level_editor.puzzle_max_num_words_label.setVisible(true);
			level_builder.level_editor.puzzle_max_num_words_textfield.setVisible(true);
			Thread.sleep(3000);
			/* Show Lightning Level Attributes */
			level_builder.level_editor.puzzle_max_num_words_label.setVisible(false);
			level_builder.level_editor.puzzle_max_num_words_textfield.setVisible(false);
			level_builder.level_editor.lightning_time_limit_label.setVisible(true);
			level_builder.level_editor.lightning_time_limit_textfield.setVisible(true);
			Thread.sleep(3000);
			/* Show Theme Level Attributes */
			level_builder.level_editor.lightning_time_limit_label.setVisible(false);
			level_builder.level_editor.lightning_time_limit_textfield.setVisible(false);
			level_builder.level_editor.theme_name_label.setVisible(true);
			level_builder.level_editor.theme_name_textfield.setVisible(true);
			level_builder.level_editor.theme_words_label.setVisible(true);
			level_builder.level_editor.theme_words_textarea.setVisible(true);
			Thread.sleep(3000);
			/* Burn Kodey */
			level_builder.level_editor.title_label.setText("Google Docs >> Microsoft Word");
			
			
		}catch(Exception e){
			System.out.println("Well, shit.");
		}
		
	}
	
}
