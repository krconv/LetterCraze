/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ *
 * ~~~~~ Team Scandium                                                                           *
 * ~~~~~ CS 3733                                                                                 *
 * ~~~~~ Project: Level Builder                                                                  *
 * ~~~~~ Created: November 22nd - Jeff Martin                                                    *
 * ~~~~~ Class: LevelEditor                                                                      *
 * ~~~~~        This class displays Level Editing Window for the Level Builder. It allows the    *
 * ~~~~~        controllers to easily access all of the Buttons, Labels, and Textfields          *
 * ~~~~         within the window.                                                               *
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
package scandium.levelbuilder.view;

import java.awt.Font;
import java.awt.TextArea;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import scandium.common.view.BoardView;

public class LevelEditorView extends JPanel{
	
	/* Serial ID                                                                                 */
	private static final long serialVersionUID = -6718767832989688466L;
	
	/* ~~~~~                                                                               ~~~~~ *
	 * Class Attributes                                                                          *
	 * ~~~~~                                                                               ~~~~~ */
	JLabel title_label;
	JLabel level_name_label;
	JLabel thresholds_title_label;
	JLabel one_star_label;
	JLabel two_star_label;
	JLabel three_star_label;
	JLabel one_star_unit_label;
	JLabel two_star_unit_label;
	JLabel three_star_unit_label;
	JLabel gravity_label;
	JLabel level_specific_label;
	JLabel puzzle_max_num_words_label;
	JLabel lightning_time_limit_label;
	JLabel theme_name_label;
	JLabel theme_words_label;
	
	JTextField level_name_textfield;
	JTextField one_star_textfield;
	JTextField two_star_textfield;
	JTextField three_star_textfield;
	JTextField puzzle_max_num_words_textfield;
	JTextField lightning_time_limit_textfield;
	JTextField theme_name_textfield;
	TextArea theme_words_textarea;
	
	JButton save_button;
	JButton generate_button;
	JButton main_menu_button;
	
	JRadioButton puzzle_level_button;
	JRadioButton lightning_level_button;
	JRadioButton theme_level_button;
	JRadioButton gravity_up_button;
	JRadioButton gravity_down_button;
	JRadioButton gravity_left_button;
	JRadioButton gravity_right_button;
	
	ButtonGroup level_type_group;
	ButtonGroup gravity_group;
	
	BoardView board_view;
	
	/**~~~~~                                                                               ~~~~~ *
	 * Constructor Method                                                                        *
	 * ~~~~~                                                                               ~~~~~ */
	public LevelEditorView() {
		this.title_label = new JLabel("LevelBuilder: LevelEditor");
		this.level_name_label = new JLabel("Level Name:");
		this.thresholds_title_label = new JLabel("Enter Thresholds:");
		this.one_star_label = new JLabel("1 Star:");
		this.two_star_label = new JLabel("2 Star:");
		this.three_star_label = new JLabel("3 Star");
		this.one_star_unit_label = new JLabel("units");
		this.two_star_unit_label = new JLabel("units");
		this.three_star_unit_label = new JLabel("units");
		this.gravity_label = new JLabel("Select Gravity Direction");
		this.level_specific_label = new JLabel("Level Specific Fields");
		this.puzzle_max_num_words_label = new JLabel("Maximum Number of Words:");
		this.lightning_time_limit_label = new JLabel("Time Limit:");
		this.theme_name_label = new JLabel("Theme Name:");
		this.theme_words_label = new JLabel("Theme Words:");
		
		this.level_name_textfield = new JTextField();
		this.one_star_textfield = new JTextField();
		this.two_star_textfield = new JTextField();
		this.three_star_textfield = new JTextField();
		this.puzzle_max_num_words_textfield = new JTextField();
		this.lightning_time_limit_textfield = new JTextField();
		this.theme_name_textfield = new JTextField();
		this.theme_words_textarea = new TextArea();
		
		this.save_button = new JButton("Save Level");
		this.generate_button = new JButton("Generate Tiles");
		this.main_menu_button = new JButton("Main Menu");
		
		this.puzzle_level_button = new JRadioButton("Puzzle Level");
		this.lightning_level_button = new JRadioButton("Lightning Level");
		this.theme_level_button = new JRadioButton("Theme Level");
		
		this.gravity_up_button = new JRadioButton("Up");
		this.gravity_down_button = new JRadioButton("Down");
		this.gravity_left_button = new JRadioButton("Left");
		this.gravity_right_button = new JRadioButton("Right");
		
		this.level_type_group = new ButtonGroup();
		this.gravity_group = new ButtonGroup();
		
		this.board_view = new BoardView();
		
		
	}
	
