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
	 * Creates a new instance of the BoardView class
	 */
	public BoardView(){
		initialize();
	}
	
	/**
	 * This function initializes the BoardView view/gui and controllers
	 */
	void initialize(){
		initializeView();
		initializeControllers();
	}
	
	/**
	 * This function initializes the BoardView gui
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
	 * This function instantiates new instances of all of the widgets (attributes)
	 */
	void instantiateAttributes(){
		squares = new JLabel[6][6];
	}
	
	/**
	 * This function initializes all of the widgets (attributes)
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
	
	/**
	 * This function initializes the BoardView Controllers
	 */
	void initializeControllers(){
		//TODO
	}
	
	/* ~~~~~                                                                               ~~~~~ *
	 * Getter Methods                                                                            *
	 * ~~~~~                                                                               ~~~~~ */
	
	/**
	 * This function returns the JLabels representing the BoardSquares
	 * @return JLabel[][]
	 */
	public JLabel[][] getBoardSquares(){
		return squares;
	}

	/* ~~~~~                                                                               ~~~~~ *
	 * GUI Logic for Controllers                                                                 *
	 * ~~~~~                                                                               ~~~~~ */
	
	/**
	 * This function 'selects' (highlights with grey) the Board square at the specified coordinate
	 * @param row The row (indexed by 0) of the desired square
	 * @param col The column (indexed by 0) of the desired square
	 */
	public void selectBoardSquare(int row, int col){
		squares[row][col].setBackground(highlight);
	}
	
	/** 
	 * This function 'de-selects' (sets color to white) the board square at the specified coordinate
	 * @param row The row (indexed by 0) of the desired square
	 * @param col The column (indexed by 0) of the desired square
	 */
	public void deselectBoardSquare(int row, int col){
		squares[row][col].setBackground(Color.WHITE);
	}
	
	/** 
	 * This function sets the text of the board square at the specified coordinate
	 * @param letter The String to be added to the Square
	 * @param row The row (indexed by 0) of the desired square
	 * @param col The Column (indexed by 0) of the desired Square
	 */
	public void setBoardSquareText(String letter, int row, int col){
		squares[row][col].setText(letter);
	}
}
