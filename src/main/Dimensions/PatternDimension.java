package main.Dimensions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**

 * PatternDimension
 *
 * @author José Antonio García Díaz
 *
 * @package TextAnalysis
 */
public class PatternDimension extends BaseDimension {

	/** String pattern */
	public String pattern;
	
	
	/**
	 * setPattern
	 * @param pattern
	 * @return
	 */
	public DimensionInterface setPattern (String pattern) {
		this.pattern = pattern;
		return this;
	}
	
	
	/**
	 * subprocess
	 * 
	 * @param input
	 * @param regular_expression
	 * 
	 * @return
	 */
	public double subprocess () {
		
		// Create pattern
        Pattern pattern = Pattern.compile (this.pattern);
        
        
        // Create matcher
        Matcher matcher = pattern.matcher (this.getInput ());

        
        // Process!
        double result = 0;
        while (matcher.find ()) {
        	result++;
        }
		
		return result;
	}	
	
}
