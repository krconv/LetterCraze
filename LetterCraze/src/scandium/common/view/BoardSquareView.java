/**
 * BoardSquareView.java
 * 
 * @author Scandium
 */
package scandium.common.view;

import javax.swing.JLabel;

import scandium.common.model.BoardSquare;

/**
 * A Panel which shows all the elements of a BoardSquare.
 */
public class BoardSquareView {
	private BoardSquare model;
    private JLabel tileLabel;

    /**
     * Creates a new view for a BoardSquare.
     * @param model The Board Square which this view will represent.
     */
    public BoardSquareView(BoardSquare model) {
        // TODO implement here
    }

	/**
	 * @return the tileLabel
	 */
	public JLabel getTileLabel() {
		return tileLabel;
	}

	/**
	 * @param tileLabel the tileLabel to set
	 */
	public void setTileLabel(JLabel tileLabel) {
		this.tileLabel = tileLabel;
	}

	/**
	 * @return the model
	 */
	public BoardSquare getModel() {
		return model;
	}
}