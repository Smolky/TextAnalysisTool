package main.Dimensions;

import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import main.Dictionaries.Dictionary;


/**
 * MatchingWordsFromDictionary
 * 
 * this dimension will allow to obtain the number of
 * words of the text that is contained inside 
 * a dictionary
 * 
 * - comparation is case independant
 * 
 * @todo Allow configuration to test words
 * 
 * @author José Antonio García Díaz
 * 
 * @package TextAnalysis
 */
public class MatchingWordsFromDictionary extends BaseDimension {

	/** Dictionary dictionary */
	protected Dictionary dictionary;
	
	
	/**
	 * MatchingWordsFromDictionary
	 * 
	 * @param dictionary
	 */
	public MatchingWordsFromDictionary (Dictionary dictionary) {
		this.dictionary = dictionary;
	}
	
	
	/**
	 * getDimensionKey
	 *
	 * @override
	 */
	public String getDimensionKey () {
		return "Dic";
	}	
		
	
	
	/**
	 * subprocess
	 */
	public double subprocess () {
		
		// Init vars
		double result = 0;
		HashSet<String> words;
		
		
		// Create a set with the words to use 
		words = new HashSet<String>();
		
		
		// Extract words from dictorionary
		for (String word : this.dictionary.getWords ()) {
			
			// To lower case
			String lowered_word = word.toLowerCase();
			
			
			// Add
			words.add(lowered_word);
			
		}
		
		
		// Checking complex words
		for (String complex_word : words) {
			
			// MAtches?
			Pattern pattern = Pattern.compile("\\b" + complex_word + "\\b");
			Matcher matcher = pattern.matcher(this.getInput ());
			
			while (matcher.find()) {
				result++;
			}
		}
		
		    
		return result;
	}
}
