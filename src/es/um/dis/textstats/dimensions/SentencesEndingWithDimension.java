package es.um.dis.textstats.dimensions;

import es.um.dis.textstats.helpers.ExtractSentencesFromString;

/**
 * SentencesEndingWithQuestionMarkDimension
 * 
 * @todo. Maybe this methods does not work well
 * in Spanish texts
 * 
 * @author José Antonio García Díaz
 *
 */
public class SentencesEndingWithDimension extends CharacterCountDimension {

	/**
	 * subprocess
	 */
	public double subprocess () {
		
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
