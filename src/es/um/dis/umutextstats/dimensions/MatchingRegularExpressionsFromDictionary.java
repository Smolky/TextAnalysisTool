package es.um.dis.umutextstats.dimensions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import es.um.dis.umutextstats.dictionaries.Dictionary;
import es.um.dis.umutextstats.helpers.ExtractWordsFromString;


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
public class MatchingRegularExpressionsFromDictionary extends BaseDimension {

	/** Dictionary dictionary */
	protected Dictionary dictionary;
	
	
	/** ArrayList<Pattern> patterns */
	protected ArrayList<Pattern> patterns = new ArrayList<Pattern>();
	
	
	/** ArrayList<Integer> int*/
	protected ArrayList<Integer> directions = new ArrayList<Integer>();
	
	
	
	/**
	 * setDictionary
	 * 
	 * @param dictionary
	 * @return
	 */
	public DimensionInterface setDictionary (Dictionary dictionary) {
		
		// Reset
		this.patterns = new ArrayList<Pattern>();

		
		// Set dictionary
		this.dictionary = dictionary;
		
		return this;
	}
	
	
	/**
	 * hasDictionary
	 * 
	 * @return Boolean
	 */
	public boolean hasDictionary () {
		return this.dictionary != null;
	}
	
	
	
	/**
	 * getPatterns
	 * 
	 * @return ArrayList<Pattern>
	 */
	public ArrayList<Pattern> getPatterns () {
		
		// Cache!
		if (this.patterns.size() == 0) {
			for (String word : this.dictionary.getWords ()) {
				
				if (word.startsWith ("NEG:")) {
					this.directions.add(-1);
				} else {
					this.directions.add(1);
				}
				
				this.patterns.add (
					Pattern.compile("\\b" + word + "\\b", Pattern.UNICODE_CHARACTER_CLASS)
				);
			}
		}
		
		return this.patterns;
	}		
	
	
	/**
	 * getDimensionKey
	 *
	 * @override
	 */
	public String getDimensionKey () {
		
		if (this.key != null) {
			return this.key;
		}
		
		return "Dic";
	}	
		
	
	
	/**
	 * subprocess
	 */
	public double subprocess () {
		
		// Init vars
		double result = 0;
		int _how_many_words;
		int direction;
		String input = this.getInput ();
		
		
		// If the dictionary is empty, do nothing
		if (this.dictionary == null) {
			return 0;
		}
		
		
		// Checking complex words
		int index = 0;
		for (Pattern pattern : this.getPatterns ()) {
			
			// Get direction
			direction = this.directions.get(index);
			
			
			// Matches?
			Matcher matcher = pattern.matcher(input);
			
			// Count results
			while (matcher.find()) {
				result += (direction * 1);
			}

			
			index++;
		}
		

		// Return result
		return result;
	}
}
