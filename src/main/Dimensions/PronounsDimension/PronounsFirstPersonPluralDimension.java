package main.Dimensions.PronounsDimension;

import main.Dimensions.MatchingWordsFromDictionary;
import main.Sictionaries.Dictionary;

/**
 * 
 * PronounsFirstPersonPluralDimension
 *
 * @author José Antonio García Díaz
 *
 * @package TextAnalysis
 */
public class PronounsFirstPersonPluralDimension extends MatchingWordsFromDictionary {
	
	/**
	 * getDimensionKey
	 *
	 * @override
	 */
	public String getDimensionKey () {
		return "We";
	}
	
	/**
	 * PronounsFirstPersonSingularDimension
	 * @param dictionary
	 */
	public PronounsFirstPersonPluralDimension(Dictionary dictionary) {
		super(dictionary);
	}

}
