/**
 * LevelIconView.java
 * 
 * @author Scandium
 */
package scandium.levelbuilder.view;

import javax.swing.JLabel;
import javax.swing.JPanel;

import scandium.common.model.Level;

/**
 * The icon view of a Level, which shows it's name.
 */
public class LevelIconView extends JPanel {
	private static final long serialVersionUID = -5714193539673524092L;
	private Level model;
	private JLabel levelNameLabel;

    /**
     * Creates a new level view.
     * @param model The model of the view.
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
     * Initializes the view.
     */
    private void initialize() {
        // TODO implement here
    }
}