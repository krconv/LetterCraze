/**
 * LevelIconView.java
 * 
 * @author Scandium
 */
package scandium.levelbuilder.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import scandium.common.model.Level;

/**
 * The icon view of a Level, which shows its name and the correct background color for its level type.
 */
public class LevelIconView extends JPanel {
	private static final long serialVersionUID = -5714193539673524092L;
	private Level level;
	private JLabel levelNameLabel;

	/**
	 * Creates a new level icon view.
	 * @param l The level related to this LevelViewIcon.
	 */
	public LevelIconView(Level l) {
		this.level = l;
		initialize();
		refresh();
	}

	/**
	 * Returns the level associated with the level icon view.
	 * @return the model
	 */
	public Level getLevel() {
		return level;
	}

	/**
	 * Returns the Level Name Label.
	 * @return the levelNameLabel
	 */
	public JLabel getLevelNameLabel() {
		return levelNameLabel;
	}


	/**
	 * Returns the correct background color for the level icon view.
	 * @param level the level that is linked to this LevelIconView
	 * @return the color that the LevelIconView should be based upon the type of the level
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
	 * Initializes the level icon view.
	 */
	private void initialize() {
		setPreferredSize(new Dimension(300, 130));
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBorder(new EmptyBorder(10, 10, 10, 10));

		// add the name label
		levelNameLabel = new JLabel(level.getName());
		levelNameLabel.setForeground(new Color(0, 0, 0));
		levelNameLabel.setFont(levelNameLabel.getFont().deriveFont(levelNameLabel.getFont().getStyle() | Font.BOLD, levelNameLabel.getFont().getSize() + 20f));
		levelNameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		levelNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		levelNameLabel.setPreferredSize(new Dimension(250, 35));
		levelNameLabel.setMaximumSize(new Dimension(300, 35));
		add(levelNameLabel);
	}

	/**
	 * Refreshes the data of the level icon view from the model.
	 */
	public void refresh(){
		// update the level name
		levelNameLabel.setText(getLevel().getName());
		setBackground(getBackgroundColorForLevel(level));
		repaint();
	}
}
