/**
 * LevelEditor.java
 * 
 * @author Scandium
 */
package scandium.levelbuilder.view;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import scandium.common.view.BoardView;
import scandium.levelbuilder.model.Model;

/**
 * The view for the Level Editor screen. 
 */
public class LevelEditorView extends JPanel {
	private static final long serialVersionUID = -719968016048370087L;
	private Model model;
	private JLabel titleLabel;
	private BoardView boardView;
	private ButtonGroup gravityButtonGroup;
	private ButtonGroup levelButtonGroup;
	private JButton puzzleButton;
	private JButton lightningButton;
	private JButton themeButton;
	private JRadioButton gravityUpButton;
	private JRadioButton gravityRightButton;
	private JRadioButton gravityDownButton;
	private JRadioButton gravityLeftButton;
	private JButton saveButton;
	private JButton previewButton;
	private JButton mainMenuButton;
	private JTextField levelNameTextField;
	private JTextField maxNumWordsTextField;
	private JTextField[] starThresholdTextFields;
	private JTextField timeLimitTextField;
	private JTextField themeTextField;
	private JTextArea themeWordsTextArea;

    /**
     * Creates a new view for the Level Editor screen.
     * @param model The model.
     */
    public LevelEditorView(Model model) {
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
	 * @return the titleLabel
	 */
	public JLabel getTitleLabel() {
		return titleLabel;
	}

	/**
	 * @return the boardView
	 */
	public BoardView getBoardView() {
		return boardView;
	}

	/**
	 * @return the gravityButtonGroup
	 */
	public ButtonGroup getGravityButtonGroup() {
		return gravityButtonGroup;
	}

	/**
	 * @return the levelButtonGroup
	 */
	public ButtonGroup getLevelButtonGroup() {
		return levelButtonGroup;
	}

	/**
	 * @return the puzzleButton
	 */
	public JButton getPuzzleButton() {
		return puzzleButton;
	}

	/**
	 * @return the lightningButton
	 */
	public JButton getLightningButton() {
		return lightningButton;
	}

	/**
	 * @return the themeButton
	 */
	public JButton getThemeButton() {
		return themeButton;
	}

	/**
	 * @return the gravityUpButton
	 */
	public JRadioButton getGravityUpButton() {
		return gravityUpButton;
	}

	/**
	 * @return the gravityRightButton
	 */
	public JRadioButton getGravityRightButton() {
		return gravityRightButton;
	}

	/**
	 * @return the gravityDownButton
	 */
	public JRadioButton getGravityDownButton() {
		return gravityDownButton;
	}

	/**
	 * @return the gravityLeftButton
	 */
	public JRadioButton getGravityLeftButton() {
		return gravityLeftButton;
	}

	/**
	 * @return the saveButton
	 */
	public JButton getSaveButton() {
		return saveButton;
	}

	/**
	 * @return the previewButton
	 */
	public JButton getPreviewButton() {
		return previewButton;
	}

	/**
	 * @return the mainMenuButton
	 */
	public JButton getMainMenuButton() {
		return mainMenuButton;
	}

	/**
	 * @return the levelNameTextField
	 */
	public JTextField getLevelNameTextField() {
		return levelNameTextField;
	}

	/**
	 * @return the maxNumWordsTextField
	 */
	public JTextField getMaxNumWordsTextField() {
		return maxNumWordsTextField;
	}

	/**
	 * @return the starThresholdTextFields
	 */
	public JTextField[] getStarThresholdTextFields() {
		return starThresholdTextFields;
	}

	/**
	 * @return the timeLimitTextField
	 */
	public JTextField getTimeLimitTextField() {
		return timeLimitTextField;
	}

	/**
	 * @return the themeTextField
	 */
	public JTextField getThemeTextField() {
		return themeTextField;
	}

	/**
	 * @return the themeWordsTextArea
	 */
	public JTextArea getThemeWordsTextArea() {
		return themeWordsTextArea;
	}

	/**
     * Initializes the view.
     */
    private void initialize() {
        // TODO implement here
    }
}