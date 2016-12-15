package scandium.lettercraze.tool;

import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;
import scandium.common.model.Level;
import scandium.common.model.LightningLevel;
import scandium.common.model.PuzzleLevel;
import scandium.common.model.ThemeLevel;
import scandium.lettercraze.model.LevelProgress;

/**
 * This class is used to test the scandium.lettercraze.tool.ProgressLoader class.
 * @author Scandium
 * @date 14/12/16
 */
public class ProgressLoaderTest extends TestCase {
	protected ProgressLoader loader;
	
	protected void setUp() throws Exception{
		loader = new ProgressLoader();
	}
	
	protected void tearDown() throws Exception{
		loader = null;
		new File("LetterCrazeProgress.xml").delete();
	}
	
	/**
	 * This function tests ProgressLoader.getSavePath(). It ensures that it returns the 
	 * correct system path, relative to the user's system.
	 */
	public void testGetSavePath(){
		String path_actual = loader.getSavePath();
		String path_expected = Paths.get(System.getProperty("user.home"), "LetterCrazeProgress.xml").toString();
		assertEquals(path_actual, path_expected);
	}
	
	/**
	 * This function tests that a ProgressLoader can save a list of LevelProgress, 
	 * and then load them. 
	 */
	public void testSaveLoad(){
		/* Initialize a List of Level and a List of LevelProgress */
		ArrayList<Level> levels = new ArrayList<Level>();
		PuzzleLevel level1 = new PuzzleLevel();
		LightningLevel level2 = new LightningLevel();
		ThemeLevel level3 = new ThemeLevel();
		levels.add(level1);
		levels.add(level2);
		levels.add(level3);
		ArrayList<LevelProgress> progresses = new ArrayList<LevelProgress>();
		LevelProgress progress1 = new LevelProgress(level1);
		LevelProgress progress2 = new LevelProgress(level2);
		LevelProgress progress3 = new LevelProgress(level3);
		progresses.add(progress1);
		progresses.add(progress2);
		progresses.add(progress3);
		/* Give the LevelProgresses some progress to be saved */
		progress1.setScore(150);
		progress1.setUnlocked(true);
		progress2.setUnlocked(true);

		
		/* Save the Level Progresses */
		long gameToken = 25;
		List<LevelProgress> loaded_progresses;
		loader.SaveLevelProgress(progresses);
		/* Load the Level Progresses */
		loaded_progresses = loader.LoadLevelProgress(levels);
		
		/* Confirm that save and load occurred properly */
		LevelProgress actual = loaded_progresses.get(0);
		LevelProgress expected = progresses.get(0);
		assertEquals(actual.getScore(), expected.getScore());
		assertEquals(actual.isUnlocked(), expected.isUnlocked());
		
		actual = loaded_progresses.get(1);
		expected = progresses.get(1);
		assertEquals(actual.isUnlocked(), expected.isUnlocked());
		
		assertEquals(loaded_progresses.size(), 3);
		
		/* Test Loading with Invalid Cookie, Should generate completely new level progresses */
		loaded_progresses = loader.LoadLevelProgress(levels);
		
		assertEquals(loaded_progresses.size(), 3);
		assertEquals(loaded_progresses.get(0).getScore(), 0);
		assertEquals(loaded_progresses.get(1).getScore(), 0);
		assertEquals(loaded_progresses.get(2).getScore(), 0);
		assertEquals(loaded_progresses.get(0).isUnlocked(), true);
		assertEquals(loaded_progresses.get(1).isUnlocked(), false);
		assertEquals(loaded_progresses.get(2).isUnlocked(), false);
		
	}
}
