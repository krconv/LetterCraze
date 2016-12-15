/**
 * CheatCodeController.java
 * 
 * @author Scandium
 */
package scandium.lettercraze.controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import scandium.lettercraze.model.LevelProgress;
import scandium.lettercraze.model.Model;
import scandium.lettercraze.view.Application;

/**
 * The controller to handle the cheat code.
 */
public class CheatCodeController implements KeyListener {
	private Model model;
	private Application app;
	private final String cheatCode = "scandium";
	private long lastKey;
	private int i = 0;
	
	/**
	 * Create a new cheat code controller.
	 * @param model The model.
	 * @param app The app.
	 */
	public CheatCodeController(Model model, Application app) {
		this.model = model;
		this.app = app;
	}

	/* (non-Javadoc)
	 * @see java.awt.event.KeyListener#keyPressed(java.awt.event.KeyEvent)
	 */
	@Override
	public void keyPressed(KeyEvent arg0) {
		
	}

	/* (non-Javadoc)
	 * @see java.awt.event.KeyListener#keyReleased(java.awt.event.KeyEvent)
	 */
	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see java.awt.event.KeyListener#keyTyped(java.awt.event.KeyEvent)
	 */
	@Override
	public void keyTyped(KeyEvent arg0) {
		if (System.currentTimeMillis() - lastKey > 2000)
			i = 0;
		
		// update the last key press
		lastKey = System.currentTimeMillis();
		
		// set if the key pressed is part of the cheat word
		if (arg0.getKeyChar() == cheatCode.charAt(i)) {
			i++;
			if (i == cheatCode.length()) {
					for (LevelProgress progress : model.getProgress().getLevelProgresses()) {
						progress.setUnlocked(true);
						progress.setScore(progress.getLevel().getStar(2).getThreshold());
					}
				i = 0;
				model.getProgress().SaveProgress();
				app.getMainMenu().refresh();
			} 
		} else {
			i = 0;
		}
	}
}
