/**
 * LevelEditorView.java
 * 
 * @author Scandium
 * Date: 11/22/2016
 * Description: This class represents the level editor View/GUI. It allows the controllers to 
 * easily access all of the buttons, labels, and textfields within the window.
 */
package scandium.levelbuilder.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import scandium.common.model.Level;
import scandium.common.model.LightningLevel;
import scandium.common.model.PuzzleLevel;
import scandium.common.model.ThemeLevel;
import scandium.levelbuilder.model.EditProgress;
import scandium.levelbuilder.model.Model;

public class LevelEditorView extends JPanel{

	/* Serial ID                                                                                 */
	private static final long serialVersionUID = -6718767832989688466L;

	/* ~~~~~                                                                               ~~~~~ *
	 * Class Attributes                                                                          *
	 * ~~~~~                                                                               ~~~~~ */
	Model model;
	Application app;
	EditProgress editProgress;
	
	JLabel title_label;
	JComboBox<String> level_type_combo_box;
	JTextField level_name_textfield;
	JTextField star_one_textfield;
	JTextField star_two_textfield;
	JTextField star_three_textfield;
	JLabel star_unit_label;
	Box max_num_words_box;
	JTextField max_num_words_textfield;
	Box time_limit_box;
	JTextField time_limit_textfield;
	Box theme_name_box;
	JTextField theme_name_textfield;
	Box theme_words_box;
	JTextArea theme_words_textarea;
	JButton save_button;
	JButton generate_button;
	JButton main_menu_button;
	BoardView board_view;

	/* ~~~~~                                                                               ~~~~~ *
	 * Constructors And Initialization                                                           *
	 * ~~~~~                                                                               ~~~~~ */

	/**
	 * Creates a new LevelEditorView based upon the given Model.
	 * @param m the Model to be associated with this Level Editor View
	 * @param app The application.
	 */
	public LevelEditorView(Model m, Application app) {
		this.model = m;
		this.app = app;
		initializeView();
		refresh();
	}

