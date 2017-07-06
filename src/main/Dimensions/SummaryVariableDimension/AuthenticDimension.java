package main.Dimensions.SummaryVariableDimension;

import main.Dictionaries.Dictionary;
import main.Dimensions.MatchingWordsFromDictionary;

/**
 * AuthenticDimension
 *
 * @author Jos� Antonio Garc�a D�az
 *
 * @package TextAnalysis
 */
public class AuthenticDimension extends MatchingWordsFromDictionary {
	
	/**
	 * EmotionalToneDimension
	 * 
	 * @param dictionary
	 */
	public AuthenticDimension(Dictionary dictionary) {
		super(dictionary);
	}
	
	
	/**
	 * getDimensionKey
	 *
	 * @override
	 */
	public String getDimensionKey () {
		return "Authentic";
	}		

}
