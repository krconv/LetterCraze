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

import scandium.lettercraze.model.Model;
import javax.swing.Box;
import javax.swing.border.EmptyBorder;
import java.awt.Component;
import java.awt.Color;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JList;
import javax.swing.AbstractListModel;

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
	private JLabel[] starLabels;
	private JLabel scoreLabel;
	private JLabel starThresholdLabel;
	private JLabel foundWordsLabel;
	private Box horizontalBox;
	private JButton btnLeave;
	private JButton btnResetBoard;
	private JButton btnUndo;
	private Component rigidArea;
	private Component rigidArea_1;
	private JLabel levelNameLabel;
	private Box horizontalBox_1;
	private Box horizontalBox_2;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;
	private JLabel label_5;
	private Box verticalBox;
	private JLabel lblScore;
	private JLabel lblPts;
	private JLabel lblNextStar;
	private JLabel lblPts_1;
	private Box horizontalBox_3;
	private Box horizontalBox_4;
	private Component rigidArea_2;
	private Component rigidArea_3;
	private Box horizontalBox_5;
	private Component rigidArea_4;
	private JScrollPane scrollPane;
	private JLabel lblFoundWords;
	private JList<String> list;


    /**
     * Creates a new view for the Level Player screen.
     * @param model The model.
     */
    public LevelPlayerView(Model model) {
    	setBackground(new Color(0, 191, 255));
    	setBorder(new EmptyBorder(20, 20, 20, 20));
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
    	setLayout(new BorderLayout(0, 0));
    	
    	levelNameLabel = new JLabel("Puzzled");
    	levelNameLabel.setForeground(Color.BLACK);
    	levelNameLabel.setFont(levelNameLabel.getFont().deriveFont(levelNameLabel.getFont().getSize() + 50f));
    	add(levelNameLabel, BorderLayout.NORTH);
    	
    	JPanel panel_1 = new JPanel();
    	panel_1.setBorder(new EmptyBorder(10, 10, 10, 10));
    	panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.Y_AXIS));
    	panel_1.setOpaque(false);
    	
    	horizontalBox = Box.createHorizontalBox();
    	horizontalBox.setBorder(new EmptyBorder(10, 10, 10, 10));
    	panel_1.add(horizontalBox);
    	
    	btnLeave = new JButton("Leave");
    	btnLeave.setFont(btnLeave.getFont().deriveFont(btnLeave.getFont().getSize() + 10f));
    	horizontalBox.add(btnLeave);
    	
    	rigidArea_1 = Box.createRigidArea(new Dimension(20, 20));
    	horizontalBox.add(rigidArea_1);
    	
    	btnResetBoard = new JButton("Reset");
    	btnResetBoard.setFont(btnResetBoard.getFont().deriveFont(btnResetBoard.getFont().getSize() + 10f));
    	horizontalBox.add(btnResetBoard);
    	
    	rigidArea = Box.createRigidArea(new Dimension(20, 20));
    	horizontalBox.add(rigidArea);
    	
    	btnUndo = new JButton("Undo");
    	btnUndo.setFont(btnUndo.getFont().deriveFont(btnUndo.getFont().getSize() + 10f));
    	horizontalBox.add(btnUndo);
    	
    	add(panel_1, BorderLayout.CENTER);
    	
    	horizontalBox_1 = Box.createHorizontalBox();
    	panel_1.add(horizontalBox_1);
    	
    	verticalBox = Box.createVerticalBox();
    	verticalBox.setBorder(new EmptyBorder(10, 10, 10, 10));
    	panel_1.add(verticalBox);
    	
    	horizontalBox_2 = Box.createHorizontalBox();
    	verticalBox.add(horizontalBox_2);
    	
    	label_1 = new JLabel();
    	label_1.setIcon(new ImageIcon(LevelPlayerView.class.getResource("/scandium/lettercraze/resources/star-icon-off.png")));
    	horizontalBox_2.add(label_1);
    	
    	label_2 = new JLabel();
    	label_2.setIcon(new ImageIcon(LevelPlayerView.class.getResource("/scandium/lettercraze/resources/star-icon-off.png")));
    	horizontalBox_2.add(label_2);
    	
    	label_3 = new JLabel();
    	label_3.setIcon(new ImageIcon(LevelPlayerView.class.getResource("/scandium/lettercraze/resources/star-icon-off.png")));
    	horizontalBox_2.add(label_3);
    	
    	horizontalBox_3 = Box.createHorizontalBox();
    	verticalBox.add(horizontalBox_3);
    	
    	lblScore = new JLabel("Score:");
    	lblScore.setFont(lblScore.getFont().deriveFont(lblScore.getFont().getSize() + 15f));
    	horizontalBox_3.add(lblScore);
    	lblScore.setAlignmentX(Component.CENTER_ALIGNMENT);
    	
    	rigidArea_2 = Box.createRigidArea(new Dimension(20, 20));
    	horizontalBox_3.add(rigidArea_2);
    	
    	lblPts = new JLabel("0 pts");
    	lblPts.setFont(lblPts.getFont().deriveFont(lblPts.getFont().getSize() + 15f));
    	horizontalBox_3.add(lblPts);
    	lblPts.setAlignmentX(Component.CENTER_ALIGNMENT);
    	
    	horizontalBox_4 = Box.createHorizontalBox();
    	horizontalBox_4.setAlignmentY(Component.CENTER_ALIGNMENT);
    	verticalBox.add(horizontalBox_4);
    	
    	lblNextStar = new JLabel("Next Star:");
    	lblNextStar.setFont(lblNextStar.getFont().deriveFont(lblNextStar.getFont().getSize() + 15f));
    	horizontalBox_4.add(lblNextStar);
    	lblNextStar.setAlignmentX(Component.CENTER_ALIGNMENT);
    	
    	rigidArea_3 = Box.createRigidArea(new Dimension(20, 20));
    	horizontalBox_4.add(rigidArea_3);
    	
    	lblPts_1 = new JLabel("10 pts");
    	lblPts_1.setFont(lblPts_1.getFont().deriveFont(lblPts_1.getFont().getSize() + 15f));
    	horizontalBox_4.add(lblPts_1);
    	lblPts_1.setAlignmentX(Component.CENTER_ALIGNMENT);
    	
    	horizontalBox_5 = Box.createHorizontalBox();
    	verticalBox.add(horizontalBox_5);
    	
    	label_4 = new JLabel("Max Number of Words:");
    	label_4.setFont(label_4.getFont().deriveFont(label_4.getFont().getSize() + 15f));
    	horizontalBox_5.add(label_4);
    	
    	rigidArea_4 = Box.createRigidArea(new Dimension(20, 20));
    	horizontalBox_5.add(rigidArea_4);
    	
    	label_5 = new JLabel("10");
    	label_5.setFont(label_5.getFont().deriveFont(label_5.getFont().getSize() + 15f));
    	horizontalBox_5.add(label_5);
    	
    	scrollPane = new JScrollPane();
    	scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
    	panel_1.add(scrollPane);
    	
    	lblFoundWords = new JLabel("Found Words");
    	lblFoundWords.setFont(lblFoundWords.getFont().deriveFont(lblFoundWords.getFont().getSize() + 15f));
    	scrollPane.setColumnHeaderView(lblFoundWords);
    	
    	list = new JList<String>();
    	list.setFont(list.getFont().deriveFont(list.getFont().getSize() + 10f));
    	list.setVisibleRowCount(-1);
    	list.setModel(new AbstractListModel<String>() {
			private static final long serialVersionUID = -4671828597298661166L;
			String[] values = new String[] {"1. Dog (12 pts)", "2. Cat (14 pts)", "3. Horse (24 pts)", "4. Red (9 pts)", "5.", "6.", "7.", "8.", "9.", "10.", "11.", "12."};
    		public int getSize() {
    			return values.length;
    		}
    		public String getElementAt(int index) {
    			return values[index];
    		}
    	});
    	scrollPane.setViewportView(list);
    	
    	boardView = new BoardView();
    	boardView.setBorder(new EmptyBorder(10, 10, 10, 10));
    	add(boardView, BorderLayout.EAST);
    	boardView.setPreferredSize(new Dimension(750, 500));
    }
}