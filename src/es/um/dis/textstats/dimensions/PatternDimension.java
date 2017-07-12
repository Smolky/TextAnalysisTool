package es.um.dis.textstats.dimensions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import es.um.dis.textstats.Asset;

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
	 * setInput
	 * 
	 * Allows to establish the input for the dimension
	 * 
	 * @param input
	 */	
	public PatternDimension setInput (Asset asset) {
		this.reset ();
		this.asset = asset.toString ();
		return this;
	}	
	
	
	/**
	 * setPattern
	 * @param pattern
	 * @return
	 */
	public PatternDimension setPattern (String pattern) {
		this.pattern = pattern;
		return this;
	}
	
	
	/**
	 * setInput
	 * 
	 * Allows to establish the input for the dimension
	 * 
	 * @param input
	 */	
	public PatternDimension setInput (String asset) {
		super.setInput (asset);
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
