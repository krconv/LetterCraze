/**
 * LevelIconView.java
 * 
 * @author Scandium
 */
package scandium.lettercraze.view;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import scandium.common.model.Level;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import javax.swing.border.EmptyBorder;
import java.awt.Color;

/**
 * The icon view of a Level, which shows it's progress and state.
 */
public class LevelIconView extends JPanel {
	private static final long serialVersionUID = -5714193539673524092L;
	private Level model;
	private JLabel levelNameLabel;
	private JLabel highScoreLabel;
	private Box starBox;
	private JLabel starOneLabel;
	private JLabel starTwoLabel;
	private JLabel starThreeLabel;

	/**
	 * Creates a new level view without a model.
	 */
	public LevelIconView() {
		initialize();
	}

	/**
	 * Creates a new level view.
	 * 
	 * @param model
	 *            The model of the view.
	 */
	public void LevelView(Level model) {
		this.model = model;
		initialize();
	}

	/**
	 * @return the model
	 */
	public Level getModel() {
		return model;
	}

	/**
	 * @return the levelNameLabel
	 */
	public JLabel getLevelNameLabel() {
		return levelNameLabel;
	}

	/**
	 * @return the highScoreLabel
	 */
	public JLabel getHighScoreLabel() {
		return highScoreLabel;
	}	

	/**
	 * @return the starOneLabel
	 */
	public JLabel getStarOneLabel() {
		return starOneLabel;
	}

	/**
	 * @return the starTwoLabel
	 */
	public JLabel getStarTwoLabel() {
		return starTwoLabel;
	}

	/**
	 * @return the starThreeLabel
	 */
	public JLabel getStarThreeLabel() {
		return starThreeLabel;
	}

	/**
	 * Initializes the view.
	 */
	private void initialize() {
		setPreferredSize(new Dimension(300, 130));
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBorder(new EmptyBorder(10, 10, 10, 10));

		levelNameLabel = new JLabel("Level 1", SwingConstants.CENTER);
		levelNameLabel.setForeground(new Color(0, 0, 0));
		levelNameLabel.setBackground(SystemColor.activeCaption);
		levelNameLabel.setFont(levelNameLabel.getFont().deriveFont(levelNameLabel.getFont().getStyle() | Font.BOLD, levelNameLabel.getFont().getSize() + 20f));
		levelNameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		levelNameLabel.setPreferredSize(new Dimension(250, 35));
		levelNameLabel.setMaximumSize(new Dimension(300, 35));
		add(levelNameLabel);

		starBox = Box.createHorizontalBox();
		add(starBox);

		starOneLabel = new JLabel();
		starOneLabel.setIcon(
				new ImageIcon(LevelIconView.class.getResource("/scandium/lettercraze/resources/star-icon-on.png")));
		starBox.add(starOneLabel);

		starTwoLabel = new JLabel();
		starTwoLabel.setIcon(
				new ImageIcon(LevelIconView.class.getResource("/scandium/lettercraze/resources/star-icon-on.png")));
		starBox.add(starTwoLabel);

		starThreeLabel = new JLabel();
		starThreeLabel.setIcon(
				new ImageIcon(LevelIconView.class.getResource("/scandium/lettercraze/resources/star-icon-on.png")));
		starBox.add(starThreeLabel);

		highScoreLabel = new JLabel("100 pts");
		highScoreLabel.setForeground(new Color(0, 0, 0));
		highScoreLabel.setFont(highScoreLabel.getFont().deriveFont(highScoreLabel.getFont().getSize() + 6f));
		highScoreLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(highScoreLabel);
	}
}