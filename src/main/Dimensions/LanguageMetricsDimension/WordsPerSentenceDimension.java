package main.Dimensions.LanguageMetricsDimension;

import main.Dimensions.BaseDimension;
import main.helpers.ExtractSentencesFromString;

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
		return "WPS";
	}
	
	
	/**
	 * subprocess
	 */
	public double subprocess () {
		
		// Get the number of sentences
		double sentences = ExtractSentencesFromString.getSentences(this.getInput ()).length; 
		
		
		// Get the number of words
		double words = this.getInput ().split ("\\s+").length;
		
		
		// Return the average value
		return words / sentences;
				
	}
}
