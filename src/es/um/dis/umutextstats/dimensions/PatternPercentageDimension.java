package es.um.dis.umutextstats.dimensions;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import es.um.dis.umutextstats.helpers.ExtractWordsFromString;

/**

 * PatternPercentageDimension
 *
 * @author José Antonio García Díaz
 *
 * @package TextAnalysis
 */
public class PatternPercentageDimension extends PatternDimension {

	
	/**
	 * subprocess
	 * 
	 * @param input
	 * @param regular_expression
	 * 
	 * @return
	 */
	public double subprocess () {
		
		// Get result
		double result = super.subprocess();
		
		
		// Get total words
		double total_words = ExtractWordsFromString.getWords(this.getInput ()).length;
        
		
		// Avoid divide by zero
		if (total_words == 0) {
			return 0;
		}

		
		// Calculate percentage
		BigDecimal bd = new BigDecimal (100 * result / total_words);
		bd = bd.setScale (2, RoundingMode.HALF_UP);

		
		return bd.doubleValue();		
	}	
}
