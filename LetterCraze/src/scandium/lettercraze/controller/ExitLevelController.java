package scandium.lettercraze.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import scandium.lettercraze.model.Model;
import scandium.lettercraze.view.Application;

/**
 * @author Richard Cole
 */
public class ExitLevelController implements ActionListener{

	private Model model;
	private Application app;

	/**
	 * Default constructor
	 */
	public ExitLevelController() {
	}


	/**
	 * @param m The Model the current game is running on
	 * @param app The current application being run
	 */
	public ExitLevelController(Model m, Application app) {
		this.model = m;
		this.app = app;
	}
	
	/**
	 * @param ActionEvent ae The mouse is clicked on the button
	 * entry condition: the button this controller is attached to is pressed
	 * exit condition: the View has been set to the Main Menu and progress in the level has been saved if needed
	 */
	@Override
	public void actionPerformed(ActionEvent ae) {
		app.setView(app.getMainMenu());

		//TODO SAVE THE LEVEL PROGRESS UPON EXIT
	}

}