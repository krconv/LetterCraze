package scandium.levelbuilder.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JRadioButton;

import scandium.common.model.Level;
import scandium.common.model.LightningLevel;
import scandium.common.model.PuzzleLevel;
import scandium.common.model.ThemeLevel;
import scandium.levelbuilder.model.EditProgress;
import scandium.levelbuilder.model.Model;
import scandium.levelbuilder.view.Application;

/**
 * @author Scandium WORK ON THIS
 */
public class SpecifyLevelTypeController implements ActionListener{
	//attributes
	Model model;
	Application app;
    Level l;
    EditProgress progress;

    /**
     * @param model 
     * @param app
     */
    public SpecifyLevelTypeController(Model m, Application a) {
        this.model = m;
        this.app = a;
    }

    /**
     * @param ActionEvent ae
     */
    public void actionPerformed(ActionEvent ae) {
    	System.out.println("level type button pressed");
    	
    	JRadioButton puzzle = app.getLevelEditor().getPuzzleLevelButton();
    	JRadioButton lightning = app.getLevelEditor().getLightningLevelButton();
    	JRadioButton theme = app.getLevelEditor().getThemeLevelButton();
    	
    	
        if(puzzle.isSelected() == true){
        	app.getLevelEditor().setPuzzleLevelView();
        	l = new PuzzleLevel();
        	this.progress = new EditProgress(l);
        	System.out.println("changing level to puzzle");
        }
        if(lightning.isSelected() == true){
        	app.getLevelEditor().setLightningLevelView();
        	l = new LightningLevel();
        	this.progress = new EditProgress(l);
        	System.out.println("changing level to lightning");
        }
        if(theme.isSelected() == true){
        	app.getLevelEditor().setThemeLevelView();
        	l = new ThemeLevel();
        	this.progress = new EditProgress(l);
        	System.out.println("changing level to theme");
        }
    }

}