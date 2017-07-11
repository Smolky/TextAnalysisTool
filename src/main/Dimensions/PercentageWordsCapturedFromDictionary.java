package main.Dimensions;

/**
 * PercentageWordsCapturedFromDictionary
 * 
 * @author José Antonio García Díaz
 * 
 * @package TextAnalysis
 */
public class PercentageWordsCapturedFromDictionary extends MatchingWordsFromDictionary {
	
	/**
	 * getDimensionKey
	 *
	 * @override
	 */
	public String getDimensionKey () {
		return "DicPercentage";
	}	
	
	
	/**
	 * subprocess
	 */
	public double subprocess () {
		
		// GEt words
		double matching_words = super.subprocess();
		double total_words = this.dictionary.getWords ().size ();
		
		
		// Check empty dirtionaries
		if (total_words == 0) {
			return 0;
		}
		
		
		// Return 
		return matching_words / total_words;
		
	}	
	
}
