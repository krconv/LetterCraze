/**
 * WordDictionary.java
 * 
 * @author Scandium
 */
package scandium.common.tool;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.HashSet;
import java.util.Iterator;

/**
 * A tool to contain a list of words.
 */
public class WordDictionary implements IWordDictionary {
	
	/* Dictionary File                                                                           */
	final static String dictionary_file  = "Dictionary.txt";
	
	/* Class Attributes                                                                          */
	HashSet<String> words = new HashSet<String>();
	public static final WordDictionary instance = new WordDictionary();

    /**
     * Create a new dictionary.
     */
    private WordDictionary() {
    	this.words = new HashSet<String>();
    	initialize();
    }
    
    /**
     * Initializes the dictionary to hold the words stored in Dictionary.txt
     */
    void initialize(){
		Iterator<String> it = null;
		try {
	    	URL url = getClass().getResource("Dictionary.txt");
			it = new StringFileIterator(new File (url.getPath()));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while (it.hasNext()) {
			String word = it.next();
			word = word.trim();
			words.add(word);
		}
    }

    /**
     * Force loads the dictionary.
     */
    public static void load() {}
    
    /**
     * Check whether a word is contained in the dictionary.
     * @param word The word to check.
     * @return Whether the given word is in this dictionary.
     */
    public boolean isWord(String word) {
		word = word.toLowerCase();
		return word.length() >= 3 && words.contains(word);
    }
}

