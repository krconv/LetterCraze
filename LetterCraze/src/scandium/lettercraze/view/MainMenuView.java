/**
 * MainMenuView.java
 * 
 * @author Scandium
 */
package scandium.lettercraze.view;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import scandium.common.model.Level;
import scandium.common.view.WrapLayout;
import scandium.lettercraze.model.LevelProgress;
import scandium.lettercraze.model.Model;

import java.awt.BorderLayout;
import javax.swing.BoxLayout;

import java.awt.Component;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JScrollPane;

/**
 * The view for the main menu screen.
 */
public class MainMenuView extends JPanel {
	private static final long serialVersionUID = -5238087610632124590L;
	private Model model;
	private JPanel levelsPanel;
	private JLabel titleLabel;
	private JPanel buttonPanel;
	private JButton resetButton;

    /**
     * Creates the view for the Main Menu screen.
     * @param model The model.
     */
    public MainMenuView(Model model) {
    	this.model = model;
    	initialize();
    	refresh();
    }
    
	/**
	 * @return the titleLabel
	 */
	public JLabel getTitleLabel() {
		return titleLabel;
	}

	/**
	 * @return the resetButton
	 */
	public JButton getResetButton() {
		return resetButton;
	}
	
	
	/**
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
	
	/**
     * Initializes the view.
     */
    private void initialize() {
		setBackground(new Color(0, 191, 255));
		setBorder(new EmptyBorder(20, 20, 20, 20));
		setLayout(new BorderLayout(0, 0));
		
		// add the main menu title
		titleLabel = new JLabel("LetterCraze");
		titleLabel.setForeground(new Color(0, 0, 0));
		titleLabel.setFont(titleLabel.getFont().deriveFont(titleLabel.getFont().getSize() + 50f));
		add(titleLabel, BorderLayout.NORTH);
		
		// add the side panel
		JPanel sidePanel = new JPanel();
		sidePanel.setBorder(new EmptyBorder(10, 10, 10, 10));
		sidePanel.setLayout(new BorderLayout());
		sidePanel.setOpaque(false);
				
		// add the button panel
		buttonPanel = new JPanel();
		buttonPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
		buttonPanel.setOpaque(false);
		Dimension buttonSize = new Dimension(200, 40);
		
		// add the reset button
		resetButton = new JButton("Reset Progress");
		resetButton.setPreferredSize(buttonSize);
		resetButton.setMaximumSize(buttonSize);
		resetButton.setFont(resetButton.getFont().deriveFont(resetButton.getFont().getSize() + 10f));
		buttonPanel.add(resetButton);
		
		sidePanel.add(buttonPanel, BorderLayout.SOUTH);
		
		add(sidePanel, BorderLayout.EAST);
		
		// add the level panel
		levelsPanel = new JPanel();
		levelsPanel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		levelsPanel.setOpaque(false);
		levelsPanel.setLayout(new WrapLayout());

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(levelsPanel);
		add(scrollPane, BorderLayout.CENTER);
    }

	/**
	 * Refreshes the data of the main menu from the model.
	 */
    public void refresh() {
    	// update the level icons
    	List<Level> levels = model.getLevels();
		for (int i = 0; i < levels.size(); i++) {
			LevelProgress progress = model.getProgress().getProgressForLevel(levels.get(i));
			if (getLevelIcons().size() < i + 1 || getLevelIcons().get(i).getModel() != progress) {
				levelsPanel.add(new LevelIconView(progress), i);
			}
		}
		
		// refresh the level icons
		for (LevelIconView icon : getLevelIcons())
			icon.refresh();
		repaint();
    }
}