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
import scandium.common.model.LightningLevel;
import scandium.common.model.ThemeLevel;
import scandium.common.tool.LevelRestrictor;
import scandium.lettercraze.model.LevelProgress;
import scandium.levelbuilder.view.BoardView;

import javax.swing.Box;
import javax.swing.border.EmptyBorder;
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
	private Box undoButtonBox;
	private JButton undoButton;
	private Box starBox;
	private Box scoreBox;
	private JLabel scoreValueLabel;
	private Box nextStarBox;
	private JLabel nextStarValueLabel;
	private Box restrictorBox;
	private JLabel restrictorLabel;
	private JLabel restrictorValueLabel;
	private Box themeWordBox;
	private JLabel themeWordValueLabel;
	private JScrollPane foundWordsScrollPane;
	private JLabel foundWordsLabel;
	private JList<String> foundWordsList;
	private DefaultListModel<String> foundWordsListModel;
	private BoardView boardView;

	/**
	 * Creates a new view for the Level Player screen.
	 * 
	 * @param progress
	 *            The level progress which will hold information about the player's progress.
	 */
	public LevelPlayerView(LevelProgress progress) {
		this.progress = progress;
		initialize();
		refresh();
	}

	/**
	 * @return the level Progress associated with this level
	 */
	public LevelProgress getLevelProgress() {
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
	 * @return the undoButtonBox
	 */
	public Box getUndoButtonBox() {
		return undoButtonBox;
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
	 * @return the restrictor box
	 */
	public Box getRestrictorBox() {
		return restrictorBox;
	}

	/**
	 * @return the restrictor label
	 */
	public JLabel getRestrictorLabel() {
		return restrictorLabel;
	}
	
	/**
	 * @return the restrictor value label
	 */
	public JLabel getRestrictorValueLabel() {
		return restrictorValueLabel;
	}

	/**
	 * @return the themeWordBox
	 */
	public Box getThemeWordBox() {
		return themeWordBox;
	}

	/**
	 * @return the themeWordValueLabel
	 */
	public JLabel getThemeWordValueLabel() {
		return themeWordValueLabel;
	}

	/**
	 * @return the levelNameLabel
	 */
	public JLabel getLevelNameLabel() {
		return levelNameLabel;
	}

	/**
	 * @param index The index of the star label to get.
	 * @return The star label at the given index.
	 */
	public JLabel getStarLabel(int index) {
		return (JLabel) starBox.getComponent(index);
	}

	/**
	 * @return the scoreValueLabel
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
	 * @return the star box for this view
	 */
	public Box getStarBox() {
		return starBox;
	}
	
	/**
	 * @return the score box for this view
	 */
	public Box getScoreBox() {
		return scoreBox;
	}
	
	/**
	 * @return the next star box for this view
	 */
	public Box getNextStarBox() {
		return nextStarBox;
	}
	
	/**
	 * @return the next star's value label for this level
	 */
	public JLabel getNextStarValueLabel() {
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
	
	public JScrollPane getFoundWordsScrollPane(){
		return foundWordsScrollPane;
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
		Dimension buttonSize = new Dimension(100, 40);
		
		// leave button
		leaveButton = new JButton("Leave");
		leaveButton.setPreferredSize(buttonSize);
		leaveButton.setMaximumSize(buttonSize);
		leaveButton.setFont(leaveButton.getFont().deriveFont(leaveButton.getFont().getSize() + 10f));
		buttonsBox.add(leaveButton);

		buttonsBox.add(Box.createRigidArea(new Dimension(20, 20)));
		// reset button
		resetButton = new JButton("Reset");
		resetButton.setPreferredSize(buttonSize);
		resetButton.setMaximumSize(buttonSize);
		resetButton.setFont(resetButton.getFont().deriveFont(resetButton.getFont().getSize() + 10f));
		buttonsBox.add(resetButton);

		undoButtonBox = Box.createHorizontalBox();
		undoButtonBox.add(Box.createRigidArea(new Dimension(20, 20)));
		// undo button
		undoButton = new JButton("Undo");
		undoButton.setPreferredSize(buttonSize);
		undoButton.setMaximumSize(buttonSize);
		undoButton.setFont(undoButton.getFont().deriveFont(undoButton.getFont().getSize() + 10f));
		undoButtonBox.add(undoButton);
		buttonsBox.add(undoButtonBox);

		infoPanel.add(buttonsBox);

		// set up the stars
		starBox = Box.createHorizontalBox();
		for (int i = 0; i < 3; i++) {
			starBox.add(new JLabel());
		}
		infoPanel.add(starBox);

		// set up next star score
		scoreBox = createLabelValueBox("Score", true);
		scoreValueLabel = (JLabel) scoreBox.getComponent(2);
		infoPanel.add(scoreBox);
		
		// set up next star score
		nextStarBox = createLabelValueBox("Next Star", true);
		nextStarValueLabel = (JLabel) nextStarBox.getComponent(2);
		infoPanel.add(nextStarBox);

		// set up the restrictor information
		restrictorBox = createLabelValueBox(null, true);
		restrictorLabel = (JLabel) restrictorBox.getComponent(0);
		restrictorValueLabel = (JLabel) restrictorBox.getComponent(2);
		infoPanel.add(restrictorBox);

		// set up theme word
		themeWordBox = createLabelValueBox("Theme", false);
		themeWordValueLabel = (JLabel) themeWordBox.getComponent(2);
		infoPanel.add(themeWordBox);
		
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
	 * Creates a box which holds a label and its value. The caller can retrieve
	 * the labels by getting the first and third components in the box.
	 * 
	 * @param labelText
	 *            The text that the label should have.
	 * @param visible
	 *            Whether the box should be initially visible.
	 * @return The created box with the given specifications.
	 */
	private Box createLabelValueBox(String labelText, boolean visible) {
		// create the box
		Box box = Box.createHorizontalBox();
		box.setBorder(new EmptyBorder(7, 7, 7, 7));
		
		// create the label
		JLabel label = new JLabel(labelText + ":");
		label.setFont(label.getFont().deriveFont(label.getFont().getSize() + 15f));
		box.add(label);

		// add a spacer between the label and value
		box.add(Box.createRigidArea(new Dimension(20, 20)));
		
		// create the value
		JLabel value = new JLabel();
		value.setFont(value.getFont().deriveFont(value.getFont().getSize() + 15f));
		box.add(value);
		box.setVisible(visible);
		return box;
	}

	/**
	 * Refreshes the data of the level player from the model.
	 */
	public void refresh() {
		Level level = progress.getLevel();
		if (level != null) {
			// disable the undo and reset buttons if the level is over
			undoButton.setEnabled(progress.isPlaying());
			resetButton.setEnabled(progress.isPlaying());
			
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
				int nextThreshold = level.getStars()[progress.getStarCount()].getThreshold();
				nextStarValueLabel.setText(nextThreshold + " " + level.getScoreUnits(nextThreshold != 1));
			} else
				nextStarBox.setVisible(false);

			// update found words
			if (foundWordsListModel.size() != progress.getFoundWords().size()) {
				foundWordsListModel.removeAllElements();
				int i = 1;
				for (String word : progress.getFoundWords())
					foundWordsListModel.addElement((i++) + ". " + word);
				if (progress.getFoundWords().size() == 0)
					foundWordsLabel.setText("Found Words"); 
				else
					foundWordsLabel.setText("Found Words (" + progress.getFoundWords().size() + ")"); 
			}
			
			// show the restrictor value
			LevelRestrictor restrictor = progress.getRestrictor();
			restrictorLabel.setText(restrictor.getLabel() + ":");
			restrictorValueLabel.setText(restrictor.getValue() + " " + restrictor.getValueUnit());
			
			// hide the level specific attributes
			themeWordBox.setVisible(false);
			undoButtonBox.setVisible(true);
			
			if (level instanceof ThemeLevel) {
				// update the theme word
				themeWordValueLabel.setText(((ThemeLevel) level).getTheme());
				themeWordBox.setVisible(true);
			} else if (level instanceof LightningLevel) {
				// hide the undo button
				undoButtonBox.setVisible(false);
			}
			
			// update the board
			boardView.refresh();
			repaint();
		}
	}
}