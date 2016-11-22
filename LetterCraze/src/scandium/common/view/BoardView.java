/* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ *
 * ~~~~~ Team Scandium                                                                           *
 * ~~~~~ CS 3733                                                                                 *
 * ~~~~~ Project: Level Builder                                                                  *
 * ~~~~~ Created: November 22nd - Jeff Martin                                                    *
 * ~~~~~ Class: BoardView                                                                        *
 * ~~~~~        This class displays the 6x6 board as a JPanel. It allows controllers to easily   *
 * ~~~~~        access all of the JLabel squares within the window.                              *
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
package scandium.common.view;


import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class BoardView extends JPanel{

	/* Serial ID                                                                                 */
	private static final long serialVersionUID = 6326535097986903469L;

	/* ~~~~~                                                                               ~~~~~ *
	 * Class Attributes                                                                          *
	 * ~~~~~                                                                               ~~~~~ */
	JLabel[][] squares;
	
	/**~~~~~                                                                               ~~~~~ *
	 * Constructor Method                                                                        *
	 * ~~~~~                                                                               ~~~~~ */
	public BoardView(){
		squares = new JLabel[6][6];
	}
	
	/**~~~~~                                                                               ~~~~~ *
	 * initialize()                                                                              *
	 * ~~~~~                                                                               ~~~~~ */
	public void initialize(){
		setBackground(Color.BLACK);
		/* Create Border                                                                         */
		setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, Color.BLACK));
		setLayout(null);
		
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
	
	/**~~~~~                                                                               ~~~~~ *
	 * getBoardSquares()                                                                         *
	 * @return JLabel[][]                                                                        *
	 * This function returns the JLabels representing the BoardSquares                           *
	 * ~~~~~                                                                               ~~~~~ */
	public JLabel[][] getBoardSquares(){
		return squares;
	}

}
