package main.Dimensions;

import main.Dimensions.MatchingWordsFromDictionary;
import main.Sictionaries.Dictionary;

/**
 * 
 * NegationDimension
 *
 * @author Jos� Antonio Garc�a D�az
 *
 * @package TextAnalysis
 */
public class NegationDimension extends MatchingWordsFromDictionary {
	
	/**
	 * getDimensionKey
	 *
	 * @override
	 */
	public String getDimensionKey () {
		return "Negate";
	}
	
	/**
	 * NegationDimension
	 * @param dictionary
	 */
	public NegationDimension(Dictionary dictionary) {
		super(dictionary);
	}

}
