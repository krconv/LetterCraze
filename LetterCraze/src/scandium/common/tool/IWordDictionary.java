/**
 * IWordDictionary.java
 * 
 * @author Scandium
 */
package scandium.common.tool;

/**
 * A tool which contains a list of words.
 */
public interface IWordDictionary {
	
    /**
     * Check whether a word is contained in the dictionary.
     * @param word The word to check.
     * @return Whether the given word is in this dictionary.
     */
    public abstract boolean isWord(String word);
}
