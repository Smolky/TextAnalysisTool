package es.um.dis.umutextstats.dimensions;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * CharacterPercentageDimension
 * 
 * This dimension measures the relation between 
 * characters and the length of the input
 * 
 * @author José Antonio García Díaz
 * @package TextAnalysis
 */
public class CharacterPercentageDimension extends CharacterCountDimension {

	/**
	 * subprocess
	 */
	public double subprocess () {
		
		// Init vars
		double result = super.subprocess();
		double total_length = this.getInput ().length(); 
		
		
		// Avoid divide by zero
		if (total_length == 0) {
			return 0;
		}
		
		
		// Calculate percentage
		BigDecimal bd = new BigDecimal (100 * result / total_length);
		bd = bd.setScale (2, RoundingMode.HALF_UP);
		
		
		// Return the average value
		return bd.doubleValue();			

	}	

}
