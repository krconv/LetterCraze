/**
 * 
 */
package scandium.common.model;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;
import scandium.common.tool.LetterDictionary;

/**
 * @author Connor
 *
 */
public class ThemeLevelTest extends TestCase {
	private ThemeLevel level;
	private Board board;
	private LetterDictionary dictionary;

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
		board = new Board(true, GravityDirection.Up);
		dictionary = new LetterDictionary(100);
		
		level = new ThemeLevel();
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	/**
	 * Test method for {@link scandium.common.model.ThemeLevel#getType()}.
	 */
	public void testGetType() {
		assertEquals("Theme", level.getType());
	}

	/**
	 * Test method for {@link scandium.common.model.ThemeLevel#getTheme()} and {@link scandium.common.model.ThemeLevel#setTheme(java.lang.String)}.
	 */
	public void testGetSetTheme() {
		level.setTheme("Fruit");
		assertEquals("Fruit", level.getTheme());
	}

	/**
	 * Test method for {@link scandium.common.model.ThemeLevel#getThemeWords()} and {@link scandium.common.model.ThemeLevel#setThemeWords(java.util.List)}.
	 */
	public void testGetSetThemeWords() {
		ArrayList<String> tW = new ArrayList<String>();
		tW.add("hello");
		tW.add("peachy");
		level.setThemeWords(tW);
		assertEquals(tW, level.getThemeWords());
		List<String> themeWords = level.getThemeWords();
		assertEquals(tW.get(0), themeWords.get(0));
		assertEquals(themeWords.get(0), "hello");
	}

	/**
	 * Test method for {@link scandium.common.model.ThemeLevel#copy()}.
	 */
	public void testCopy() {
		level.setName("This is a level");
		level.setTheme("Fruit");
		level.setBoard(board);
		ArrayList<String> tW = new ArrayList<String>();
		tW.add("strawberry");
		tW.add("peach");
		level.setThemeWords(tW);
		ThemeLevel levelCopy = level.copy();
		assertEquals("This is a level", levelCopy.getName());
		assertNotNull(levelCopy.getBoard());
		assertEquals("Fruit", levelCopy.getTheme());
		assertEquals(tW, levelCopy.getThemeWords());
	}

	/**
	 * Test method for {@link scandium.common.model.ThemeLevel#addThemeWord(java.lang.String)}.
	 */
	public void testAddThemeWord() {
		level.setTheme("Fruit");
		level.addThemeWord("banana");
		assertEquals("banana", level.getThemeWords().get(0));
		level.addThemeWord("banana");
		assertEquals("banana", level.getThemeWords().get(0));
		assertEquals("banana", level.getThemeWords().get(1));
	}

	/**
	 * Test method for {@link scandium.common.model.ThemeLevel#removeThemeWord(java.lang.String)}.
	 */
	public void testRemoveThemeWord() {
		level.setTheme("Fruit");
		level.addThemeWord("banana");
		level.removeThemeWord("banana");
		assertEquals(0, level.getThemeWords().size());
		level.addThemeWord("cherry");
		level.addThemeWord("banana");
		level.removeThemeWord("cherry");
		assertEquals("banana",level.getThemeWords().get(0));
	}
	

	/**
	 * Test method for {@link scandium.common.model.ThemeLevel#isValid()}.
	 */
	public void testIsValid() {
		level.setTheme("Food");
		ArrayList<String> tW = new ArrayList<String>();
		tW.add("strawberry");
		tW.add("peach");
		level.setThemeWords(tW);
		level.setName("This is a level");
		level.setBoard(board);
		level.getStar(0).setThreshold(1);
		level.getStar(1).setThreshold(2);
		level.getStar(2).setThreshold(3);
		board.fillEmptySquares(dictionary);
		assertTrue(level.isValid());
	}
}