	/**
	 * Initializes the view.
	 * 
	 * entryCondition: None.
	 * exitCondition: All attributes have been initialized properly
	 */
	void initializeView(){
		setBackground(new Color(0, 191, 255));
		setBorder(new EmptyBorder(20, 20, 20, 20));
		setLayout(new BorderLayout(0, 0));
		
		/* Initialize Title Label                                                                */
		title_label = new JLabel();
		title_label.setBounds(10, 10, 1280, 40);
		title_label.setFont(new Font(title_label.getFont().getName(), Font.BOLD, 36));
		add(title_label, BorderLayout.NORTH);
		
		// create the side panel
		JPanel side_panel = new JPanel();
		side_panel.setBorder(new EmptyBorder(10, 10, 10, 10));
		side_panel.setLayout(new BorderLayout());
		side_panel.setOpaque(false);
		
		JPanel fields_panel = new JPanel();
		
		// create the level type combo box
		Box level_type_box = createLabelTextFieldBox("Type", true);
		level_type_box.remove(2);
		level_type_combo_box = new JComboBox<String>(new String[] {
				"Puzzle",
				"Lightning",
				"Theme"
		});
		level_type_box.add(level_type_combo_box);
		fields_panel.add(level_type_box);		
		
		// create the level name text box
		Box level_name_box = createLabelTextFieldBox("Name", true);
		level_name_textfield = (JTextField) level_name_box.getComponent(2);
		fields_panel.add(level_name_box);
		
		// create the star threshold area
		Box star_threshold_area_box = Box.createVerticalBox();
		JLabel thresholds_title_label = new JLabel("Score Thresholds");
		star_threshold_area_box.add(thresholds_title_label);
		
		// create the star thresholds
		star_unit_label = new JLabel();
		star_unit_label.setFont(star_unit_label.getFont().deriveFont(star_unit_label.getFont().getSize() + 15f));
		Box star_threshold_box = Box.createVerticalBox();
		Box star_one_box = createLabelTextFieldBox("Star One", true);
		star_one_textfield = (JTextField) star_one_box.getComponent(2);
		star_one_box.add(star_unit_label);
		star_threshold_box.add(star_one_box);
		
		Box star_two_box = createLabelTextFieldBox("Star Two", true);
		star_two_textfield = (JTextField) star_two_box.getComponent(2);
		star_two_box.add(star_unit_label);
		star_threshold_box.add(star_two_box);
		
		Box star_three_box = createLabelTextFieldBox("Star Three", true);
		star_three_textfield = (JTextField) star_three_box.getComponent(2);
		star_three_box.add(star_unit_label);
		star_threshold_box.add(star_three_box);
		star_threshold_area_box.add(star_threshold_box);
		fields_panel.add(star_threshold_area_box);
		
		/* Initialize Level Specific Label                                                       */
		/* Initialize Puzzle Max Num Words Label                                                 */
		max_num_words_box = createLabelTextFieldBox("Word Limit", false);
		max_num_words_textfield = (JTextField) max_num_words_box.getComponent(2);
		JLabel max_num_words_unit_label = new JLabel("words");
		max_num_words_unit_label.setFont(max_num_words_unit_label.getFont().deriveFont(max_num_words_unit_label.getFont().getSize() + 15f));
		max_num_words_box.add(max_num_words_unit_label);
		fields_panel.add(max_num_words_box);
		
		/* Initialize Lightning Time Limit Label                                                 */
		time_limit_box = createLabelTextFieldBox("Time Limit", false);
		time_limit_textfield = (JTextField) time_limit_box.getComponent(2);
		JLabel time_limit_unit_label = new JLabel("seconds");
		time_limit_unit_label.setFont(time_limit_unit_label.getFont().deriveFont(time_limit_unit_label.getFont().getSize() + 15f));
		time_limit_box.add(time_limit_unit_label);
		fields_panel.add(max_num_words_box);
		
		/* Initialize Theme Name Label                                                           */
		theme_name_box = createLabelTextFieldBox("Theme", false);
		theme_name_textfield = (JTextField) theme_name_box.getComponent(2);
		fields_panel.add(theme_name_box);
		
		/* Initialize Theme Words Label                                                          */
		theme_words_box = createLabelTextFieldBox("Theme Words", false);
		theme_words_textarea = new JTextArea();
		theme_words_box.remove(2);
		theme_words_box.add(theme_words_textarea);
		fields_panel.add(theme_words_box);
		
		side_panel.add(fields_panel, BorderLayout.CENTER);
		
		// add the button panel
		JPanel button_panel = new JPanel();
		button_panel.setLayout(new BoxLayout(button_panel, BoxLayout.Y_AXIS));
		button_panel.setOpaque(false);
		Dimension buttonSize = new Dimension(200, 40);
		
		/* Initialize Create New Level Button                                                    */
		save_button = new JButton("Save");
		save_button.setPreferredSize(buttonSize);
		save_button.setMaximumSize(buttonSize);
		save_button.setFont(save_button.getFont().deriveFont(save_button.getFont().getSize() + 10f));
		button_panel.add(save_button);
		button_panel.add(Box.createVerticalStrut(15));
		
		/* Initialize Edit Level Button                                                          */
		generate_button = new JButton("Preview");
		generate_button.setPreferredSize(buttonSize);
		generate_button.setMaximumSize(buttonSize);
		generate_button.setFont(generate_button.getFont().deriveFont(generate_button.getFont().getSize() + 10f));
		button_panel.add(generate_button);
		button_panel.add(Box.createVerticalStrut(15));
		
		/* Initialize Delete Level Button                                                        */
		main_menu_button = new JButton("Maun Menu");
		main_menu_button.setPreferredSize(buttonSize);
		main_menu_button.setMaximumSize(buttonSize);
		main_menu_button.setFont(main_menu_button.getFont().deriveFont(main_menu_button.getFont().getSize() + 10f));
		button_panel.add(main_menu_button);
		button_panel.add(Box.createVerticalStrut(15));
		
		side_panel.add(button_panel, BorderLayout.SOUTH);
		
		add(side_panel, BorderLayout.EAST);
				
		/* Initialize BoardView                                                                  */
		board_view = new BoardView();
		add(board_view, BorderLayout.CENTER);
	}

	/**
	 * Creates a box which holds a label and a text field. The caller can retrieve
	 * the text field by getting the third components in the box.
	 * 
	 * @param labelText
	 *            The text that the label should have.
	 * @param visible
	 *            Whether the box should be initially visible.
	 * @return The created box with the given specifications.
	 */
	private Box createLabelTextFieldBox(String labelText, boolean visible) {
		// create the box
		Box box = Box.createHorizontalBox();
		box.setBorder(new EmptyBorder(7, 7, 7, 7));
		
		// create the label
		JLabel label = new JLabel(labelText + ":");
		label.setFont(label.getFont().deriveFont(label.getFont().getSize() + 15f));
		box.add(label);

		// add a spacer between the label and value
		box.add(Box.createRigidArea(new Dimension(20, 20)));
		
		// create the text field
		JTextField value = new JTextField();
		value.setFont(value.getFont().deriveFont(value.getFont().getSize() + 15f));
		box.add(value);
		box.setVisible(visible);
		return box;
	}
	
