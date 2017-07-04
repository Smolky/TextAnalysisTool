package main.Dimensions.PronounsDimension;

import main.Dimensions.MatchingWordsFromDictionary;
import main.Sictionaries.Dictionary;

/**
 * 
 * PronounsFirstPersonSingularDimension
 *
 * @author José Antonio García Díaz
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
