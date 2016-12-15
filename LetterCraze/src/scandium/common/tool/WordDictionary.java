/**
 * WordDictionary.java
 * 
 * @author Scandium
 */
package scandium.common.tool;

import java.util.HashSet;
import java.util.Scanner;

/**
 * A tool to contain a list of words.
 */
public class WordDictionary implements IWordDictionary {

	/* Dictionary File */
	final static String dictionary_file = "Dictionary.txt";

	/* Class Attributes */
	private HashSet<String> words = new HashSet<String>();
	public static final WordDictionary instance = new WordDictionary();

	/**
	 * Create a new dictionary.
	 * 
	 * @param words
	 *            The words in the dictionary.
	 */
	private WordDictionary() {
		this.words = new HashSet<String>();
		initialize();
	}

	/**
	 * This function initializes the dictionary to hold the words stored in
	 * Dictionary.txt
	 */
	void initialize() {
		Scanner s = new Scanner(getClass().getResourceAsStream("/scandium/common/resources/Dictionary.txt"));
		while (s.hasNext()) {
			words.add(s.next());
		}
		s.close();
	}

	/**
	 * Force loads the dictionary.
	 */
	public static void load() {
	}

	/**
	 * Check whether a word is contained in the dictionary.
	 * 
	 * @param word
	 *            The word to check.
	 * @return Whether the given word is in this dictionary.
	 */
	public boolean isWord(String word) {
		word = word.toLowerCase();
		return word.length() >= 3 && words.contains(word);
	}
}
