package es.um.dis.umutextstats.dimensions;

import java.math.BigDecimal;
import java.math.RoundingMode;
import es.um.dis.umutextstats.helpers.ExtractWordsFromString;

/**
 * WordsAverageLengthDimension
 * 
 * @author José Antonio García Díaz
 * 
 * @package TextAnalysis
 */
public class WordAverageLengthDimension extends BaseDimension {
	
	/**
	 * subprocess
	 */
	public double subprocess () {
		
		// Store the result
		double total_words_length = 0;
		
		
		// Get the number of words 
		double words = ExtractWordsFromString.getWords(this.getInput ()).length;
		
		
		// Avoid divide by zero
		if (words == 0) {
			return 0;
		}		
		
		
		// Get total words length
		for (String word : ExtractWordsFromString.getWords (this.getInput ())) {
			total_words_length = total_words_length + word.length();
		};
		
		
		// Check data
		BigDecimal bd = new BigDecimal (total_words_length / words);
		bd = bd.setScale (2, RoundingMode.HALF_UP);
		
		
		// Return the average value
		return bd.doubleValue();		
		
	}
}
