package main.Dimensions.PronounsDimension;

import main.Dictionaries.Dictionary;
import main.Dimensions.MatchingWordsFromDictionary;

/**
 * 
 * PronounsFirstPersonSingularDimension
 *
 * @author Jos� Antonio Garc�a D�az
 *
 * @package TextAnalysis
 */
public class PronounsFirstPersonSingularDimension extends MatchingWordsFromDictionary {
	
	/**
	 * getDimensionKey
	 *
	 * @override
	 */
	public String getDimensionKey () {
		return "I";
	}
	
	/**
	 * PronounsFirstPersonSingularDimension
	 * @param dictionary
	 */
	public PronounsFirstPersonSingularDimension(Dictionary dictionary) {
		super(dictionary);
	}

}
