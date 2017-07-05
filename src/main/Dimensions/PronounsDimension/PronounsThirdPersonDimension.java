package main.Dimensions.PronounsDimension;

import main.Dictionaries.Dictionary;
import main.Dimensions.MatchingWordsFromDictionary;

/**
 * 
 * PronounsThirdPersonDimension
 *
 * @author Jos� Antonio Garc�a D�az
 *
 * @package TextAnalysis
 */
public class PronounsThirdPersonDimension extends MatchingWordsFromDictionary {
	
	/**
	 * getDimensionKey
	 *
	 * @override
	 */
	public String getDimensionKey () {
		return "Other";
	}
	
	
	/**
	 * PronounsFirstPersonSingularDimension
	 * @param dictionary
	 */
	public PronounsThirdPersonDimension (Dictionary dictionary) {
		super(dictionary);
	}

}
