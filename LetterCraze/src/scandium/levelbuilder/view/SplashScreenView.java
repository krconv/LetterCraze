package scandium.levelbuilder.view;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import scandium.lettercraze.view.LevelIconView;

public class SplashScreenView extends JPanel{

	/* Unique ID                                                                                 */
	private static final long serialVersionUID = -3440958103004228842L;
	
	/* Class Attributes                                                                          */
	JLabel image_label;
	ImageIcon image_icon;

	/**
	 * This function instantiates a new instance of the level builder splash screen
	 */
	public SplashScreenView(){
		initialize();
	}
	
	/**
	 * This function initializes the splash screen
	 */
	void initialize(){
		image_icon = new ImageIcon(LevelIconView.class.getResource("/scandium/levelbuilder/resources/levelbuilder-splash.gif"));
		image_label = new JLabel(image_icon);
		add(image_label);
	}
}