	/* ~~~~~                                                                               ~~~~~ *
	 * Getter Methods                                                                            *
	 * ~~~~~                                                                               ~~~~~ */

	/**
	 * @return the model
	 */
	public Model getModel() {
		return model;
	}

	/**
	 * @return the editProgress
	 */
	public EditProgress getEditProgress() {
		return editProgress;
	}

	/**
	 * @return the title_label
	 */
	public JLabel getTitleLabel() {
		return title_label;
	}

	/**
	 * @return the level_type_combo_box
	 */
	public JComboBox<String> getLevel_type_combo_box() {
		return level_type_combo_box;
	}

	/**
	 * @return the level_name_textfield
	 */
	public JTextField getLevelNameTextfield() {
		return level_name_textfield;
	}

	/**
	 * @return the star_one_textfield
	 */
	public JTextField getStarOneTextfield() {
		return star_one_textfield;
	}

	/**
	 * @return the star_two_textfield
	 */
	public JTextField getStarTwoTextfield() {
		return star_two_textfield;
	}

	/**
	 * @return the star_three_textfield
	 */
	public JTextField getStarThreeTextfield() {
		return star_three_textfield;
	}

	/**
	 * @return the star_unit_label
	 */
	public JLabel getStarUnitLabel() {
		return star_unit_label;
	}

	/**
	 * @return the max_num_words_box
	 */
	public Box getMaxNumWordsBox() {
		return max_num_words_box;
	}

	/**
	 * @return the max_num_words_textfield
	 */
	public JTextField getMaxNumWordsTextfield() {
		return max_num_words_textfield;
	}

	/**
	 * @return the time_limit_box
	 */
	public Box getTimeLimitBox() {
		return time_limit_box;
	}

	/**
	 * @return the time_limit_textfield
	 */
	public JTextField getTimeLimitTextfield() {
		return time_limit_textfield;
	}

	/**
	 * @return the theme_name_box
	 */
	public Box getThemeNameBox() {
		return theme_name_box;
	}

	/**
	 * @return the theme_name_textfield
	 */
	public JTextField getThemeNameTextfield() {
		return theme_name_textfield;
	}

	/**
	 * @return the theme_words_box
	 */
	public Box getThemeWordsBox() {
		return theme_words_box;
	}

	/**
	 * @return the theme_words_textarea
	 */
	public JTextArea getThemeWordsTextarea() {
		return theme_words_textarea;
	}

	/**
	 * @return the list of words in the theme level words text area
	 */
	public List<String> getThemeWords() {
		ArrayList<String> words = new ArrayList<String>();
		for (String word : theme_words_textarea.getText().split("\n"))
			words.add(word.trim());
		return words;
	}

	/**
	 * Sets the theme words.
	 * @param words the theme words
	 */
	public void setThemeWords(List<String> words) {
		StringBuilder string = new StringBuilder();
		for (String word : words)
			string.append(word).append("\n");
		theme_words_textarea.setText(string.toString());
	}	
	
	/**
	 * @return the save_button
	 */
	public JButton getSaveButton() {
		return save_button;
	}

	/**
	 * @return the generate_button
	 */
	public JButton getGenerateButton() {
		return generate_button;
	}

	/**
	 * @return the main_menu_button
	 */
	public JButton getMainMenuButton() {
		return main_menu_button;
	}

	/**
	 * @return the board_view
	 */
	public BoardView getBoardView() {
		return board_view;
	}
	

	/* ~~~~~                                                                               ~~~~~ *
	 * GUI Logic for Controllers                                                                 *
	 * ~~~~~                                                                               ~~~~~ */

	/**
	 * Sets the edit progress for the editor.
	 * @param ep The edit progress.
	 */
	public void setEditProgress(EditProgress ep){
		this.editProgress = ep;
		board_view.setBoard(ep.getModified().getBoard());
	}

	/**
	 * Refreshes the Level Editor View based upon the EditProgress associated with that View.
	 */
	public void refresh(){
		max_num_words_box.setVisible(false);
		time_limit_box.setVisible(false);
		theme_name_box.setVisible(false);
		theme_words_box.setVisible(false);
		
		if (editProgress != null) {
			Level level = editProgress.getModified();
			if(level != null) {	
				// set view to be correct type
				if (level instanceof PuzzleLevel) {
					max_num_words_box.setVisible(false);
				} else if (level instanceof LightningLevel) {
					time_limit_box.setVisible(true);
				} else if (level instanceof ThemeLevel) {
					theme_name_box.setVisible(true);
					theme_words_box.setVisible(true);
				}
			}
		}
		board_view.refresh();
		repaint();
	}
}

