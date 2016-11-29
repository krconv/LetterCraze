package scandium.lettercraze.view;
import java.awt.*;

import javax.swing.*;

public class SplashScreen extends JWindow {
	private int time;
	public SplashScreen(int t){
		this.time = t;
	}
	
	public void displaySplash() {
		JPanel display = (JPanel)getContentPane();
		display.setBackground(Color.white);
		
		int width = 1280;
	    int height = 720;
	    Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
	    int x = (screen.width-width)/2;
	    int y = (screen.height-height)/2;
	    setBounds(x,y,width,height);
		
		//Build splash screen
		JLabel splash = new JLabel(new ImageIcon("lettercraze-splash.gif"));
		display.add(splash, BorderLayout.CENTER);
		
		//Display the splash
		setVisible(true);
		
		//Wait the time specified
		try { Thread.sleep(time); } catch (Exception e) {}
		
		setVisible(false);
	}
}
