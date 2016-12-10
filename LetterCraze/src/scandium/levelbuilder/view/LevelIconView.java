/**
 * LevelIconView.java
 * 
 * @author Scandium
 */
package scandium.levelbuilder.view;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

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
		levelNameLabel = new JLabel(level.getName());
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
