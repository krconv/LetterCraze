package scandium.levelbuilder.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import scandium.common.model.BoardSquare;
import scandium.common.model.Level;
import scandium.common.model.PuzzleLevel;
import scandium.common.model.LightningLevel;
import scandium.common.model.ThemeLevel;
import scandium.levelbuilder.model.EditProgress;
import scandium.levelbuilder.model.Model;
import scandium.levelbuilder.view.Application;

/**
 * @author Felix
 */
public class ToggleEnableController extends MouseAdapter{
	//attributes
    Model model;
    Application app;
    int row;
    int col;
    
    /**
     * @param m 
     * @param a
     */
    public ToggleEnableController(Model m, Application a, int r, int c) {
    	this.model = m;
    	this.app = a;
    	this.row = r;
    	this.col = c;
    }

    /**
     * @param MouseEvent me
     */
    public void mouseClicked(MouseEvent me) {
    	//finding boardSquare
    	EditProgress progress = model.getEditProgress();
    	Level current = progress.getModified();
    	BoardSquare bs = current.getBoard().getSquare(row, col);
    	
    	//enable/disable toggle logic
    	if(bs.isEnabled() == true){
    		bs.setEnabled(false);
    	}
    	else{
    		bs.setEnabled(true);
    	}
    	
    	//refresh the display
    	app.getLevelEditor().refresh();
    	System.out.println("refreshing");
    }
    
}
