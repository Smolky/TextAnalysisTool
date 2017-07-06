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
	 * subprocess
	 */
	public double subprocess () {
		
		// Init vars
		double words_found = 0;
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
