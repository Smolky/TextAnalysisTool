package main.Dimensions.Grammar;

import main.Dictionaries.Dictionary;
import main.Dimensions.MatchingWordsFromDictionary;

/**
 * InterrogativesDimension
 *
 * @author José Antonio García Díaz
 *
 * @package TextAnalysis
 */
public class InterrogativesDimension extends MatchingWordsFromDictionary {

	/**
	 * ArticlesDimension
	 * 
	 * @param dictionary
	 */
	public InterrogativesDimension(Dictionary dictionary) {
		super(dictionary);
	}
	
	
	/**
	 * getDimensionKey
	 *
	 * @override
	 */
	public String getDimensionKey () {
		return "interrogative";
	}	
	
}
