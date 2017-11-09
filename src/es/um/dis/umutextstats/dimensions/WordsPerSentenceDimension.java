package es.um.dis.umutextstats.dimensions;

import java.math.BigDecimal;
import java.math.RoundingMode;


import es.um.dis.umutextstats.helpers.ExtractSentencesFromString;
import es.um.dis.umutextstats.helpers.ExtractWordsFromString;

/**
 * WordsPerSentenceDimension
 * 
 * @author José Antonio García Díaz
 * 
 * @package TextAnalysis
 */
public class WordsPerSentenceDimension extends BaseDimension {
	
	/**
	 * subprocess
	 */
	public double subprocess () {
		
		// Get the number of sentences
		double sentences = ExtractSentencesFromString.getSentences(this.getInput ()).length; 
		
		
		// Get the number of words
		double words = ExtractWordsFromString.getWords(this.getInput ()).length;
		
		
		// Avoid divide by zero
		if (sentences == 0) {
			return 0;
		}
		
		// Decimal format
		BigDecimal bd = new BigDecimal (words / sentences);
		bd = bd.setScale (2, RoundingMode.HALF_UP);
		
		
		// Return the average value
		return bd.doubleValue();
				
	}
}
