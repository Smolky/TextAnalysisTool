package main.Dimensions;

import java.util.HashSet;

import main.helpers.ExtractWordsFromString;

/**
 * PercentageWordsCapturedFromDictionary
 * 
 * @author Jos� Antonio Garc�a D�az
 * 
 * @package TextAnalysis
 */
public class PercentageWordsCapturedFromDictionary extends MatchingWordsFromDictionary {
	
	
	/**
	 * getDimensionKey
	 *
	 * @override
	 */
	public String getDimensionKey () {
		return "DicPercentage";
	}	
	
	
	/**
	 * subprocess
	 */
	public double subprocess () {
		
		// GEt words
		double matching_words = super.subprocess();
		
		return matching_words / this.dictionary.getWords ().size ();
		
	}	
	
}
