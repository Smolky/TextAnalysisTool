package es.um.dis.umutextstats.dimensions;

import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import es.um.dis.umutextstats.dictionaries.Dictionary;


/**
 * MatchingWordsFromDictionary
 * 
 * @author José Antonio García Díaz
 * 
 * @package TextAnalysis
 */
public class EmoticonsDimension extends MatchingRegularExpressionsFromDictionary {
	
	/**
	 * subprocess
	 */
	public double subprocess () {
		
		// Process the dictionary
		Dictionary parsed = new Dictionary ();
		for (String word : this.dictionary.getWords ()) {
			
			// Get all chars
			String modified_word = "";
			for (int i = 0; i < word.length(); i++){
				modified_word = modified_word + "\\\\" + word.charAt(i);
			}
			
			System.out.println(modified_word);
			
			parsed.add (word);
		}
		
		this.setDictionary(parsed);
		
		return super.subprocess();
	}
}
