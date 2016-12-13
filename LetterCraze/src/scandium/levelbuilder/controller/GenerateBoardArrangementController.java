package scandium.levelbuilder.controller;

import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JRadioButton;

import scandium.common.model.Board;
import scandium.common.tool.LetterDictionary;
import scandium.levelbuilder.model.Model;
import scandium.levelbuilder.view.Application;

/**
 * @author Scandium
 */
public class GenerateBoardArrangementController extends MouseAdapter{

	//attributes
    Model model;
    Application app;
    LetterDictionary dictionary;

    /**
     * @param model 
     * @param app
     */
    public GenerateBoardArrangementController(Model m, Application a) {
        this.model = m;
        this.app = a;
        this.dictionary = new LetterDictionary();
    }

    /**
     * @param ActionEvent ae
     */
    public void mouseClicked(MouseEvent me) {
    	JRadioButton theme = app.getLevelEditor().getThemeLevelButton();
    	
    	if(theme.isSelected() == true){
    		System.out.println("Preview Board for Theme Level");
    		//get words from theme word bank and insert them into board (extra letters?)
    		//String[][] wordsToBeAdded = app.getLevelEditor().getThemeWordsTextArea().getText();
    	}
    	else{
        	System.out.println("Preview Board");
    		app.getLevelEditor().getBoardView().clearExistingLetters();
    		app.getLevelEditor().getBoardView().fillEmptySquares(dictionary);
    	}
    	
    }

}