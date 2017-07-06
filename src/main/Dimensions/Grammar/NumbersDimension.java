package main.Dimensions.Grammar;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import main.Dimensions.BaseDimension;

/**
 * NumbersDimension
 * 
 * Detects how many numbers exists in a dimension
 * 
 * It will try to extract first numbers based on a context
 * like phone numbers and treat them as unique
 * 
 * It will also try to obtain textual numbers
 *
 * @author José Antonio García Díaz
 *
 * @package TextAnalysis
 */
public class NumbersDimension extends BaseDimension {
	
	double internal_count = 0;

	/**
	 * getDimensionKey
	 *
	 * @override
	 */
	public String getDimensionKey () {
		return "numbers";
	}
	
	
	/**
	 * subprocess
	 */
	public double subprocess () {
		
		// Original input
		String input = this.getInput (); 
		
		
		// Reset
		this.internal_count = 0;

		
		// Get phone numbers
		input = this.extractBasedOnPattern (input, "\\d{3}-\\d{3}-\\d{4}");
		
	
		// Get numbers
		input = this.extractBasedOnPattern (input, "\\b[\\d.]+\\b");
		
		
		// How many items?
		return this.internal_count;
		
		
	}
	
	
	/**
	 * ExtractBasedOnPattern
	 * 
	 * @param input
	 * @param regular_expression
	 * 
	 * @return
	 */
	private String extractBasedOnPattern (String input, String regular_expression) {
		
		// Create pattern
        Pattern pattern = Pattern.compile (regular_expression);
        
        
        // Create matcher
        Matcher matcher = pattern.matcher (input);

        
        // Process!
        while (matcher.find ()) {
        	this.internal_count++;
        	
        	input = input.replace (matcher.group (), "");
        }
		
		return input;
	}
	
}
