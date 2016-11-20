/**
 * ThemeLevel.java
 * 
 * @author Scandium
 */
package scandium.common.model;

import java.util.ArrayList;

/**
 * A type of Level with a predefined list of theme words.
 */
public class ThemeLevel extends Level {
	private String theme;
	ArrayList<String> themeWords;

    /**
     * Creates a new uninitialized Theme Level.
     */
    public ThemeLevel() {
    	super();
    	this.themeWords = new ArrayList<String>();
    }

    /**
     * Creates a new Theme Level with the given information.
     * @param name The name of the Level.
     * @param board The Board of the Level.
     * @param stars The Stars in the Level.
     * @param theme The theme name for the Level.
     * @param themeWords The predefined theme words for the Level.
     */
    public ThemeLevel(String name, Board board, Star[] stars, String theme, ArrayList<String> themeWords) {
    	super(name, board, stars);
    	this.theme = theme;
    	this.themeWords = themeWords;
    }

    /**
	 * @return the theme
	 */
	public String getTheme() {
		return theme;
	}

	/**
	 * @param theme the theme to set
	 */
	public void setTheme(String theme) {
		this.theme = theme;
	}

	/**
	 * @return the themeWords
	 */
	public ArrayList<String> getThemeWords() {
		return themeWords;
	}

	/**
	 * @param themeWords the themeWords to set
	 */
	public void setThemeWords(ArrayList<String> themeWords) {
		this.themeWords = themeWords;
	}

	/* (non-Javadoc)
     * @see scandium.common.model.Level#getType()
     */
    @Override
    public final String getType() {
        // TODO implement here
        return "";
    }

    /* (non-Javadoc)
     * @see scandium.common.model.Level#copy()
     */
    @Override
    public ThemeLevel copy() {
        // TODO implement here
        return null;
    }

    /* (non-Javadoc)
     * @see scandium.common.model.Level#isValid()
     */
    @Override
    public boolean isValid() {
        // TODO implement here
        return false;
    }

    /**
     * Adds the given word to the list of theme words.
     * @param word The word to add.
     * @return Whether the word was added.
     */
    public boolean addThemeWord(String word) {
        // TODO implement here
        return false;
    }

    /**
     * Removes the given word from the list of theme words.
     * @param word The word to remove.
     * @return Whether the word was removed.
     */
    public boolean removeThemeWord(String word) {
        // TODO implement here
        return false;
    }
}