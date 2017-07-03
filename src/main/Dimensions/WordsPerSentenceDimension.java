package main.Dimensions;

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
	 * process
	 */
	public double process () {
		if (this.getInput ().isEmpty()) {
			return 0;
		}
		
		// Get the number of sentences
		double sentences = ExtractSentencesFromString.getSentences(this.getInput ()).length; 
		
		
		// Get the number of words
		double words = this.getInput ().split ("\\s+").length;
		
		
		// Return the average value
		return words / sentences;
				
	}
	
	
}
