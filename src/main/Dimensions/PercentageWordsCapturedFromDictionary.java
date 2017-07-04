package main.Dimensions;

import java.util.HashSet;

import main.helpers.ExtractWordsFromString;

/**
 * PercentageWordsCapturedFromDictionary
 * 
 * @author José Antonio García Díaz
 * 
 * @package TextAnalysis
 */
public class PercentageWordsCapturedFromDictionary extends BaseDimension {

	protected String[] words = {"cabe", "ante", "que"};
	
	
	/**
	 * getDimensionKey
	 *
	 * @override
	 */
	public String getDimensionKey () {
		return "Dic";
	}	
	
	
	/**
	 * process
	 */
	public double process () {
		
		// Init vars
		double words_found = 0;
		
		
		// Check if results are empty
		if (this.getInput ().isEmpty()) {
			return 0;
		}
		
		
		// Get the words stats
		double words_in_dictionary = this.words.length;
		double words_in_text = ExtractWordsFromString.getWords (this.getInput ()).length;
		
		
		// Get matching words
		HashSet<String> map = new HashSet<String>();
		for (String word : this.words) {
			map.add (word);
		}
		
		
		for (String word : ExtractWordsFromString.getWords (this.getInput ())) {
			if (map.contains (word)) {
				words_found++;
			}
		}
		    
		return words_found / words_in_text;
	}	
	
}
