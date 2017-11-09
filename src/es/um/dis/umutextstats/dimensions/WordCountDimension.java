package es.um.dis.umutextstats.dimensions;

import es.um.dis.umutextstats.helpers.ExtractWordsFromString;

/**
 * WordCountDimension
 * 
 * This dimensions counts the number of words has the
 * text
 * 
 * @author José Antonio García Díaz
 * 
 * @package TextAnalysis
 */
public class WordCountDimension extends BaseDimension {
	
	/**
	 * process
	 */
	public double subprocess () {
		return ExtractWordsFromString.getWords(this.getInput ()).length;
	}
	
	
}
