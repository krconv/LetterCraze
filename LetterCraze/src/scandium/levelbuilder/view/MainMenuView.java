/**
 * MainMenuView.java
 * 
 * @author Scandium
 */
package scandium.levelbuilder.view;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import scandium.lettercraze.model.Model;
import scandium.lettercraze.view.LevelIconView;

/**
 * The view for the main menu screen.
 */
public class MainMenuView extends JPanel {
	private static final long serialVersionUID = -61817840340352865L;
	private Model model;
	private ArrayList<LevelIconView> levelIconViews;
	private JLabel titleLabel;
	private JButton newButton;
	private JButton editButton;
	private JButton deleteButton;

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
	 * @return the newButton
	 */
	public JButton getNewButton() {
		return newButton;
	}

	/**
	 * @return the editButton
	 */
	public JButton getEditButton() {
		return editButton;
	}

	/**
	 * @return the deleteButton
	 */
	public JButton getDeleteButton() {
		return deleteButton;
	}

	/**
     * Initializes the view.
     */
    private void initialize() {
        // TODO implement here
    }

}