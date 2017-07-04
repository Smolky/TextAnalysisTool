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
public class PronounsSecondPersonDimension extends MatchingWordsFromDictionary {
	
	/**
	 * getDimensionKey
	 *
	 * @override
	 */
	public String getDimensionKey () {
		return "You";
	}
	
	
	/**
	 * PronounsFirstPersonSingularDimension
	 * @param dictionary
	 */
	public PronounsSecondPersonDimension(Dictionary dictionary) {
		super(dictionary);
	}

}
