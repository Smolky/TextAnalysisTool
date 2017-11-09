package es.um.dis.umutextstats.dimensions;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;

import es.um.dis.umutextstats.helpers.ExtractWordsFromString;

/**
 * UniqueWordsPercentageDimension
 *
 * This dimension counts the % of different words
 * the text.
 * 
 * @author José Antonio García Díaz
 * 
 * @package TextAnalysis
 */
public class UniqueWordsPercentageDimension extends UniqueWordsDimension {
	
	/**
	 * getDimensionKey
	 *
	 * @override
	 */
	public String getDimensionKey () {
		return "UniquePercentage";
	}	
	
	
	/**
	 * subprocess
	 */
	public double subprocess () {
		
		// Check if results are empty
		double result = super.subprocess();
		
		
		// Get the number of words 
		double words = ExtractWordsFromString.getWords(this.getInput ()).length;
		
		
		// Avoid divide by zero
		if (words == 0) {
			return 0;
		}
		
		
		// Decimal format
		BigDecimal bd = new BigDecimal (100 * result / words);
		bd = bd.setScale (2, RoundingMode.HALF_UP);
		
		
		// Return the average value
		return bd.doubleValue();		
	}
}
