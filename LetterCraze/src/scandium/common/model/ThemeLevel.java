/**
 * ThemeLevel.java
 * 
 * @author Scandium
 */
package scandium.common.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import scandium.common.tool.IWordDictionary;
import scandium.common.tool.LevelRestrictor;
import scandium.common.tool.WordLevelRestrictor;

/**
 * A type of Level with a predefined list of theme words.
 */
@XmlRootElement(name = "themeLevel")
@XmlAccessorType(XmlAccessType.FIELD)
public class ThemeLevel extends Level {
	@XmlElement
	private String theme;
	@XmlElementWrapper(name = "themeWords")
	@XmlElement(name = "word")
	private List<String> themeWords;
	@XmlTransient
	private IWordDictionary dictionary;

    /**
     * Creates a new Theme level with the default information.
     */
    public ThemeLevel() {
    	super();
    	theme = new String();
    	themeWords = new ArrayList<String>();
    	dictionary = new IWordDictionary() {
			@Override
			public boolean isWord(String word) {
				for (String string : themeWords) {
					if (string.equalsIgnoreCase(word))
						return true;
				}
				return false;
			}
    	};
		super.setBoard(new Board(false, GravityDirection.Up));
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
     * Gets the name of the theme for this level.
	 * @return the theme
	 */
	public String getTheme() {
		return theme;
	}

	/**
     * Sets the name of the theme for this level.
	 * @param theme the theme to set
	 */
	public void setTheme(String theme) {
		this.theme = theme;
	}

	/**
     * Gets the theme words for this level.
	 * @return the themeWords
	 */
	public List<String> getThemeWords() {
		return themeWords;
	}

	/**
     * Sets the theme words for this level.
	 * @param theme_words the themeWords to set
	 */
	public void setThemeWords(List<String> theme_words) {
		this.themeWords = theme_words;
	}
	
	/* (non-Javadoc)
	 * @see scandium.common.model.Level#determineScore(scandium.common.model.Word)
	 */
	@Override
	public int determineScore(Word word) {
		return 1;
	}
	
	/* (non-Javadoc)
	 * @see scandium.common.model.Level#isValidWord(scandium.common.model.Word)
	 */
	@Override
	public boolean isValidWord(Word word) {
		return dictionary.isWord(word.generateString());
	}
	
	/* (non-Javadoc)
	 * @see scandium.common.model.Level#getWordDictionary()
	 */
	@Override
	public IWordDictionary getWordDictionary() {
		return dictionary;
	}

	/* (non-Javadoc)
	 * @see scandium.common.model.Level#getScoreUnits(boolean)
	 */
	@Override
	public String getScoreUnits(boolean plural) {
		return "word" + (plural ? "s" : "");
	}

	/* (non-Javadoc)
	 * @see scandium.common.model.Level#getRestrictor()
	 */
	@Override
	public LevelRestrictor getRestrictor() {
		return new WordLevelRestrictor(themeWords.size());
	}

	/* (non-Javadoc)
     * @see scandium.common.model.Level#getType()
     */
    @Override
    public final String getType() {
        return "Theme";
    }

    /* (non-Javadoc)
     * @see scandium.common.model.Level#copy()
     */
    @Override
    public ThemeLevel copy() {
    	ThemeLevel levelCopy = new ThemeLevel(super.getName(), super.getBoard().copy(), super.getStars(), theme, new ArrayList<String>(themeWords));
        return levelCopy;
    }

    /* (non-Javadoc)
     * @see scandium.common.model.Level#isValid()
     */
    @Override
    public boolean isValid() {
    	return (super.isValid() && (theme != null) && (themeWords.isEmpty() == false));
    }

    /**
     * Adds the given word to the list of theme words.
     * @param word The word to add.
     * @return Whether the word was added.
     */
    public boolean addThemeWord(String word) {
		return themeWords.add(word);
    }

    /**
     * Removes the given word from the list of theme words.
     * @param word The word to remove.
     * @return Whether the word was removed.
     */
    public boolean removeThemeWord(String word) {
    	return themeWords.remove(word);
    }
}