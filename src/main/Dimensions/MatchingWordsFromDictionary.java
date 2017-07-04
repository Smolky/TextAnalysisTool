package main.Dimensions;

import java.util.HashSet;

import main.Sictionaries.Dictionary;
import main.helpers.ExtractWordsFromString;

/**
 * MatchingWordsFromDictionary
 * 
 * this dimension will allow to obtain the number of
 * words of the text that is contained inside 
 * a dictionary
 * 
 * The comparation will be case independant
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
	 * process
	 */
	public double process () {
		
		// Init vars
		double result = 0;
		
		
		// Check if results are empty
		if (this.getInput ().isEmpty()) {
			return 0;
		}
		
		
		// Prepare 
		HashSet<String> map = new HashSet<String>();
		for (String word : this.dictionary.getWords ()) {
			map.add (word.toLowerCase());
		}
		
		
		for (String word : ExtractWordsFromString.getWords (this.getInput ())) {
			if (map.contains (word.toLowerCase())) {
				result++;
			}
		}
		    
		return result;
	}
	
	
}
