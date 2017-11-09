package es.um.dis.umutextstats.dimensions;

import es.um.dis.umutextstats.helpers.ExtractWordsFromString;

/**
 * WordCountDimension
 * 
 * This dimensions counts the number of words has the
 * text
 * 
 * @author Jos� Antonio Garc�a D�az
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
