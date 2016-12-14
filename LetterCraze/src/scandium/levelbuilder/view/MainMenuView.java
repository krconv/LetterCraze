/**
 * MainMenuView.java
 * 
 * @author Scandium
 * Date: 11/22/2016
 * Description: This class represents the main menu View/GUI. It allows the controllers to 
 * easily access all of the buttons, labels, and textfields within the window.
 */
package scandium.levelbuilder.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;

import scandium.common.model.Level;
import scandium.common.view.WrapLayout;
import scandium.levelbuilder.model.Model;

public class MainMenuView extends JPanel{

	/* Serial ID                                                                                 */
	private static final long serialVersionUID = -6718767832989688466L;

	/* ~~~~~                                                                               ~~~~~ *
	 * Class Attributes                                                                          *
	 * ~~~~~                                                                               ~~~~~ */
	Model model = null;
	JLabel title_label;
	JButton new_level_button;
	JButton edit_level_button;
	JButton delete_level_button;
	JPanel levelsPanel;

	/* ~~~~~                                                                               ~~~~~ *
	 * Constructors And Initialization                                                           *
	 * ~~~~~                                                                               ~~~~~ */

	/**
	 * Creates a new MainMenuView object without a Model.
	 */
	public MainMenuView() {
		initializeView();
		refresh();
	}

	/**
	 * Creates the view for the Main Menu screen with the given Model.
	 * @param model The model.
	 */
	public MainMenuView(Model model) {
		this.model = model;
		initializeView();
		refresh();
	}

	/** 
	 * This function initializes the main menu gui.
	 */
	void initializeView(){
		instantiateAttributes();
		initializeAttributes();

		/* JPanel Management                                                                     */
		setLayout(null);
		setBounds(0,0,1280,720);
	}

	/**
	 * This function instantiates new instances of all the objects.
	 */
	void instantiateAttributes(){
		this.title_label = new JLabel("LevelBuilder: MainMenu");
		this.new_level_button = new JButton("New Level");
		this.edit_level_button = new JButton("Edit Level");
		this.delete_level_button = new JButton("Delete Level");
		this.levelsPanel = new JPanel();
	}

	/**
	 * This function initializes the GUI widgets (attributes).
	 */
	void initializeAttributes(){
		/* Initialize Title Label                                                                */
		title_label.setBounds(10, 10, 1280, 40);
		title_label.setFont(new Font(title_label.getFont().getName(), Font.BOLD, 36));
		add(title_label);
		/* Initialize Create New Level Button                                                    */
		new_level_button.setBounds(1075, 100, 125, 50);
		add(new_level_button);
		/* Initialize Edit Level Button                                                          */
		edit_level_button.setBounds(1075, 200,  125, 50);
		add(edit_level_button);
		/* Initialize Delete Level Button                                                        */
		delete_level_button.setBounds(1075, 300,  125,  50);
		add(delete_level_button);

		// add the level panel
		levelsPanel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		levelsPanel.setOpaque(false);
		levelsPanel.setLayout(new WrapLayout());
		add(levelsPanel);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(levelsPanel);
		scrollPane.setBounds(25, 100, 1000, 500);
		add(scrollPane, BorderLayout.CENTER);

	}

	/* ~~~~~                                                                               ~~~~~ *
	 * Getter Methods                                                                            *
	 * ~~~~~                                                                               ~~~~~ */

	/**
	 * This function returns the JLabel representing the title.
	 * @return JLabel
	 */
	public JLabel getTitleLabel(){
		return title_label;
	}

	/**
	 * This function returns the JButton that is used to create a new level. 
	 * @return JButton
	 */
	public JButton getNewLevelButton(){
		return new_level_button;
	}

	/**
	 * This function returns the JButton that is used to edit a selected level.
	 * @return JButton
	 */
	public JButton getEditLevelButton(){
		return edit_level_button;
	}

	/**
	 * This function returns the JButton that is used to delete a selected level.
	 * @return JButton
	 */
	public JButton getDeleteLevelButton(){
		return delete_level_button;
	}

	/**
	 * Returns a list of all of the level icons in the Main Menu View.
	 * @return The list of level icons
	 */
	public List<LevelIconView> getLevelIcons() {
		// convert the components from the level panel to level icons
		List<LevelIconView> levelIcons = new ArrayList<LevelIconView>(levelsPanel.getComponentCount());
		for (Component icon : levelsPanel.getComponents()) {
			levelIcons.add((LevelIconView) icon);
		}
		return levelIcons;
	}
	
	public LevelIconView getLevelIconView(int number){
		return getLevelIcons().get(number);
	}

	/* ~~~~~                                                                               ~~~~~ *
	 * GUI Logic for Controllers                                                                 *
	 * ~~~~~                                                                               ~~~~~ */

	/**
	 * Refreshes and repaints the Main Menu View based upon the Model associated with it.
	 */
	public void refresh(){
		// update the level icons
		List<Level> levels = model.getLevels();
		for(LevelIconView liv : getLevelIcons()){
			levelsPanel.remove(liv);
		}
		for (int i = 0; i < levels.size(); i++) {
			LevelIconView iconView = new LevelIconView(levels.get(i));
			levelsPanel.add(iconView);
		}

		// refresh the level icons
		for (LevelIconView icon : getLevelIcons()){
			icon.refresh();
			if(icon.getLevel().equals(model.getSelectedLevel()))
				icon.setBorder(new LineBorder(Color.BLACK, 5, true));
			else 
				icon.setBorder(null);
		}
		repaint();
	}

}
