/**
 * MainMenuView.java
 * 
 * @author Scandium
 */
package scandium.lettercraze.view;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import scandium.common.view.WrapLayout;
import scandium.lettercraze.model.Model;
import java.awt.BorderLayout;
import javax.swing.Box;
import java.awt.Component;

import javax.swing.BoxLayout;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.ImageIcon;
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
	 * @param index The index of the level icon to retrieve
	 * @return the levelIconViews
	 */
	public LevelIconView getLevelIconView(int index) {
		return (LevelIconView) levelsPanel.getComponent(index);
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
		
		levelsPanel = new JPanel();
		levelsPanel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		levelsPanel.setOpaque(false);
		levelsPanel.setLayout(new WrapLayout());
		LevelIconView levelIconView = new LevelIconView();
		levelIconView.getHighScoreLabel().setText("");
		levelIconView.setBackground(new Color(255, 0, 0));
		levelIconView.getStarOneLabel().setIcon(new ImageIcon(MainMenuView.class.getResource("/scandium/lettercraze/resources/star-icon-off.png")));
		levelIconView.getStarTwoLabel().setIcon(new ImageIcon(MainMenuView.class.getResource("/scandium/lettercraze/resources/star-icon-off.png")));
		levelIconView.getStarThreeLabel().setIcon(new ImageIcon(MainMenuView.class.getResource("/scandium/lettercraze/resources/star-icon-off.png")));
		levelIconView.getLevelNameLabel().setText("Puzzled");
		levelsPanel.add(levelIconView);
		LevelIconView levelIconView_1 = new LevelIconView();
		levelIconView_1.getHighScoreLabel().setText("");
		levelIconView_1.setBackground(new Color(192, 192, 192));
		levelIconView_1.getStarOneLabel().setIcon(null);
		levelIconView_1.getStarTwoLabel().setIcon(null);
		levelIconView_1.getStarThreeLabel().setIcon(null);
		levelIconView_1.getLevelNameLabel().setText("Wacko!");
		levelsPanel.add(levelIconView_1);
		LevelIconView levelIconView_2 = new LevelIconView();
		levelIconView_2.getHighScoreLabel().setText("");
		levelIconView_2.setBackground(new Color(192, 192, 192));
		levelIconView_2.getStarOneLabel().setIcon(null);
		levelIconView_2.getStarTwoLabel().setIcon(null);
		levelIconView_2.getStarThreeLabel().setIcon(null);
		levelIconView_2.getLevelNameLabel().setText("Hmm...");
		levelsPanel.add(levelIconView_2);
		LevelIconView levelIconView_3 = new LevelIconView();
		levelIconView_3.getHighScoreLabel().setText("");
		levelIconView_3.setBackground(new Color(192, 192, 192));
		levelIconView_3.getStarOneLabel().setIcon(null);
		levelIconView_3.getStarTwoLabel().setIcon(null);
		levelIconView_3.getStarThreeLabel().setIcon(null);
		levelIconView_3.getLevelNameLabel().setText("Getting Difficult");
		levelsPanel.add(levelIconView_3);
		LevelIconView levelIconView_4 = new LevelIconView();
		levelIconView_4.getHighScoreLabel().setText("");
		levelIconView_4.setBackground(new Color(192, 192, 192));
		levelIconView_4.getStarOneLabel().setIcon(null);
		levelIconView_4.getStarTwoLabel().setIcon(null);
		levelIconView_4.getStarThreeLabel().setIcon(null);
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
		levelIconView_7.getLevelNameLabel().setText("Let it Snow");
		levelsPanel.add(levelIconView_7);
		LevelIconView levelIconView_8 = new LevelIconView();
		levelIconView_8.getHighScoreLabel().setText("");
		levelIconView_8.setBackground(new Color(192, 192, 192));
		levelIconView_8.getStarOneLabel().setIcon(null);
		levelIconView_8.getStarTwoLabel().setIcon(null);
		levelIconView_8.getStarThreeLabel().setIcon(null);
		levelIconView_8.getLevelNameLabel().setText("Turkey Day");
		levelsPanel.add(levelIconView_8);
		LevelIconView levelIconView_9 = new LevelIconView();
		levelIconView_9.getHighScoreLabel().setText("");
		levelIconView_9.setBackground(new Color(192, 192, 192));
		levelIconView_9.getStarOneLabel().setIcon(null);
		levelIconView_9.getStarTwoLabel().setIcon(null);
		levelIconView_9.getStarThreeLabel().setIcon(null);
		levelIconView_9.getLevelNameLabel().setText("What?!");
		levelsPanel.add(levelIconView_9);
		LevelIconView levelIconView_10 = new LevelIconView();
		levelIconView_10.getHighScoreLabel().setText("");
		levelIconView_10.setBackground(new Color(192, 192, 192));
		levelIconView_10.getStarOneLabel().setIcon(null);
		levelIconView_10.getStarTwoLabel().setIcon(null);
		levelIconView_10.getStarThreeLabel().setIcon(null);
		levelIconView_10.getLevelNameLabel().setText("FASTT!!");
		levelsPanel.add(levelIconView_10);
		LevelIconView levelIconView_11 = new LevelIconView();
		levelIconView_11.getHighScoreLabel().setText("");
		levelIconView_11.setBackground(new Color(192, 192, 192));
		levelIconView_11.getStarOneLabel().setIcon(null);
		levelIconView_11.getStarTwoLabel().setIcon(null);
		levelIconView_11.getStarThreeLabel().setIcon(null);
		levelIconView_11.getLevelNameLabel().setText("...slow...");
		levelsPanel.add(levelIconView_11);
		LevelIconView levelIconView_12 = new LevelIconView();
		levelIconView_12.getHighScoreLabel().setText("");
		levelIconView_12.setBackground(new Color(192, 192, 192));
		levelIconView_12.getStarOneLabel().setIcon(null);
		levelIconView_12.getStarTwoLabel().setIcon(null);
		levelIconView_12.getStarThreeLabel().setIcon(null);
		levelIconView_12.getLevelNameLabel().setText("Tom Brady");
		levelsPanel.add(levelIconView_12);
		LevelIconView levelIconView_13 = new LevelIconView();
		levelIconView_13.getHighScoreLabel().setText("");
		levelIconView_13.setBackground(new Color(192, 192, 192));
		levelIconView_13.getStarOneLabel().setIcon(null);
		levelIconView_13.getStarTwoLabel().setIcon(null);
		levelIconView_13.getStarThreeLabel().setIcon(null);
		levelIconView_13.getLevelNameLabel().setText("Trumped");
		levelsPanel.add(levelIconView_13);
		LevelIconView levelIconView_14 = new LevelIconView();
		levelIconView_14.getHighScoreLabel().setText("");
		levelIconView_14.setBackground(new Color(192, 192, 192));
		levelIconView_14.getStarOneLabel().setIcon(null);
		levelIconView_14.getStarTwoLabel().setIcon(null);
		levelIconView_14.getStarThreeLabel().setIcon(null);
		levelIconView_14.getLevelNameLabel().setText("Not Done Yet");
		levelsPanel.add(levelIconView_14);
		

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(levelsPanel);
		add(scrollPane, BorderLayout.CENTER);
		
    }
    
 
}