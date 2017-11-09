package es.um.dis.umutextstats.dimensions;

import java.math.BigDecimal;
import java.math.RoundingMode;


import es.um.dis.umutextstats.helpers.ExtractSentencesFromString;
import es.um.dis.umutextstats.helpers.ExtractWordsFromString;

/**
 * SentenceCountDimension
 * 
 * @author Jos� Antonio Garc�a D�az
 * 
 * @package TextAnalysis
 */
public class SentenceCountDimension extends BaseDimension {
	
	/**
	 * subprocess
	 */
	public double subprocess () {
		
		// Get the number of sentences
		return ExtractSentencesFromString.getSentences(this.getInput ()).length; 
				
	}
}
