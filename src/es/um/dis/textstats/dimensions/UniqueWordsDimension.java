package es.um.dis.textstats.dimensions;

import java.util.Arrays;

import es.um.dis.textstats.helpers.ExtractWordsFromString;

/**
 * UniqueWordsDimension
 *
 * This dimension counts the number of different words
 * the text.
 * 
 * @author José Antonio García Díaz
 * 
 * @package TextAnalysis
 */
public class UniqueWordsDimension extends BaseDimension {
	
	/**
	 * getDimensionKey
	 *
	 * @override
	 */
	public String getDimensionKey () {
		return "Unique";
	}	
	
	
	/**
	 * subprocess
	 */
	public double subprocess () {
		
		// Check if results are empty
		if (this.getInput ().isEmpty()) {
			return 0;
		}
		
		// Get words
		String[] words = ExtractWordsFromString.getWords(this.getInput ());
		
		
		// Remove duplicates
		// @link  * @link https://stackoverflow.com/questions/33636346/removing-duplicates-from-an-array-that-contains-multiple-string-elements
		return (Arrays.stream (words).distinct().toArray(s -> new String[s])).length;
		
	}
}