	/**~~~~~                                                                               ~~~~~ *
	 * initialize()                                                                              *
	 * ~~~~~                                                                               ~~~~~ */
	public void initialize(){

		/* Initialize Title Label                                                                */
		title_label.setBounds(10, 10, 1280, 40);
		title_label.setFont(new Font(title_label.getFont().getName(), Font.BOLD, 36));
		add(title_label);
		/* Initialize Level Name Label                                                           */
		level_name_label.setBounds(900, 20, 100, 30);
		add(level_name_label);
		/* Initialize Threshold Title Label                                                      */
		thresholds_title_label.setBounds(900, 100, 250, 30);
		add(thresholds_title_label);
		/* Initialize Star Labels                                                                */
		one_star_label.setBounds(950, 150, 75, 30);
		add(one_star_label);
		two_star_label.setBounds(950, 200, 75, 30);
		add(two_star_label);
		three_star_label.setBounds(950, 250, 75, 30);
		add(three_star_label);
		/* Initialize Star Unit Labels                                                           */
		one_star_unit_label.setBounds(1100, 150, 100, 30);
		add(one_star_unit_label);
		two_star_unit_label.setBounds(1100, 200, 100, 30);
		add(two_star_unit_label);
		three_star_unit_label.setBounds(1100, 250, 100, 30);
		add(three_star_unit_label);
		/* Initialize Gravity Direction Label                                                    */
		gravity_label.setBounds(600, 130, 200, 30);
		add(gravity_label);
		/* Initialize Level Specific Label                                                       */
		level_specific_label.setBounds(900, 350, 250, 30);
		add(level_specific_label);
		level_specific_label.setVisible(false);
		/* Initialize Puzzle Max Num Words Label                                                 */
		puzzle_max_num_words_label.setBounds(950, 400, 200, 30);
		add(puzzle_max_num_words_label);
		puzzle_max_num_words_label.setVisible(false);
		/* Initialize Lightning Time Limit Label                                                 */
		lightning_time_limit_label.setBounds(950, 400, 100, 30);
		add(lightning_time_limit_label);
		lightning_time_limit_label.setVisible(false);
		/* Initialize Theme Name Label                                                           */
		theme_name_label.setBounds(950, 400, 125, 30);
		add(theme_name_label);
		theme_name_label.setVisible(false);
		/* Initialize Theme Words Label                                                          */
		theme_words_label.setBounds(950, 450, 125, 30);
		add(theme_words_label);
		theme_words_label.setVisible(false);
		
		/* Initialize Level name TextField                                                       */
		level_name_textfield.setBounds(1000, 20, 250, 30);
		add(level_name_textfield);
		/* Initialize One Star TextField                                                         */
		one_star_textfield.setBounds(1025, 150, 50, 30);
		add(one_star_textfield); 
		/* Initialize Two Star TextField                                                         */
		two_star_textfield.setBounds(1025, 200, 50, 30);
		add(two_star_textfield);
		/* Initialize Three Star TextField                                                       */
		three_star_textfield.setBounds(1025, 250, 50, 30);
		add(three_star_textfield);
		/* Initialize Puzzle Max Num Words TextField                                             */
		puzzle_max_num_words_textfield.setBounds(1150, 400, 50, 30);
		add(puzzle_max_num_words_textfield);
		puzzle_max_num_words_textfield.setVisible(false);
		/* Initialize Lightning time limit TextField                                             */
		lightning_time_limit_textfield.setBounds(1050, 400, 50, 30);
		add(lightning_time_limit_textfield);
		lightning_time_limit_textfield.setVisible(false);
		/* Initialize Theme Name TextField                                                       */
		theme_name_textfield.setBounds(1075, 400, 150, 30);
		add(theme_name_textfield);
		theme_name_textfield.setVisible(false);
		/* Initialize Theme Words TextField                                                      */
		theme_words_textarea.setBounds(1075, 450, 150, 200);
		add(theme_words_textarea);
		theme_words_textarea.setVisible(false);
		
		/* Initialize Save Level Button                                                          */
		save_button.setBounds(600, 450, 150, 50);
		add(save_button);
		/* Initialize Generate Tiles Button                                                      */
		generate_button.setBounds(600, 525, 150, 50);
		add(generate_button);
		/* Initialize Main Menu Button                                                           */
		main_menu_button.setBounds(600, 600, 150, 50);
		add(main_menu_button);
		
		/* Initialize Puzzle Level Button                                                        */
		puzzle_level_button.setBounds(10, 75, 150, 50);
		add(puzzle_level_button);
		/* Initialize Lightning Level Button                                                     */
		lightning_level_button.setBounds(180, 75, 150, 50);
		add(lightning_level_button);
		/* Initialize Theme Level Button                                                         */
		theme_level_button.setBounds(350, 75, 150, 50);
		add(theme_level_button);
		/* Initialize Gravity Buttons                                                            */
		gravity_up_button.setBounds(650,180,100,30);
		add(gravity_up_button);
		gravity_down_button.setBounds(650,350,100,30);
		add(gravity_down_button);
		gravity_left_button.setBounds(575,265,100,30);
		add(gravity_left_button);
		gravity_right_button.setBounds(715,265,100,30);
		add(gravity_right_button);
		
		/* Initialize Level Type Button Group                                                    */
		level_type_group.add(puzzle_level_button);
		level_type_group.add(lightning_level_button);
		level_type_group.add(theme_level_button);
		/* Initialize Gravity Button Group                                                       */
		gravity_group.add(gravity_down_button);
		gravity_group.add(gravity_up_button);
		gravity_group.add(gravity_left_button);
		gravity_group.add(gravity_right_button);
		
		/* Initialize BoardView                                                                  */
		board_view.setBounds(10, 130, 540, 540);
		board_view.initialize();
		add(board_view);
		
		
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
	 * getLevelNameLabel()                                                                       *
	 * @return JLabel                                                                            *
	 * This function returns the JLabel representing the Level Name label                        *
	 * ~~~~~                                                                               ~~~~~ */
	public JLabel getLevelNameLabel(){
		return level_name_label;
	}
	
	/**~~~~~                                                                               ~~~~~ *
	 * getThresholdsTitleLabel()                                                                 *
	 * @return JLabel                                                                            *
	 * This function returns the JLabel representing the Threshold Label                         *
	 * ~~~~~                                                                               ~~~~~ */
	public JLabel getThresholdsTitleLabel(){
		return thresholds_title_label;
	}
	
	/**~~~~~                                                                               ~~~~~ *
	 * getOneStarLabel()                                                                         *
	 * @return JLabel                                                                            *
	 * This function returns the JLabel representing the one star Label                          *
	 * ~~~~~                                                                               ~~~~~ */
	public JLabel getOneStarLabel(){
		return one_star_label;
	}
	
	/**~~~~~                                                                               ~~~~~ *
	 * getTwoStarLabel()                                                                         *
	 * @return JLabel                                                                            *
	 * This function returns the JLabel representing the Two star Label                          *
	 * ~~~~~                                                                               ~~~~~ */
	public JLabel getTwoStarLabel(){
		return two_star_label;
	}
	
	/**~~~~~                                                                               ~~~~~ *
	 * getThreeStarLabel()                                                                       *
	 * @return JLabel                                                                            *
	 * This function returns the JLabel representing the three star Label                        *
	 * ~~~~~                                                                               ~~~~~ */
	public JLabel getThreeStarLabel(){
		return three_star_label;
	}
	
	/**~~~~~                                                                               ~~~~~ *
	 * getOneStarUnitLabel()                                                                     *
	 * @return JLabel                                                                            *
	 * This function returns the JLabel representing the one star unit Label                     *
	 * ~~~~~                                                                               ~~~~~ */
	public JLabel getOneStarUnitLabel(){
		return one_star_unit_label;
	}
	
	/**~~~~~                                                                               ~~~~~ *
	 * getTwoStarUnitLabel()                                                                     *
	 * @return JLabel                                                                            *
	 * This function returns the JLabel representing the two star unit Label                     *
	 * ~~~~~                                                                               ~~~~~ */
	public JLabel getTwoStarUnitLabel(){
		return two_star_unit_label;
	}
	
	/**~~~~~                                                                               ~~~~~ *
	 * getThreeStarUnitLabel()                                                                   *
	 * @return JLabel                                                                            *
	 * This function returns the JLabel representing the three star unit Label                   *
	 * ~~~~~                                                                               ~~~~~ */
	public JLabel getThreeStarUnitLabel(){
		return three_star_unit_label;
	}
	
	/**~~~~~                                                                               ~~~~~ *
	 * getGravityLabel()                                                                         *
	 * @return JLabel                                                                            *
	 * This function returns the JLabel representing the gravity Label                           *
	 * ~~~~~                                                                               ~~~~~ */
	public JLabel getGravityLabel(){
		return gravity_label;
	}
	
	/**~~~~~                                                                               ~~~~~ *
	 * getLevelSpecificLabel()                                                                   *
	 * @return JLabel                                                                            *
	 * This function returns the JLabel representing the Level Specific Label                    *
	 * ~~~~~                                                                               ~~~~~ */
	public JLabel getLevelSpecificLabel(){
		return level_specific_label;
	}
	
	/**~~~~~                                                                               ~~~~~ *
	 * getPuzzleMaxNumWordsLabel()                                                               *
	 * @return JLabel                                                                            *
	 * This function returns the JLabel representing the Puzzle Level's Max Num of Words label   *
	 * ~~~~~                                                                               ~~~~~ */
	public JLabel getPuzzleMaxNumWordsLabel(){
		return puzzle_max_num_words_label;
	}
	
	/**~~~~~                                                                               ~~~~~ *
	 * getLightningTimeLimitLabel()                                                              *
	 * @return JLabel                                                                            *
	 * This function returns the JLabel representing the Lightning Level's Time Limit Label      *
	 * ~~~~~                                                                               ~~~~~ */
	public JLabel getLightningTimeLimitLabel(){
		return lightning_time_limit_label;
	}
	
	/**~~~~~                                                                               ~~~~~ *
	 * getThemeNameLabel()                                                                       *
	 * @return JLabel                                                                            *
	 * This function returns the JLabel representing the Theme Level's Theme name label          *
	 * ~~~~~                                                                               ~~~~~ */
	public JLabel getThemeNameLabel(){
		return theme_name_label;
	}
	
	/**~~~~~                                                                               ~~~~~ *
	 * getThemeWordsLabel()                                                                      *
	 * @return JLabel                                                                            *
	 * This function returns the JLabel representing the Theme Level's Theme words label         *
	 * ~~~~~                                                                               ~~~~~ */
	public JLabel getThemeWordsLabel(){
		return theme_words_label;
	}
	
	/**~~~~~                                                                               ~~~~~ *
	 * getLevelNameTextField()                                                                   *
	 * @return JTextField                                                                        *
	 * This function returns the JTextField that stores the user's entered level name            *
	 * ~~~~~                                                                               ~~~~~ */
	public JTextField getLevelNameTextField(){
		return level_name_textfield;
	}
	
	/**~~~~~                                                                               ~~~~~ *
	 * getOneStarTextField()                                                                     *
	 * @return JTextField                                                                        *
	 * This function returns the JTextField that stores the user's entered value for the 1 star  *
	 * ~~~~~                                                                               ~~~~~ */
	public JTextField getOneStarTextField(){
		return one_star_textfield;
	}
	
	/**~~~~~                                                                               ~~~~~ *
	 * getTwoStarTextField()                                                                     *
	 * @return JTextField                                                                        *
	 * This function returns the JTextField that stores the user's entered value for the 2 star  *
	 * ~~~~~                                                                               ~~~~~ */
	public JTextField getTwoStarTextField(){
		return two_star_textfield;
	}
	
	/**~~~~~                                                                               ~~~~~ *
	 * getThreeStarTextField()                                                                   *
	 * @return JTextField                                                                        *
	 * This function returns the JTextField that stores the user's entered value for the 3 star  *
	 * ~~~~~                                                                               ~~~~~ */
	public JTextField getThreeStarTextField(){
		return three_star_textfield;
	}
	
	/**~~~~~                                                                               ~~~~~ *
	 * getPuzzleMaxNumWordsTextField()                                                           *
	 * @return JTextField                                                                        *
	 * This function returns the JTextField that stores the user's entered value for puzzle      *
	 * levels maximum number of words.                                                           *
	 * ~~~~~                                                                               ~~~~~ */
	public JTextField getPuzzleMaxNumWordsTextField(){
		return puzzle_max_num_words_textfield;
	}
	
	/**~~~~~                                                                               ~~~~~ *
	 * getThemeNameTextField()                                                                   *
	 * @return JTextField                                                                        *
	 * This function returns the JTextField that stores the user's entered value for theme       *
	 * levels theme name.                                                                        *
	 * ~~~~~                                                                               ~~~~~ */
	public JTextField getThemeNameTextField(){
		return theme_name_textfield;
	}
	
	/**~~~~~                                                                               ~~~~~ *
	 * getThemeNameTextArea()                                                                    *
	 * @return TextArea                                                                          *
	 * This function returns the TextArea that stores the user's entered value for theme         *
	 * levels theme words                                                                        *
	 * ~~~~~                                                                               ~~~~~ */
	public TextArea getThemeWordsTextArea(){
		return theme_words_textarea;
	}
	
	/**~~~~~                                                                               ~~~~~ *
	 * getSaveButton()                                                                           *
	 * @return JButton                                                                           *
	 * This function returns the JButton that is used to save the current level.                 *
	 * ~~~~~                                                                               ~~~~~ */
	public JButton getSaveButton(){
		return save_button;
	}
	
	/**~~~~~                                                                               ~~~~~ *
	 * getGenerateButton()                                                                       *
	 * @return JButton                                                                           *
	 * This function returns the JButton that is used to Generate tiles on the board.            *
	 * ~~~~~                                                                               ~~~~~ */
	public JButton getGenerateButton(){
		return generate_button;
	}
	
	/**~~~~~                                                                               ~~~~~ *
	 * getMainMenuButton()                                                                       *
	 * @return JButton                                                                           *
	 * This function returns the JButton that is used to return to the main menu.                *
	 * ~~~~~                                                                               ~~~~~ */
	public JButton getMainMenuButton(){
		return main_menu_button;
	}
	
	/**~~~~~                                                                               ~~~~~ *
	 * getPuzzleLevelButton()                                                                    *
	 * @return JRadioButton                                                                      *
	 * This function returns the JRadioButton that is used to specify that this level is a       *
	 * puzzle level.                                                                             *
	 * ~~~~~                                                                               ~~~~~ */
	public JRadioButton getPuzzleLevelButton(){
		return puzzle_level_button;
	}
	
	/**~~~~~                                                                               ~~~~~ *
	 * getLightningLevelButton()                                                                 *
	 * @return JRadioButton                                                                      *
	 * This function returns the JRadioButton that is used to specify that this level is a       *
	 * lightning level.                                                                          *
	 * ~~~~~                                                                               ~~~~~ */
	public JRadioButton getLightningLevelButton(){
		return lightning_level_button;
	}
	
	/**~~~~~                                                                               ~~~~~ *
	 * getThemeLevelButton()                                                                     *
	 * @return JRadioButton                                                                      *
	 * This function returns the JRadioButton that is used to specify that this level is a       *
	 * theme level.                                                                              *
	 * ~~~~~                                                                               ~~~~~ */
	public JRadioButton getThemeLevelButton(){
		return theme_level_button;
	}
	
	/**~~~~~                                                                               ~~~~~ *
	 * getGravityUpButton()                                                                      *
	 * @return JRadioButton                                                                      *
	 * This function returns the JRadioButton that is used to specify that the direction of      *
	 * gravity is up.                                                                            *
	 * ~~~~~                                                                               ~~~~~ */
	public JRadioButton getGravityUpButton(){
		return gravity_up_button;
	}
	
	/**~~~~~                                                                               ~~~~~ *
	 * getGravityDownButton()                                                                    *
	 * @return JRadioButton                                                                      *
	 * This function returns the JRadioButton that is used to specify that the direction of      *
	 * gravity is down.                                                                          *
	 * ~~~~~                                                                               ~~~~~ */
	public JRadioButton getGravityDownButton(){
		return gravity_down_button;
	}
	
	/**~~~~~                                                                               ~~~~~ *
	 * getGravityLeftButton()                                                                    *
	 * @return JRadioButton                                                                      *
	 * This function returns the JRadioButton that is used to specify that the direction of      *
	 * gravity is Left.                                                                          *
	 * ~~~~~                                                                               ~~~~~ */
	public JRadioButton getGravityLeftButton(){
		return gravity_left_button;
	}
	
	/**~~~~~                                                                               ~~~~~ *
	 * getGravityRightButton()                                                                   *
	 * @return JRadioButton                                                                      *
	 * This function returns the JRadioButton that is used to specify that the direction of      *
	 * gravity is Right.                                                                         *
	 * ~~~~~                                                                               ~~~~~ */
	public JRadioButton getGravityRightButton(){
		return gravity_right_button;
	}
	
	/**~~~~~                                                                               ~~~~~ *
	 * getLevelTypeGroup()                                                                       *
	 * @return ButtonGroup                                                                       *
	 * This function returns the Button Group representing the puzzle level, lightning level,    *
	 * and theme level buttons                                                                   *
	 * ~~~~~                                                                               ~~~~~ */
	public ButtonGroup getLevelTypeGroup(){
		return level_type_group;
	}
	
	/**~~~~~                                                                               ~~~~~ *
	 * getGravityGroup()                                                                         *
	 * @return ButtonGroup                                                                       *
	 * This function returns the Button Group representing the up, down, left, and right gravity *
	 * buttons                                                                                   *
	 * ~~~~~                                                                               ~~~~~ */
	public ButtonGroup getGravityGroup(){
		return level_type_group;
	}
	
	/**~~~~~                                                                               ~~~~~ *
	 * getBoardView()                                                                            *
	 * @return BoardView                                                                         *
	 * This function returns the Board View containing all the board squares                     *
	 * ~~~~~                                                                               ~~~~~ */
	public BoardView getBoardView(){
		return board_view;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

