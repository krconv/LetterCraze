/**
 * Application.java
 * 
 * @author Scandium
 */
package scandium.lettercraze.view;

import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import scandium.lettercraze.model.Model;

/**
 * The LetterCraze application window.
 */
public class Application extends JFrame {
	static final long serialVersionUID = -7053432922965446279L;
	private Model model;
	private MainMenuView mainMenu;
	private LevelPlayerView levelPlayer;

	/**
	 * Creates a new LetterCraze application window without a model.
	 */
	public Application() {
		initializeView();
	}

	/**
	 * Creates a new LetterCraze application window.
	 * 
	 * @param model
	 *            The model of the application.
	 */
	public Application(Model model) {
		this.model = model;

		initializeModel();
		initializeView();
		initializeControllers();
	}

	/**
	 * @return the model
	 */
	public Model getModel() {
		return model;
	}

	/**
	 * @return the mainMenu
	 */
	public MainMenuView getMainMenu() {
		return mainMenu;
	}

	/**
	 * @return the levelPlayer
	 */
	public LevelPlayerView getLevelPlayer() {
		return levelPlayer;
	}

	public void setView(JPanel view) {
		getContentPane().removeAll();
		getContentPane().add(view);
		getContentPane().revalidate();
	}

	/**
	 * Initialize the model.
	 */
	private void initializeModel() {
		// TODO implement here
	}

	/**
	 * Initialize the view.
	 */
	private void initializeView() {
		SplashScreen lcSplash = new SplashScreen(5000);
		lcSplash.displaySplash();
		
		setTitle("LetterCraze");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		UIManager.getLookAndFeelDefaults().put("defaultFont", new Font("Segoe WP Light", Font.PLAIN, 12));
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		this.mainMenu = new MainMenuView();
		this.levelPlayer = new LevelPlayerView(null);
		mainMenu.getLevelIconViews().get(0).addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setView(levelPlayer);
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}
		});
		mainMenu.getLevelIconViews().get(1).addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setView(levelPlayer);
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}
		});
		mainMenu.getLevelIconViews().get(2).addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setView(levelPlayer);
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}
		});
		mainMenu.getLevelIconViews().get(3).addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setView(levelPlayer);
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}
		});
		mainMenu.getLevelIconViews().get(4).addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setView(levelPlayer);
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}
		});
		mainMenu.getLevelIconViews().get(5).addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setView(levelPlayer);
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}
		});
		mainMenu.getLevelIconViews().get(6).addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setView(levelPlayer);
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}
		});
		levelPlayer.getLeaveButton().addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setView(mainMenu);
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
			}
		});
		setView(mainMenu);
	}

	/**
	 * Initialize the controllers.
	 */
	private void initializeControllers() {
		
	}
}

