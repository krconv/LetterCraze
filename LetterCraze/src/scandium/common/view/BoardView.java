/* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ *
 * ~~~~~ Team Scandium                                                                           *
 * ~~~~~ CS 3733                                                                                 *
 * ~~~~~ Project: Level Builder                                                                  *
 * ~~~~~ Created: November 22nd - Jeff Martin                                                    *
 * ~~~~~ Class: BoardView                                                                        *
 * ~~~~~        This class displays the 6x6 board as a JPanel. It allows controllers to easily   *
 * ~~~~~        access all of the JLabel squares within the window.                              *
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
/**
 * BoardView.java
 * 
 * @author Scandium
 * Date: 11/22/2016
 * Description: This class displays the 6x6 board as a JPanel. It allows controllers to easily
 * access all of the JLabel squares within the window
 */
package scandium.common.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import scandium.common.tool.LetterDictionary;

public class BoardView extends JPanel{

	/* Serial ID                                                                                 */
	private static final long serialVersionUID = 6326535097986903469L;
	private static final Color highlight = Color.GRAY;
	/* ~~~~~                                                                               ~~~~~ *
	 * Class Attributes                                                                          *
	 * ~~~~~                                                                               ~~~~~ */
	JLabel[][] squares;
	
	/* ~~~~~                                                                               ~~~~~ *
	 * Constructor Methods and Initialization                                                    *
	 * ~~~~~                                                                               ~~~~~ */
	
	/**
	 * Creates a new instance of the BoardView class.
	 */
	public BoardView(){
		initialize();
	}
	
	/**
	 * This function initializes the BoardView view/gui and controllers.
	 */
	void initialize(){
		initializeView();
	}
	
	/**
	 * This function initializes the BoardView GUI.
	 */
	void initializeView(){
		instantiateAttributes();
		initializeAttributes();
		
		/* Manage JPanel                                                                         */
		setBounds(10, 130, 540, 540);
		setBackground(Color.BLACK);
		setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, Color.BLACK));
		setLayout(null);
	}
	
	/**
	 * This function instantiates new instances of all of the widgets (attributes).
	 */
	void instantiateAttributes(){
		squares = new JLabel[6][6];
	}
	
	/**
	 * This function initializes all of the widgets (attributes).
	 */
	void initializeAttributes(){
		/* Initialize Each BoardSquare                                                           */
		for(int i = 0; i < 6; i++){
			for(int j = 0; j < 6; j++){
				squares[i][j] = new JLabel();
				squares[i][j].setBounds(i * 90, j * 90, 90, 90);
				squares[i][j].setFont(new Font(squares[i][j].getFont().getName(), Font.BOLD, 36));
				squares[i][j].setBorder(BorderFactory.createMatteBorder(1,1,1,1, Color.BLACK));
				squares[i][j].setBackground(Color.WHITE);
				squares[i][j].setOpaque(true);
				add(squares[i][j]);
			}
		}
	}
	
	/* ~~~~~                                                                               ~~~~~ *
	 * Getter Methods                                                                            *
	 * ~~~~~                                                                               ~~~~~ */
	
	/**
	 * This function returns the JLabels representing the BoardSquares.
	 * @return JLabel[][]
	 */
	public JLabel[][] getBoardSquares(){
		return squares;
	}
	
	/**
	 * This function returns the JLabel at the given row and column (indexed by 0).
	 * @param row The row index
	 * @param col The col index
	 * @return JLabel
	 */
	public JLabel getJLabel(int col, int row){
		return squares[row][col];
		
	}

	/* ~~~~~                                                                               ~~~~~ *
	 * GUI Logic for Controllers                                                                 *
	 * ~~~~~                                                                               ~~~~~ */
	
	/**
	 * This function 'selects' (highlights with grey) the Board square at the specified coordinate.
	 * @param row The row (indexed by 0) of the desired square
	 * @param col The column (indexed by 0) of the desired square
	 */
	public void selectBoardSquare(int row, int col){
		squares[row][col].setBackground(highlight);
	}
	
	/** 
	 * This function 'de-selects' (sets color to white) the board square at the specified coordinate.
	 * @param row The row (indexed by 0) of the desired square
	 * @param col The column (indexed by 0) of the desired square
	 */
	public void deselectBoardSquare(int row, int col){
		squares[row][col].setBackground(Color.WHITE);
	}
	
	/** 
	 * This function sets the text of the board square at the specified coordinate.
	 * @param letter The String to be added to the Square
	 * @param row The row (indexed by 0) of the desired square
	 * @param col The Column (indexed by 0) of the desired Square
	 */
	public void setBoardSquareText(String letter, int row, int col){
		squares[row][col].setText(letter);
	}
	
	
	/** 
	 * This function randomly sets the letter for all JLabels on a BoardView's squares[][].
	 * @param dictionary The LetterDictionary used to get random letters
	 */
	public boolean fillEmptySquares(LetterDictionary dictionary) {
        int indicator = 0;
        for (int i = 0; i < squares.length; i++){
        	for (int j = 0; j < squares.length; j++){
        		if ((squares[i][j].getText() == "") && (squares[i][j].getBackground() == Color.WHITE)){
        			squares[i][j].setText(dictionary.getRandomTile().getContent());
        			indicator = 1;
        		}
        	}
        }
        if (indicator == 1){
        	return true;
        }else{
        	return false;
        }
    }
	
	
	/** 
	 * This function clears the letters for all JLabels on a BoardView's squares[][].
	 */
	public boolean clearExistingLetters() {
		int indicator = 0;
        for (int i = 0; i < squares.length; i++){
        	for (int j = 0; j < squares.length; j++){
        		if (squares[i][j].getText() != ""){
        			squares[i][j].setText("");
        			indicator = 1;
        		}
        	}
        }
        if (indicator == 1){
        	return true;
        }else{
        	return false;
        }
	}
}
