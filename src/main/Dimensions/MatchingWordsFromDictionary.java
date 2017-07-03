package main.Dimensions;

import java.util.HashSet;

/**
 * MatchingWordsFromDictionary
 * 
 * @author José Antonio García Díaz
 * 
 * @package TextAnalysis
 */
public class MatchingWordsFromDictionary extends BaseDimension {

	protected String[] words = {"cabe", "ante", "que"};
	
	
	
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
		for (String word : this.words) {
			map.add (word);
		}
		
		
		for (String word : this.getInput ().split ("\\s+")) {
			if (map.contains (word)) {
				result++;
			}
		}
		    
		return result;
	}
	
	
}
