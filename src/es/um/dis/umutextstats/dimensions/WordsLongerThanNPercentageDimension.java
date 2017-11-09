package es.um.dis.umutextstats.dimensions;

import java.math.BigDecimal;
import java.math.RoundingMode;

import es.um.dis.umutextstats.helpers.ExtractWordsFromString;


/**
 * WordsLongerThanNPercentageDimension
 * 
 * Detects the number of words with more/or equal than N
 * characters 
 * 
 * @author José Antonio García Díaz
 */
public class WordsLongerThanNPercentageDimension extends WordsLongerThanNDimension {

	
	/**
	 * subprocess
	 */
	public double subprocess () {
		
		// Get the number of words
		double result = super.subprocess ();;
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
