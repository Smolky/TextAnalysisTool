package es.um.dis.umutextstats.dimensions;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

import es.um.dis.umutextstats.helpers.ExtractSentencesFromString;

/**
 * WordsPerSentenceDimension
 * 
 * @author José Antonio García Díaz
 * 
 * @package TextAnalysis
 */
public class WordsPerSentenceDimension extends BaseDimension {
	
	/**
	 * getDimensionKey
	 *
	 * @override
	 */
	public String getDimensionKey () {
		return "wps";
	}
	
	
	/**
	 * subprocess
	 */
	public double subprocess () {
		
		// Get the number of sentences
		double sentences = ExtractSentencesFromString.getSentences(this.getInput ()).length; 
		
		
		// Get the number of words
		double words = this.getInput ().split ("\\s+").length;
		
		
		if (sentences == 0) {
			return 0;
		}
		
		// Decimal format
		BigDecimal bd = new BigDecimal (words / sentences);
		bd = bd.setScale (5, RoundingMode.HALF_UP);
		
		
		// Return the average value
		return bd.doubleValue();
				
	}
}
