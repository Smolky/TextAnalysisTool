package es.um.dis.umutextstats.dimensions;

import es.um.dis.umutextstats.helpers.ExtractWordsFromString;

/**
 * PercentageWordsCapturedFromDictionary
 * 
 * @author José Antonio García Díaz
 * 
 * @package TextAnalysis
 */
public class PercentageWordsCapturedFromDictionary extends MatchingRegularExpressionsFromDictionary {
	
	/**
	 * getDimensionKey
	 *
	 * @override
	 */
	public String getDimensionKey () {
		
		if (this.key != null) {
			return this.key;
		}
		
		return "DicPercentage";
	}			
	
	
	/**
	 * subprocess
	 */
	public double subprocess () {
		
		// GEt words
		double matching_words = super.subprocess();
		double total_words = ExtractWordsFromString.getWords(this.getInput ()).length;

		
		// Check empty dirtionaries
		if (total_words == 0) {
			return 0;
		}
		
		
		// Return 
		return matching_words / total_words;
		
	}	
	
}
