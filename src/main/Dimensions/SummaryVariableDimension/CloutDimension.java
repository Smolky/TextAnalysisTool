package main.Dimensions.SummaryVariableDimension;

import main.Dictionaries.Dictionary;
import main.Dimensions.MatchingWordsFromDictionary;

/**
 * CloutDimension
 *
 * @author Jos� Antonio Garc�a D�az
 *
 * @package TextAnalysis
 */
public class CloutDimension extends MatchingWordsFromDictionary {
	
	/**
	 * EmotionalToneDimension
	 * 
	 * @param dictionary
	 */
	public CloutDimension(Dictionary dictionary) {
		super(dictionary);
	}
	
	
	/**
	 * getDimensionKey
	 *
	 * @override
	 */
	public String getDimensionKey () {
		return "Clout";
	}		

}
