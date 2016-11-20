/**
 * LevelPlayerView.java
 * 
 * @author Scandium
 */
package scandium.lettercraze.view;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import scandium.common.view.BoardView;
import scandium.lettercraze.model.Model;

/**
 * The view for the Level Player screen. 
 */
public class LevelPlayerView extends JPanel {
	private static final long serialVersionUID = 2542897782615081218L;
	private Model model;
	private JButton leaveButton;
	private JButton resetButton;
	private JButton undoButton;
	private BoardView boardView;
	private JLabel maxNumWordsLabel;
	private JLabel timerLabel;
	private JLabel themeLabel;
	private JLabel levelNameLabel;
	private JLabel[] starLabels;
	private JLabel scoreLabel;
	private JLabel starThresholdLabel;
	private JLabel foundWordsLabel;


    /**
     * Creates a new view for the Level Player screen.
     * @param model The model.
     */
    public LevelPlayerView(Model model) {
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
	 * @return the leaveButton
	 */
	public JButton getLeaveButton() {
		return leaveButton;
	}

	/**
	 * @return the resetButton
	 */
	public JButton getResetButton() {
		return resetButton;
	}

	/**
	 * @return the undoButton
	 */
	public JButton getUndoButton() {
		return undoButton;
	}

	/**
	 * @return the boardView
	 */
	public BoardView getBoardView() {
		return boardView;
	}

	/**
	 * @return the maxNumWordsLabel
	 */
	public JLabel getMaxNumWordsLabel() {
		return maxNumWordsLabel;
	}

	/**
	 * @return the timerLabel
	 */
	public JLabel getTimerLabel() {
		return timerLabel;
	}

	/**
	 * @return the themeLabel
	 */
	public JLabel getThemeLabel() {
		return themeLabel;
	}

	/**
	 * @return the levelNameLabel
	 */
	public JLabel getLevelNameLabel() {
		return levelNameLabel;
	}

	/**
	 * @return the starLabels
	 */
	public JLabel[] getStarLabels() {
		return starLabels;
	}

	/**
	 * @return the scoreLabel
	 */
	public JLabel getScoreLabel() {
		return scoreLabel;
	}

	/**
	 * @return the starThresholdLabel
	 */
	public JLabel getStarThresholdLabel() {
		return starThresholdLabel;
	}

	/**
	 * @return the foundWordsLabel
	 */
	public JLabel getFoundWordsLabel() {
		return foundWordsLabel;
	}

	/**
     * Initializes the view.
     */
    private void initialize() {
        // TODO implement here
    }
}