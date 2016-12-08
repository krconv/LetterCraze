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
import scandium.lettercraze.model.LevelProgress;

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.border.EmptyBorder;
import java.awt.Color;

/**
 * The icon view of a Level, which shows it's progress and state.
 */
public class LevelIconView extends JPanel {
	private static final long serialVersionUID = -5714193539673524092L;
	private LevelProgress progress;
	private JLabel levelNameLabel;
	private JLabel highScoreLabel;
	private Box starBox;

	/**
	 * Creates a new level view.
	 * 
	 * @param progress
	 *            The progress of the level.
	 */
	public LevelIconView(LevelProgress progress) {
		this.progress = progress;
		initialize();
		refresh();
	}

	/**
	 * @return the model
	 */
	public LevelProgress getModel() {
		return progress;
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
	public JLabel getStarLabel(int index) {
		return (JLabel) starBox.getComponent(index);
	}

	/**
	 * Initializes the view.
	 */
	private void initialize() {
		setPreferredSize(new Dimension(300, 130));
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBorder(new EmptyBorder(10, 10, 10, 10));

		// add the name label
		levelNameLabel = new JLabel();
		levelNameLabel.setForeground(new Color(0, 0, 0));
		levelNameLabel.setFont(levelNameLabel.getFont().deriveFont(levelNameLabel.getFont().getStyle() | Font.BOLD, levelNameLabel.getFont().getSize() + 20f));
		levelNameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		levelNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		levelNameLabel.setPreferredSize(new Dimension(250, 35));
		levelNameLabel.setMaximumSize(new Dimension(300, 35));
		add(levelNameLabel);

		// add the stars
		starBox = Box.createHorizontalBox();
		for (int i = 0; i < 3; i++) {
			starBox.add(new JLabel());
		}
		add(starBox);

		// add the high score label
		highScoreLabel = new JLabel();
		highScoreLabel.setForeground(new Color(0, 0, 0));
		highScoreLabel.setFont(highScoreLabel.getFont().deriveFont(highScoreLabel.getFont().getSize() + 6f));
		highScoreLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		highScoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
		add(highScoreLabel);
	}
	
	/**
	 * @param level
	 *            The level to calculate using
	 * @return the background color for the given level 
	 */
	private static Color getBackgroundColorForLevel(Level level) {
		switch (level.getType().toLowerCase()) {
		case "puzzle":
			return Color.RED;
		case "lightning":
			return Color.MAGENTA;
		case "theme":
			return Color.GREEN;
		default:
			return Color.BLACK;
		}
	}
	
	/**
	 * Refreshes the data of the level icon from the model.
	 */
	public void refresh() {
		// update the level name
		levelNameLabel.setText(progress.getLevel().getName());
		if (progress.isUnlocked()) {
			// update the background
			setBackground(getBackgroundColorForLevel(progress.getLevel()));
			// update the star icons
			starBox.setVisible(true);
			for (int i = 0; i < 3; i++) {
				if (progress.getStarCount() > i)
					getStarLabel(i).setIcon(
						new ImageIcon(LevelIconView.class.getResource("/scandium/lettercraze/resources/star-icon-on.png")));
				else
					getStarLabel(i).setIcon(
							new ImageIcon(LevelIconView.class.getResource("/scandium/lettercraze/resources/star-icon-off.png")));
			}
			// update the high score label
			highScoreLabel.setVisible(true);
			highScoreLabel.setText(progress.getScore() + " " + progress.getLevel().getScoreUnits(progress.getScore() != 1));
		} else {
			// level is locked so hide everything and make it gray
			setBackground(Color.GRAY);
			starBox.setVisible(false);
			highScoreLabel.setVisible(false);;
		}
	}
}