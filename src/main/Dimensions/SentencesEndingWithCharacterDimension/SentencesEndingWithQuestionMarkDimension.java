package main.Dimensions.SentencesEndingWithCharacterDimension;

import main.Dimensions.BaseDimension;
import main.helpers.ExtractSentencesFromString;

/**
 * SentencesEndingWithQuestionMarkDimension
 * 
 * @todo. Maybe this methods does not work well
 * in Spanish texts
 * 
 * @author José Antonio García Díaz
 *
 */
public class SentencesEndingWithQuestionMarkDimension extends BaseDimension {
	
	/**
	 * process
	 */
	public double process () {
		if (this.getInput ().isEmpty()) {
			return 0;
		}
		
		
		
		// Get the number of sentences
		double result = 0;
		for (String sentence : ExtractSentencesFromString.getSentences(this.getInput ())) {
			if (sentence.substring (sentence.length() - 1) == "?") {
				result++;
			}
		}
		return result;
				
	}

}
