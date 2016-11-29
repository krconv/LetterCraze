/* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ *
 * ~~~~~ Team Scandium                                                                           *
 * ~~~~~ CS 3733                                                                                 *
 * ~~~~~ Project: Level Builder                                                                  *
 * ~~~~~ Created: November 22nd - Jeff Martin                                                    *
 * ~~~~~ Class: MainMenu                                                                      *
 * ~~~~~        This class displays the Main Menu for the Level Builder. It allows the           *
 * ~~~~~        controllers to easily access all of the Buttons, Labels, and Textfields          *
 * ~~~~         within the window.                                                               *
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
package scandium.levelbuilder.view;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainMenuView extends JPanel{
	
	/* Serial ID                                                                                 */
	private static final long serialVersionUID = -6718767832989688466L;
	
	/* ~~~~~                                                                               ~~~~~ *
	 * Class Attributes                                                                          *
	 * ~~~~~                                                                               ~~~~~ */
	JLabel title_label;
	JButton new_level_button;
	JButton edit_level_button;
	JButton delete_level_button;
	
	/**~~~~~                                                                               ~~~~~ *
	 * Constructor Method                                                                        *
	 * ~~~~~                                                                               ~~~~~ */
	public MainMenuView() {
		this.title_label = new JLabel("LevelBuilder: MainMenu");
		this.new_level_button = new JButton("New Level");
		this.edit_level_button = new JButton("Edit Level");
		this.delete_level_button = new JButton("Delete Level");
	}
	
	/**~~~~~                                                                               ~~~~~ *
	 * initialize()                                                                              *
	 * ~~~~~                                                                               ~~~~~ */
	public void initialize(){

		/* Initialize Title Label                                                                */
		title_label.setBounds(10, 10, 1280, 40);
		title_label.setFont(new Font(title_label.getFont().getName(), Font.BOLD, 36));
		add(title_label);
		/* Initialize Create New Level Button                                                    */
		new_level_button.setBounds(1000, 100, 125, 50);
		add(new_level_button);
		/* Initialize Edit Level Button                                                          */
		edit_level_button.setBounds(1000, 200,  125, 50);
		add(edit_level_button);
		/* Initialize Delete Level Button                                                        */
		delete_level_button.setBounds(1000,  300,  125,  50);
		add(delete_level_button);
		
		/* Remove all layout management from the JPanel */
		setLayout(null);
		
	}
	
	/**~~~~~                                                                               ~~~~~ *
	 * getTitleLabel()                                                                           *
	 * @return JLabel                                                                            *
	 * This function returns the JLabel representing the Title                                   *
	 * ~~~~~                                                                               ~~~~~ */
	public JLabel getTitleLabel(){
		return title_label;
	}
	
	/**~~~~~                                                                               ~~~~~ *
	 * getNewLevelButton()                                                                       *
	 * @return JButton                                                                           *
	 * This function returns the JButton that is used to create a new level.                     *
	 * ~~~~~                                                                               ~~~~~ */
	public JButton getNewLevelButton(){
		return new_level_button;
	}
	
	/**~~~~~                                                                               ~~~~~ *
	 * getEditLevelButton()                                                                      *
	 * @return JButton                                                                           *
	 * This function returns the JButton that is used to edit a selected level.                  *
	 * ~~~~~                                                                               ~~~~~ */
	public JButton getEditLevelButton(){
		return edit_level_button;
	}
	
	/**~~~~~                                                                               ~~~~~ *
	 * getDeleteLevelButton()                                                                    *
	 * @return JButton                                                                           *
	 * This function returns the JButton that is used to delete a selected level.                *
	 * ~~~~~                                                                               ~~~~~ */
	public JButton getDeleteLevelButton(){
		return delete_level_button;
	}

}
