/**
 * MainMenuView.java
 * 
 * @author Scandium
 */
package scandium.lettercraze.view;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import scandium.lettercraze.model.Model;
import java.awt.BorderLayout;
import javax.swing.Box;
import java.awt.Component;
import javax.swing.BoxLayout;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.ImageIcon;

/**
 * The view for the main menu screen.
 */
public class MainMenuView extends JPanel {
	private static final long serialVersionUID = -5238087610632124590L;
	private Model model;
	private JPanel levelsPanel;
	private ArrayList<LevelIconView> levelIconViews;
	private JLabel titleLabel;
	private JPanel buttonPanel;
	private JButton resetButton;


	/**
	 * Creates a new main menu view without a model.
	 */
	public MainMenuView() {
		setBackground(new Color(0, 191, 255));
		setBorder(new EmptyBorder(20, 20, 20, 20));
		initialize();
	}
	
    /**
     * Creates the view for the Main Menu screen.
     * @param model The model.
     */
    public MainMenuView(Model model) {
    	this.model = model;
    	initialize();
    }

    /**
	 * @return the model
	 */
	public Model getModel() {
		return model;
	}

	/**
	 * @return the levelIconViews
	 */
	public ArrayList<LevelIconView> getLevelIconViews() {
		return levelIconViews;
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
     * Initializes the view.
     */
    private void initialize() {
		setLayout(new BorderLayout(0, 0));
		
		titleLabel = new JLabel("LetterCraze");
		titleLabel.setForeground(new Color(0, 0, 0));
		titleLabel.setFont(titleLabel.getFont().deriveFont(titleLabel.getFont().getSize() + 50f));
		add(titleLabel, BorderLayout.NORTH);
		
		levelsPanel = new JPanel();
		levelsPanel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		levelsPanel.setOpaque(false);
		LevelIconView levelIconView = new LevelIconView();
		levelIconView.getLevelNameLabel().setText("Welcome");
		levelIconView.setBackground(new Color(255, 0, 0));
		levelsPanel.add(levelIconView);
		LevelIconView levelIconView_1 = new LevelIconView();
		levelIconView_1.getStarThreeLabel().setIcon(new ImageIcon(MainMenuView.class.getResource("/scandium/lettercraze/resources/star-icon-off.png")));
		levelIconView_1.getLevelNameLabel().setText("Wacko!");
		levelIconView_1.setBackground(new Color(50, 205, 50));
		levelsPanel.add(levelIconView_1);
		LevelIconView levelIconView_2 = new LevelIconView();
		levelIconView_2.getStarThreeLabel().setIcon(new ImageIcon(MainMenuView.class.getResource("/scandium/lettercraze/resources/star-icon-off.png")));
		levelIconView_2.getHighScoreLabel().setText("4 words");
		levelIconView_2.getLevelNameLabel().setText("Hmm...");
		levelIconView_2.setBackground(new Color(147, 112, 219));
		levelsPanel.add(levelIconView_2);
		LevelIconView levelIconView_3 = new LevelIconView();
		levelIconView_3.getLevelNameLabel().setText("Getting Difficult");
		levelIconView_3.setBackground(new Color(255, 0, 0));
		levelsPanel.add(levelIconView_3);
		LevelIconView levelIconView_4 = new LevelIconView();
		levelIconView_4.getStarOneLabel().setIcon(new ImageIcon(MainMenuView.class.getResource("/scandium/lettercraze/resources/star-icon-off.png")));
		levelIconView_4.getStarTwoLabel().setIcon(new ImageIcon(MainMenuView.class.getResource("/scandium/lettercraze/resources/star-icon-off.png")));
		levelIconView_4.getStarThreeLabel().setIcon(new ImageIcon(MainMenuView.class.getResource("/scandium/lettercraze/resources/star-icon-off.png")));
		levelIconView_4.setBackground(new Color(50, 205, 50));
		levelIconView_4.getLevelNameLabel().setText("Yahooo");
		levelsPanel.add(levelIconView_4);
		LevelIconView levelIconView_5 = new LevelIconView();
		levelIconView_5.getHighScoreLabel().setText("");
		levelIconView_5.setBackground(new Color(192, 192, 192));
		levelIconView_5.getStarOneLabel().setIcon(null);
		levelIconView_5.getStarTwoLabel().setIcon(null);
		levelIconView_5.getStarThreeLabel().setIcon(null);
		levelIconView_5.getLevelNameLabel().setText("Violets");
		levelsPanel.add(levelIconView_5);
		LevelIconView levelIconView_6 = new LevelIconView();
		levelIconView_6.getHighScoreLabel().setText("");
		levelIconView_6.setBackground(new Color(192, 192, 192));
		levelIconView_6.getStarOneLabel().setIcon(null);
		levelIconView_6.getStarTwoLabel().setIcon(null);
		levelIconView_6.getStarThreeLabel().setIcon(null);
		levelIconView_6.getLevelNameLabel().setText("Let's Go!");
		levelsPanel.add(levelIconView_6);
		LevelIconView levelIconView_7 = new LevelIconView();
		levelIconView_7.getHighScoreLabel().setText("");
		levelIconView_7.setBackground(new Color(192, 192, 192));
		levelIconView_7.getStarOneLabel().setIcon(null);
		levelIconView_7.getStarTwoLabel().setIcon(null);
		levelIconView_7.getStarThreeLabel().setIcon(null);
		levelIconView_7.getLevelNameLabel().setText("Trumped");
		levelsPanel.add(levelIconView_7);
		add(levelsPanel, BorderLayout.CENTER);
		
		buttonPanel = new JPanel();
		buttonPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
		buttonPanel.setOpaque(false);
		
		resetButton = new JButton("Reset Progress");
		resetButton.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		resetButton.setFont(resetButton.getFont().deriveFont(resetButton.getFont().getSize() + 10f));
		buttonPanel.add(resetButton);
		
		Component verticalStrut = Box.createVerticalStrut(10);
		buttonPanel.add(verticalStrut);
		add(buttonPanel, BorderLayout.EAST);
    }
}