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
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import scandium.common.model.Level;
import scandium.common.view.WrapLayout;
import scandium.levelbuilder.controller.SelectLevelController;
import scandium.levelbuilder.model.Model;

public class MainMenuView extends JPanel{

	/* Serial ID                                                                                 */
	private static final long serialVersionUID = -6718767832989688466L;

	/* ~~~~~                                                                               ~~~~~ *
	 * Class Attributes                                                                          *
	 * ~~~~~                                                                               ~~~~~ */
	Model model;
	Application app;
	JLabel title_label;
	JPanel levels_panel;
	JPanel button_panel;
	JButton new_level_button;
	JButton edit_level_button;
	JButton delete_level_button;

	/* ~~~~~                                                                               ~~~~~ *
	 * Constructors And Initialization                                                           *
	 * ~~~~~                                                                               ~~~~~ */

	/**
	 * Creates the view for the Main Menu screen with the given Model.
	 * @param model The model.
	 * @param app The application.
	 */
	public MainMenuView(Model model, Application app) {
		this.model = model;
		this.app = app;
		initializeView();
		refresh();
	}

	/**
	 * This function initializes the GUI widgets (attributes).
	 */
	void initializeView(){
		// set the background color and layout manager
		setBackground(new Color(0, 191, 255));
		setBorder(new EmptyBorder(20, 20, 20, 20));
		setLayout(new BorderLayout(0, 0));
		
		/* Initialize Title Label                                                                */
		title_label = new JLabel("LetterCraze Level Builder");
		title_label.setForeground(new Color(0, 0, 0));
		title_label.setFont(title_label.getFont().deriveFont(title_label.getFont().getSize() + 50f));
		add(title_label, BorderLayout.NORTH);

		// add the side panel
		JPanel side_panel = new JPanel();
		side_panel.setBorder(new EmptyBorder(10, 10, 10, 10));
		side_panel.setLayout(new BorderLayout());
		side_panel.setOpaque(false);
		
		// add the button panel
		JPanel button_panel = new JPanel();
		button_panel.setLayout(new BoxLayout(button_panel, BoxLayout.Y_AXIS));
		button_panel.setOpaque(false);
		Dimension buttonSize = new Dimension(200, 40);
		
		/* Initialize Create New Level Button                                                    */
		new_level_button = new JButton("New Level");
		new_level_button.setPreferredSize(buttonSize);
		new_level_button.setMaximumSize(buttonSize);
		new_level_button.setFont(new_level_button.getFont().deriveFont(new_level_button.getFont().getSize() + 10f));
		button_panel.add(new_level_button);
		button_panel.add(Box.createVerticalStrut(15));
		
		/* Initialize Edit Level Button                                                          */
		edit_level_button = new JButton("Edit Level");
		edit_level_button.setPreferredSize(buttonSize);
		edit_level_button.setMaximumSize(buttonSize);
		edit_level_button.setFont(edit_level_button.getFont().deriveFont(edit_level_button.getFont().getSize() + 10f));
		button_panel.add(edit_level_button);
		button_panel.add(Box.createVerticalStrut(15));
		
		/* Initialize Delete Level Button                                                        */
		delete_level_button = new JButton("Delete Level");
		delete_level_button.setPreferredSize(buttonSize);
		delete_level_button.setMaximumSize(buttonSize);
		delete_level_button.setFont(delete_level_button.getFont().deriveFont(delete_level_button.getFont().getSize() + 10f));
		button_panel.add(delete_level_button);
		button_panel.add(Box.createVerticalStrut(15));
		
		side_panel.add(button_panel, BorderLayout.SOUTH);
		
		add(side_panel, BorderLayout.EAST);
		
		// add the level panel
		levels_panel = new JPanel();
		levels_panel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		levels_panel.setOpaque(false);
		levels_panel.setLayout(new WrapLayout());
		add(levels_panel);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(levels_panel);
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
		List<LevelIconView> levelIcons = new ArrayList<LevelIconView>(levels_panel.getComponentCount());
		for (Component icon : levels_panel.getComponents()) {
			levelIcons.add((LevelIconView) icon);
		}
		return levelIcons;
	}
	
	/* ~~~~~                                                                               ~~~~~ *
	 * GUI Logic for Controllers                                                                 *
	 * ~~~~~                                                                               ~~~~~ */

	/**
	 * Refreshes and repaints the Main Menu View based upon the Model associated with it.
	 */
	public void refresh() {
		// update the level icons
		List<Level> levels = model.getLevels();
		for(LevelIconView liv : getLevelIcons()){
			levels_panel.remove(liv);
		}
		for (int i = 0; i < levels.size(); i++) {
			if (getLevelIcons().size() < i + 1) {
				LevelIconView iconView = new LevelIconView(model, levels.get(i));
				iconView.addMouseListener(new SelectLevelController(model, app, levels.get(i)));				
				levels_panel.add(iconView);
			}
		}
		
		// refresh the icon views
		for (LevelIconView iconView : getLevelIcons())
			iconView.refresh();
		repaint();
	}

}
