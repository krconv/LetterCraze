/**
 * LevelPlayerView.java
 * 
 * @author Scandium
 */
package scandium.lettercraze.view;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import scandium.common.model.Level;
import scandium.common.model.PuzzleLevel;
import scandium.lettercraze.model.LevelProgress;
import javax.swing.Box;
import javax.swing.border.EmptyBorder;
import java.awt.Component;
import java.awt.Color;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JList;


/**
 * The view for the Level Player screen.
 */
public class LevelPlayerView extends JPanel {
	private static final long serialVersionUID = 2542897782615081218L;
	private LevelProgress progress;
	private JLabel levelNameLabel;
	private JPanel infoPanel;
	private Box buttonsBox;
	private JButton leaveButton;
	private JButton resetButton;
	private JButton undoButton;
	private Box starBox;
	private Box scoreBox;
	private JLabel scoreLabel;
	private JLabel scoreValueLabel;
	private Box nextStarBox;
	private JLabel nextStarLabel;
	private JLabel nextStarValueLabel;
	private Box maxNumWordsBox;
	private JLabel maxNumWordsLabel;
	private JLabel maxNumWordsValueLabel;
	private JScrollPane foundWordsScrollPane;
	private JLabel foundWordsLabel;
	private JList<String> foundWordsList;
	private DefaultListModel<String> foundWordsListModel;
	private BoardView boardView;

	/**
	 * Creates a new view for the Level Player screen.
	 * 
	 * @param model
	 *            The model.
	 */
	public LevelPlayerView(LevelProgress progress) {
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
	 * @return the maxNumWordsValueLabel
	 */
	public JLabel getMaxNumWordsValueLabel(){
		return maxNumWordsValueLabel;
	}
	
	/**
	 * @return the timerLabel
	 */
	public JLabel getTimerLabel() {
		return null;
	}

	/**
	 * @return the themeLabel
	 */
	public JLabel getThemeLabel() {
		return null;
	}

	/**
	 * @return the levelNameLabel
	 */
	public JLabel getLevelNameLabel() {
		return levelNameLabel;
	}

	/**
	 * @return the starOneLabel
	 */
	public JLabel getStarLabel(int index) {
		return (JLabel) starBox.getComponent(index);
	}

	/**
	 * @return the scoreLabel
	 */
	public JLabel getScoreLabel() {
		return scoreLabel;
	}
	
	/**
	 * @return the scoreValueLabel
	 * @return
	 */
	public JLabel getScoreValueLabel(){
		return scoreValueLabel;
	}

	/**
	 * @return the starThresholdLabel
	 */
	public JLabel getStarThresholdLabel() {
		return nextStarValueLabel;
	}

	/**
	 * @return the foundWordsLabel
	 */
	public JLabel getFoundWordsLabel() {
		return foundWordsLabel;
	}

	/**
	 * @return the foundWordsListModel
	 */
	public DefaultListModel<String> getFoundWordsListModel(){
		return foundWordsListModel;
	}
	
	/**
	 * Initializes the view.
	 */
	private void initialize() {
		setBackground(new Color(0, 191, 255));
		setBorder(new EmptyBorder(20, 20, 20, 20));
		setLayout(new BorderLayout(0, 0));

		// add the level name label
		levelNameLabel = new JLabel();
		levelNameLabel.setForeground(Color.BLACK);
		levelNameLabel.setFont(levelNameLabel.getFont().deriveFont(levelNameLabel.getFont().getSize() + 50f));
		add(levelNameLabel, BorderLayout.NORTH);

		// add the info panel
		infoPanel = new JPanel();
		infoPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
		infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));
		infoPanel.setOpaque(false);

		// set up the buttons
		buttonsBox = Box.createHorizontalBox();
		buttonsBox.setBorder(new EmptyBorder(10, 10, 10, 10));
		// leave button
		leaveButton = new JButton("Leave");
		leaveButton.setFont(leaveButton.getFont().deriveFont(leaveButton.getFont().getSize() + 10f));
		buttonsBox.add(leaveButton);

		buttonsBox.add(Box.createRigidArea(new Dimension(20, 20)));
		// reset button
		resetButton = new JButton("Reset");
		resetButton.setFont(resetButton.getFont().deriveFont(resetButton.getFont().getSize() + 10f));
		buttonsBox.add(resetButton);

		buttonsBox.add(Box.createRigidArea(new Dimension(20, 20)));
		// undo button
		undoButton = new JButton("Undo");
		undoButton.setFont(undoButton.getFont().deriveFont(undoButton.getFont().getSize() + 10f));
		buttonsBox.add(undoButton);

		infoPanel.add(buttonsBox);

		// set up the stars
		starBox = Box.createHorizontalBox();
		for (int i = 0; i < 3; i++) {
			starBox.add(new JLabel());
		}
		infoPanel.add(starBox);

		// set up the score
		scoreBox = Box.createHorizontalBox();
		scoreBox.setBorder(new EmptyBorder(7, 7, 7, 7));
		// the label for the score
		scoreLabel = new JLabel("Score:");
		scoreLabel.setFont(scoreLabel.getFont().deriveFont(scoreLabel.getFont().getSize() + 15f));
		scoreLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		scoreBox.add(scoreLabel);

