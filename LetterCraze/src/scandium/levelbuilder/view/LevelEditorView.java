/**
 * LevelEditorView.java
 * 
 * @author Scandium
 * Date: 11/22/2016
 * Description: This class represents the level editor View/GUI. It allows the controllers to 
 * easily access all of the buttons, labels, and textfields within the window.
 */
package scandium.levelbuilder.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.TextArea;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import scandium.common.model.Level;
import scandium.common.model.PuzzleLevel;
import scandium.common.model.LightningLevel;
import scandium.common.model.ThemeLevel;
import scandium.common.view.BoardView;
import scandium.levelbuilder.model.EditProgress;
import scandium.levelbuilder.model.Model;

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

	Model model;
	EditProgress editProgress;

	String currentView;

	/* ~~~~~                                                                               ~~~~~ *
	 * Constructors And Initialization                                                           *
	 * ~~~~~                                                                               ~~~~~ */

	/**
	 * Creates a new LevelEditorView based upon the given Model.
	 * @param m the Model to be associated with this Level Editor View
	 */
	public LevelEditorView(Model m) {
		this.model = m;
		initialize();
	}

	/**
	 * This function initializes the view/GUI of the Level Editor View
	 */
	void initialize(){
		instantiateAttributes();
		initializeAttributes();

		/* Manage JPanel                                                                         */
		setLayout(null);
		setBounds(0,0,1280, 720);
	}

	/**
	 * This function instantiates copies of all of the class attributes.
	 */
	void instantiateAttributes(){
		//instantiates all labels for the level Editor view
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

		//instantiates all of the TextFields for the level Editor View
		this.level_name_textfield = new JTextField();
		this.one_star_textfield = new JTextField();
		this.two_star_textfield = new JTextField();
		this.three_star_textfield = new JTextField();
		this.puzzle_max_num_words_textfield = new JTextField();
		this.lightning_time_limit_textfield = new JTextField();
		this.theme_name_textfield = new JTextField();
		this.theme_words_textarea = new TextArea();

		//instantiates all Buttons for the level Editor View
		this.save_button = new JButton("Save Level");
		this.generate_button = new JButton("Generate Tiles");
		this.main_menu_button = new JButton("Main Menu");

		//instantiates all RadioButtons and RadioButtonGroups for the level Editor View
		this.puzzle_level_button = new JRadioButton("Puzzle Level");
		this.lightning_level_button = new JRadioButton("Lightning Level");
		this.theme_level_button = new JRadioButton("Theme Level");

		this.gravity_up_button = new JRadioButton("Up");
		this.gravity_down_button = new JRadioButton("Down");
		this.gravity_left_button = new JRadioButton("Left");
		this.gravity_right_button = new JRadioButton("Right");

		this.level_type_group = new ButtonGroup();
		this.gravity_group = new ButtonGroup();

		//instantiates the BoardView for the level Editor view
		this.board_view = new BoardView();
		
		//instantiates the editProgress
		this.editProgress = model.getEditProgress();
	}

	/**
	 * This function initializes all of the attributes within the level editor.
	 * 
	 * entryCondition: Must be called after instantiateAttributes() or will fail.
	 * exitCondition: All attributes have been initialized properly
	 */
	void initializeAttributes(){
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
		add(board_view);
	}

	/* ~~~~~                                                                               ~~~~~ *
	 * Getter Methods                                                                            *
	 * ~~~~~                                                                               ~~~~~ */

	/**
	 * This function returns the JLabel representing the Title
	 * @return JLabel
	 */
	public JLabel getTitleLabel(){
		return title_label;
	}

	/** 
	 * This function returns the JLabel representing the Level Name Label
	 * @return JLabel
	 */
	public JLabel getLevelNameLabel(){
		return level_name_label;
	}

	/**
	 * This function returns the JLabel representing the Threshold Label
	 * @return JLabel
	 */
	public JLabel getThresholdsTitleLabel(){
		return thresholds_title_label;
	}

	/**
	 * This function returns the JLabel representing the one star label
	 * @return JLabel
	 */
	public JLabel getOneStarLabel(){
		return one_star_label;
	}

	/**
	 * This function returns the JLabel representing the two star label
	 * @return JLabel
	 */
	public JLabel getTwoStarLabel(){
		return two_star_label;
	}

	/**
	 * This function returns the JLabel representing the three star label   
	 * @return JLabel
	 */
	public JLabel getThreeStarLabel(){
		return three_star_label;
	}

	/**
	 * This function returns the JLabel representing the one star unit label
	 * @return JLabel
	 */
	public JLabel getOneStarUnitLabel(){
		return one_star_unit_label;
	}

	/** 
	 * This function returns the JLabel representing the two star unit label
	 * @return JLabel
	 */
	public JLabel getTwoStarUnitLabel(){
		return two_star_unit_label;
	}

	/**
	 * This function returns the JLabel representing the three star unit label
	 * @return JLabel
	 */
	public JLabel getThreeStarUnitLabel(){
		return three_star_unit_label;
	}

	/**
	 * This function returns the JLabel representing the gravity label
	 * @return JLabel
	 */
	public JLabel getGravityLabel(){
		return gravity_label;
	}

	/**
	 * This function returns the JLabel representing the level specific label 
	 * @return JLabel
	 */
	public JLabel getLevelSpecificLabel(){
		return level_specific_label;
	}


	/**
	 * This function returns the JLabel representing the puzzle level's maximum number of words
	 * label
	 * @return JLabel
	 */
	public JLabel getPuzzleMaxNumWordsLabel(){
		return puzzle_max_num_words_label;
	}

	/**
	 * This function returns the JLabel representing the lightnint level's time limit label
	 * @return JLabel
	 */
	public JLabel getLightningTimeLimitLabel(){
		return lightning_time_limit_label;
	}

	/**
	 * This function returns the JLabel representing the theme level's theme name label
	 * @return JLabel
	 */
	public JLabel getThemeNameLabel(){
		return theme_name_label;
	}

	/**
	 * This function returns the JLabel representing the theme level's theme words label 
	 * @return JLabel
	 */
	public JLabel getThemeWordsLabel(){
		return theme_words_label;
	}

	/**
	 * This function returns the JTextField that stores the user's entered level name
	 * @return JTextField
	 */
	public JTextField getLevelNameTextField(){
		return level_name_textfield;
	}

	/**
	 * This function returns the JTextField that stores the user's entered value for the first
	 * star's threshold
	 * @return JTextField
	 */
	public JTextField getOneStarTextField(){
		return one_star_textfield;
	}

	/**
	 * This function returns the JTextField that stores the user's entered value for the second
	 * star's threshold
	 * @return JTextField
	 */
	public JTextField getTwoStarTextField(){
		return two_star_textfield;
	}

	/**
	 * This function returns the JTextField that stores the user's entered value for the third
	 * star's threshold
	 * @return JTextField
	 */
	public JTextField getThreeStarTextField(){
		return three_star_textfield;
	}

	/**
	 * This function returns the JTextField taht stores the user's entered value for a puzzle
	 * level's maximum number of words.
	 * @return JTextField
	 */
	public JTextField getPuzzleMaxNumWordsTextField(){
		return puzzle_max_num_words_textfield;
	}

	/**
	 * This function returns the JTextField that stores the user's entered value for a theme
	 * level's theme name
	 * @return JTextField
	 */
	public JTextField getThemeNameTextField(){
		return theme_name_textfield;
	}

	/**
	 * This function returns the TextArea that stores the user's entered value for a theme
	 * level's theme words
	 * @return TextArea
	 */
	public TextArea getThemeWordsTextArea(){
		return theme_words_textarea;
	}

	/**
	 * This function returns the JButton that is used to save the current level
	 * @return JButton
	 */
	public JButton getSaveButton(){
		return save_button;
	}

	/** 
	 * This function returns the JButton that is used to generate tiles on the board
	 * @return JButton
	 */
	public JButton getGenerateButton(){
		return generate_button;
	}

	/**
	 * This function returns the JButton that is used to return to the main menu
	 * @return JButton
	 */
	public JButton getMainMenuButton(){
		return main_menu_button;
	}

	/** 
	 * This function returns the JRadioButton that is used to specify that this level is a 
	 * puzzle level
	 * @return JRadioButton
	 */
	public JRadioButton getPuzzleLevelButton(){
		return puzzle_level_button;
	}

	/**
	 * This function returns the JRadioButton that is used to specify that this level is a 
	 * lightning level
	 * @return JRadioButton
	 */
	public JRadioButton getLightningLevelButton(){
		return lightning_level_button;
	}

	/**
	 * This function return the JRadioButton that is used to specify that this level is a 
	 * theme level
	 * @return JRadioButton
	 */
	public JRadioButton getThemeLevelButton(){
		return theme_level_button;
	}

	/**
	 * This function returns the JRadioButton that is used to specify that the direction of 
	 * gravity is up.
	 * @return JRadioButton
	 */
	public JRadioButton getGravityUpButton(){
		return gravity_up_button;
	}

	/** 
	 * This function returns the JRadioButton that is used to specify that the direction of
	 * gravity is down
	 * @return JRadioButton
	 */
	public JRadioButton getGravityDownButton(){
		return gravity_down_button;
	}

	/**
	 * This function returns the JRadioButton that is used to specify that the direction of 
	 * gravity is left
	 * @return JRadioButton
	 */
	public JRadioButton getGravityLeftButton(){
		return gravity_left_button;
	}

	/**
	 * This function returns the JRadioButton that is used to specify that the direction of 
	 * gravity is right
	 * @return JRadioButton
	 */
	public JRadioButton getGravityRightButton(){
		return gravity_right_button;
	}

	/**
	 * This function returns the Button Group representing the puzzle level, lightning level,
	 * and theme level buttons
	 * @return ButtonGroup
	 */
	public ButtonGroup getLevelTypeGroup(){
		return level_type_group;
	}

	/**
	 * This function returns the Button Group representing the up, down, left, and right gravity
	 * buttons
	 * @return ButtonGroup
	 */
	public ButtonGroup getGravityGroup(){
		return level_type_group;
	}


	/**
	 * This function returns the Board View containing all the board squares
	 * @return BoardView
	 */
	public BoardView getBoardView(){
		return board_view;
	}


	/* ~~~~~                                                                               ~~~~~ *
	 * GUI Logic for Controllers                                                                 *
	 * ~~~~~                                                                               ~~~~~ */

	/**
	 * This function sets the EditProgress
	 */
	public void setEditProgress(EditProgress ep){
		this.editProgress = ep;
	}
	
	/**
	 * This function sets the LevelEditor View to represent a puzzle level
	 */
	public void setPuzzleLevelView(){
		level_specific_label.setVisible(true);

		/* Disable theme and lightning*/
		theme_name_label.setVisible(false);
		theme_words_label.setVisible(false);
		theme_name_textfield.setVisible(false);
		theme_words_textarea.setVisible(false);
		lightning_time_limit_label.setVisible(false);
		lightning_time_limit_textfield.setVisible(false);

		/* Enable puzzle*/
		puzzle_max_num_words_label.setVisible(true);
		puzzle_max_num_words_textfield.setVisible(true);
		
		//sets Puzzle Level Button to be selected
    	getPuzzleLevelButton().setSelected(true);

		/* Set current view for reference later */
		currentView = "puzzle";
		
		/* Set correct radio button as enabled*/
		System.out.println("puzzle is selected");
	}

	/**
	 * This function sets the LevelEditor view to represent a lightning level
	 */
	public void setLightningLevelView(){
		level_specific_label.setVisible(true);

		/* Disable theme and puzzle*/
		theme_name_label.setVisible(false);
		theme_words_label.setVisible(false);
		theme_name_textfield.setVisible(false);
		theme_words_textarea.setVisible(false);
		puzzle_max_num_words_label.setVisible(false);
		puzzle_max_num_words_textfield.setVisible(false);

		/* Enable lightning*/
		lightning_time_limit_label.setVisible(true);
		lightning_time_limit_textfield.setVisible(true);
		
		//sets Lightning Level Button to be selected
    	getLightningLevelButton().setSelected(true);

		/* Set current view for reference later */
		currentView = "lightning";
		
		/* Set correct radio button as enabled*/
		System.out.println("lightning is selected");
	}

	/**
	 * This function sets the LevelEditor view to represent a Theme level
	 */
	public void setThemeLevelView(){
		level_specific_label.setVisible(true);

		/* Disable lightning and puzzle*/
		puzzle_max_num_words_label.setVisible(false);
		puzzle_max_num_words_textfield.setVisible(false);
		lightning_time_limit_label.setVisible(false);
		lightning_time_limit_textfield.setVisible(false);

		/* Enable theme*/
		theme_name_label.setVisible(true);
		theme_words_label.setVisible(true);
		theme_name_textfield.setVisible(true);
		theme_words_textarea.setVisible(true);
		
		//sets Theme Level Button to be selected
    	getThemeLevelButton().setSelected(true);

		/* Set current view for reference later */
		currentView = "theme";
		
		/* Set correct radio button as enabled*/
		System.out.println("theme is selected");
	}

	/**
	 * Refreshes the Level Editor View based upon the EditProgress associated with that View.
	 */
	public void refresh(){
		Level modLevel = editProgress.getModified();
		if(modLevel != null) {
			for (int row = 0; row < 6; row++) {
				for (int col = 0; col < 6; col++) {
					if(modLevel.getBoard().getSquare(row, col).isEnabled()){
						board_view.getJLabel(row, col).setBackground(Color.WHITE);
					} else {
						board_view.getJLabel(row, col).setBackground(Color.BLACK);
					}
				}
			}

			//set view to be correct type
			switch (modLevel.getType().toLowerCase()) {
			case "lightning":
				if(!currentView.equals("lightning")) {
					setLightningLevelView();
					System.out.println("setting view to lightning");
				}
			case "theme":
				if(!currentView.equals("theme")) {
					setThemeLevelView();
					System.out.println("setting view to theme");
				}
			case "puzzle":
				if(!currentView.equals("puzzle")) {
					setPuzzleLevelView();
					System.out.println("setting view to puzzle");
				}
			}
		}
	}


}

