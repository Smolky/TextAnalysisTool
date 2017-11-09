package es.um.dis.umutextstats.dimensions;

import java.math.BigDecimal;
import java.math.RoundingMode;

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

		
		// Avoid divide by zero
		if (total_words == 0) {
			return 0;
		}
		
		
		// Calculate percentage
		BigDecimal bd = new BigDecimal (100 * matching_words / total_words);
		bd = bd.setScale (2, RoundingMode.HALF_UP);
		
		
		// Return the average value
		return bd.doubleValue();			

		
	}	
	
}
