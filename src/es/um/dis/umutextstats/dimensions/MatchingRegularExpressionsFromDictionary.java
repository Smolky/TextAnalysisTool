package es.um.dis.umutextstats.dimensions;

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
	
	
	/**
	 * setDictionary
	 * 
	 * @param dictionary
	 * @return
	 */
	public DimensionInterface setDictionary (Dictionary dictionary) {
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
		int direction = 1;
		HashSet<String> words;
		
		
		// Create a set with the words to use 
		words = new HashSet<String>();
		
		
		// If the dictionary is empty, do nothing
		if (this.dictionary == null) {
			return 0;
		}
		
		
		// Extract words from the dictionary
		for (String word : this.dictionary.getWords ()) {
			
			// To lower case
			String lowered_word = word.toLowerCase();
			
			
			// Add
			words.add(lowered_word);
			
		}
		
		
		// Checking complex words
		for (String word : words) {
			
			String _word;
			int _how_many_words;
			
			
			// NEG:expressions reduces the result
			if (word.startsWith ("NEG:")) {
				_word = word.substring(4);
				direction = -1;
			} else {
				_word = word;
				direction = 1;
			}
			
			
			// How many words the regular expression has
			_how_many_words = ExtractWordsFromString.getWords(_word).length;
			
			
			// Matches?
			Pattern pattern = Pattern.compile("\\b" + _word + "\\b", Pattern.UNICODE_CHARACTER_CLASS);
			Matcher matcher = pattern.matcher(this.getInput ());
			
			
			// Count results
			while (matcher.find()) {
				result = result + (direction * _how_many_words);
			}
		}
		

		    
		return result;
	}
}
