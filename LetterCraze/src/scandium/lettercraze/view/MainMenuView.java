/**
 * MainMenuView.java
 * 
 * @author Scandium
 */
package scandium.lettercraze.view;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;

import scandium.lettercraze.model.Model;

/**
 * The view for the main menu screen.
 */
public class MainMenuView {
	private Model model;
	private ArrayList<LevelIconView> levelIconViews;
	private JLabel titleLabel;
	private JButton resetButton;

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
        // TODO implement here
    }
}