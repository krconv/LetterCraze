package scandium.levelbuilder.view;
import java.awt.*;

import javax.swing.*;

public class SplashScreen extends JWindow {
	  private int time;
	  public SplashScreen(int d) {
	    time = d;
	  }

	  //Method to show the splash screen at the beginning
	  public void displaySplash() {
	    JPanel display = (JPanel)getContentPane();
	    display.setBackground(Color.white);

	    // Set the window's bounds, and center it
	    int w = 1280;
	    int h = 720;
	    Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
	    int x = (screen.width-w)/2;
	    int y = (screen.height-h)/2;
	    setBounds(x,y,w,h);

	    // Build splash screen
	    JLabel appName = new JLabel ("LevelBuilder");
	    appName.setBounds(640, 360, 500, 500);
	    appName.setFont(new Font("Sans-Serif", Font.BOLD, 48));
	    add(appName);
	    
	    JLabel teamname = new JLabel
	      ("Scandium: Richard Cole, Kodey Converse, Jeff Martin, Felix Sanchez, YABOI C-Smith", JLabel.CENTER);
	    teamname.setFont(new Font("Sans-Serif", Font.BOLD, 12));
	    display.add(teamname, BorderLayout.SOUTH);
	    display.setBorder(BorderFactory.createLineBorder(Color.BLUE, 10));

	    setVisible(true);

	    // Show for a short period of time
	    try { Thread.sleep(time); } catch (Exception e) {}

	    setVisible(false);
	  }
	}