		scoreBox.add(Box.createRigidArea(new Dimension(20, 20)));
		// the value for the score
		scoreValueLabel = new JLabel();
		scoreValueLabel.setFont(scoreValueLabel.getFont().deriveFont(scoreValueLabel.getFont().getSize() + 15f));
		scoreValueLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		scoreBox.add(scoreValueLabel);
		infoPanel.add(scoreBox);

		// set up next star score
		nextStarBox = Box.createHorizontalBox();
		// the label for the next star
		nextStarLabel = new JLabel("Next Star:");
		nextStarLabel.setFont(nextStarLabel.getFont().deriveFont(nextStarLabel.getFont().getSize() + 15f));
		nextStarLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		nextStarBox.add(nextStarLabel);

		nextStarBox.add(Box.createRigidArea(new Dimension(20, 20)));
		// the value for the next star
		nextStarValueLabel = new JLabel();
		nextStarValueLabel
				.setFont(nextStarValueLabel.getFont().deriveFont(nextStarValueLabel.getFont().getSize() + 15f));
		nextStarValueLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		nextStarBox.add(nextStarValueLabel);

		// set up max number of words
		maxNumWordsBox = Box.createHorizontalBox();
		maxNumWordsBox.setBorder(new EmptyBorder(7, 7, 7, 7));
		// label for max number of words
		maxNumWordsLabel = new JLabel("Max Number of Words:");
		maxNumWordsLabel.setFont(maxNumWordsLabel.getFont().deriveFont(maxNumWordsLabel.getFont().getSize() + 15f));
		maxNumWordsBox.add(maxNumWordsLabel);

		maxNumWordsBox.add(Box.createRigidArea(new Dimension(20, 20)));
		// value for the max number of words
		maxNumWordsValueLabel = new JLabel();
		maxNumWordsValueLabel
				.setFont(maxNumWordsValueLabel.getFont().deriveFont(maxNumWordsValueLabel.getFont().getSize() + 15f));
		maxNumWordsBox.add(maxNumWordsValueLabel);
		maxNumWordsBox.setVisible(false);
		infoPanel.add(maxNumWordsBox);

		// set up the scroll pane for found words
		foundWordsScrollPane = new JScrollPane();
		foundWordsScrollPane.setBorder(new EmptyBorder(7, 7, 7, 7));
		foundWordsScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		// the title for the scroll pane
		foundWordsLabel = new JLabel("Found Words");
		foundWordsLabel.setBorder(new EmptyBorder(5, 5, 5, 5));
		foundWordsLabel.setFont(foundWordsLabel.getFont().deriveFont(foundWordsLabel.getFont().getSize() + 15f));
		foundWordsScrollPane.setColumnHeaderView(foundWordsLabel);
		// the data for the scroll pane
		foundWordsList = new JList<String>();
		foundWordsList.setFont(foundWordsList.getFont().deriveFont(foundWordsList.getFont().getSize() + 10f));
		foundWordsListModel = new DefaultListModel<String>();
		foundWordsList.setModel(foundWordsListModel);
		foundWordsScrollPane.setViewportView(foundWordsList);
		infoPanel.add(foundWordsScrollPane);
		add(infoPanel, BorderLayout.WEST);

		// add the board view
		boardView = new BoardView(progress);
		boardView.setBorder(new EmptyBorder(10, 10, 10, 10));
		boardView.setPreferredSize(new Dimension(750, 750));
		add(boardView, BorderLayout.CENTER);
	}

	/**
	 * Refreshes the data of the level player from the model.
	 */
	public void refresh() {
		Level level = progress.getLevel();
		if (level != null) {
			// update the level name
			levelNameLabel.setText(level.getName());
			
			// update the star icons
			for (int i = 0; i < 3; i++) {
				if (progress.getStarCount() > i) // this star is on
					getStarLabel(i).setIcon(
						new ImageIcon(LevelIconView.class.getResource("/scandium/lettercraze/resources/star-icon-on.png")));
				else // this star is off
					getStarLabel(i).setIcon(
							new ImageIcon(LevelIconView.class.getResource("/scandium/lettercraze/resources/star-icon-off.png")));
			}
			
			// update the current score
			scoreValueLabel.setText(progress.getScore() + " " + level.getScoreUnits(progress.getScore() != 1));

			// update the next star score
			if (progress.getStarCount() < 3) {
				nextStarBox.setVisible(true);
				nextStarValueLabel.setText(level.getStars()[progress.getStarCount()] + " " + level.getScoreUnits(progress.getScore() != 1));
			} else
				nextStarBox.setVisible(false);

			// update found words
			if (foundWordsListModel.size() != progress.getFoundWords().size()) {
				foundWordsListModel.removeAllElements();
				for (String word : progress.getFoundWords())
					foundWordsListModel.addElement(word);
			}
			
			// hide the level specific attributes
			maxNumWordsBox.setVisible(false);
			
			// update the level specific attributes
			if (level instanceof PuzzleLevel) {
				// update max num words
				maxNumWordsValueLabel.setText("" + ((PuzzleLevel) level).getMaxNumWords());
				maxNumWordsBox.setVisible(true);
			}
			
			// update the board
			boardView.refresh();
		}
	}
}